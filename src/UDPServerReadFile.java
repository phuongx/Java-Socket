import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerReadFile {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(2345);
			//Nhan goi yeu cau tu client
			byte b[] = new byte[100000];
			int len = 100000;
			DatagramPacket goinhan = new DatagramPacket(b,len);
			ds.receive(goinhan);
			//Xu ly yeu cau
			byte b1[] = goinhan.getData();
			int len1 = goinhan.getLength();
			InetAddress ad = goinhan.getAddress();
			int port = goinhan.getPort();
			String yeucau = new String(b1,0,len1);
			String tenfile = yeucau.substring(8);
			System.out.println(tenfile);
			File f = new File(tenfile);
			int size = (int) f.length();
			byte b2[] = new byte[size];
			if (f.exists() && f.isFile()) {
				FileInputStream fis = new FileInputStream(tenfile);
				int n = fis.read(b2);	
			} 
			DatagramPacket goigui = new DatagramPacket(b2,size,ad,port);
			ds.send(goigui);
		} catch (SocketException e) {
			System.out.println("Loi.");
		} catch (IOException e) {
			System.out.println("Loi khi nhan goi.");
		}
		
		//String str="hello";
		//StringBuilder str1 = new StringBuilder(str);
		//System.out.println(str1.reverse().toString());
	}

}
