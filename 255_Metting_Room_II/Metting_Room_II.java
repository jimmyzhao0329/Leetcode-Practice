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
import java.util.Arrays; 
 
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
        	@Override
        	public int compare(Interval a, Interval b) {
        		return a.start - b.start;
   			}
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        int rooms = 0;
        for(int i = 0; i < intervals.length; i++) {
            if(minHeap.size() == 0) {
                minHeap.add(intervals[i].end);
                rooms++;
                continue;
            }
            if(minHeap.peek() <= intervals[i].start) {
                minHeap.poll();
                minHeap.add(intervals[i].end);
            } else {
                minHeap.add(intervals[i].end);
                rooms++;
            }
        }
        return rooms;
    }
}