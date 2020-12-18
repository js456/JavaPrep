package com.jitendrasaini.tree.stack;

public class SortStack {
	
    public static void sortStack1(Stack<Integer> stack) {
        Stack<Integer>stack1 = new Stack<Integer>(stack.getMaxSize());
        Stack<Integer>stack2 = new Stack<Integer>(stack.getMaxSize());
        sortHelper(stack, stack1, stack2);
        
    }
    public static void sortStack(Stack<Integer> stack) {
        //1. Use a second tempStack.
        //2. Pop value from mainStack.
        //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
        //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
        //till mainStack is not empty.
        //4. When mainStack will be empty, tempStack will have sorted values in descending order.
        //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
        Stack<Integer> newStack = new Stack<>(stack.getMaxSize());
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if (!newStack.isEmpty() && value >= newStack.top()) {
                newStack.push(value);
            } else {
                while (!newStack.isEmpty() && newStack.top() > value)
                    stack.push(newStack.pop());
                newStack.push(value);
            }
        }

        while (!newStack.isEmpty())
            stack.push(newStack.pop());
    
    }
    public static void sortHelper(Stack<Integer> stack,Stack<Integer> stack1,Stack<Integer> stack2) {
    	if(stack.isEmpty()) {
    		return;
    	}
    	stack1.push(stack.pop());
        while(stack.getCurrentSize()>0) {
        	if(stack1.top()<stack.top()) {
        		stack2.push(stack1.pop());
        		stack1.push(stack.pop());
        	}else {
        		stack2.push(stack.pop());
        	}
        }
        sortHelper(stack2, stack1, stack);
    }
    public static void main(String[] args) {
		Stack<Integer>stack = new Stack<Integer>(5);
		stack.push(2);
		stack.push(6);
		stack.push(5);
		stack.push(8);
		stack.push(10);
		sortStack(stack);
	}

}
