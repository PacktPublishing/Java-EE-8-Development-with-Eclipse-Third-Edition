package packt.jee.course_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import packt.jee.course_management.dto.CourseDTO;

@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDatasource (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<CourseDTO> getCourses() {
		List<CourseDTO> courses = jdbcTemplate.query("select * from course",
			new CourseRowMapper());
		
		return courses;
	}
	
	public static final class CourseRowMapper implements RowMapper<CourseDTO> {
		@Override
		public CourseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CourseDTO course = new CourseDTO();
			course.setId(rs.getInt("id"));
			course.setName(rs.getString("name"));
			course.setCredits(rs.getInt("credits"));
			return course;
		}
	}
	
	public void addCourse (final CourseDTO course) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into Course (name, credits) values (?,?)";
				PreparedStatement stmt = con.prepareStatement(sql, new String[] {"id"});
				stmt.setString(1, course.getName());
				stmt.setInt(2, course.getCredits());
				return stmt;
			}
		}, keyHolder);
		
		course.setId(keyHolder.getKey().intValue());
	}
	
	public void updateCourse (final CourseDTO course) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "update Course set name = ?, credits = ? where id = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, course.getName());
				stmt.setInt(2, course.getCredits());
				stmt.setInt(3, course.getId());
				return stmt;
			}
		});
	}
	
	public void deleteCourse(final int id) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "delete from Course where id = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, id);
				return stmt;
			}
		});
	}
	
	public CourseDTO getCourse (int id) {
		String sql = "select * from course where id = ?";
		CourseDTO course = jdbcTemplate.queryForObject(sql, new CourseRowMapper(), id);
		return course;
	}
	
}
