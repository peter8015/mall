package com.macro.mall.algorithm;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ReverseList {

    /**
     * recursion
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        print(l1, "l1");
        ListNode reversed = reverse(l1);
        print(reversed, "reversed");
    }



    @Test
    public void test2() {
        if(isUnique("aabccccc")) {
            System.out.println("TRUE");
        }

    }

    public boolean isUnique(String astr) {
        int mark = 0;
        for (int i = 0; i < astr.length(); i++){
            int move = astr.charAt(i) - 'a';  // 当前字符对应的mark移动的位数
            if ((mark & (1 << move)) != 0)
                return false;
            else
                mark = mark | (1 << move);
        }
        return true;
    }



    private void print(ListNode head, String name) {
        System.out.print(name + " : ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}