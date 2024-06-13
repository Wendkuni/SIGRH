package com.sigrh.gestionressourceh.common.security;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SigrhUser extends User {
    private PersonnelModel personnelModel;
    public SigrhUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public SigrhUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public SigrhUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                     PersonnelModel personnelModel) {
        super(username, password, authorities);
        this.personnelModel = personnelModel;
    }

    public PersonnelModel getPersonnelModel() {
        return personnelModel;
    }

    public void setPersonnelModel(PersonnelModel personnelModel) {
        this.personnelModel = personnelModel;
    }
}
