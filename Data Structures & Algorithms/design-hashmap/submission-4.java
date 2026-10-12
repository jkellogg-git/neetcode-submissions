class ListNode {
    int key;
    int val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);
    }
}

public class MyHashMap {
    private int cap;
    private int size;
    private ListNode[] map;
    private double threshold;

    public MyHashMap() {
        cap = 16;
        threshold = 0.7;
        map = new ListNode[cap];
        for (int i = 0; i < cap; i++) {
            map[i] = new ListNode();
        } 
    }

    public int hash(int key) {
        // put(4, 10) -- put(20, 20)
        return key % cap;
    }
    
    public void put(int key, int value) {
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value, null);
        size++;
        if ((double) size / cap > threshold) {
            resize();
        }
    }

    private void resize() {
        cap *= 2;
        ListNode[] oldMap = map;
        map = new ListNode[cap];
        for (int i = 0; i < cap; i++) {
            map[i] = new ListNode();
        }
        for (ListNode oldDummy : oldMap) {
            // -1 -> 4(20) -> null
            // -1 -> 4(20) -> 20(10) -> null
            ListNode curr = oldDummy.next;
            while (curr != null) {
                int newHashIndex = hash(curr.val);
                ListNode newDummy = map[newHashIndex];
                while (newDummy.next != null) {
                    newDummy = newDummy.next;
                }
                newDummy.next = new ListNode(curr.key, curr.val, null);
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
        ListNode curr = map[hash(key)];
        // -1 -> 4(20) -> 20(10) -> null 
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