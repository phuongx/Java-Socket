import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MulticastServerSendFile {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			//Tao goi gui
			byte b[] = new byte[100000];
			int len = 100000;
			InetAddress ad = InetAddress.getByName("226.1.2.3");
			int port = 2345;
			FileInputStream fis = new FileInputStream("d:/text_test.txt");
			int n = fis.read(b);
			DatagramPacket goigui = new DatagramPacket(b,n,ad,port);
			//gui goi
			int i = 0;
			while (true) {
				ds.send(goigui);
				System.out.println("Da gui goi thu "+i++);
				
				Thread.sleep(5000);
			}
			
		} catch (SocketException e) {
			System.out.println("Loi.");
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file.");
		} catch (UnknownHostException e) {
			System.out.println("Dia chi khong hop le.");
		} catch (IOException e) {
			System.out.println("Loi khi doc file.");
		} catch (InterruptedException e) {
			System.out.println("Loi khi tam ngung.");
		}
		
	}

}
