/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 
 示例：
 
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 * @param l1
 * @param l2
 * @return {ListNode}
 */

var 2 = function(l1, l2) {
    let a = 0,b = 0,flag = 0;
    let l1node =l1,l2node = l2;
    let result = new ListNode(0);
    let thenode = result;
    while(true){
        a = l1node === null?0:l1node.val;
        b = l2node === null?0:l2node.val;
        if(!l1node && !l2node &&flag===0) return result.next;
        let node = new ListNode((a+b+flag)%10)
        if(a+b+flag >=10) flag = 1;else flag = 0;
        thenode.next = node;
        thenode = node;
        l1node = l1node?l1node.next:null;
        l2node = l2node?l2node.next:null;
    }
};