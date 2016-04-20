package practic.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import nedis.study.interfaces.t6.io.FileAlreadyExistsException;
import nedis.study.interfaces.t6.io.FileCopyFailedException;
import nedis.study.interfaces.t6.io.FileCopyUtils;

public class FileCopyUtilsBufImpl implements FileCopyUtils {

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		
		File f = new File(destination);
		if (f.exists()) {
			throw new FileAlreadyExistsException("File already exists");
		}
		
		try (BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
			 BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination)))) {
			
			while(input.ready()) {
				String tmp = input.readLine();
				output.write(tmp);
			}
		} catch (Exception e) {
			throw new FileCopyFailedException("Exception on copy", e);
		}

	}

}
