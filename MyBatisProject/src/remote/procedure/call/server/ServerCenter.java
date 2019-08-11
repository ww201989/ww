package remote.procedure.call.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.sun.xml.internal.ws.wsdl.writer.document.Port;

//服务中心的具体实现
public class ServerCenter implements Server{
	private static int port ;
	public ServerCenter(int port) {
		this.port = port;
	}
	@Override
	public void start()  {
		// TODO Auto-generated method stub
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		try {
			ServerSocket server = new ServerSocket();		
			
			server.bind(new InetSocketAddress(port));
			Socket socket = server.accept();
			input = new ObjectInputStream(socket.getInputStream());
			String serviceName = input.readUTF();
			String methodName = input.readUTF();
			Class[] parameterTypes = (Class[])input.readObject();
			Object[] arguments = (Object[])input.readObject();
			
			Class ServiceClass = serviceRegiser.get(serviceName);
			Method method = ServiceClass.getMethod(methodName, parameterTypes);
			Object result = method.invoke(ServiceClass.newInstance(), arguments);
			output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			try {
				if(output!=null)output.close(); 
				if(input!=null)input.close(); 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

		//map
	private static HashMap<String, Class> serviceRegiser = new HashMap<>();
	
	@Override
	public void register(Class service,Class serviceImpl) {
		serviceRegiser.put(service.getName(), serviceImpl);
		// TODO Auto-generated method stub
		
	}
	

}
