package com.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.Model.Security;

@Repository
public interface SecurityRepo extends JpaRepository<Security, Long> {

	Security findById(long id);
}
