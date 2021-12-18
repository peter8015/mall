package com.macro.mall;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseListA {


    @Test
    public void t1() {
        ListNodeA head1 = new ListNodeA(1);
        ListNodeA head2= new ListNodeA(2);
        ListNodeA head3 = new ListNodeA(3);
        ListNodeA head4 = new ListNodeA(4);
        ListNodeA head5 = new ListNodeA(5);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        print(head1, "head1");
        System.out.println();
        ListNodeA reverseList = reverseList(head1);
        print(reverseList, "reverseList");
    }

    private ListNodeA reverseList(ListNodeA head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNodeA p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    private void print(ListNodeA head1, String name) {
        System.out.print(name +" : ");
        while(head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }
}


 class ListNodeA {
    int val;
    ListNodeA next;

    public ListNodeA(int val) {
        this.val = val;
    }
 }