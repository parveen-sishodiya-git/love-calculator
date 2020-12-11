package tech.sishodiyology.lovecalculator.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tech.sishodiyology.lovecalculator.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		String userInsertQuery = "insert into user (NAME,username,PASSWORD,country,hobbies,gender) values(?,?,?,?,?,?)";
		System.out.println("Saving user");
		String hobbies = "";
		for (String hobby : user.getHobbies()) {
			hobbies += hobby + ",";
		}
		Object[] valuesArray = {user.getName(), user.getUserName(), user.getPassword(),
				user.getCountry(), hobbies, user.getGender() };
		jdbcTemplate.update(userInsertQuery, valuesArray);
		System.out.println("User saved into DB");

	}

	@Override
	public void deleteUser(int id) {
		String deleteUserQuery = "delete from user where id=(?)";
		jdbcTemplate.update(deleteUserQuery, new Object[] {id});
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String userSelectQuery = "select * from user";
		List<User> user = jdbcTemplate.query(userSelectQuery, new ResultSetExtractor<List<User>>() {

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> list = new ArrayList<>();
				while(rs.next()) {
					User user =  new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setUserName(rs.getString("username"));
					user.setCountry(rs.getString("country"));
					user.setHobbies(getHobbies(rs.getString("hobbies")));
					user.setGender(rs.getString("gender"));
					list.add(user);
				}
				return list;
			}
			
			public String[] getHobbies(String resultHobbies) {
				String[] hobbies = resultHobbies.split(",");
				return hobbies;
			}
			
		});
		return user;
	}


	
	@Override
	public User getUserById(int id) {
		String userQuery = "select * from user where id=?";
		 User user = jdbcTemplate.queryForObject(userQuery, new Object[] {id}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUserName(rs.getString("username"));
				user.setCountry(rs.getString("country"));
				user.setHobbies(getHobbies(rs.getString("hobbies")));
				user.setGender(rs.getString("gender"));
				return user;
			}
			
			public String[] getHobbies(String resultHobbies) {
				String[] hobbies = resultHobbies.split(",");
				return hobbies;
			}
		});
		return user;
	}

}
