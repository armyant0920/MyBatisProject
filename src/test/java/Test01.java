import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.activation.MailcapCommandMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import Mapper.Mapper01;
import bean.Basebean;
import bean.MyHashMap;

public class Test01 {

	public SqlSession getSqlSession() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		return sqlSessionFactory.openSession();

	}

	@Test
	public void test() throws IOException {
		System.out.println("begin");
//		String resource="mybatis-config.xml";
//		InputStream inputStream=Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//		
//		SqlSession openSession=sqlSessionFactory.openSession();
		SqlSession openSession = getSqlSession();
		try {

			Basebean bean = openSession.selectOne("selectTestData", 1);
			System.out.println("result:" + bean);

//			List list =openSession.selectList("selectList");
//			for(Object o:list) {
//				
//				if(o instanceof Basebean) {
//					System.out.println("data:"+(Basebean)o);
//					
//				}else {
//					System.out.println("cannot convert");
//				}
//				
//			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			openSession.close();
			System.out.println("close session");
		}

		System.out.println("end");
	}

	@Test
	public void test2() throws IOException {
		SqlSession session = getSqlSession();

		Mapper01 mapper = session.getMapper(Mapper01.class);

		Basebean bean = mapper.selectByID(1);
		System.out.println("data:" + bean);
		session.close();

	}

	@Test
	public void test3() throws IOException {
		SqlSession session = getSqlSession();

		Mapper01 mapper = session.getMapper(Mapper01.class);

		MyHashMap result[] = mapper.selectAll();

		System.out.println("Class=" + result.getClass());

		for (MyHashMap map : result) {

			System.out.println("map" + map + ",Class=" + map.getClass());

		}

		session.close();

	}

	@Test
	public void test4() throws IOException {

		SqlSession session = getSqlSession();

		Mapper01 mapper = session.getMapper(Mapper01.class);

		MyHashMap result[] = mapper.selectList2();

		System.out.println("Class=" + result.getClass());

		for (MyHashMap map : result) {

			System.out.println("map" + map + ",Class=" + map.getClass());

		}

		session.close();

	}
	
	@Test
	public void updateTest1() throws IOException {

		SqlSession session = getSqlSession();

		Mapper01 mapper = session.getMapper(Mapper01.class);

		Basebean bean=mapper.selectByID(8);
		bean.setName("aaa");
		bean.setName2("bbb");
		System.out.println("result:"+mapper.updateName(bean));
		session.commit();
		Basebean bean2=mapper.selectByID(8);
		System.out.println("id8="+bean2);
		//System.out.println("result:"+session.insert("addOne"));
		
		
		session.close();

	}
	
	@Test
	public void addTest1() throws IOException {

		SqlSession session = getSqlSession();

		Mapper01 mapper = session.getMapper(Mapper01.class);

		Basebean bean=new Basebean();
	
		bean.setName("dddd");
		bean.setName2("tttt");
		System.out.println("result:"+mapper.addOne(bean));
		//System.out.println("result:"+session.insert("addOne"));
		session.commit();
		
		session.close();

	}
	
	@Test
	public void deleteTest3() throws IOException {
		
		SqlSession session=getSqlSession();
		Mapper01 mapper=session.getMapper(Mapper01.class);
		String name="dddd";
		System.out.println("by名稱刪除:"+name+" result:"+mapper.deleteByName(name));
		
		session.commit();
		
		session.close();
		
		
		
	}
	
	@Test
	public void deleteTest2() throws IOException {
	SqlSession session=getSqlSession();
	
	Mapper01 mapper01=session.getMapper(Mapper01.class);
	
	MyHashMap result[] =mapper01.queryByName("dddd");
	
	int index=0;
	for(MyHashMap map:result) {
		index++;
		System.out.println("result:"+index+":"+map);
		Basebean basebean=new Basebean();
		basebean.setId((int) map.get("id"));
		basebean.setName((String) map.get("name"));
		basebean.setName2((String)map.get("name2"));
		
		System.out.println("Bean="+basebean);
		
		System.out.println("刪除:"+mapper01.deletebyId(basebean.getId()));
		
	}
	session.commit();
	
	session.close();
		
	}
	
	
	@Test
	
	public void deleteTest1() throws IOException {
		
		SqlSession session=getSqlSession();
		
		Mapper01 mapper01=session.getMapper(Mapper01.class);
		
		
		System.out.println("delete result:"+mapper01.deletebyId(8));
		
		session.commit();
		
		session.close();
		
		
	}

}
