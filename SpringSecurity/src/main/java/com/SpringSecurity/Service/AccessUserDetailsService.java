package com.SpringSecurity.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.SpringSecurity.Model.Access;
import com.SpringSecurity.Repository.AccessRepo;

@Component
public class AccessUserDetailsService implements UserDetailsService {

	@Autowired
	AccessRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Access> access =repo.findByName(username);
	
		return access.map(AccessUserDetails :: new)
			.orElseThrow(() -> new UsernameNotFoundException("User Not Found "+username));
		
	}




}
