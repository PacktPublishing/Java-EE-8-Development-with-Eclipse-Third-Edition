package packt.book.jee.eclipse.ch4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import packt.book.jee.eclipse.ch4.bean.Teacher;
import packt.book.jee.eclipse.ch4.db.connection.DatabaseConnectionFactory;

public class TeacherDAO {
	
	public void addTeacher (Teacher teacher) throws SQLException {
		//get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			String sql = "insert into Teacher (first_name,last_name,designation) values (?,?,?)";
			//create prepared statement with option to get auto generated keys
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//set parameters
			stmt.setString(1, teacher.getFirstName());
			stmt.setString(2, teacher.getLastName());
			stmt.setString(3, teacher.getDesignation());
			
			stmt.execute();
			
			//Get auto generated keys
	        ResultSet rs = stmt.getGeneratedKeys(); 
	        
	        if (rs.next())
	        	teacher.setId(rs.getInt(1));
	        
	        rs.close();
	        stmt.close();
		} finally {
			con.close();
		}
	}
	
	public List<Teacher> getTeachers () throws SQLException {
		//get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		List<Teacher> teachers = new ArrayList<Teacher>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			
			String sql = "select * from teacher order by first_name";
			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setFirstName(rs.getString("first_name"));
				teacher.setLastName(rs.getString("last_name"));
				teacher.setDesignation(rs.getString("designation"));
				teachers.add(teacher);
			}
			
			return teachers;
		} finally {
			con.close();
		}
	}

}
