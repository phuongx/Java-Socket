import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClientReadFile {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Nhap ten file: ");
			String tenfile = sc.nextLine();
			System.out.println("Nhap ten file luu: ");
			String tenluu = sc.nextLine();
			String yeucau = "READUDP "+tenfile;
			//Tao goi gui
			byte b[] = yeucau.getBytes();
			int len = yeucau.length();
			InetAddress ad = InetAddress.getByName("127.0.0.1");
			int port = 2345;
			DatagramPacket goigui = new DatagramPacket(b,len,ad,port);
			//gui goi
			ds.send(goigui);
			//tao goi nhan
			byte b1[] = new byte[100000];
			int len1 = 100000;
			DatagramPacket goinhan = new DatagramPacket(b1,len1);
			//nhan goi
			ds.receive(goinhan);
			//xu ly
			byte b2[] = goinhan.getData();
			int len2 = goinhan.getLength();
			System.out.println(len2);
			if (len2 >0) {
				FileOutputStream fis = new FileOutputStream(tenluu);
				fis.write(b2, 0 , len2);
				System.out.println("Luu file thanh cong");
			} else System.out.println("Ten file khong ton tai hoac file rong.");
		} catch (SocketException e) {
			System.out.println("Loi.");
		} catch (IOException e) {
			System.out.println("Loi khi nhan goi.");
		}

	}

}
