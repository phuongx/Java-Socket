import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerListThuMuc {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2345);
			Socket s = ss.accept();
			System.out.println("Da chap nhan 1 yeu cau noi ket");
			// Nhan yeu cau tu client
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			String yeucau = sc.nextLine();
			String ten = yeucau.substring(5);
			File f = new File(ten);
			if (f.exists() && f.isDirectory()) {
				String elm[] = f.list();
				int n = elm.length;
				pw.println(n);pw.flush();
				for (int i=0;i<n;i++) {
					File f1 = new File(elm[i]);
					if (f1.isDirectory()) {
						String kq = "["+elm[i]+"]";
						pw.println(kq);pw.flush();
					} else {
						pw.println(elm[i]);pw.flush();
					}
				}
			} else {
				pw.println("-1"); pw.flush();
			}
		} catch (IOException e) {
			System.out.println("Khoi tao Socket that bai.");
		}
		
	}

}
