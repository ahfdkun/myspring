package com.ahfdkun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahfdkun.domain.Spitter;

public interface SpitterRespository extends JpaRepository<Spitter, Long> {

	Spitter findByUsername(String username);
	
}
