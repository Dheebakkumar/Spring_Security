package com.SpringSecurity.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurity.Dto.SecurityDto;
import com.SpringSecurity.Model.Access;
import com.SpringSecurity.Model.Security;
import com.SpringSecurity.Repository.AccessRepo;
import com.SpringSecurity.Repository.SecurityRepo;
import com.SpringSecurity.Service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	
	
	@Autowired
	SecurityRepo repo;

	@Override
	public SecurityDto addUser(SecurityDto securityDto) {

		Security security = new Security();
		
		security.setName(securityDto.getName());
		security.setGender(securityDto.getGender());
		security.setDob(securityDto.getDob());
		security.setMobileNumber(securityDto.getMobileNumber());
		
		Security sec = repo.save(security);
	
		return dto(sec);
	}

	public SecurityDto dto(Security sec) {
		
		SecurityDto dto = new SecurityDto();
		dto.setId(sec.getId());
		dto.setName(sec.getName());
		dto.setMobileNumber(sec.getMobileNumber());
		dto.setGender(sec.getGender());
		dto.setDob(sec.getDob());
		
		return dto;
	}

	@Override
	public SecurityDto getById(long id) {

		Security checkId = repo.findById(id);
		if(checkId !=null) {
			
			return dto(checkId);
		}
		else throw new RuntimeException("Invalid Id");
		
	}

	@Override
	public List<SecurityDto> getAll() {

		List<Security> securities = repo.findAll();
		List<SecurityDto> securityDtos = new ArrayList<SecurityDto>();
		securities.forEach(each->{
			securityDtos.add(dto(each));
		});
		
		return securityDtos;
	}
	
	
	//Authentication
	
	@Autowired
	AccessRepo accessRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	public String addAccess(Access access) {
		
		access.setPassword(encoder.encode(access.getPassword()));
		
		accessRepo.save(access);
	
		return "User Added Successfully ...";
	}
}
