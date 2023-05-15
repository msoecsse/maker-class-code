package finalexam;

public class IntList {
    private static class IntNode {
        private int item;
        private IntNode next = null;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    IntNode head;

    // Assume IntList is always of size > 3
    public void removeAllOdds() {
        IntNode cur = head;
        IntNode prev = cur;

        while(cur.next.next != null) {
            cur = cur.next;
            if (cur.item % 2 != 0) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
        }
    }
    
    public void swapHeadAndTail() {
        int tmpHeadVal = head.item;
        IntNode currentNode = head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        int tmpTailVal = currentNode.item;
        currentNode.item = tmpHeadVal;
        head.item = tmpTailVal;
    }

}
