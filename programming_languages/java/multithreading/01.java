package prac;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Running");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class Prac {

    public static void main(String[] args) {
        Processor pro = new Processor();
        pro.start();
        // Wait for the enter key
        System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
        new Scanner(System.in).nextLine();
        pro.shutdown();
    }
}
