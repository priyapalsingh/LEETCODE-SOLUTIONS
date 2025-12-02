import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;
class StockSpanner {
    private Stack<SimpleEntry<Integer,Integer>> stack;
    public StockSpanner() {
        stack=new Stack<>();       
    }
    
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty() && stack.peek().getKey()<=price){
            span+=stack.pop().getValue();
        }
        stack.push(new SimpleEntry<>(price,span));
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */