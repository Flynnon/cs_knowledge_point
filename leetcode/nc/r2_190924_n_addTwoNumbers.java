import java.util.List;

public class r2_190924_n_addTwoNumbers {
    /*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

      如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

      示例：

      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
      输出：7 -> 0 -> 8
      原因：342 + 465 = 807

      拓展：如果链表中的数字不是按逆序存储  (3→4→2)+(4→6→5)=8→0→7
     */
    public static void main(String[] args) {
        r2_190924_n_addTwoNumbers r2 = new r2_190924_n_addTwoNumbers();
    }



    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;
        }
    }

    //链表：需要补
    /*复杂度分析：
        时间复杂度：O(max(m, n)，假设m和n分别表示l1和l2的长度，上面的算法最多重复max(m,n)次
        空间复杂度：O(max(m, n)，新列表的长度最多为 max(m,n)+1

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //dummyHead
        ListNode dummyHead = new ListNode(0);
        //curr
        ListNode p = l1, q = l2, curr = dummyHead;
        //进位
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /*标签：链表
      将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
      每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
      如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
      小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }




    //没看
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2, null);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, ListNode prev) {
        ListNode next1 = null;
        ListNode next2 = null;
        int val1 = 0;
        int val2 = 0;
        if (l1 != null) {
            val1 = l1.val;
            next1 = l1.next;
        }
        if (l2 != null) {
            val2 = l2.val;
            next2 = l2.next;
        }
        ListNode newNode = new ListNode(val1 + val2);
        if (prev != null) {
            if (prev.val >= 10) {
                prev.val %= 10;
                newNode.val += 1;
            }
        }
        if (next1 != null || next2 != null) {
            newNode.next = addTwoNumbers2(next1, next2, newNode);
        } else if (newNode.val >= 10) {
            newNode.next = addTwoNumbers2(next1, next2, newNode);
        }
        return newNode;
    }

}
