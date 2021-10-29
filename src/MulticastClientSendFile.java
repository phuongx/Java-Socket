import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClientSendFile {

	public static void main(String[] args) {
		try {
			
			MulticastSocket ms = new MulticastSocket(2345);
			InetAddress ad = InetAddress.getByName("226.1.2.3");
			ms.joinGroup(ad);
			//tao goi nhan
			byte b [] = new byte[100000];
			int len = 100000;
			DatagramPacket goinhan = new DatagramPacket(b,len);
			//nhan goi
			ms.receive(goinhan);
			//xuly
			byte b1[] = goinhan.getData();
			int len1 = goinhan.getLength();
			FileOutputStream fos = new FileOutputStream("d:/tt_rsmtc.txt");
			fos.write(b1, 0, len1);
			System.out.println("Ghi file thanh cong");
			fos.close();
			//roi nhom
			ms.leaveGroup(ad);
		} catch (IOException e) {
			System.out.println("Loi khi tao SK.");
		}
		

	}

}
