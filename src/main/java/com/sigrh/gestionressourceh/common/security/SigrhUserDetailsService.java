package com.sigrh.gestionressourceh.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sigrh.gestionressourceh.daoImplement.users.UserDAOImplement;
import com.sigrh.gestionressourceh.daoImplement.users.UserRoleDAOImplement;
import com.sigrh.gestionressourceh.domains.utlisateur.UtilisateurModel;
import com.sigrh.gestionressourceh.domains.utlisateur.UtilisateurRoleaModel;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;




@Component
public class SigrhUserDetailsService implements UserDetailsService {

	//@Cacheable(value = "user", key = "#username")
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UtilisateurModel user = UserDAOImplement.findByUserName(username);
		if(user == null) throw new UsernameNotFoundException(username);
		List<UtilisateurRoleaModel> roles = UserRoleDAOImplement.findByUser(user);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for (UtilisateurRoleaModel userRole : roles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRolesa()));
		}
		//return new User(user.getUsername(), user.getPassword(), authorities);
		return new SigrhUser(user.getNomPrenom(), user.getPasswd(), authorities);
	}

	public String getPrincipal() {
		String username = "anonymous";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   username = authentication.getName();
		}
		return username;
	}

}
