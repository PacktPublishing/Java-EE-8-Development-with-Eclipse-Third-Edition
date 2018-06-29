package packt.book.jee.eclipse.ch4.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * Singleton Factory class to create JDBC database connections 
 *
 */
public class DatabaseConnectionFactory {
	//singleton instance
	private static DatabaseConnectionFactory conFactory = new DatabaseConnectionFactory();
	
	private DataSource dataSource = null;
	
	//Make the construction private
	private DatabaseConnectionFactory() {}
	
	//
	
	
	
	/**
	 * Must be called before any other method in this class.
	 * Initializes the data source and saves it in an instance variable
	 *  
	 * @throws IOException
	 */
	public synchronized void init() throws IOException {
		if (dataSource != null)
			return;
		
		//load db.properties file first
		InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
		Properties dbProperties = new Properties();
		dbProperties.load(inStream);
		inStream.close();
		
		//create Tomcat specific pool properties
		PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://" + dbProperties.getProperty("db_host") + 
					":" + dbProperties.getProperty("db_port") + "/" + 
					dbProperties.getProperty("db_name"));
		
		p.setDriverClassName(dbProperties.getProperty("db_driver_class_name"));
		p.setUsername(dbProperties.getProperty("db_user_name"));
		p.setPassword(dbProperties.getProperty("db_password"));
		p.setMaxActive(10);
		
		dataSource = new DataSource();
		dataSource.setPoolProperties(p);
	}
	
	//Provides access to singleton instance
	public static DatabaseConnectionFactory getConnectionFactory() {
		return conFactory;
	}
	
	//returns database connection object 
	public Connection getConnection () throws SQLException {
		if (dataSource == null)
			throw new SQLException("Error initializing datasource");
		return dataSource.getConnection();
	}
}
