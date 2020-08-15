package Exam;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class StreamingData {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/world";
	static final String USER = "root";
	static final String PASSWORD = "123456";

	public static void createXMLTable(Statement statement) throws SQLException {
		System.out.println("Creating XML_Data table...");

		String streamingDataSql = "CREATE TABLE XML_Data (id INTEGER, Data LONG)";

		// If already exists
		try {
			statement.executeUpdate("DROP TABLE XML_Data");
		} catch (SQLException e) {
			e.getMessage();
		}
		statement.executeUpdate(streamingDataSql);
	}

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");

			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = (Statement) connection.createStatement();
			createXMLTable(statement);

			File file = new File("D:\\Program Files\\assignments\\src\\Exam\\src\\Exam/xml_data.xml");
			long fileLength = file.length();
			FileInputStream fileInputStream = new FileInputStream(file);

			String SQL = "INSERT INTO XML_Data VALUES(?, ?)";
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, 125);
			preparedStatement.setAsciiStream(2, fileInputStream, fileLength);
			preparedStatement.execute();

			fileInputStream.close();

			SQL = "SELECT Data FROM XML_Data WHERE id=125";
			resultSet = statement.executeQuery(SQL);

			if (resultSet.next()) {
				InputStream xmlInputStream = resultSet.getAsciiStream(1);
				int b;
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				while ((b = xmlInputStream.read()) != -1) {
					byteArrayOutputStream.write(b);
				}
				System.out.println(byteArrayOutputStream.toString());
			}
			resultSet.close();
			statement.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
				se2.getMessage();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se3) {
				se3.getMessage();
			} 
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se3) {
				se3.getMessage();
			} 
		} 
		System.out.println("Goodbye!");
	}
}
