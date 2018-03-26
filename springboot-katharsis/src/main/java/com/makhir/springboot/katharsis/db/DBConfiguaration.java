package com.makhir.springboot.katharsis.db;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguaration {
	private String username;
	private String password;
	private String url;
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
//	@Bean
//	public DbCustomRepository dbCustomRepositoryJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		return new DbCustomRepository(jdbcTemplate);
//	}

	@Bean
	DataSource dataSource() throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		dataSource.setCharacterEncoding(StandardCharsets.UTF_8.name());
		dataSource.setCharacterSetResults(StandardCharsets.UTF_8.name());
		return dataSource;
	}
}
