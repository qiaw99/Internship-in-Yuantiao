package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import POJO.User;

public interface IUser {
	@Select("SELECT * FROM user where id=#{id}")
	public User getUserByID(int id);
	
	public List<User> getUserList();
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int userId);
	
	public User getUser(int userId);
}
