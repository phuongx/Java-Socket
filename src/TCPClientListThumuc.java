import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientListThumuc {
	public static void main(String[] args) {
		String dcSV = "127.0.0.1";
		int port = 2345;
		try {
			Socket s = new Socket(dcSV,port);
			System.out.println("Da ket noi thanh cong");
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			//Nhap ten thu muc
			Scanner nhap = new Scanner(System.in);
			System.out.println("Nhap ten thu muc: ");
			String ten = nhap.nextLine();
			String yeucau = "LIST "+ten;
			//Gui yeu cau qua Server
			pw.println(yeucau); pw.flush();
			//Nhan ket qua
			String str = sc.nextLine();
			int n = Integer.parseInt(str);
			System.out.println(n);
			if ( n > 0)	{
				for (int i=0;i<n;i++) {
					String kq = sc.nextLine();
					String tenfile = ten+"/"+kq;
					File f = new File(tenfile);
					if (f.isFile())
						System.out.println(kq);
					else System.out.println("["+kq+"]");
				}
			} else if (n == 0)	System.out.println("Thu muc rong.");
			else System.out.println("Ten thu muc khong hop le");
		} catch (UnknownHostException e) {
			System.out.println("Loi ket noi");
		} catch (IOException e) {
			System.out.println("Loi ket noi");
		}
		
	}
}
