package practic.task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import nedis.study.interfaces.t6.io.FileAlreadyExistsException;
import nedis.study.interfaces.t6.io.FileCopyFailedException;
import nedis.study.interfaces.t6.io.FileCopyUtils;

public class FileCopyUtilsImpl implements FileCopyUtils {

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {

		File f = new File(destination);
		if (f.exists()) {
			throw new FileAlreadyExistsException("File already exists");
		}
		
		try (InputStream input = new FileInputStream(source);
			 OutputStream output = new FileOutputStream(destination)) {
			
			int k = -1;
			while( (k = input.read()) != -1) {
				output.write(k);
			}
		} catch (Exception e) {
			throw new FileCopyFailedException("Exception on copy", e);
		}

	}

}
