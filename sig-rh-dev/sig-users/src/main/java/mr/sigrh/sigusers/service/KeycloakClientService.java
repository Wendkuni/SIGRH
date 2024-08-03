package mr.sigrh.sigusers.service;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import mr.sigrh.sigusers.dto.Utilisateur;
import mr.sigrh.sigusers.dto.UtilisateurComplet;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KeycloakClientService {

    private static final Logger logger = Logger.getLogger(KeycloakClientService.class.getName());

    private static final String SERVER_URL = "http://localhost:9009/";
    private static final String REALM = "SIG-RH";
    private static final String CLIENT_ID = "admin-cli";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private OkHttpClient client;

    public KeycloakClientService() {
        this.client = new OkHttpClient.Builder().build();
    }

    private String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id=" + CLIENT_ID + "&username=" + USERNAME + "&password=" + PASSWORD + "&grant_type=password");
        Request request = new Request.Builder()
                .url(SERVER_URL + "/realms/master/protocol/openid-connect/token")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to get access token. Response: " + response.code() + " - " + response.message());
            }
            JSONObject jsonResponse = new JSONObject(response.body().string());
            return jsonResponse.getString("access_token");
        } catch (JSONException e) {
            logger.log(Level.SEVERE, "Failed to parse access token response", e);
            throw new IOException("Failed to parse access token response", e);
        }
    }

    public Utilisateur createUser(UtilisateurComplet user) throws IOException {
        String accessToken = getAccessToken();
        String group = user.getGroupeName();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new JSONObject()
                .put("username", user.getUsername())
                .put("firstName", user.getFirstName())
                .put("lastName", user.getLastName())
                .put("email", user.getEmail())
                .put("enabled", true)
                .put("credentials", new JSONArray().put(new JSONObject()
                        .put("type", "password")
                        .put("value", user.getPassword())
                        .put("temporary", false)))
                .toString());

        Request request = new Request.Builder()
                .url(SERVER_URL + "/admin/realms/" + REALM + "/users")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to create user. Response: " + response.code() + " - " + response.message());
            }
            String locationHeader = response.header("Location");
            if (locationHeader != null) {
                String userId = locationHeader.substring(locationHeader.lastIndexOf('/') + 1);
                Utilisateur utilisateur = getUserById(userId, accessToken);
                addUserToGroup(userId, group);
                return utilisateur;
            } else {
                throw new IOException("Failed to get user ID from response");
            }
        }
    }

    public Utilisateur getUserById(String userId, String accessToken) throws IOException {
        Request request = new Request.Builder()
                .url(SERVER_URL + "/admin/realms/" + REALM + "/users/" + userId)
                .get()
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to get user. Response: " + response.code() + " - " + response.message());
            }
            JSONObject userObject = new JSONObject(response.body().string());
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(userObject.getString("id"));
            utilisateur.setCreatedTimestamp(userObject.getLong("createdTimestamp"));
            utilisateur.setUsername(userObject.getString("username"));
            utilisateur.setEnabled(userObject.getBoolean("enabled"));
            utilisateur.setTotp(userObject.getBoolean("totp"));
            utilisateur.setEmailVerified(userObject.getBoolean("emailVerified"));
            utilisateur.setFirstName(userObject.optString("firstName", ""));
            utilisateur.setLastName(userObject.optString("lastName", ""));
            utilisateur.setEmail(userObject.optString("email", ""));
            JSONObject accessObject = userObject.getJSONObject("access");
            Map<String, Boolean> accessMap = new HashMap<>();
            accessMap.put("manageGroupMembership", accessObject.getBoolean("manageGroupMembership"));
            accessMap.put("view", accessObject.getBoolean("view"));
            accessMap.put("mapRoles", accessObject.getBoolean("mapRoles"));
            accessMap.put("impersonate", accessObject.getBoolean("impersonate"));
            accessMap.put("manage", accessObject.getBoolean("manage"));
            utilisateur.setAccess(accessMap);
            return utilisateur;
        }
    }

    public void addUserToGroup(String userId, String groupName) throws IOException {
        String accessToken = getAccessToken();

        // Get group ID by name
        Request getGroupRequest = new Request.Builder()
                .url(SERVER_URL + "/admin/realms/" + REALM + "/groups")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try (Response groupResponse = client.newCall(getGroupRequest).execute()) {
            if (!groupResponse.isSuccessful()) {
                throw new IOException("Failed to get groups. Response: " + groupResponse.code() + " - " + groupResponse.message());
            }
            JSONArray groupsArray = new JSONArray(groupResponse.body().string());
            String groupId = null;
            for (int i = 0; i < groupsArray.length(); i++) {
                JSONObject group = groupsArray.getJSONObject(i);
                if (group.getString("name").equals(groupName)) {
                    groupId = group.getString("id");
                    break;
                }
            }
            if (groupId == null) {
                throw new IOException("Group not found: " + groupName);
            }

            // Add user to group
            RequestBody body = RequestBody.create(null, new byte[0]);
            Request addUserToGroupRequest = new Request.Builder()
                    .url(SERVER_URL + "/admin/realms/" + REALM + "/users/" + userId + "/groups/" + groupId)
                    .put(body)
                    .addHeader("Authorization", "Bearer " + accessToken)
                    .build();

            try (Response addUserToGroupResponse = client.newCall(addUserToGroupRequest).execute()) {
                if (!addUserToGroupResponse.isSuccessful()) {
                    throw new IOException("Failed to add user to group. Response: " + addUserToGroupResponse.code() + " - " + addUserToGroupResponse.message());
                }
                logger.info("User added to group successfully");
            }
        }
    }

    public List<Utilisateur> getUsers() throws IOException {
        String accessToken = getAccessToken();
        Request request = new Request.Builder()
                .url(SERVER_URL + "/admin/realms/" + REALM + "/users")
                .get()
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to get users. Response: " + response.code() + " - " + response.message());
            }
            JSONArray usersArray = new JSONArray(response.body().string());
            List<Utilisateur> users = new ArrayList<>();
            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject userObject = usersArray.getJSONObject(i);
                Utilisateur user = new Utilisateur();
                user.setId(userObject.getString("id"));
                user.setCreatedTimestamp(userObject.getLong("createdTimestamp"));
                user.setUsername(userObject.getString("username"));
                user.setEnabled(userObject.getBoolean("enabled"));
                user.setTotp(userObject.getBoolean("totp"));
                user.setEmailVerified(userObject.getBoolean("emailVerified"));
                user.setFirstName(userObject.optString("firstName", ""));
                user.setLastName(userObject.optString("lastName", ""));
                user.setEmail(userObject.optString("email", ""));
                JSONObject accessObject = userObject.getJSONObject("access");
                Map<String, Boolean> accessMap = new HashMap<>();
                accessMap.put("manageGroupMembership", accessObject.getBoolean("manageGroupMembership"));
                accessMap.put("view", accessObject.getBoolean("view"));
                accessMap.put("mapRoles", accessObject.getBoolean("mapRoles"));
                accessMap.put("impersonate", accessObject.getBoolean("impersonate"));
                accessMap.put("manage", accessObject.getBoolean("manage"));
                user.setAccess(accessMap);
                users.add(user);
            }
            return users;
        }
    }

    public void deleteUser(String userId) throws IOException {
        String accessToken = getAccessToken();
        Request request = new Request.Builder()
                .url(SERVER_URL + "/admin/realms/" + REALM + "/users/" + userId)
                .delete()
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to delete user. Response: " + response.code() + " - " + response.message());
            }
            logger.info("User deleted successfully");
        }
    }
}
