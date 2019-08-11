package org.entity;
//Statement��ʽʵ����ɾ�Ĳ�
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.javafx.geom.CubicApproximator;

public class Test {
	//Connection-SqlSession
	
	//��ѯ����ѧ��
	 public static void queryStudentByStuno() throws IOException {
		 Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			String statement = "org.entity.studentMapper.queryStudentByStuno";
			Student student = session.selectOne(statement,1);
			System.out.println(student);
			session.close();
			
	}
	 
	 //��ѯȫ��ѧ��
	 
	 public static void queryAllStudents() throws IOException {
		 Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			
			
			String statement = "org.entity.studentMapper.queryAllStudents";
			List<Student> students = session.selectList(statement);
			System.out.println(students);
			session.close();
			
	}
//	 
//	//����ѧ��
//	 
//		 public static void addStudent() throws IOException {
//			 Reader reader = Resources.getResourceAsReader("conf.xml");
//				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//				SqlSession session = sessionFactory.openSession();
//				
//				
//				String statement = "org.entity.studentMapper.addStudent";
//				Student student  = new Student(3,"ww",25,"s1");
//				int count = session.insert(statement,student);
//				session.commit();
//				System.out.println("����"+count+"��ѧ��");
//				session.close();
//				
//		}
	 
		 
		//ɾ��ѧ��
		 
		 public static void deleteStudentByStuno() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				String statement = "org.entity.studentMapper.deleteStudentByStuno";
				int count = session.delete(statement,3);
				session.commit();
				System.out.println("ɾ��"+count+"��ѧ��");
				
				session.close();
				
		}
		 
		//�޸�ѧ��
		 
		 public static void updateStudentBySuno() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				String statement = "org.entity.studentMapper.updateStudentByStuno";
				//�޸ĵĲ���
				Student student = new Student();
				//�޸��ĸ��ˣ�where stuno = ?
				student.setStuNo(2);
				//�޸ĳ�ʲô����
				student.setStuName("lxs");
				student.setStuAge(44);
				student.setGraName("s2");
				//ִ��
				int count = session.update(statement,student);
				session.commit();
				System.out.println("�޸�"+count+"��ѧ��");
				session.close();
				
		}
	
	public static void main(String[] args) throws IOException {
			queryAllStudents();
//			addStudent();
//			deleteStudentByStuno();
			updateStudentBySuno();
			queryAllStudents();
		
	}
}
