package com.cm.special_enterprise.de.linkMode;

import java.io.InputStream;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        SHDnsServer shDnsServer = new SHDnsServer();
        ChinaTopDnsServer chinaTopDnsServer = new ChinaTopDnsServer();
        TopDnsServer topDnsServer = new TopDnsServer();
        chinaTopDnsServer.setUpperServer(topDnsServer);
        shDnsServer.setUpperServer(chinaTopDnsServer);
        System.out.println("域名解析器");
        while (true) {
            System.out.println("请输入域名");
            Scanner scanner = new Scanner(System.in);
            String domain = scanner.nextLine();
            if (domain.equalsIgnoreCase("n")) {
                return;
            }
            Recorder recorder = new Recorder();
            recorder.setDomain(domain);
            shDnsServer.update(null, recorder);
            System.out.println("服务器解析结果");
            System.out.println(recorder);
        }

    }
}
