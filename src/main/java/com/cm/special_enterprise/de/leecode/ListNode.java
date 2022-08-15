package com.cm.special_enterprise.de.leecode;

import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
