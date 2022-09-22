package com.cm.special_enterprise.de.zuhemoshi;

import java.util.ArrayList;

public class Client {
    public static String getTreeInfo(Branch root) {
        ArrayList<Crop> arrayList = root.getArrayList();
        String info = "";
        for (Crop c : arrayList) {
            if (c instanceof Leaf) {
                info = info+ c.getInfo()+"\n";
            } else {
                info = info + c.getInfo() + getTreeInfo((Branch) c)+"\n";
            }
        }
        return info;
    }


    public static void main(String[] args) {
        Branch branch = new Branch("1", "1", 1);
        Branch branch1 = new Branch("2", "2", 2);
        branch.addList(branch1);
        Branch branch2 = new Branch("22", "22", 22);
        branch1.addList(branch2);
        Branch branch3 = new Branch("223", "223", 223);
        branch1.addList(branch3);

        System.out.println(getTreeInfo(branch1));

    }
}
