import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClientDaochuoi {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			//nhap chuoi
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap mot chuoi ky tu: ");
			String chuoi = sc.nextLine();
			//tao goi gui
			byte b[] = chuoi.getBytes();
			int len = b.length;
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
			String ketqua = new String(b2,0,len2);
			System.out.println(ketqua);
		} catch (SocketException e) {
			System.out.println("Loi.");
		} catch (IOException e) {
			System.out.println("Loi khi nhan goi.");
		}
	}

}
