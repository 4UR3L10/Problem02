/******************************************************************************************************
* Purpose/Description: <Implements the methods below of a Binary Search Tree>                          *
* Author’s Panther ID: <6206864>                                                                      *
* Certification:                                                                                      *
* I hereby certify that this work is my own and none of it is the work of                             *
* any other person.                                                                                   *
******************************************************************************************************/
package problem02;

public class BinarySearchTree
{
    private BinarySearchTreeNode root;

    // Insert an element into the Tree.
    public void insert(int key)
    {
        // If the Tree is empty. 
        if (root == null)
        {
            root = new BinarySearchTreeNode();
            root.key = key;
        } // Locate the parent node.
        else
        {
            BinarySearchTreeNode parent = null;
            BinarySearchTreeNode currentKey = root;

            // Look up for the node's parent in the three.
            while (currentKey != null)
            {
                // Get the parent and go to the left.
                if (key < currentKey.key)
                {
                    parent = currentKey;
                    currentKey = currentKey.left;
                } // Get the parent and go to the left.
                else if (key > currentKey.key)
                {
                    parent = currentKey;
                    currentKey = currentKey.right;
                } // Duplicate
                else
                {
                    System.out.println("The value already exists on the tree.");
                    return;
                }
            }
            if (key < parent.key)
            {
                parent.left = new BinarySearchTreeNode();
                parent.left.key = key;
            } else
            {
                parent.right = new BinarySearchTreeNode();
                parent.right.key = key;
            }
            
            System.out.println("Key inserted succesfully");
            return;
        }
    }

    // Delete an element from the Tree.
    public void delete(int key)
    {
        BinarySearchTreeNode parent = null;
        BinarySearchTreeNode currentKey = root;

        // Look up for the node's parent in the three.
        while (currentKey != null)
        {
            // Get the parent and go to the left.
            if (key < currentKey.key)
            {
                parent = currentKey;
                currentKey = currentKey.left;
            } // Get the parent and go to the left.
            else if (key > currentKey.key)
            {
                parent = currentKey;
                currentKey = currentKey.right;
            } // Duplicate
            else
            {
                break; // Element is in the three pointed at by current.
            }
        }
        
        if(currentKey == null)
        {
            System.out.println("Element is not in the tree");
        }
        
        // Case 1 -> Current has not left child.
        if(currentKey.left == null)
        {
           // Connect the parent with the right child of the current node.
           if(parent == null)
           {
               root = currentKey.right;
           }
            else
            {
                if (key < parent.key)
                {
                    parent.left = currentKey.right;                    
                } 
                else
                {
                    parent.right = currentKey.right;
                }
            }
        }
        else
        {
            // Case 2: The current node has a left child.
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent.
            BinarySearchTreeNode parentOfRightMost = currentKey;
            BinarySearchTreeNode rightMost = currentKey.left;

            while (rightMost.right != null)
            {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right.
            }
            
            // Replace the element in current by the element in rightMost.
            currentKey.key = rightMost.key;
            
            // Eliminate the rightmost node.
            if(parentOfRightMost.right == rightMost)
            {
                parentOfRightMost.right = rightMost.left;
            }
            // Special case: parentOfRightMost == current.
            else
            {
                parentOfRightMost.left = rightMost.left;
            }
        }
        
        System.out.println("Element Deleted Successfully.");        
    }

    // Lookup for a value in the Tree.
    public boolean find(int key)
    {
        // Start from the root.
        BinarySearchTreeNode currentKey = root;

        // Look up for the value until the end of the tree.
        while (currentKey != null)
        {
            // If is smaller go to the left.
            if (key < currentKey.key)
            {
                currentKey = currentKey.left;
            }
            // If is bigger go to the right.
            if (key > currentKey.key)
            {
                currentKey = currentKey.right;
            } // If is equal -> Found.
            else
            {
                return true;
            }
        }

        // If it reach the end of the three -> Not Found.
        return false;
    }
    
    // Helper to Add positive numbers.
    public int positiveKeySum()
    {
      // Helper.  
      return positiveKeySum(root);  
    }

    // Add all positive numbers from the Tree.
    public int positiveKeySum(BinarySearchTreeNode root)
    {
        // If Tree is empty.
        if (root == null)
        {
            return 0;
        }
        // If a number is negative do not add.
        if(root.key < 0)
        {
          return 0;
        }
        // Recursion to keep adding.
        return root.key + positiveKeySum(root.left) + positiveKeySum(root.right);
    }
    
    // Delete the maximum number in the Tree.
    public void deleteMax()
    {
        BinarySearchTreeNode currentNode = root;
        
        // If the Tree is empty.
        if(currentNode == null)
        {
            System.out.println("Root is null");  
        }
        // Keep looking to the rightmost.
        else
        {
            while(currentNode.right != null)
            {
                currentNode = currentNode.right;
            }            
        }
        
        // Use the method to delete the MaxNumber.
        System.out.println("Max:" + currentNode.key + " have been deleted");
        delete(currentNode.key);
    }
    
    // Helper to print the Tree in InOrder Traversal.
    public void printTree() 
    {
        printTree(root);
    }
    
    // Print the Tree in InOrder Traversal.
    public void printTree(BinarySearchTreeNode root) // InOrder
    {
        // If the Tree is empty.
        if(root == null)
        {                        
            return;
        }
        
        // First left child.
        printTree(root.left);
        
        // Then print the data of the current key.
        System.out.println(root.key);
        
        // Last Right Child.
        printTree(root.right);
    }
}
