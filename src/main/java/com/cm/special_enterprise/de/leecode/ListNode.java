package com.cm.special_enterprise.de.leecode;

import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
