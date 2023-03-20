package Cs102hw3;

public class ArrayQueue  {
    private int[] data;
    private int f = 0;
    private int sz = 0;
    
    // Constructors    
    public ArrayQueue(int capacity) {
        data = new int[capacity];
    }
    
    // Methods
    public int size() {
        return sz;
    }
    
    public boolean isEmpty() {
        return (sz == 0);
    }
    
    public void enqueue(Integer e) throws IllegalStateException {
        
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }
    
    public Integer first() {
        if (isEmpty()) return null;    
        return data[f];
    }
    
    public Integer dequeue() {
        if (isEmpty()) return null;
        int answer = data[f];
        data[f] = 0; // Set the dequeued element to zero (or any other default value)
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}
