import java.util.*;

public class task_with_cooldown{
	public static int min_time(int[] tasks, int interval){
		if(tasks == null || tasks.length == 0){
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int time = 0;
		for(int task : tasks){
			Integer task_last_time = map.get(task);
			if(task_last_time != null && task_last_time + interval + 1 > time){
				time = task_last_time + interval + 1;
			}
			map.put(task, time);
			time++;
		}
		return time;
	}

	public static void main(String[] args){
		int[] tasks = {1, 2,3,2,3};
		System.out.println(min_time(tasks, 3));
	}
}