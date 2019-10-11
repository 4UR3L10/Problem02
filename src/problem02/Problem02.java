package problem02;

public class Problem02
{

    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(2);
        bst.insert(5);
        bst.insert(1);
        bst.insert(3);
                
        //bst.preOrder();
        
        //bst.deleteMax();

        //bst.preOrder();
         
        bst.printTree();
        
        
        //System.out.println("The total is: " + bst.positiveKeySum());
    }
    
}
