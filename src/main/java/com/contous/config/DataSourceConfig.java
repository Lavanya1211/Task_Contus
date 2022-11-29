package com.contous.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public JdbcTemplate getJdbc(DataSource datasource1) {
		return new JdbcTemplate(datasource1);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
