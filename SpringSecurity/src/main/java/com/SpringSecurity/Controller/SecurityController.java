package com.SpringSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.Dto.SecurityDto;
import com.SpringSecurity.Model.Access;
import com.SpringSecurity.Service.SecurityService;

@RestController
@RequestMapping("/security")
public class SecurityController {

	
	//Authorization
	
	
	@Autowired
	SecurityService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to Spring Security";
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping("/add")
	public SecurityDto add(@RequestBody SecurityDto securityDto) {
		
		return service.addUser(securityDto);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/get/{id}")
	public SecurityDto get(@PathVariable long id) {
		
		return service.getById(id);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/getAll")
	public List<SecurityDto> getAll(){
		
		return service.getAll();
				
	}
	
	//Authentication
	
	
	@PostMapping("/access/add")
	public String addAccess(@RequestBody Access access) {
		
		return service.addAccess(access);
	}
}
