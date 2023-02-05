package ClassesPart;

public class Passenger {

    private int front,end = 0;
    private final String[] queue;

    public Passenger(int capacity){
        this.queue = new String[capacity];
    }

    // Adding an item to the queue
    public void enQueue(String name){
        queue[end] = name;
        end = ++end % queue.length;
    }

    // Removing an item from the queue
    public String deQueue(){
        String removedName = queue[front];
        queue[front] = null;
        front = ++front % queue.length;
        return removedName;
    }
}


