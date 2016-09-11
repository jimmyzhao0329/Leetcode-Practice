// https://leetcode.com/problems/merge-intervals/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval l1, Interval l2){
                if(l1.start < l2.start){
                    return -1;
                }
                else if(l1.start == l2.start){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval i : intervals){
            if(i.start <= end){
                end = Math.max(end, i.end);
            }
            else{
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}