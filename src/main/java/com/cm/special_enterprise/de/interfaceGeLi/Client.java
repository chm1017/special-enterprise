package com.cm.special_enterprise.de.interfaceGeLi;

public class Client {
    public static void main(String[] args) {
        IBGirl girl = new BGirl("ke");

        AbstractSearcher searcher = new Searcher(girl);

        searcher.show();



    }
}
