package com.ahfdkun.repository;

import com.ahfdkun.domain.Spitter;

public interface SpitterRespository {

	Spitter save(Spitter spitter);

	Spitter findByUsername(String username);
	
}
