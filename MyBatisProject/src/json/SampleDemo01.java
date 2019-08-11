package json;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SampleDemo01 {
	//Map-->JSON
	public static void demo01() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("s01", "zs");
		map.put("s02", "ls");
		map.put("s03", "ww");
		JSONObject jsonObject = new JSONObject(map);
		System.out.println(jsonObject);
		
	}
	
	//JavaBean-->Json
	public static void demo02() {
		Person person = new Person();
		person.setName("zs");
		person.setAge(23);
		
		Address address = new Address("北京","西安");
		person.setAddress(address);
		
		JSONObject jsonObject = new JSONObject(person);
		System.out.println(jsonObject);
	}
	
	public static void main(String[] args) throws IOException {
//		demo01();
//		demo02();
//		demo03();
//		SampleDemo01 sample = new SampleDemo01();
//		sample.demo04();
		demo05();
	}
	//String-->JSON
	public static void demo03() {
		String string = "{\"name\":\"zs\",\"age\":23}";
		JSONObject jsonObject = new JSONObject(string);
		System.out.println(jsonObject);
	}
	
	//文件-->JSON
	public void demo04() throws IOException {
//		InputStream inputStream = super.getClass().getClassLoader().getResourceAsStream("json/per.json");
//		byte[] bs  = new byte[10];
//		int len = -1;
//		StringBuffer stringBuffer = new StringBuffer();
//		while ((len=inputStream.read(bs))!=-1){
//			String string  = new String(bs,0,len);
//			stringBuffer.append(string);
//			
//		}
		
		//commons-io.jar
		String s =FileUtils.readFileToString(new File("D:\\workspace-sts\\MyBatisProject\\src\\json\\per.json"));
		JSONObject jsonObject = new JSONObject(s);
		System.out.println(jsonObject);
//		System.out.println(stringBuffer);
	}
	
	//生成json文件
	public static void demo05() throws JSONException, IOException {
		Map<String, Person> map = new HashMap<>();
		Person p1= new Person(23,"zs",new Address("xa","bj"));
		Person p2= new Person(24,"ls",new Address("xa23","bj2"));
		Person p3= new Person(25,"ww",new Address("xa3","bj3"));
		map.put("zs", p1);
		map.put("ls", p2);
		map.put("ww", p3);
		JSONObject jsonObject  = new JSONObject(map);
		//
		Writer writer = new FileWriter("D:\\p.obj");
		jsonObject.write(writer);
		writer.close();
	}

}
