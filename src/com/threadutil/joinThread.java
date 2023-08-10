package com.threadutil;

public class joinThread {
    public static void main(String[] args) {
        Thread userDetailsThread = new Thread(new UserDetailsTask());
        Thread countThread = new Thread(new CountTask(userDetailsThread));

        userDetailsThread.start();
        countThread.start();

        try {
            userDetailsThread.join();
            countThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have completed.");
    }
}

class UserDetailsTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000); // Wait for 5 seconds
            String userId = "123"; // Get the user ID from input
            System.out.println("Hello user " + userId );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CountTask implements Runnable {
    private final Thread userDetailsThread;

    public CountTask(Thread userDetailsThread) {
        this.userDetailsThread = userDetailsThread;
    }

    @Override
    public void run() {
        while (userDetailsThread.isAlive()) {
            try {
                Thread.sleep(2000); // Wait for 2 seconds
                // Display the count logic here
                System.out.println("Count: ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}