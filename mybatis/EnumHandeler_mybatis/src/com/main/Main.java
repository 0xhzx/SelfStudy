package com.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.mapper.StudentsMapper;
import com.pojo.PhoneNumber;
import com.pojo.Students;
/**
 * ���Դ���
 * @author ASUS
 *
 */
public class Main {

	private static Logger logger=Logger.getLogger(Main.class);
	public static void main(String[] args) throws IOException {
		//step1:�õ�SqlSessionFactory   �൱�����ӳ�
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//step2:�õ�SqlSession    �൱��connection
		SqlSession sqlSession=sqlSessionFactory.openSession();

		StudentsMapper studentMapper = sqlSession.getMapper(StudentsMapper.class);

		Students student = new Students();
		student.setName("zth");
		student.setEmail("zth@qq.com");
		PhoneNumber phoneNumber = new PhoneNumber("123","456","789");

		studentMapper.addStudents(student);
		sqlSession.commit();
		System.out.println("ok");
	}
}
