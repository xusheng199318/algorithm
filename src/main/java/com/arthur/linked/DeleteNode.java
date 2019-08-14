package com.arthur.linked;

import org.junit.Test;

public class DeleteNode {

    @Test
    public void testDeleteNode() {
        ListNode node4 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        node3.next = node4;
        ListNode node2 = new ListNode(5);
        node2.next = node3;
        ListNode root = new ListNode(4);
        root.next = node2;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
