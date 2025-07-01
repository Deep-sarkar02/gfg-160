LRU Cache
Difficulty: HardAccuracy: 18.44%Submissions: 182K+Points: 8Average Time: 40m
Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

PUT x y: sets the value of the key x with value y
GET x: gets the value of key x if present else returns -1.
The LRUCache class has two methods get() and put() which are defined as follows.

get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
In the constructor of the class the capacity of the cache should be initialized.
Examples:

Input: cap = 2, Q = 2, Queries = [["PUT", 1, 2], ["GET", 1]]
Output: [2]
Explanation: Cache Size = 2
["PUT", 1, 2] will insert the key-value pair (1, 2) in the cache,
["GET", 1] will print the value corresponding to Key 1, ie 2.
Input: cap = 2, Q = 8, Queries = [["PUT", 1, 2], ["PUT", 2, 3], ["PUT", 1, 5], ["PUT", 4, 5], ["PUT", 6, 7], ["GET", 4], ["PUT", 1, 2], ["GET", 3]]
Output: [5, -1]
Explanation: Cache Size = 2
["PUT", 1, 2] will insert the pair (1,2) in the cache.
["PUT", 2, 3] will insert the pair (2,3) in the cache: 1->2, 2->3(the most recently used one is kept at the rightmost position) 
["PUT", 1, 5] will replace the value of 1 from 2 to 5 : 2 -> 3, 1 -> 5
["PUT", 4, 5] : 1 -> 5, 4 -> 5 (Cache size is 2, hence we delete the least recently used key-value pair)
["PUT", 6, 7] : 4 -> 5, 6 -> 7 
["GET", 4] : Prints 5 (The cache now looks like 6 -> 7, 4->5)
["PUT", 1, 2] : 4 -> 5, 1 -> 2  (Cache size is 2, hence we delete the least recently used key-value pair)
["GET", 3] : No key value pair having key = 3. Hence, -1 is printed.


class LRUCache {
    
    // create the ndoe
    static class Node
    {
        int key , value;
        Node prev;
        Node next;
        
        Node(int k , int v)
        {
            this.key = k;
            this.value =v;
            // all the prev and the next will be null
            prev = next = null;
        }
    }
    
    // create a dummy head and tail wil value of -1 , -1
    Node head = new Node(-1 , -1);
    Node tail = new Node(-1 , -1);



    // create an unorders map for the key val storage
    HashMap<Integer  , Node> m = new HashMap<>();
    int limit;
    
    LRUCache(int cap)
    {
        // code here
        limit = cap;
        // now  we will point the head to the tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // your code here
        if(!m.containsKey(key)) return -1;
        // now we will store the val of the key or the to the ansNode
        Node ansNode = m.get(key);
        // now we will ge the address of the node
        int ans = ansNode.value;
        // now we will need to remove the ansNode from the ll
        // first delete the key from the map
        m.remove(key);
        //now delete thendeo
        deletenode(ansNode);
        // then  add the ndoe
        addnode(ansNode);
        // add the key val pair in map
        m.put(key , ansNode);
        
        return ans;
        
    }

    
    
    // addnode and delete node function
    public void addnode(Node newNode)
    {
        //we will store the head.next or the tail node
        Node oldnext = head.next;
        // head will point to new node
        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldnext;
        oldnext.prev = newNode;
        
        
    }
    public void deletenode(Node oldnode)
    {
        Node oldprev = oldnode.prev;
        Node oldnext = oldnode.next;
        oldprev.next = oldnext;
        oldnext.prev = oldprev;
    }
    public  void put(int key, int value) {
        // your code here
        // wewill first check that if it exists or not
        if(m.containsKey(key))
        {
            // if this is true
            // get the value of the key or the address of the node that we want to delete
            Node oldnode = m.get(key);
            // now we will delete the node from the DLL
            deletenode(oldnode);
            // now earese the node from the map
            m.remove(key);
        }
        // if the map capacity reached
        if(m .size() == limit)
        {
            // here we will delete the key val from the map first of the lru
            m.remove(tail.prev.key);
            // then we will remove the lru
            deletenode(tail.prev);
        }
        // else we will create the new node  with the key and value
        Node newNode = new Node(key , value);
        // now add the ndoe to the front in the ll
        addnode(newNode);
        // add the key and value to the map
        m.put(key , newNode);
    }
}

