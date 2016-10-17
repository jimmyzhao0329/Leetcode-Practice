import java.util.*;

public class min_queue {

	private static Queue<Integer> q;
	private static PriorityQueue<Integer> pq;

	public min_queue (){
		q = new LinkedList<Integer>();
		pq = new PriorityQueue<Integer>();
	}

	public static void offer(int x){
		q.offer(x);
		pq.offer(x);
	}

	public static void poll(){
		int temp = q.poll();
		pq.remove(temp);
	}

	public static int peek(){
		return q.peek();
	}

	public static int getMin(){
		return pq.peek();
	}

	public static void main(String[] args){
		min_queue mq = new min_queue();
		int[] arr = {3,5,2,1};
		for(int i : arr){
			mq.offer(i);
			System.out.println(mq.getMin());
		}
		mq.poll();
		mq.poll();
		mq.offer(0);
		System.out.println(mq.getMin());
	}
}