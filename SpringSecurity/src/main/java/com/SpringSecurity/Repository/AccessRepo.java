package com.SpringSecurity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.Model.Access;

@Repository
public interface AccessRepo extends JpaRepository<Access, Long>{

	Optional<Access> findByName(String username);

}
