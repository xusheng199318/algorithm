package com.arthur.linked;

import org.junit.Test;

public class RemoveNthFromEnd {

    @Test
    public void testRemoveNode() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        ListNode listNode = removeNthFromEnd(node1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode quick = root;
        for (int i = 0; i <= n; i++) {
            quick = quick.next;
        }

        ListNode slow = root;
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return root.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}



