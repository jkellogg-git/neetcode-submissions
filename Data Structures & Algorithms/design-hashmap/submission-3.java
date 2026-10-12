class ListNode {
    int key;
    int val;
    ListNode next;

    public ListNode(int key, int val, ListNode next){
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);
    }
} 

public class MyHashMap {
    private ListNode[] map;
    private int capacity;
    private int size;

    public MyHashMap() {
        capacity = 16;
        map = new ListNode[capacity];
        for (int i = 0; i < capacity; i++) {
            map[i] = new ListNode();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        //map[key] = value;
        ListNode curr = map[hash(key)];
        // put(202, 60)
        // -1 -> 2(10) -> *102(50) -> 202(60) -> null
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value, null);
        size++;
        if ((double) size / capacity > 0.7) {
            resize();
        }
    }
    
    private void resize() {
        ListNode[] oldMap = map;
        capacity *= 2;
        map = new ListNode[capacity];
        for (int i = 0; i < capacity; i++) {
            map[i] = new ListNode();
        }

        for (ListNode list : oldMap) {
            ListNode curr = list.next;
            while (curr != null) {
                int newIndex = hash(curr.key);
                ListNode insertNode = map[newIndex];
                while (insertNode.next != null) {
                    insertNode = insertNode.next;
                }
                insertNode.next = new ListNode(curr.key, curr.val, null);
                curr = curr.next; 
            }
        }
    }

    public int get(int key) {
        ListNode curr = map[hash(key)].next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        // remove(2)
        // -1 -> 2(10) -> 102(50) -> 202(60) -> null
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                size--;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */