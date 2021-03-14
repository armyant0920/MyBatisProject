package Mapper;

import bean.Basebean;
import bean.MyHashMap;

public interface Mapper01 {
	
	MyHashMap[]  selectAll();
	
	MyHashMap[]  selectList2();
	
	MyHashMap[] queryByName(String name);
	
	int addOne(Basebean bean);
	
	int updateName(Basebean bean);
	
	
	
	
	Basebean selectByID(int id);
	
	int updateName(int id,String name);
	
	int deletebyId(int id);
	
	int deleteByName(String name);
	
	
	

	
	
	

}
