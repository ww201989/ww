package socket1;

import java.io.FileOutputStream;
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
//		byte[] bs = new byte[100];
//		in.read(bs);
//		System.out.println("client接受到的消息为："+new String(bs));
//		
		
		//
		byte[] bs = new byte[100];//接收每次发来的文件切片（100byte）
		int len  = -1;
		OutputStream fileOut = new FileOutputStream("D:\\aaa.txt");
		while ((len = in.read(bs)) != -1) {
			fileOut.write(bs,0,len);
		}
		fileOut.close();
		
		
		OutputStream output = socket.getOutputStream();
		String info = "world";
		output.write(info.getBytes());
		
		output.close();
		in.close();
		socket.close();
	}

}
