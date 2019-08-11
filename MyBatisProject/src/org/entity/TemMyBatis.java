package org.entity;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TemMyBatis {
	//º”‘ÿMyBatis≈‰÷√Œƒº˛
	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		//Sqlsessionfactory - connection
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader); 
		SqlSession session = sessionFactory.openSession();
		
		String statement = "org.entity.personMapper.queryPersonById";
		Person person = session.selectOne(statement,1);
		System.out.println(person);
		session.close();
		
	}

}
