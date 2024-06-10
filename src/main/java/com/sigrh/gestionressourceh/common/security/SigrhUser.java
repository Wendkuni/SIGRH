package com.sigrh.gestionressourceh.common.security;

import com.did.ersto.personnel.model.PersonnelPersonnelModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SigrhUser extends User {
    private PersonnelPersonnelModel personnelModel;
    public SigrhUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public SigrhUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public SigrhUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                     PersonnelPersonnelModel personnelModel) {
        super(username, password, authorities);
        this.personnelModel = personnelModel;
    }

    public PersonnelPersonnelModel getPersonnelModel() {
        return personnelModel;
    }

    public void setPersonnelModel(PersonnelPersonnelModel personnelModel) {
        this.personnelModel = personnelModel;
    }
}
