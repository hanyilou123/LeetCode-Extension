public class LRUCache {
    public class Node{
        Node pre, next;
        int key, value;
        public Node(int key, int value){
            this.pre=null;
            this.next=null;
            this.key=key;
            this.value=value;
        }
    }
    int capacity;
    Map<Integer, Node> hs = new HashMap<Integer, Node>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next=tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!hs.containsKey(key))
            return -1;
        Node cur = hs.get(key);
        cur.pre.next = cur.next;    //remove the cur
        cur.next.pre = cur.pre;
        
        moveToTail(cur);
        return hs.get(key).value;
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1)
        {
            hs.get(key).value = value;
            return;
        }
        if(hs.size()==capacity)
        {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        Node insert = new Node(key, value);
        hs.put(key, insert);
        moveToTail(insert);
    }
    
    public void moveToTail(Node cur)
    {
        cur.pre = tail.pre;
        cur.next = tail;
        cur.pre.next = cur;
        tail.pre = cur;
    }
}