package com.samcm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

public class ConnectionConfiguration {


//	@Bean(name = "mySqlDataSource")
//	@Primary
//	public DataSource mySqlDataSource() 
//	{
//		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.url("jdbc:mysql://localhost/samcmdb");
//		dataSourceBuilder.username("root");
//		dataSourceBuilder.password("root");
//		return dataSourceBuilder.build();
//
//	}
	
//	@Autowired
//	@Qualifier("mySqlDataSource")
//	DataSource dataSource;

	public static Connection connection;

	public Connection getConnection() throws SQLException 
	{
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/samcmdb","root","root"); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
