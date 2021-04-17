package java_4_1;

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//分隔链表
class Solution {
    //创建两个链表small and large
    //small：存储<x的节点；large：存储>=x的节点
    //遍历原链表结束后，small的尾节点指向large的head.next;
    //返回small的head.next;
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(1);
        ListNode large = new ListNode(1);
        ListNode sCur = small;
        ListNode lCur = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                sCur.next = cur;
                sCur = sCur.next;
            } else {
                lCur.next = cur;
                lCur = lCur.next;
            }
            cur = cur.next;
        }
        lCur.next = null;//注意将lCur.next置空，否则会形成环形链表
        sCur.next = large.next;
        return small.next;
    }
}
