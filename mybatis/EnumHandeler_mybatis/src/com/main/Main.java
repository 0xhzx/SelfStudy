package com.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.mapper.StudentsMapper;
import com.pojo.PhoneNumber;
import com.pojo.SexEnum;
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
		StudentsMapper sm=sqlSession.getMapper(StudentsMapper.class);
		
		//step3:��ѯ��Ϣ
		Students s=new Students("����2","66666@qq.com",new Date(),SexEnum.MALE);
        sm.addStudents(s);
		
		/*Students stu=sm.getStudentById(9);
		System.out.println(stu);*/
		logger.info("��Ѱһ��ѧ��");
		sqlSession.commit();
		System.out.println("ok");
	}
}
