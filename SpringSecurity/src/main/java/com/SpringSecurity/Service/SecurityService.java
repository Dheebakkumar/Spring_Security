package com.SpringSecurity.Service;

import java.util.List;

import com.SpringSecurity.Dto.SecurityDto;
import com.SpringSecurity.Model.Access;

public interface SecurityService{

	public SecurityDto addUser(SecurityDto securityDto);
	public SecurityDto getById(long id);
	public List<SecurityDto> getAll();
	
	//Authentication 
	
	public String addAccess(Access access);
	
	
}
