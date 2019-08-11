package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//通过反射获取类
public class ReflectDemo01 {

	public static void demo01() {
		//1.Class.forname(全类名）2.XX.class3.
				try {
					Class<?> perClazz = Class.forName("reflect.Person");
					System.out.println(perClazz);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Class<?> perClazz2 = Person.class;
				System.out.println(perClazz2);
				
				Person per = new Person();
				Class<?>perClazz3 = per.getClass();
				System.out.println(perClazz3);
		
	}
	
	//获取方法
	public static void demo02() {
		Class<?> perClazz = null;
		try {
			 perClazz = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		Method[] methods = perClazz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("=========");
		
		//获取当前类的所有方法
		Method[] declaredMethods = perClazz.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println(declaredMethod);
		}
	}
	
	//获取所有的接口
	public static void demo03() {
		Class<?> perClazz = null;
		try {
			 perClazz = Class.forName("reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class<?>[] interfaces = perClazz.getInterfaces();
		for (Class<?> inter : interfaces) {
			System.out.println(inter);
			
		}
	}
	
	//获取所有的父类
		public static void demo04() {
			Class<?> perClazz = null;
			try {
				 perClazz = Class.forName("reflect.Person");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Class<?> superclass = perClazz.getSuperclass();
			System.out.println(superclass);
		}
		
		//获取所有的构造方法
		public static void demo05() {
			Class<?> perClazz = null;
			try {
				 perClazz = Class.forName("reflect.Person");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Constructor<?>[] constructors = perClazz.getConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}
		}
	
		//获取所有的公告属性
		public static void demo06() {
			Class<?> perClazz = null;
			try {
				 perClazz = Class.forName("reflect.Person");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Field[] fields = perClazz.getFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			//所有属性
			System.out.println("=========");
			Field[] declaredFields = perClazz.getDeclaredFields();
			for (Field declaredField : declaredFields) {
				System.out.println(declaredField);
			}
			
		}
		
		//获取所有的接口
		public static void demo07() throws InstantiationException, IllegalAccessException {
			Class<?> perClazz = null;
			try {
				 perClazz = Class.forName("reflect.Person");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Object Instance = perClazz.newInstance();
			Person person = (Person)Instance;
			person.interface2Method();
			
		}
		
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		demo02();
//		demo03();
//		demo04();
//		demo05();
//		demo06();
		demo07();

	}
}
