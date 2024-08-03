
package mr.sigrh.sigusers.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class UtilisateurComplet {

    private String id;
    private long createdTimestamp;
    private String username;
    private String password;
    private boolean enabled;
    private boolean totp;
    private boolean emailVerified;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, Boolean> access;
    private String groupeName;
    @Override
    public String toString() {
        return "UtilisateurComplet{" + "id=" + id + ", createdTimestamp=" + createdTimestamp + ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", totp=" + totp + ", emailVerified=" + emailVerified + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", access=" + access + ", groupeName=" + groupeName + '}';
    }

}
