package org.test;
//Լ����ʽʵ����ɾ�Ĳ�(�ӿڷ�ʽ)

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.entity.Address;
import org.entity.Student;
import org.mapper.StudentMapper;

public class Test {
	//Connection-SqlSession
	
	
	//��ѯ����ѧ��(ʹ����ת����)
		 public static void queryStudentByStunoWithConverter() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				Student student = studentMapper.queryStudentByStunoWithConveter(1);
				System.out.println(student);
				session.close();
				
		}
	
	//��ѯ����ѧ��
	 public static void queryStudentByStuno() throws IOException {
		 Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			
			
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			Student student = studentMapper.queryStudentByStuno(1);
			System.out.println(student);
			session.close();
			
	}
	 
	 
	//��ѯ����ѧ��ͨ��stuage����stuName
		 public static void queryStudentBystuageOrstuname() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				Student student = new Student();
				student.setStuAge(24);
				student.setStuName("w");
				List<Student> students = studentMapper.queryStudentBystuageOrstuname(student);
				System.out.println(students);
				session.close();
				
		}
		 
		//��ѯ����ѧ��ͨ��stuage����stuName(HashMap)
		 public static void queryStudentBystuageOrstunameWithHashMap() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				
				Map<String, Object> studentMap = new HashMap<>();
				studentMap.put("stuAge", 44);
				studentMap.put("stuName", "zs");
				List<Student> students = studentMapper.queryStudentBystuageOrstunameWithHashMap(studentMap);
				System.out.println(students);
				session.close();
				
		}
	 
	 //��ѯȫ��ѧ��
	 
	 public static void queryAllStudents() throws IOException {
		 Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();	
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			
			
			List<Student> students = studentMapper.queryAllStudents();
			System.out.println(students);
			session.close();
			
	}
	 
	//ͨ����ַ��ѯѧ��
	 
		 public static void queryStudentByAddress() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();			
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				
				
//				Address address = new Address();
//				address.setHomeAddress("xa");
//				address.setSchoolAddress("bj");
//				List<Student> students = studentMapper.queryStudentByAddress(address);
				
				Student student = new Student();
				Address address = new Address();
				address.setHomeAddress("xa");
				address.setSchoolAddress("bj");
				student.setAddress(address);
				List<Student> students = studentMapper.queryStudentByAddress(student);
				
				
				
				System.out.println(students);
				session.close();
				
		}
	 
	 
	//��ѯȫ��ѧ����������
	 
		 public static void queryStudentOrderByColumn() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
//				List<Student> students = session.selectList(statement);
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				List<Student> students = studentMapper.queryStudentOrderByColumn("stuno");
				System.out.println(students);
				session.close();
				
		}
	 
	 
		//����ѧ��(��ת������)
	 
	 public static void addStudentWithConverter() throws IOException {
		 Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			
			
			Student student  = new Student(53,"ww",53,"s1",true);
//			student.setStuSex(true);
//			int count = session.insert(statement,student);
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.addStudentWithConverter(student);
			session.commit();
			System.out.println("���ӳɹ�");
			session.close();
			
	}
	 
	//����ѧ��
	 
		 public static void addStudent() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				Student student  = new Student(13,"ww",33,"s1",false);
				
//				int count = session.insert(statement,student);
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				studentMapper.addStudent(student);
				session.commit();
				System.out.println("���ӳɹ�");
				session.close();
				
		}
	 
		 
		//ɾ��ѧ��
		 
		 public static void deleteStudentByStuno() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
//				String statement = "org.entity.studentMapper.deleteStudentByStuno";
//				int count = session.delete(statement,3);
				
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				studentMapper.deleteStudentByStuno(3);
				
				session.commit();
				System.out.println("ɾ���ɹ�");
				
				session.close();
				
		}
		 
		//�޸�ѧ��
		 
		 public static void updateStudentBySuno() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
//				String statement = "org.entity.studentMapper.updateStudentByStuno";
				//�޸ĵĲ���
				Student student = new Student();
				//�޸��ĸ��ˣ�where stuno = ?
				student.setStuNo(2);
				//�޸ĳ�ʲô����
				student.setStuName("lxs");
				student.setStuAge(44);
				student.setGraName("s2");
				//ִ��
//				int count = session.update(statement,student);
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				studentMapper.updateStudentByStuno(student);
				session.commit();
				System.out.println("�޸ĳɹ�");
				session.close();
				
		}
	
	public static void main(String[] args) throws IOException {
//			queryStudentByStuno();
//		queryStudentByStunoWithConverter();
//		addStudentWithConverter();
//		queryStudentOrderByColumn();
//		queryStudentBystuageOrstuname();
//		queryStudentByAddress();
		queryStudentBystuageOrstunameWithHashMap();
//			queryAllStudents();
//			addStudent();
//			deleteStudentByStuno();
//			updateStudentBySuno();
//			queryAllStudents();
		
	}
}
