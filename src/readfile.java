import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class readfile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten file: ");
		String tenfile = sc.nextLine();
		File f = new File(tenfile);
		int size = (int) f.length();
		if (f.isFile()) {
			if (size > 0) {
				try {
					byte b [] = new byte[100000];
					FileInputStream fis = new FileInputStream(tenfile);
					int n = fis.read(b);
					String noidung = new String(b,0,n);
					System.out.println("Noi dung file: ");
					System.out.println(noidung);
					System.out.println("CACH 2:");
					
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found!");
				} catch (IOException e) {
					System.out.println("IO Exception!");
				}
				
			} else System.out.println("File rong!");
		} else System.out.println("File khong ton tai!");

	}

}
