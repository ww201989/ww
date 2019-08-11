package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//获取对象的实例，并操作对象
	public class ReflectDemo02 {
		public static void demo01() throws InstantiationException, IllegalAccessException {
			Class<?> perClazz = null;
			try {
				 perClazz = Class.forName("reflect.Person");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Person per = (Person)perClazz.newInstance();
			per.setName("zs");
			per.setAge(23);
			System.out.println(per.getName()+","+per.getAge());
			
			
		}
		
		public static void demo02() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
			Class<?> perClazz = null;
			try {
				 perClazz = Class.forName("reflect.Person");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Person per = (Person)perClazz.newInstance();
			Field idField = perClazz.getDeclaredField("id");
			//
			idField.setAccessible(true);
			
			idField.set(per, 1);
			System.out.println(per.getId());
			System.out.println("=======");
			
			Method method = perClazz.getDeclaredMethod("privateMethod", null);
			method.setAccessible(true);
			
			method.invoke(per, null		);
			Method method2 = perClazz.getDeclaredMethod("privateMethod2", String.class);
			method2.setAccessible(true);
			method2.invoke(per, "zs");
			
			
			
			
		}
		
		public static void demo03() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
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
			System.out.println("=====");
			Constructor<?>[] declaredConstructors = perClazz.getDeclaredConstructors();
			for (Constructor<?> constructor : declaredConstructors) {
				
				System.out.println(constructor);
			}
			
			System.out.println("=======");
			Constructor<?> constructor = perClazz.getConstructor(int.class);
			System.out.println(constructor);
			System.out.println("=======");
			Constructor<?> declaredConstructor = perClazz.getDeclaredConstructor(String.class);
			System.out.println(declaredConstructor);
			
			Person instance = (Person)constructor.newInstance(12);
			System.out.println(instance);
			Constructor<?> constructor2 = perClazz.getConstructor();
			Person instance2 = (Person)constructor2.newInstance();
			System.out.println(instance2);
			declaredConstructor.setAccessible(true);
			Person instance3 = (Person)declaredConstructor.newInstance("zs");
			System.out.println(instance3);
			
			
		}
		
		
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
//		demo01();
//		demo02();
		demo03();
	}
}
