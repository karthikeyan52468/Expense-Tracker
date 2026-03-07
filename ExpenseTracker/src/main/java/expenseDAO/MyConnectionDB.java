package expenseDAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MyConnectionDB {


	private static HikariConfig config;
	public static HikariDataSource dataSource;
static
	{
		config = new HikariConfig();
		config.setMaximumPoolSize(10);
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setUsername("root");
		config.setPassword("root");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/expenseTracker");
		dataSource=new HikariDataSource(config);
	
		
	}
	
	public static Connection getConnection() throws SQLException
	{
		
		return dataSource.getConnection();
	}
	
}
