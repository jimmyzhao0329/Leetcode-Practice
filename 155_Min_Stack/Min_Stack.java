// https://leetcode.com/problems/min-stack/

public class MinStack {
    
    private LinkedList<Integer> list;
    private List<Integer> minHere;
    
    public MinStack() {
        list = new LinkedList<Integer>();
        minHere = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
        if(minHere.isEmpty()){
            minHere.add(x);
        }
        else{
            int temp = minHere.get(minHere.size() - 1);
            if(temp > x){
                minHere.add(x);
            }
            else{
                minHere.add(temp);
            }
        }
        
    }
    
    public void pop() {
        list.removeLast();
        minHere.remove(minHere.size() - 1);
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        return minHere.get(minHere.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */