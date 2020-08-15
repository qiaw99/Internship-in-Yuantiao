package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import POJO.Student;

public class TestMyBatis {
	public static void main(String[] args) throws IOException {
		String resourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourceString);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
//		Get info of all students in the database 		
//		List<Student> listStudents = session.selectList("listStudent");
//		for(Student student: listStudents) {
//			System.out.println(student);
//		}
		
        Student student1 = new Student();
        student1.setId(4);
        student1.setStudentID(4);
        student1.setName("新增加的学生");
        session.insert("addStudent", student1);

        Student student2 = new Student();
        student2.setId(1);
        session.delete("deleteStudent", student2);

        Student student3 = session.selectOne("getStudent", 2);

        student3.setName("修改的学生");
        session.update("updateStudent", student3);

        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        session.commit();
        session.close();
	}
}
