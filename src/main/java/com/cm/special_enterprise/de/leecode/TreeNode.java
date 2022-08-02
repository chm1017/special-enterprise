package com.cm.special_enterprise.de.leecode;

import lombok.Data;

@Data
public class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }

}
