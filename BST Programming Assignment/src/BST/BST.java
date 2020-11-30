/*
BST.java
CSCI 211
Prof Herbert
This class contains methods for building a BST
Last edited by Pat Doyle 8/2/2020
 */

package BST;

public class BST {
    //properties:
    //root is used to keep track of the root
    private Node root;
    //size is used to count how many nodes are in the BST
    private int size;
    //result is the true or false value returned by the search method
    private boolean result;
    //max is the Node with the maximum value returned by the max method
    private Node max;
    //min is the Node with the minimum value returned by the min method
    private Node min;

    //getters and setters
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //null constructor
    public BST()
    {
        root = null;
    }//end BST()

    //insert method: used to insert data into a BST
    public void insert(int[] myArray)
    {
        for (int i = 0; i < myArray.length; i++)
        {
            //if the root is empty, put new data at the root
            if (root == null)
            {
                //put data into a new Node
                Node newNode = new Node();
                newNode.setData(myArray[i]);

                size++;
                System.out.println("size: " + size + " ; data: " + newNode.getData());

                //make the new Node the root
                root = newNode;
            }//end if

            else
            {
                //find a spot for the data in the tree
                //set a current pointer to the root
                Node current;
                current = root;

                //call recursive insert method w data and current node as parameters
                recursiveInsert(myArray[i], current);
            }//end else

        }//end for
    }//end insert method

    //recursive insert method is called by the insert method to find a spot for data
    //in the BST when the root is full
    private void recursiveInsert (int data, Node current)
    {
        //if the data belongs to the left of the current node
        if (data < current.getData())
        {

            //if there is no left child, data goes there
            if (current.getLeft() == null)
            {
                //put the data into a new Node
                Node newNode = new Node();
                newNode.setData(data);

                size++;
                System.out.println("size: " + size + " ; data: " + newNode.getData());

                //set current.left to point to the new Node
                current.setLeft(newNode);
            }//end nested if

            else
            { //keep looking to the left: set current current.left and use recursion
                current = current.getLeft();
                recursiveInsert(data, current);
            }//end nested else

        }//end if

        //else if data belongs to the right of the current node
        else if (data > current.getData())
        {


            //if there is no right child, data goes there
            if (current.getRight() == null)
            {
                //put the data into a new Node
                Node newNode = new Node();
                newNode.setData(data);

                size++;
                System.out.println("size: " + size + " ; data: " + newNode.getData());

                //set current.right to point to the new Node
                current.setRight(newNode);
            }//end nested if

            else
            { //keep looking to the right: set current current.right and use recursion
                current = current.getRight();
                recursiveInsert(data, current);
            }//end nested else


        }//end else if

        else
        {//triggered if data is already in the tree or something is wrong
            //print error message
            System.out.println("Error. ");
            return;
        }

    }//end recusiveInsert method

    //search method will take an integer as a key, search the BST for the key,
    //and return true or false depending on if the key is found
    public boolean search(int key)
    {
        //if the data in the root == key
        if (root.getData() == key)
        {
            //set result to true
            result = true;
        }//end if

        else
        {//if the root isn't the key, call recursiveSearch method
            recursiveSearch(key, root);
        }//end else

        //return the result
        return result;
    }//end search method

    //recursiveSearch is the recursive portion of the search method
    private void recursiveSearch(int key, Node current)
    {

        //if current is null, we have searched the tree without finding the key
        if (current == null )
        {
            System.out.println("Key not found");
        }

        //else if key > current.data, use recursion w right child of current
        else if (key > current.getData())
        {
            recursiveSearch(key, current.getRight());
        }//end else if

        //else if key < current.data, use recursion with left child of current
        else if (key < current.getData())
        {
            recursiveSearch(key, current.getLeft());
        }//end else if

        else { //triggered when the key = current.data
            //change result to true
            result = true;
        }

    }//end recursiveSearch method

    //min method finds the minimum value in the tree
    //Always the left most node, start at the root and use recursion to reach it
    public Node min()
    {
        //if the root is null the BST is not loaded and has no min value
        if (root == null)
        {
            System.out.println("BST is not filled ");
        }//end if

        else //if the root isn't null call the recursive min method with the root as parameters
        {
            recMin(root);
        }

        //return min at the end of the method
        return min;
    }//end max

    //recMin method is the recursive portion of the min method
    public void recMin(Node current)
    {
        //if the current node has no left child, it has the minimum value of the BST
        if (current.getLeft() == null)
        {
            min = current;
        }//end if

        //recursively call the method with the left child of current as parameters if
        //there is a left child
        else
        {
            recMin(current.getLeft());
        }//end else

    }//end recMax method

    //finds the max value in the BST
    //the max is the rightmost node. Use recursion to reach it
    public Node max()
    {
        //if the root is null the BST is not loaded and has no max value
        if (root == null)
        {
            System.out.println("BST is not filled ");
        }//end if

        else //call the recursive max method w/ the root as parameters if the root isn't null
        {
            recMax(root);
        }

        //return max before the method has finished running
        return max;
    }//end max

    //recMax method is the recursive portion of the max method
    public void recMax(Node current)
    {
        //if the right child of current is null, current has the max value
        if (current.getRight() == null)
        {
            max = current;
        }//end if

        //if current has a right child, recursively call recMax w/ the right child as parameters
        else
        {
            recMax(current.getRight());
        }//end else

    }//end recMax method

    //print method prints the data in the tree in order using an in-order traversal
    public void print()
    {
        //print error statement if root is null
        if (root == null)
        {
            System.out.println("BST is not filled ");
            return;
        }//end if

        else
        {
            //call inOrder method with root as parameters
            inOrder(root);
        }//end else
    }//end print method

    //inOrder method takes a node as parameters and uses recursion to traverse
    //the tree and print data
    public void inOrder(Node current)
    {
        //visit the left subtree
        //if the left child exists move to that node
        if (current.getLeft() != null)
        {
            inOrder(current.getLeft());
        }//end if

        //if current node has no left child, print the current node
        System.out.println(current.getData());

        //visit the right subtree
        //if the right child exists move to that node
        if(current.getRight() != null)
        {
            inOrder(current.getRight());
        }
    }//end inOrder method

}//end BST
