/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

public List<Interval> merge(List<Interval> intervals) {
    Interval prev = null;
    List<Interval> result = new ArrayList<>();
    Collections.sort(intervals, (a, b) -> a.start - b.start);
    for(Interval i : intervals){
        if(prev == null){
            prev = i;
        }
        else if(prev.end >= i.start){
            prev.end = Math.max(prev.end, i.end);
        }
        else{
            result.add(prev);
            prev = i;
        }
    }
    
    if(prev != null) result.add(prev);
    return result;
}