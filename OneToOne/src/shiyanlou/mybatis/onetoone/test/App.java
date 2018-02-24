package shiyanlou.mybatis.onetoone.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shiyanlou.mybatis.onetoone.mapper.ClassesMapper;
import shiyanlou.mybatis.onetoone.model.Classes;

public class App {
	private static InputStream inputStream;
	private static SqlSessionFactory build;

	public static void main(String[] args) {
		String resource = "mybatis.cfg.xml";
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		build = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = build.openSession();
		ClassesMapper mapper = session.getMapper(ClassesMapper.class);
		
		Classes classById = mapper.selectClassById(1);
		
		
		session.commit();
		System.out.println("banjishi ,"+classById.getName());
		
		
		session.close();
		
		
		
		
		
		
		
	}
}
