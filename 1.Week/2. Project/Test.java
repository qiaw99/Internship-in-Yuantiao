package Exam;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class Test{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/world";
	static final String USER = "root";
	static final String PASSWORD = "123456";
	
	public static void main(String[] args) {
		Properties info = new Properties();
		info.put("user", USER);
		info.put("password", PASSWORD);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlString = "SELECT url from websites where name = ?";
		
		try {
			connection = (Connection) DriverManager.getConnection(DB_URL, info);
			preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setString(1, "Google");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String urlString = resultSet.getString("url");
				System.out.println("The URL is: " + urlString);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}