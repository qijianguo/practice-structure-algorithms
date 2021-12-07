package com.qijianguo.algorithms.linkedlist;

/**
 * @author qijianguo
 * 节点
 */
public class ListNode {

    Integer val;

    ListNode next;

    public ListNode(Integer val) {
        this.val = val;
        next = null;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
