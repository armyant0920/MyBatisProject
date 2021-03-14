import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.junit.Test;

public class UniformTest {

	@Test
	public void test() {
		
		List<String>list=new ArrayList<String>();
		
		String code1="12345678";
		String code2="20828393";
		String code3="00238778";
		
		list.add(code1);
		list.add(code2);
		list.add(code3);
		list.add("哇哈哈");
		
		for(String s:list) {
			System.out.println(s+"是統編:"+Verification.checkUniform(s));
			
		}
		
//		System.out.println(code1+"是統編:"+Verification.checkUniform(code1));
//		System.out.println(code2+"是統編:"+Verification.checkUniform(code2));
//		System.out.println(code3+"是統編:"+Verification.checkUniform(code3));
	}

}
