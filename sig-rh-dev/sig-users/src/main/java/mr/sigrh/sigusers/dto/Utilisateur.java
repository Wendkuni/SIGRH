/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mr.sigrh.sigusers.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Utilisateur {

    private String id;
    private long createdTimestamp;
    private String username;
    private boolean enabled;
    private boolean totp;
    private boolean emailVerified;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, Boolean> access;

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", createdTimestamp=" + createdTimestamp + ", username=" + username + ", enabled=" + enabled + ", totp=" + totp + ", emailVerified=" + emailVerified + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", access=" + access + '}';
    }

}
