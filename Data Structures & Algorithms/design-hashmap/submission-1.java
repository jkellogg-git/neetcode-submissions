class ListNode {
    int val;
    int key;
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
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) {
            // seed each bucket with dummy node
            map[i] = new ListNode();
        }
    }

    private int hash(int key) {
        return key % map.length;
    }
    
    public void put(int key, int value) {
        ListNode curr = map[hash(key)];
        // 11, 28
        // -1 -> 10(25) -> 11(26) -> null
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value, null);
    }
    
    public int get(int key) {
        ListNode curr = map[hash(key)].next;
        while (curr != null) {
            if (curr.key == key){
                return curr.val;
            }
            curr = curr.next;
        }    
        return -1;    
    }
    
    public void remove(int key) {
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                // remove(10)
                // -1 -> 10(25) -> 11(26) -> 12(27) -> null
                // -1 -> 11(26) -> 12(27) -> null
                // remove(12)
                // *-1 -> *11(26) -> 12(27) -> null 
                // *-1 -> *11(26) -> null
                curr.next = curr.next.next;
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