package com.cm.special_enterprise.de;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test06 {
    public static void main(String[] args) {
        String a = "adfajlgja";
        System.out.println(a.indexOf("a"));

        FileReader fr = null;
        try {
            fr = new FileReader(new File("D:\\test.txt"));
            char[] buf = new char[1024];
            int len;
            while ((len = fr.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
        } catch (IOException e) {
            System.out.println("read-Exception :" + e.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println("close-Exception :" + e.getMessage());
                }
            }
        }

    }
}
