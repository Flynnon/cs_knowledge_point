/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 
 示例：
 
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let l1_now = l1,l2_now = l2,new_now;
    let newList = new ListNode("head");
    new_now = newList;
    while(l1_now&&l2_now){
        if(l1_now.val < l2_now.val){
            new_now.next = l1_now;
            l1_now = l1_now.next;
        }else{
            new_now.next = l2_now;
            l2_now = l2_now.next;
        }
        new_now = new_now.next;
        new_now.next = null;
    }
    if(l1_now){
        new_now.next = l1_now;
    }else{
        new_now.next = l2_now;
    }
    return newList.next;
};
