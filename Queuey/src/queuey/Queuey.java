
package queuey;

import java.util.LinkedList;
import java.util.Stack;

public class Queuey<D> {

    LinkedList<D> queue;
    
    // Making a queue instance
    public Queuey() {
        queue = new LinkedList();
    }
    
    // Is our queue empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    // What is the size of our queue?
    public int size(){
        return queue.size();
    }
    
    // Enqueuing an item
    public void enqueue(D n){
        queue.addLast(n);
    }
    
    // Dequeueing an item
    public D dequeue(){
        return queue.remove(0);
    }
    
    // Peek at the first item
    public D peek(){
        return queue.get(0);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<String> stacky = new Stack<>();
        stacky.push("there");
        stacky.push("hi");
        System.out.print(stacky.pop() + " ");
        System.out.println(stacky.pop() + "! ");
        System.out.println("Size: "+stacky.size());
        
        
        Queuey numQueue = new Queuey();
        numQueue.enqueue(5);
        numQueue.enqueue(7);
        numQueue.enqueue(6);
        System.out.println("First out: "+ numQueue.dequeue());
        System.out.println("Peek at second item: "+numQueue.peek());
        System.out.println("Second out: "+ numQueue.dequeue());
        System.out.println("Third out: "+ numQueue.dequeue());
    }
    
}
