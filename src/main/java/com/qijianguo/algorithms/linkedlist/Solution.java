package com.qijianguo.algorithms.linkedlist;

public class Solution {

    public ListNode twoNumsAdd(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curr = null;
        int carry = 0;
        // 当l1和l2不为空的时候执行
        while (l1 != null || l2 != null || carry > 0) {
            int l1v = l1 == null ? 0 : l1.getVal();
            int l2v = l2 == null ? 0 : l2.getVal();
            int sum = l1v + l2v + carry;
            // 位
            int lrv = sum % 10;
            carry = sum >= 10 ? 1 : 0;

            //
            if (curr == null) {
                curr = new ListNode(lrv);
            } else {
                curr.next = new ListNode(lrv);
                root = curr;
                curr = curr.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root;
    }


    public ListNode twoNumsAdd1(ListNode l1, ListNode l2) {

        int step = 0;

        ListNode cur = null;
        while (l1.getNext() != null || l2.getNext() != null) {

            int l1V = l1 == null ? 0 : l1.getVal();
            int l2V = l2 == null ? 0 : l2.getVal();
            int sum = l1V + l2V + step;
            int mod = sum % 10;
            step = sum / 10;
            if (cur == null) {
                cur = new ListNode(mod);
            } else {
                /*cur.setNext(new ListNode(mod));
                cur = cur.getNext();*/
                cur.next = new ListNode(mod);
                cur = cur.next;
            }
            if (l1 != null) {
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2 = l2.getNext();
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(3));// 13
        ListNode l2 = new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(1))));// 3121 > 4426

        ListNode listNode = solution.twoNumsAdd(l1, l2);
        System.out.println(listNode);
    }


}
