/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 示例:
 给定 1->2->3->4, 你应该返回 2->1->4->3.
 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    let now =head,nextNow = head,newList = new ListNode("head"),newNow = newList;
    while(now&&now.next){
        //获取下一次要交换的第一个元素的节点
        nextNow = now.next.next;
        //交换
        newNow.next = now.next;
        newNow.next.next = now;
        newNow = newNow.next.next;
        now = nextNow;
    }
    newNow.next = nextNow;
    return newList.next;
};

let first = new ListNode(1);
// first.next = new ListNode(2);
// first.next.next = new ListNode(3);
// first.next.next.next = new ListNode(4);
let linkList = first;
console.log(swapPairs(linkList))