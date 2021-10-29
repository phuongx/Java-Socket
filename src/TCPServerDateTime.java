import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class TCPServerDateTime {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2345);
			System.out.println("Khoi tao thanh cong. Dang cho noi ket...");
			Socket s = ss.accept();
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			//Nhan yeu cau tu client
			String yeucau = sc.nextLine();
			System.out.println(yeucau);
			//Gui ngay gio den client
			while (true) {
				Date date = new Date();
				String str = date.toString();
				pw.println(str);pw.flush();
				Thread.sleep(5000);
				
			}
			
		} catch (IOException e) {
			System.out.println("Loi server.");
		} catch (InterruptedException e) {
			System.out.println("Loi khi tam ngung.");
		}

	}

}
