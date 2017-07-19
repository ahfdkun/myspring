package com.ahfdkun.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterRespository;

/**
 * @Description: Spring中使用JDBC
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:02
 */
/*@Repository*/
public class JDBCSpitterRepositoryImpl implements SpitterRespository {

	private static final String INSERT_SPITTER = 
			"insert into Spitter" + 
			"	(username,password,first_name,last_name) " + 
			"values" + 
			"	(:username,:password,:first_name,:last_name)";
	
	private JdbcOperations jdbcOperations;
	
	/**
	 * 使用命名参数
	 */
	private NamedParameterJdbcOperations namedParameterJdbcOperations;

	@Autowired
	public JDBCSpitterRepositoryImpl(JdbcOperations jdbcOperations, NamedParameterJdbcOperations namedParameterJdbcOperations) {
		this.jdbcOperations = jdbcOperations;
		this.namedParameterJdbcOperations = namedParameterJdbcOperations;
	}

	@Override
	public int save(Spitter spitter) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", spitter.getUsername());
		paramMap.put("password", spitter.getPassword());
		paramMap.put("first_name", spitter.getFirstName());
		paramMap.put("last_name", spitter.getLastName());
		return namedParameterJdbcOperations.update(INSERT_SPITTER, paramMap);
		/*return jdbcOperations.update("insert into spitter(username,password,first_name,last_name) values(?,?,?,?)",
				spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName());*/
	}

	@Override
	public Spitter findByUsername(String username) {
		return jdbcOperations.queryForObject("select * from spitter where username = ?", this::mySpitter, username);
	}

	private Spitter mySpitter(ResultSet rs, int rowNum) throws SQLException {
		return new Spitter(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
				rs.getString("first_name"), rs.getString("last_name"));
	}
	
}
