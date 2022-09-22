package com.cm.special_enterprise.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Tree {

    private String label;
    private Tree left;
    private Tree right;



    private List<Tree> children;

    private Boolean isYezi = false;

    private void setIsYeZi(boolean flag) {
        this.isYezi = flag;
    }
}
