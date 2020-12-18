package com.jitendrasaini.tree;


public class FindBinChallenge {
	
	// Find binary number upto n
	public static String[] findBinaryArr(int n) {
		
		String []result = new String[n];
		Queue<Integer>queue = new Queue<Integer>(n + 1);
		queue.enqueue(1);
        for (int i = 0; i < n; i++) {
            result[i] = String.valueOf(queue.dequeue());
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(Integer.parseInt(s1));
            queue.enqueue(Integer.parseInt(s2));
        }
		return result;
		
	}
	
	public static void main(String[] args) {
		findBinaryArr(6);
	}

}
class Queue<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Un-comment the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }
    
    public V top() {
        return array[front];
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(V value) {
        if (isFull())
            return;
        back = (back + 1) % maxSize; //to keep the index in range
        array[back] = value;
        currentSize++;
    }

    public V dequeue (){
        if(isEmpty())
            return null;

        V temp = array[front];
        front = (front + 1) % maxSize; //to keep the index in range
        currentSize--;

        return temp;
    }
}

