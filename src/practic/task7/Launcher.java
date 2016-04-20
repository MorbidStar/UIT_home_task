package practic.task7;

import java.io.FileNotFoundException;

import practic.task6.FileCopyUtilsJava7Impl;
import practic.task6.IOUtilsImpl;
import nedis.study.interfaces.t6.io.IOUtils;
import nedis.study.interfaces.t7.threads.FindFilesTask;
import nedis.study.interfaces.t7.threads.NamePrinter;
import nedis.study.interfaces.t7.threads.TaskExecutionFailedException;
import nedis.study.interfaces.t7.threads.TasksStorage;

public class Launcher {

	public static void main(String[] args) throws NullPointerException, FileNotFoundException, TaskExecutionFailedException {
//		NamePrinterImpl np = new NamePrinterImpl();
//		np.setCount(5);
//		np.setInterval(1000);
//		np.setPrintName("Thread-8");
//		np.setStream(System.out);
//		np.start();
		
//		NamePrinterImpl2 np4 = new NamePrinterImpl2();
//		np4.setCount(3);
//		np4.setInterval(500);
//		np4.setPrintName("Thread-24");
//		np4.setStream(System.out);
//		Thread t1 = new Thread(np4);
//		t1.start();
		
		FindFilesTask ffti = new FindFilesTaskImpl();
		ffti.setDirectory("d:/musik");
		ffti.setFileNameSearchString(".mp3");
		ffti.setPrintStream(System.out);
//		ffti.execute();
		FindFilesTask ffti2 = new FindFilesTaskImpl();
		ffti2.setDirectory("d:/djvureader");
		ffti2.setFileNameSearchString(".dll");
		ffti2.setPrintStream(System.out);
//		ffti2.execute();
		FindFilesTask ffti3 = new FindFilesTaskImpl();
		ffti3.setDirectory("d:/FavoriteVideo");
		ffti3.setFileNameSearchString(".mp4");
		ffti3.setPrintStream(System.out);
		FindFilesTask ffti4 = new FindFilesTaskImpl();
		ffti4.setDirectory("d:/photo");
		ffti4.setFileNameSearchString(".JPEG");
		ffti4.setPrintStream(System.out);
		FindFilesTask ffti5 = new FindFilesTaskImpl();
		ffti5.setDirectory("d:/");
		ffti5.setFileNameSearchString(".PNG");
		ffti5.setPrintStream(System.out);
		
		CopyFileTaskImpl cfti = new CopyFileTaskImpl("D:/musik/Kipelov/01-На Распутье.mp3", "d:/1.mp3");
		cfti.setFileCopyUtils(new FileCopyUtilsJava7Impl());
		CopyFileTaskImpl cfti2 = new CopyFileTaskImpl("D:/musik/Kipelov/02-Дыханье Тьмы.mp3", "d:/2.mp3");
		cfti2.setFileCopyUtils(new FileCopyUtilsJava7Impl());
		CopyFileTaskImpl cfti3 = new CopyFileTaskImpl("D:/musik/Kipelov/03-Пророк.mp3", "d:/3.mp3");
		cfti3.setFileCopyUtils(new FileCopyUtilsJava7Impl());
//		cfti.execute();
		
		TasksStorage ts = new TaskStorageImpl();
		ts.add(ffti);
		ts.add(ffti2);
		ts.add(ffti3);
		ts.add(ffti4);
		ts.add(ffti5);
		ts.add(cfti);
		ts.add(cfti2);
		ts.add(cfti3);
		System.out.println(ts.count());
		TaskExecutorImpl te1 = new TaskExecutorImpl();
		TaskExecutorImpl te2 = new TaskExecutorImpl();
		TaskExecutorImpl te3 = new TaskExecutorImpl();
		te1.setStorage(ts);
		te2.setStorage(ts);
		te3.setStorage(ts);
		Thread t1 = new Thread(te1);
		Thread t2 = new Thread(te2);
		Thread t3 = new Thread(te3);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
