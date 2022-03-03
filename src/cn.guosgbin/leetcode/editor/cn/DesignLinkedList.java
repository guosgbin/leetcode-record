package cn.guosgbin.leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @author Dylan Kwok
 * @date 2022-03-02 21:19:22
 */
public class DesignLinkedList {
    public static void main(String[] args) {
//        Solution solution = new DesignLinkedList().new Solution();
//        MyLinkedList linkedList = new MyLinkedList();
//        System.out.println(linkedList);
//
//        linkedList.addAtHead(1);
//        System.out.println(linkedList);
//
//        linkedList.addAtTail(3);
//        System.out.println(linkedList);
//
//        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(1));            //返回2
//        System.out.println(linkedList);
//
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(1));            //返回3
//        System.out.println(linkedList);

        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0,10);
        list.addAtIndex(0,20);
        list.addAtIndex(1,30);
        System.out.println(list);

        System.out.println(list.get(0));



    }


    //leetcode submit region begin(Prohibit modification and deletion)

     static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    static class MyLinkedList {
        private int size;
        private Node head;

        public MyLinkedList() {

        }

        public int get(int index) {
            // 校验索引是否有效
            if (index < 0 || index >= size) {
                return -1;
            }
            Node cur = head;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        public void addAtHead(int val) {
            // 新的头结点
            Node newHead = new Node(val, head);
            // 连接
            head = newHead;

            size++;
        }

        public void addAtTail(int val) {
            Node cur = new Node(-1, head);
            while (cur.next != null) {
                cur = cur.next;
            }
            // 此时cur指向添加前的最后一个元素
            Node newNode = new Node(val, null);
            if (head == null) {
                // 表明之前是空链表
                head = newNode;
            } else {
                cur.next = newNode;
            }
            size++;
        }

        /**
         * 存到index处
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }

            Node cur = new Node(-1, head);
            int idx = 0;
            while (idx <= index) {
                if (idx == index) {
                    // 找到位置了，此时指针指向的要添加位置的前一个位置
                    Node newNode = new Node(val, null);
                    if (head == null) {
                        // 表明之前的链表是空链表
                        head = newNode;
                    } else if (cur.next == head) {
                        // 表明替换的是头结点
                        newNode.next = cur.next;
                        head = newNode;
                    } else {
                        // 之前不是空链表
                        newNode.next = cur.next;
                        cur.next = newNode;
                    }
                    size++;
                    return;
                }
                idx++;
                cur = cur.next;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            Node cur = new Node(-1, head);
            int idx = 0;
            while (cur.next != null) {
                if (idx == index) {
                    if (cur.next == head) {
                        head = head.next;
                    } else {
                        cur.next = cur.next.next;
                    }
                    size--;
                    return;
                }
                cur = cur.next;
                idx++;
            }
        }

        @Override
        public String toString() {
            Node cur = head;
            StringBuilder builder = new StringBuilder("[");
            while (cur != null) {
                if (cur.next == null) {
                    builder.append(cur.val);
                } else {
                    builder.append(cur.val + ", ");
                }
                cur = cur.next;
            }
            return builder.append("]").toString();
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}