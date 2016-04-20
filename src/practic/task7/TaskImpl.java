package practic.task7;

import nedis.study.interfaces.t7.threads.Task;
import nedis.study.interfaces.t7.threads.TaskExecutionFailedException;

public abstract class TaskImpl implements Task {

	private int countTask = 0;

	@Override
	public int getTryCount() {
		return countTask;
	}

	@Override
	public void incTryCount() {
		countTask++;
	}

	@Override
	public void execute() throws TaskExecutionFailedException {
		// TODO
		System.out.println("TaskImpl");
	}

}
