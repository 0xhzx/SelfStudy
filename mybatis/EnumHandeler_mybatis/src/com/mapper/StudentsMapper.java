package com.mapper;

import java.util.List;

import com.pojo.Students;

public interface StudentsMapper {
	
	//��ѯ����ѧ����Ϣ
   public void addStudents(Students s);
   
   public Students getStudentById(int stu_id);
   
   public List<Students> getAllStudents();
}
