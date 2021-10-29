import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerReadFile {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2345);
			System.out.println("Dang cho noi ket");
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			// Nhan yeu cau tu client
			String yeucau = sc.nextLine();
			String tenfile = yeucau.substring(5);
			System.out.println(tenfile);
			//Xu ly yeu cau
			File f = new File(tenfile);
			if (f.exists() && f.isFile()) {
				int size = (int) f.length();
				pw.println(size);pw.flush();
				
				byte b[] = new byte[size];
				FileInputStream fis = new FileInputStream(tenfile);
				DataInputStream dis = new DataInputStream(fis);
				dis.readFully(b);
				System.out.println("Da doc xong file");
				DataOutputStream dos = new DataOutputStream(os);
				dos.write(b, 0 , size);
				fis.close();
			}	else {
				pw.println("-1"); pw.flush();
			}
		} catch (IOException e) {
			System.out.println("Loi noi ket.");
		}
		
		
	}

}
