package Exam;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class Test {
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
		String sqlString = "SELECT url from websites where name = ?;";
		Savepoint savepoint1 = null;

		try {
			connection = (Connection) DriverManager.getConnection(DB_URL, info);
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sqlString, ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, "Google");
			
			savepoint1 = connection.setSavepoint("Savepoint1");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String urlString = resultSet.getString("url");
				System.out.println("The URL is: " + urlString);
			}
			connection.commit();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			try {
				connection.rollback(savepoint1);
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
			}
		}
	}
}