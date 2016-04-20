package practic.task7;

import java.util.concurrent.TimeUnit;

import nedis.study.interfaces.t7.threads.Task;
import nedis.study.interfaces.t7.threads.TaskExecutionFailedException;
import nedis.study.interfaces.t7.threads.TaskExecutor;
import nedis.study.interfaces.t7.threads.TasksStorage;

public class TaskExecutorImpl implements TaskExecutor, Runnable {
	
	private TasksStorage storage;
	private boolean isStop;

	@Override
	public void setStorage(TasksStorage storage) throws NullPointerException {
		if (storage == null) {
			throw new NullPointerException("storage is null");
		}
		
		this.storage = storage;
	}

	@Override
	public TasksStorage getStorage() {
		return storage;
	}

	@Override
	public void start() throws NullPointerException, IllegalStateException {
		if (storage == null) {
			throw new NullPointerException("storage is null");
		}
		
		while (!isStop) {
			if (storage.count() > 0) {
				Task task = storage.get();
				if (task != null) {
					try {
						task.execute();
					} catch (TaskExecutionFailedException e) {
						task.incTryCount();
						if (task.getTryCount() < 5) {
							storage.add(task);
						}
					}
				} else {
					isStop = true;
				}
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// NOP
			}
		}

	}

	@Override
	public void stop() throws IllegalStateException {
		isStop = true;
	}

	@Override
	public void run() {
		start();
	}

}
