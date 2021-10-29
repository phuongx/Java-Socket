import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientReadFile {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",2345);
			System.out.println("Tao Socket thanh cong");
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			//Gui ten file qua server
			Scanner nhap = new Scanner(System.in);
			System.out.println("Nhap ten file muon doc: ");
			String tenfile = nhap.nextLine();
			System.out.println("Nhap ten file can luu: ");
			String tenluu = nhap.nextLine();
			String yeucau = "READ "+tenfile;
			pw.println(yeucau); pw.flush();
			System.out.println("Da gui yeu cau cau den Server");
			//Nhan du lieu tu server
			String str = sc.nextLine();
			int size = Integer.parseInt(str);
			if (size == -1) {
				System.out.println("Ten file khong hop le");
			} else if (size ==0) {
				System.out.println("File trong");
			} else {
				byte b[] = new byte[100000];
				int n = is.read(b, 0 , size);
				FileOutputStream fos = new FileOutputStream(tenluu);
				fos.write(b, 0 , n);
				fos.close();
				System.out.println("Ghi file thanh cong");
			}
		} catch (UnknownHostException e) {
			System.out.println("Loi noi ket");
		} catch (IOException e) {
			System.out.println("Khong tao duoc Socket");
		}
		

	}

}
