package practic.task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import nedis.study.interfaces.t6.io.FileAlreadyExistsException;
import nedis.study.interfaces.t6.io.FileCopyFailedException;
import nedis.study.interfaces.t6.io.FileCopyUtils;

public class FileCopyUtilsJava7Impl implements FileCopyUtils {

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		
		File sour = new File(source);
		File dest = new File(destination);
		if (dest.exists()) {
			throw new FileAlreadyExistsException("File already exists");
		}
		
		try {
			Files.copy(sour.toPath(), dest.toPath());
		} catch (Exception e) {
			throw new FileCopyFailedException("Exception on copy", e);
		}

	}

}
