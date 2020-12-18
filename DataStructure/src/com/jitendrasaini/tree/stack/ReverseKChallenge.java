package com.jitendrasaini.tree.stack;

class ReverseKChallenge {
    public static <V> void reverseK(Queue<V> queue, int k) {
        Stack<V> stack = new Stack<V>(k);
        //push K element into the stack
        while(k>0){
            stack.push(queue.dequeue());
            k--;
        }
        //traverse the complet queue
        for(int i =0; i<queue.getMaxSize(); i++){
            if(stack.getCurrentSize() >0){
                queue.enqueue(stack.pop());
            }else{
                queue.enqueue(queue.dequeue());
            }
            
        }
    }
    
    public static void main(String[] args) {
		Queue<Integer>queue = new Queue<Integer>(3);
		queue.enqueue(23);
		queue.enqueue(25);
		queue.enqueue(27);
		reverseK(queue, 3);
	}
}
