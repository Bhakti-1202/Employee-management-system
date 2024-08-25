package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCrud {
	public Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "bhakti@12");
		return connection;
	}

	public int signUp(EmployeeInfo info1) throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, info1.getId());
		preparedStatement.setString(2, info1.getName());
		preparedStatement.setString(3, info1.getAddress());
		preparedStatement.setLong(4, info1.getPhone());
		preparedStatement.setString(5, info1.getEmail());
		preparedStatement.setString(6, info1.getPassword());

		int op = preparedStatement.executeUpdate();

		connection.close();
		return op;
	}

	public String login(String email) throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT PASSWORD FROM EMPLOYEE WHERE EMAIL = ?");
		preparedStatement.setString(1, email);

		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}

		return password;
	}

	public List<EmployeeInfo> fetch() throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
		while (resultSet.next()) {
			EmployeeInfo info = new EmployeeInfo();
			info.setId(resultSet.getInt("id"));
			info.setName(resultSet.getString("name"));
			info.setPhone(resultSet.getLong("phone"));
			info.setAddress(resultSet.getString("address"));
			info.setEmail(resultSet.getString("email"));
			info.setPassword(resultSet.getString("password"));
			list.add(info);
		}
		connection.close();
		return list;
	}

	public int delete(int id) throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
		preparedStatement.setInt(1, id);

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}
	
	public EmployeeInfo getInfo(int id) throws Exception {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT NAME, ADDRESS , PHONE , EMAIL , PASSWORD FROM EMPLOYEE WHERE ID = ?");
		preparedStatement.setInt(1, id);
		ResultSet set = preparedStatement.executeQuery();
		EmployeeInfo info = new EmployeeInfo();
		while(set.next()) {
			info.setId(id);
			info.setName(set.getString("name"));
			info.setPhone(set.getLong("phone"));
			info.setEmail(set.getString("email"));
			info.setAddress(set.getString("address"));
			info.setPassword(set.getString("password"));
		}
		return info;
		
	}
	
	public int update(int id , EmployeeInfo info) throws Exception {
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET NAME=? , ADDRESS=? , PHONE=?,EMAIL=? , PASSWORD = ? WHERE ID = ?");
		preparedStatement.setString(1, info.getName());
		preparedStatement.setString(2, info.getAddress());
		preparedStatement.setLong(3, info.getPhone());
		preparedStatement.setString(4, info.getEmail());
		preparedStatement.setString(5, info.getPassword());
		preparedStatement.setInt(6, id);
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
	
	public int deleteAll() throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE ");

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}
	

}
