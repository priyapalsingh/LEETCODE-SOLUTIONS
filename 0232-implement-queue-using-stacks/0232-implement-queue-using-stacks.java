class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
        
    }
    
    public void push(int x) {
        while(s1.empty()==false){
            s2.add(s1.peek());
            s1.pop();
        }
        s1.add(x);
        while(s2.empty()==false){
            s1.add(s2.peek());
            s2.pop();
        }
        
    }
    
    public int pop() {
        if (s1.empty()) {
            System.out.println("Stack is empty");

        }
        int val = s1.peek();
        s1.pop();
        return val;
        
    }
    
    public int peek() {
        if (s1.empty()) {
            System.out.println("Stack is empty");

        }
        return s1.peek();
        
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */