package com.threadutil;
class PrintNames implements Runnable {

    private String[] name = {"Peter", "Sam", "Edgar", "Mathew", "Simond"};

    public synchronized void printArray() {
        for (String s : name) {
            System.out.println(s);
        }
    }

  
    public void run() {
        printArray();
    }
}
public class sync{

    public static void main(String[] args) {
        PrintNames printNames = new PrintNames();
        Thread thread = new Thread(printNames);
        thread.start();
    }
}
