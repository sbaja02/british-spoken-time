package com.smartbear.service;

import java.util.Scanner;

public class RequestReader {
    private final Scanner scanner;
    public RequestReader() {
        this.scanner = new Scanner(System.in);
    }
    public String read() {
        System.out.print("Enter the time (format: HH:MM): ");
        return scanner.nextLine().trim();
    }
}
