package remote.procedure.call.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	//��ȡ�������˵Ķ�̬�������
	@SuppressWarnings("unchecked")
	public static <T> T getRemoteProxyObj(Class serviceInterface,InetSocketAddress addr) {
		//proxy:����Ķ���   method���ĸ�����   args�������б�
		return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader()	, new Class<?>[] {serviceInterface} ,new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				//�ͻ��˵�����˷�������
				Socket socket = new Socket();
				ObjectOutputStream output = null;
				ObjectInputStream input = null;
				try {
				socket.connect(addr);
				output = new ObjectOutputStream(socket.getOutputStream());
				output.writeUTF(serviceInterface.getName());
				output.writeUTF(method.getName());
				
				output.writeObject(method.getParameterTypes());
				output.writeObject(args);
				
				input = new ObjectInputStream(socket.getInputStream());
				return input.readObject();
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					return null;
				}finally {
					try {
						if(output!=null)output.close(); 
						if(input!=null)input.close(); 
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		} );
	}

}
