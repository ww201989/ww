package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//ͨ�������ȡ��
public class ReflectDemo01 {

	public static void demo01() {
		//1.Class.forname(ȫ������2.XX.class3.
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
	
	//��ȡ����
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
		
		//��ȡ��ǰ������з���
		Method[] declaredMethods = perClazz.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println(declaredMethod);
		}
	}
	
	//��ȡ���еĽӿ�
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
	
	//��ȡ���еĸ���
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
		
		//��ȡ���еĹ��췽��
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
	
		//��ȡ���еĹ�������
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
			//��������
			System.out.println("=========");
			Field[] declaredFields = perClazz.getDeclaredFields();
			for (Field declaredField : declaredFields) {
				System.out.println(declaredField);
			}
			
		}
		
		//��ȡ���еĽӿ�
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
