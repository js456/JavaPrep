package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer>{

	int arr[];
	
	private static final int THRESHOLD = 20;
	public CustomRecursiveTask(int[] arr) {
		this.arr = arr;
	}


	@Override
	protected Integer compute() {
		if(arr.length>THRESHOLD) {
			return ForkJoinTask.invokeAll(createSubtasks()).stream().mapToInt(ForkJoinTask::join).sum();
		}
		return null;
	}

	
    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        return dividedTasks;
    }
    
    public static void main(String[] args) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		int arr[] = new int[50];
		for(int i=0;i<50;i++)
			arr[i]= i;
		CustomRecursiveTask task = new CustomRecursiveTask(arr);
		pool.execute(task);
		int result = task.join();
		System.out.println(result);
	}
}
