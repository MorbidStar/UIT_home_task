package practic.task6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

import nedis.study.interfaces.t6.io.FileAlreadyExistsException;
import nedis.study.interfaces.t6.io.FileCopyFailedException;
import nedis.study.interfaces.t6.io.FileCopyTestUtils;
import nedis.study.interfaces.t6.io.IOUtils;

public class Launcher {

	public static void main(String[] args) throws IOException, FileAlreadyExistsException, FileCopyFailedException {
		
		IOUtils test = new IOUtilsImpl();
//		Reader r = new InputStreamReader(new FileInputStream("D:/task6.txt"));
//		Writer w = new FileWriter("d:/taskRes.txt");
//		test.replaceChars(r, w, "357", "480");
		
//		String[] findX = test.findFiles("d:/djvureader/djvureader");
//		for (String s : findX) {
//			System.out.println(s);
//		}
		
		FileCopyTestUtils newTest = new FileCopyTestUtilsImpl();
		long start2 = System.currentTimeMillis();
		newTest.createBufferedFileCopyUtils().copyFile("d:/study/razer.mp4", "d:/razer2.mp4");
		long finish2 = System.currentTimeMillis();
		System.out.println(finish2 - start2);
		long start3 = System.currentTimeMillis();
		newTest.createChannelsFileCopyUtils().copyFile("d:/study/razer.mp4", "d:/razer3.mp4");
		long finish3 = System.currentTimeMillis();
		System.out.println(finish3 - start3);
		long start4 = System.currentTimeMillis();
		newTest.createJava7CopyUtils().copyFile("d:/study/razer.mp4", "d:/razer4.mp4");
		long finish4 = System.currentTimeMillis();
		System.out.println(finish4 - start4);
		long start = System.currentTimeMillis();
		newTest.createSimpleFileCopyUtils().copyFile("d:/study/razer.mp4", "d:/razer1.mp4");
		long finish = System.currentTimeMillis();
		System.out.println(finish - start);
		
	}

}
// долго :)     2.5    0.3(0.18)   0.48(0.21)