package com.cm.special_enterprise.de.proxy.yuanxinmoshi;

import org.checkerframework.checker.units.qual.A;

import java.util.Random;

public class Client {

    private static int MAX_COUNT = 6;

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail(new AdvTemplate());

        int i = 0;
        while (i < MAX_COUNT) {
            Mail cloneMail = mail.clone();
            mail.setReceiver(getRandString(5));
            sendMail(cloneMail);
            i++;
        }
    }

    private static String getRandString(int maxlength) {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < maxlength; i++) {
           sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();

    }

    private static void sendMail(Mail mail) {
        System.out.println(mail.getReceiver() + "=====" + mail.getSubject());
    }


}
