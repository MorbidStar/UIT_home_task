package practic.task7;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import nedis.study.interfaces.t7.threads.Task;
import nedis.study.interfaces.t7.threads.TasksStorage;

public class TaskStorageImpl implements TasksStorage {
	
	private Queue<Task> queue = new ConcurrentLinkedQueue<>();

	@Override
	public void add(Task task) throws NullPointerException {
		if (task == null) {
			throw new NullPointerException("task is null");
		} else if (task.getTryCount() < 5) {
			queue.add(task);
		}
	}

	@Override
	public Task get() {
		return queue.poll();
	}

	@Override
	public int count() {
		return queue.size();
	}

}
