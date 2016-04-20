package practic.task7;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import nedis.study.interfaces.t7.threads.NamePrinter;

public class NamePrinterImpl2 implements NamePrinter, Runnable {

	private String name;
	private long ms;
	private int count;
	private PrintStream stream;
	
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		
		for (int i = 0; i < count; i++) {
			try {
				stream.write(Thread.currentThread().getName().getBytes());
				TimeUnit.MILLISECONDS.sleep(ms);
			} catch (IOException e1) {
				// NOP
			} catch (InterruptedException e) {
				// NOP
			}
		}
	}

	@Override
	public void setPrintName(String name) throws NullPointerException,
			IllegalArgumentException {
		if (name == null) {
			throw new NullPointerException("name is null");
		} else if (name.length() == 0) {
			throw new IllegalArgumentException("name.length() = 0");
		}
		
		this.name = name;
	}

	@Override
	public void setStream(PrintStream stream) throws NullPointerException {
		if (stream == null) {
			throw new NullPointerException("stream is null");
		}
		
		this.stream = stream;
	}

	@Override
	public void setInterval(long ms) throws IllegalArgumentException {
		if (ms <= 0) {
			throw new IllegalArgumentException("ms <= 0");
		}
		
		this.ms = ms;
	}

	@Override
	public void setCount(int count) throws IllegalArgumentException {
		if (count <= 0) {
			throw new IllegalArgumentException("count <= 0");
		}
		
		this.count = count;
	}

}
