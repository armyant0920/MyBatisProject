import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class UniformTest {
	
	public static void main(String[] args) {
		String s="111";
		String temp=String.format("%09d", Integer.parseInt(s));
		System.out.println(temp);
	}

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
	
	@Test
	public void Test2() {
		
		String temp=String.format("%09s", "x");
		System.out.println(temp);
	}
	
	@Test
	
	public void number(){
		
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<=99999;i++) {
		
			String temp=String.format("%08d", i);
			if(Verification.checkUniform(temp)) {
				list.add(temp);
				
				
			}
			
		}
		System.out.println("0開頭共有"+list.size()+"個");
		boolean run=true;
		while(run) {
			
			Scanner scanner=new Scanner(System.in);
			String s=scanner.next();
			if(s.equals("z")) {
				String temp=list.get(new Random().nextInt(list.size()));
				System.out.printf("字串%s是統編%b",temp,Verification.checkUniform(temp));
			}else{
				run=false;
			};
			
		}
		
		
		
		
	}

}
