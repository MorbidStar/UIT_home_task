package practic.task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.file.Files;

import nedis.study.interfaces.t6.io.FileAlreadyExistsException;
import nedis.study.interfaces.t6.io.FileCopyFailedException;
import nedis.study.interfaces.t6.io.FileCopyUtils;

public class FileCopyUtilsCanImpl implements FileCopyUtils {

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		
		File sour = new File(source);
		File dest = new File(destination);
		
		if (dest.exists()) {
			throw new FileAlreadyExistsException("File already exists");
		}
		
		try (FileInputStream fis = new FileInputStream(sour);
			 FileOutputStream fos = new FileOutputStream(dest);
			 FileChannel fcin = fis.getChannel();	
			 FileChannel fcout = fos.getChannel();) {
			
			fcin.transferTo(0, fcin.size(), fcout);
		} catch (IOException e) {
			throw new FileCopyFailedException("Exception on copy", e);
		} 
		
	}

}
