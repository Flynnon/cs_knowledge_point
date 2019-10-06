/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 
 示例：
 
 给定一个链表: 1->2->3->4->5, 和 n = 2.
 
 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：
 
 给定的 n 保证是有效的。
 
 进阶：
 
 你能尝试使用一趟扫描实现吗？
 
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if(!head.next) return null;
    let now = head;
    let pre = null;
    while(now.next){
        now = now.next;
        n--;
        if(n === 0){
            pre = head;
        }else if(n < 0){
            pre = pre.next;
        }
    }
    //如果删除的是头结点
    if(!pre){
        return head.next;
    }
    else{
        pre.next = pre.next.next;
    }
    return head;
};
//
// let first = new ListNode(1);
// first.next = new ListNode(2);
// // first.next.next = new ListNode(3);
// // first.next.next.next = new ListNode(4);
//
// let linkList = first;
// console.log(removeNthFromEnd(linkList,1))