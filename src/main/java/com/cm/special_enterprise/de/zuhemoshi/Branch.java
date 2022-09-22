package com.cm.special_enterprise.de.zuhemoshi;

import java.util.ArrayList;

public class Branch extends Crop{
    ArrayList<Crop> arrayList = new ArrayList<Crop>();


    public Branch(String name, String position, Integer salary) {
        super(name, position, salary);
    }

    public void addList(Crop crop) {
        this.arrayList.add(crop);
    }

    public ArrayList<Crop> getArrayList() {
        return this.arrayList;
    }
}
