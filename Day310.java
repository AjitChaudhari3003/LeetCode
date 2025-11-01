// 3217. Delete Nodes From Linked List Present in Array
// You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
// Example 1:
// Input: nums = [1,2,3], head = [1,2,3,4,5]
// Output: [4,5]

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
         boolean[] hasN=new boolean[100001];
        for(int x: nums) hasN[x]=true;
        ListNode dummy=new ListNode(0, head);
        ListNode prev=dummy;
        for(ListNode curr=head; curr!=null; curr=curr.next){
            if (hasN[curr.val]) 
                prev.next=curr.next;
            else 
                prev=prev.next;
        }
        return dummy.next;
    }

}
