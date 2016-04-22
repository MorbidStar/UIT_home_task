package practic.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import practic.task6.IOUtilsImpl;
import nedis.study.interfaces.t7.threads.FindFilesTask;
import nedis.study.interfaces.t7.threads.TaskExecutionFailedException;

public class FindFilesTaskImpl extends TaskImpl implements FindFilesTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(FindFilesTaskImpl.class);
	private String directory;
	private String searchString;
	private PrintStream out;
	private IOUtilsImpl iou;

	@Override
	public void setDirectory(String directory) throws NullPointerException,
			FileNotFoundException {
		
		if (directory == null) {
			throw new NullPointerException("directory is null");
		}
		
		File dirFrom = new File(directory);
		
		if (!dirFrom.exists() && !dirFrom.isDirectory()) {
			throw new FileNotFoundException("directory not exists");
		}
		
		this.directory = directory;
		LOGGER.debug("директория установлена");
	}

	@Override
	public void setFileNameSearchString(String searchString)
			throws IllegalArgumentException {
		if (searchString == null) {
			throw new IllegalArgumentException("searchString is null");
		}
		
		this.searchString = searchString;
	}

	@Override
	public void setPrintStream(PrintStream out) {
		this.out = out;
	}

	@Override
	public void execute() throws TaskExecutionFailedException {
		LOGGER.debug("start task");
		try {
			iou = new IOUtilsImpl();
			String[] res = iou.findFiles(directory, searchString);
			for (String s : res) {
				out.write(s.getBytes());
				out.println();
			}
		} catch (Exception e) {
			throw new TaskExecutionFailedException("задача выполнена некорректно", e);
		}
		LOGGER.debug("end task");
	}

}
