package org.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.entity.Address;
import org.entity.Student;

//操作mybatis的接口
public interface StudentMapper {

	//查询一个学生
	Student queryStudentByStuno(int stuno);
	
	//查询全部学生
	 List<Student> queryAllStudents();
	
	//增加学生
	 void addStudent(Student student);
	
	//删除学生
	void deleteStudentByStuno(int stuno);
	 
	//修改学生
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
