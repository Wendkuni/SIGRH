package com.sigrh.gestionressourceh.common.security;

import com.sigrh.gestionressourceh.common.util.PasswordUtil;
import com.sigrh.gestionressourceh.daoImplement.users.UserDAOImplement;
import com.sigrh.gestionressourceh.domains.utlisateur.UtilisateurModel;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
public class SigrhAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		if(isValidCredentials(username, password)) {
			return new UsernamePasswordAuthenticationToken(username, password);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private boolean isValidCredentials(String username, String password) {
		UtilisateurModel user = UserDAOImplement.findByUserName(username);
		if(user == null) throw new UsernameNotFoundException(username);
		return user.getPasswd().equals(PasswordUtil.getEncodedPassword(password));
	}

}
