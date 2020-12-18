package com.jitendrasaini.tree.stack;

public class TwoStacks<V> {
    private int maxSize;
    private V[] array;
    private int stack1Top;
    private int stack2Top;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
        stack1Top = -1;
        stack2Top = max_size;
    }

    //insert at top of first stack
    public void push1(V value) {
    	if(stack1Top<stack2Top-1)
    		array[++stack1Top]= value;
    }

    //insert at top of second stack
    public void push2(V value) {
    	if(stack1Top<stack2Top-1)
    		array[--stack2Top]= value;
    }

    //remove and return value from top of first stack
    public V pop1() {
    	if(stack1Top>-1) {
    		return array[stack1Top--];
    	}
    	return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
    	if(stack2Top <maxSize) {
    		return array[stack2Top++];
    	}
        return null;
    }
    
    public static void main(String[] args) {
		TwoStacks<Integer>stack = new TwoStacks(5);
		stack.push1(2);
		stack.push1(3);
		stack.push2(5);
		stack.push2(6);
		stack.push2(7);
		System.out.println(stack.pop1());
		System.out.println(stack.pop2());
		System.out.println(stack.pop1());
		System.out.println(stack.pop2());
	}
}