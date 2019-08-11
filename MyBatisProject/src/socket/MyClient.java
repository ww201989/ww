package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException  {
		Socket socket = new Socket("127.0.0.1",9999);
		
		//
		InputStream in = socket.getInputStream();
		byte[] bs = new byte[100];
		in.read(bs);
		System.out.println("client接受到的消息为："+new String(bs));
		
		OutputStream output = socket.getOutputStream();
		String info = "world";
		output.write(info.getBytes());
		
		output.close();
		in.close();
		socket.close();
	}

}
