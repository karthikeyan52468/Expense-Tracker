package expenseDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

public class MyConnectionDB {


	private static HikariConfig config;
	public static HikariDataSource dataSource;
	private static Properties prop;
	private static FileInputStream ins;

static
	{
	
		prop = new Properties();
		try {
			ins=new FileInputStream("E:\\Expense Tracker\\ExpenseTracker\\src\\resources\\application.properties");
			
			prop.load(ins);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		
		config = new HikariConfig();
		config.setMaximumPoolSize(10);
		config.setDriverClassName(prop.getProperty("db.driver"));
		config.setUsername(prop.getProperty("db.username"));
		config.setPassword(prop.getProperty("db.password"));
		config.setJdbcUrl(prop.getProperty("db.url"));
		dataSource=new HikariDataSource(config);
	
		try {
			Database database=DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(dataSource.getConnection()));
			Liquibase liquibase=new Liquibase("db.changelog.xml", new ClassLoaderResourceAccessor(), database);
			liquibase.update("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		
		return dataSource.getConnection();
	}
	
}
