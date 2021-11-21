public class HTBT {
    
    private BTNode [] table;
    private int size;

    public HTBT (int tableSize) {

        table = new BTNode [ primeNum(tableSize) ];
        size = 0;
    }

    public boolean isEmpty (){

        return size == 0;
    }

    public int getSize () {

        System.out.println(size);
        return size;
    }

    public void insert (int value) {

        size++;
        int position = myhash(value);        
        BTNode root = table[position];
        root = insert(root, value);
        table[position] = root;
    }

    private BTNode insert(BTNode node, int data)
    {
        if (node == null)
            node = new BTNode(data);
        else
        {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public void htDelete(int value)
    {
        int position = myhash(value);        
        BTNode root = table[position];
        try
        {
            root = delete(root, value);    
            size--;
        }
        catch (Exception e)
        {
            System.out.println("\nElement not present\n");        
        }        
        table[position] = root;        
    }

    private BTNode delete(BTNode root, int k)
    {
        BTNode p, p2, n;
        if (root.data == k)
        {
            BTNode left, right;
            left = root.left;
            right = root.right;
            if (left == null && right == null)
                return null;
            else if (left == null)
            {
                p = right;
                return p;
            }
            else if (right == null)
            {
                p = left;
                return p;
            }
            else
            {
                p2 = right;
                p = right;
                while (p.left != null)
                    p = p.left;
                p.left = left;
                return p2;
            }
        }
        if (k < root.data)
        {
            n = delete(root.left, k);
            root.left = n;
        }
        else
        {
            n = delete(root.right, k);
            root.right = n;             
        }
        return root;
    }
    
    private int myhash(Integer x )
    {
        int hashValue = x.hashCode( );
        hashValue %= table.length;
        if (hashValue < 0)
            hashValue += table.length;
        return hashValue;
    }

    private static int primeNum( int n )
    {
        if (n % 2 == 0)
            n++;
        for ( ; !isPrime( n ); n += 2);
 
        return n;
    }

    private static boolean isPrime( int n )
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public void display ()
    {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {    
            inorder(table[i]);
            
        }
    } 
    
    private void inorder(BTNode num)
    {
        if (num != null)
        {
            inorder(num.left);
            System.out.println(num.data +" ");
            inorder(num.right);
        }
    }     
}

