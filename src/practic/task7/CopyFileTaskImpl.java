package practic.task7;

import nedis.study.interfaces.t6.io.FileAlreadyExistsException;
import nedis.study.interfaces.t6.io.FileCopyUtils;
import nedis.study.interfaces.t7.threads.CopyFileTask;
import nedis.study.interfaces.t7.threads.TaskExecutionFailedException;

public class CopyFileTaskImpl extends TaskImpl implements CopyFileTask {

	private String source;
	private String destination;
	private FileCopyUtils fcu;
	
	public CopyFileTaskImpl(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}

	@Override
	public void setFileCopyUtils(FileCopyUtils copyUtils) {
		fcu = copyUtils;
	}

	@Override
	public void execute() throws TaskExecutionFailedException {
		
		try {
			fcu.copyFile(source, destination);
		} catch (FileAlreadyExistsException e) {
			
		} catch (Exception e) {
			throw new TaskExecutionFailedException("задача выполнена некорректно", e);
		}
		
	}

	
}
