

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bean.Basebean;

public class Test02 {

	public static void main(String[] args) throws IOException {
		System.out.println("begin");
		String resource="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession openSession=sqlSessionFactory.openSession();
		try {
			
			Basebean bean=openSession.selectOne("selectTestData",1);
			System.out.println("result:"+bean);
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			openSession.close();
			System.out.println("close session");
		}
		
		System.out.println("end");

	}

}
