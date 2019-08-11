package org.entity;
//Statement方式实现增删改查
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
	
	//查询单个学生
	 public static void queryStudentByStuno() throws IOException {
		 Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			String statement = "org.entity.studentMapper.queryStudentByStuno";
			Student student = session.selectOne(statement,1);
			System.out.println(student);
			session.close();
			
	}
	 
	 //查询全部学生
	 
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
//	//增加学生
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
//				System.out.println("增加"+count+"个学生");
//				session.close();
//				
//		}
	 
		 
		//删除学生
		 
		 public static void deleteStudentByStuno() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				String statement = "org.entity.studentMapper.deleteStudentByStuno";
				int count = session.delete(statement,3);
				session.commit();
				System.out.println("删除"+count+"个学生");
				
				session.close();
				
		}
		 
		//修改学生
		 
		 public static void updateStudentBySuno() throws IOException {
			 Reader reader = Resources.getResourceAsReader("conf.xml");
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				
				String statement = "org.entity.studentMapper.updateStudentByStuno";
				//修改的参数
				Student student = new Student();
				//修改哪个人，where stuno = ?
				student.setStuNo(2);
				//修改成什么样子
				student.setStuName("lxs");
				student.setStuAge(44);
				student.setGraName("s2");
				//执行
				int count = session.update(statement,student);
				session.commit();
				System.out.println("修改"+count+"个学生");
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
