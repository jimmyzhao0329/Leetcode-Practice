// http://blog.csdn.net/pointbreak1/article/details/48840671

/** 
 * Definition for an interval. 
 * public class Interval { 
 *     int start; 
 *     int end; 
 *     Interval() { start = 0; end = 0; } 
 *     Interval(int s, int e) { start = s; end = e; } 
 * } 
 */  
import java.util.*;   
   
public class Meeting_Rooms_II { 

	public static class Interval { 
 	   int start; 
	   int end; 
 	   Interval() { start = 0; end = 0; } 
 	   Interval(int s, int e) { start = s; end = e; } 
 	} 

    public static int minMeetingRooms(Interval[] intervals) { 

    	if(intervals == null || intervals.length == 0){
    		return 0;
    	}

    	Arrays.sort(intervals, new Comparator<Interval>(){
    		@Override
    		public int compare(Interval I1, Interval I2){
    			return I1.start - I2.start;
    		}
    	});
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	int room = 0;

    	for(Interval meet : intervals){
    		if(pq.isEmpty()){
    			pq.offer(meet.end);
    			room++;
    			continue;
    		}

    		if(pq.peek() <= meet.start){
    			pq.poll();
    			pq.offer(meet.end);
    		}
    		else{
    			pq.offer(meet.end);
    			room++;
    		}
    	}

    	return room;
    }

    public static void main(String[] args){
    	int[][] meetings = {{0, 30},{5, 10},{15, 20},{0,5}, {3,6},{2,8}};
    	Interval[] intervals = new Interval[meetings.length];
    	int i = 0;
    	for(int[] arr : meetings){
    		intervals[i++] = new Interval(arr[0], arr[1]);
    	}
    	System.out.println(minMeetingRooms(intervals));
    }
}