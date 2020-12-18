package com.jitendrasaini.tree.stack;

class QueueWithStack <V> {
    private Stack<V> stack;
    private int maxSize;
    private int currentSize;

    public QueueWithStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new Stack<V>(maxSize);
        currentSize =0;
        // Write -- Your -- Code
    }
  
    public void enqueue(V value){
      	if(currentSize<maxSize){
              stack.push(value);
              currentSize++;
          }
    }
    public V dequeue(){
		Stack<V> tempStack = new Stack<V>(currentSize);
        for(int i=1;i<currentSize;i++){
            tempStack.push(stack.pop());
        }
        V result = stack.pop();
        while(tempStack.getCurrentSize()>0){
            stack.push(tempStack.pop());
        }
        currentSize--;
        return result;
    }
    public boolean isEmpty(){
        //Write -- Your -- Code
        return currentSize == 0;
    }
    public static void main(String[] args) {
		QueueWithStack<Integer>queue= new QueueWithStack<Integer>(3);
		queue.enqueue(34);
		queue.enqueue(44);
		queue.enqueue(35);
		System.out.println(queue.dequeue());
		queue.enqueue(365);
		System.out.println(queue.dequeue());
	}
}
