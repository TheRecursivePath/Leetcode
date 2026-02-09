public class Q2_Add_Two_Numbers {
    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0); // headNode is a dummy node, we will return headNode.next
        ListNode curr = headNode; // curr is the current node
        int carry = 0; // carry is the carry
        while (l1 != null || l2 != null || carry != 0) { // loop until both lists are null and carry is 0
            int val1 = (l1 != null) ? l1.val : 0; // get the value of the current node of l1
            int val2 = (l2 != null) ? l2.val : 0; // get the value of the current node of l2
            int sum = val1 + val2 + carry; // sum of the current nodes and the carry
            carry = sum / 10; // new carry
            curr.next = new ListNode(sum % 10); // new node with the sum % 10
            curr = curr.next; // move to the next node
            if (l1 != null)
                l1 = l1.next; // move to the next node of l1
            if (l2 != null)
                l2 = l2.next; // move to the next node of l2
        }
        return headNode.next; // return the next node of the headNode
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}