package lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class While {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < 10) {
			System.out.println("Hello World " + i++);
		}
		
		try (InputStream input = new FileInputStream("C:\\1.txt");
			  OutputStream out = new FileOutputStream("C:\\2.txt")) {
			
			
			
		}
	}

}
