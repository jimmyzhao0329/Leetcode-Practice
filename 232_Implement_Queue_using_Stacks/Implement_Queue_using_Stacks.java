// https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();
    
    private void transfer(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(out.isEmpty()){
            transfer();
        }
        out.pop();
    }

    // Get the front element.
    public int peek() {
        if(out.isEmpty()){
            transfer();
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}