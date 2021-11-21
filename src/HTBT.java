public class HTBT {
    
    private Node [] table;
    private int size;

    public HTBT (int tableSize) {

        table = Node [ primeNum(tableSize) ];
        size = 0;
    }

    public boolean isEmpty (){

        return size == 0;
    }

    public int getSize () {

        return size;
    }

    public void insert (int value) {

        size++;
        int pos = myhash(value);        
        Node root = table[position];
        root = insert(root, value);
        table[position] = root;
    }

    private Node insert(Node node, int data)
    {
        if (node == null)
            node = new Node(data);
        else
        {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    
}
