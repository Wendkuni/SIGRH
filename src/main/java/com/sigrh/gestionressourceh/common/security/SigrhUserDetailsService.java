//package com.sigrh.gestionressourceh.common.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.did.ersto.user.model.UserModel;
//import com.did.ersto.user.model.UserRoleModel;
//import com.did.ersto.user.service.UserRoleService;
//import com.did.ersto.user.service.UserService;
//
//
//@Component
//public class SigrhUserDetailsService implements UserDetailsService {
//
//	//@Cacheable(value = "user", key = "#username")
//	@Override
//	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//		UserModel user = UserService.selectByUsername(username);
//		if(user == null) throw new UsernameNotFoundException(username);
//		List<UserRoleModel> roles = UserRoleService.selectByUser(user);
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		for (UserRoleModel userRole : roles) {
//			authorities.add(new SimpleGrantedAuthority(userRole.getRole().getCode()));
//		}
//		//return new User(user.getUsername(), user.getPassword(), authorities);
//		return new SigrhUser(user.getUsername(), user.getPassword(), authorities, user.getPersonnel());
//	}
//
//	public String getPrincipal() {
//		String username = "anonymous";
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//		   username = authentication.getName();
//		}
//		return username;
//	}
//
//}
