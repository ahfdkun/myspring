package com.ahfdkun.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterSweeper;

/**
 * @Description 使用Spring Data JPA实现自动化
 *
 * @author zhaoyakun
 *
 * @date 2017年7月20日 下午9:05:45
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {

	Spitter findByUsername(String username);
	
	List<Spitter> findAll();
	
	@Query("from Spitter where username like 'ahfdkun%'")
	List<Spitter> findAllMySpitters();
}
