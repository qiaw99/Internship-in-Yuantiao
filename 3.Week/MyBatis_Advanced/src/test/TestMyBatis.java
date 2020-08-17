package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import POJO.Post;
import POJO.User;

public class TestMyBatis {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//			sqlSessionFactory.getConfiguration().addMapper(IUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		IUser iUser = sqlSession.getMapper(IUser.class);
//		User user = iUser.getUserByID(1);
//		System.out.println(user);
//		sqlSession.close();
		
		User user = sqlSession.selectOne("getUser", 1);
		System.out.println(user);
		
		List<Post> posts = user.getPosts();
		for(Post p: posts) {
			System.out.println(p);
		}
		
		Post post = sqlSession.selectOne("getPosts", 1);
		System.out.println(post.getTitle());
		System.out.println(post.getUser().getUsername());
	}
	
}
