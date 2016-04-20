package practic.task6;

import java.io.*;
import java.util.*;

import nedis.study.interfaces.t6.io.IOUtils;

public class IOUtilsImpl implements IOUtils {

	@Override
	public void replaceChars(Reader in, Writer out, String inChars,
			String outChars) throws NullPointerException,
			IllegalArgumentException {

		if (in == null || out == null) {
			throw new NullPointerException("in or out is null");
		} else if (inChars.length() != outChars.length()) {
			throw new IllegalArgumentException("inChars.lenght() not equal outChars.length()");
		}
		
		try(Reader reader = in;
			Writer writer = out) {
			
			int k = -1;
			loop: while((k = reader.read()) != -1) {
				for (int i = 0; i < inChars.length(); i++) {
					if (k == inChars.charAt(i)) {
						writer.write(outChars.charAt(i));
						continue loop;
					}
				}
				writer.write(k);
			}
			
		} catch (IOException e) {
			// NOP
		}

	}

	@Override
	public String[] findFiles(String dir) throws NullPointerException,
			IllegalArgumentException {
		
		if (dir == null) {
			throw new NullPointerException("dir is null");
		}
		
		File f = new File(dir);
		
		List<String> list = new ArrayList<>();
		find(list, f);
		String[] result = new String[list.size()];
		int k = 0;
		for (String iter : list) {
			result[k++] = iter;
		}
		return result;
	}
	
	private void find(List<String> result, File dir) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				find(result, file);
			} else if (file.isFile()) {
				if (file.getName().endsWith(".java")) {
					result.add(file.getAbsolutePath());
				}
			}
		}
	}

}
