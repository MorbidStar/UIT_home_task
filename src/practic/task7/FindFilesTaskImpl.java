package practic.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;

import practic.task6.IOUtilsImpl;
import nedis.study.interfaces.t6.io.IOUtils;
import nedis.study.interfaces.t7.threads.FindFilesTask;
import nedis.study.interfaces.t7.threads.Task;
import nedis.study.interfaces.t7.threads.TaskExecutionFailedException;

public class FindFilesTaskImpl extends TaskImpl implements FindFilesTask {

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
	}

}
