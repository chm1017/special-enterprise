package com.cm.special_enterprise.de.zuhemoshi;

import java.util.ArrayList;

public class Client {
    public static String getTreeInfo(Branch root) {
        ArrayList<Crop> arrayList = root.getArrayList();
        String info = "";
        for (Crop c : arrayList) {
            if (c instanceof Leaf) {
                info = info+ c.getInfo();
            } else {
                info = info + c.getInfo() + getTreeInfo((Branch) c);
            }
        }
        return info;
    }
}
