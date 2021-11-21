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

    
}
