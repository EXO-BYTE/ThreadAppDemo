package com.threadutil;
import java.util.Scanner;


class UserDetails extends Thread {
private String name;
private String email;


public void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = scanner.nextLine();
    System.out.print("Enter email: ");
    email = scanner.nextLine();
    System.out.println("User details: Name: " + name + ", Email: " + email);
}
}

class Interest extends Thread {

public void run() {
    double principal = 12000;
    double rate = 3;
    double time = 4;
    double interest = (principal * rate * time) / 100;
    System.out.println("Simple Interest: " + interest);
}
}

public class UserThread {
public static void main(String[] args) {
    UserDetails userDetails = new UserDetails();
    Interest interest = new Interest();

    userDetails.start();
    interest.start();

 
}
}