package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();
		System.out.println("��ͻ������ӳɹ���");
		
		//
		OutputStream out = socket.getOutputStream();
		String info ="hello";
		out.write(info.getBytes());
		
		//
		InputStream inputStream = socket.getInputStream();
		byte[] bs = new byte[100] ;
		inputStream.read(bs);
		System.out.println("���ܿͻ��˷�������Ϣ��"+new String(bs));
				
		inputStream.close();
		out.close();
		socket.close();
		server.close();
	}

}
