package com.ahfdkun.repository;

import com.ahfdkun.domain.Spitter;

public interface SpitterRespository {

	int save(Spitter spitter);

	Spitter findByUsername(String username);
	
}
