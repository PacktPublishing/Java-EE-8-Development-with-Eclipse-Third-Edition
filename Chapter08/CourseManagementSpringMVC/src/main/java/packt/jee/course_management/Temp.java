package packt.jee.course_management;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Temp {

	public static void main(String[] args) throws SQLException {
		
DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUrl("jdbc:mysql://localhost:3306/course_management");
dataSource.setUsername("your_user_name");
dataSource.setPassword("your_password");
		
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			System.out.println("Connection = " + con);
		} finally {
			if (con != null)
				con.close();
		}
	}

}
