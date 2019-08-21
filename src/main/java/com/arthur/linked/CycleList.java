package com.arthur.linked;

import org.junit.Test;

public class CycleList {

    @Test
    public void testCycleList() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n3.next = n1;

        boolean result = hasCycle(n1);
        System.out.println(result);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = null;
        if (head != null) {
            slow = head.next;
        }

        ListNode fast = null;
        if (slow != null) {
            fast = slow.next;
        }

        while (slow != null && fast != null) {
            if (slow == null || fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
                continue;
            }
            return false;

        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}


