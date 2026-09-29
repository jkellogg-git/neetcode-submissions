class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        this.stack = new Stack<>();
        this.min_stack = new Stack<>();
    }
    
    public void push(int val) {
        int min_val = 0;
        if (!this.min_stack.isEmpty()) {
            min_val = Math.min(this.min_stack.peek(), val);
            
        } else {
            min_val = val;
        }
        this.stack.push(val);
        this.min_stack.push(min_val);
    }
    
    public void pop() {
        this.stack.pop();
        this.min_stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min_stack.peek();
    }
}
