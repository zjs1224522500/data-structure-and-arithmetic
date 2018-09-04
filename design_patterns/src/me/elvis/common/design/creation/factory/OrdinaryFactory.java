package me.elvis.common.design.creation.factory;

import java.util.Scanner;

/**
 * Version:v1.0 (description:  )
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * Date:2017/11/29 0029  Time:18:53
 */
public class OrdinaryFactory {


    //如果传递的参数出错，则不能正确创建对象
    // 改进：多个工厂方法模式
    public CommonInterfaceSender sendMsg(int type) {
        if (1 == type) {
            return new SmsSender();
        } else if (2 == type) {
            return new MailSender();
        } else if (3 == type) {
            return new WechatSender();
        } else {
            System.out.println("Please check the input!");
            return null;
        }
    }

    public static void main(String[] args) {
        OrdinaryFactory ordinaryFactory = new OrdinaryFactory();
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
        CommonInterfaceSender sender = ordinaryFactory.sendMsg(typeNo);
        sender.sendMsg(receiverName);
    }
}
