package socket1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket socket = server.accept();
		System.out.println("与客户端连接成功！");
		
		//发送文字
		OutputStream out = socket.getOutputStream();
//		String info ="hello";
//		out.write(info.getBytes());
//		
		
		//发送文件
		File file = new File("D:\\Readme.txt");
		InputStream fileIn = new FileInputStream(file);
		byte[] fileBytes = new byte[100];
		int len = -1;
		while ((len=fileIn.read(fileBytes)) !=-1) {
			out.write(fileBytes,0,len);
		}
		fileIn.close();
		
		//
		InputStream inputStream = socket.getInputStream();
		byte[] bs = new byte[100] ;
		inputStream.read(bs);
		System.out.println("接受客户端发来的消息："+new String(bs));
				
		inputStream.close();
		out.close();
		socket.close();
		server.close();
	}

}
