package me.elvis.common.design.creation.factory;

import java.util.Scanner;

public class SingleClassImpl {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter receiver name:");
        String receiverName = in.next();
        System.out.println("Please choose one type to send msg:[Enter numbers]");
        System.out.println("1. Send by message app on your phone.");
        System.out.println("2. Send by email");
        System.out.println("3. Send by WeChat");
        System.out.println();
        int typeNo = 0;
        try {
            typeNo = in.nextInt();
        } catch (Exception e) {
            // handle exception
            System.out.println("Invalid input!");
        }
        switch (typeNo) {
            case 1:
                System.out.println(String.format("Send to %s by message", receiverName));
                break;
            case 2:
                System.out.println(String.format("Send to %s by email", receiverName));
                break;
            case 3:
                System.out.println(String.format("Send to %s by WeChat", receiverName));
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }
}
