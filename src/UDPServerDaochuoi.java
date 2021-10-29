import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServerDaochuoi {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(2345);
			//tao goi nhan
			byte b[] = new byte[100000];
			int len = 100000;
			DatagramPacket goinhan = new DatagramPacket(b,len);
			//nhan goi
			ds.receive(goinhan);
			//xu ly
			byte b1[] = goinhan.getData();
			int len1 = goinhan.getLength();
			InetAddress ad = goinhan.getAddress();
			int port = goinhan.getPort();
			String chuoi = new String(b1,0,len1);
			StringBuilder str = new StringBuilder(chuoi);
			String ketqua = str.reverse().toString();
			// tao goi gui
			byte b2[] = ketqua.getBytes();
			int len2 = b2.length;
			DatagramPacket goigui = new DatagramPacket(b2,len2,ad,port);
			//gui goi
			ds.send(goigui);
		} catch (SocketException e) {
			System.out.println("Loi.");
		} catch (IOException e) {
			System.out.println("Loi khi nhan goi.");
		}
		
	}

}
