package thread08_wait_notify;

import java.util.Vector;

public class Consumer extends Thread {

	Producer producer;
	 
    Consumer(Producer producer) {
        this.producer = producer;
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
                System.out.println("Got message: " + message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String args[]) {
        Producer producer = new Producer();
        producer.start();
        
        new Consumer(producer).start();
    }

}

class Producer extends Thread {
	 
    static final int MAXQUEUE = 5;
    private Vector<String> messages = new Vector<String>();
 
    @Override
    public void run() {
        try {
            while (true) {
                putMessage();
                
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
 
    private synchronized void putMessage() throws InterruptedException {
        while (messages.size() == MAXQUEUE) {
            wait();
        }
        messages.addElement(new java.util.Date().toString());
        System.out.println("put message");
        notify();
    }
 
    // Called by Consumer
    public synchronized String getMessage() throws InterruptedException {
        notify();
        while (messages.size() == 0) {
        	// By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
            wait();
        }
        String message = (String) messages.firstElement();
        messages.removeElement(message);
        return message;
    }
}