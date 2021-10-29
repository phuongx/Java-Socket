import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientDateTime {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",2345);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			Scanner nhap = new Scanner(System.in);
			//Gui yeu cau
			System.out.println("Moi nhap yeu cau: ");
			String yeucau = nhap.nextLine();
			pw.println(yeucau);pw.flush();
			//Nhan ngay gio 
			while (true) {
				String date = sc.nextLine();
				System.out.println(date);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("Loi noi ket.");
		} catch (IOException e) {
			System.out.println("Loi.");
		}
		

	}

}
