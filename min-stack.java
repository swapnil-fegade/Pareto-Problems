class MinStack {

    // A simple inner class to hold both the value and the minimum at that point
    private class Node {
        int val;
        int min; // Minimum value up to this point in the stack

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int currentMin;
        if (stack.isEmpty()) {
            currentMin = val; // First element is its own minimum
        } else {
            // The minimum at this level is the smaller of the new value and the previous minimum
            currentMin = Math.min(val, stack.peek().min);
        }
        stack.push(new Node(val, currentMin));
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        
        return stack.peek().val;
    }
    
    public int getMin() {
        
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
