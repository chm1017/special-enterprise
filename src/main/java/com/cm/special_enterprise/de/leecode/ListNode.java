package com.cm.special_enterprise.de.leecode;

import com.cm.special_enterprise.de.Test01;
import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
