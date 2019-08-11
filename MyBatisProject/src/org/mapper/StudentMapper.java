package org.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.entity.Address;
import org.entity.Student;

//����mybatis�Ľӿ�
public interface StudentMapper {

	//��ѯһ��ѧ��
	Student queryStudentByStuno(int stuno);
	
	//��ѯȫ��ѧ��
	 List<Student> queryAllStudents();
	
	//����ѧ��
	 void addStudent(Student student);
	
	//ɾ��ѧ��
	void deleteStudentByStuno(int stuno);
	 
	//�޸�ѧ��
	void updateStudentByStuno(Student student);
	
	//
	Student queryStudentByStunoWithConveter(int stuno);
	
	//
	void addStudentWithConverter(Student student);
	
	//
	List<Student>  queryStudentOrderByColumn(String column);
	
	//
	List<Student> queryStudentBystuageOrstuname(Student student);
	
	//
//	List<Student> queryStudentByAddress(Address address);
	List<Student> queryStudentByAddress(Student address);
	
	//
	List<Student> queryStudentBystuageOrstunameWithHashMap(Map<String, Object> map);
}
