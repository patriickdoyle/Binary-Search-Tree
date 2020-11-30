/* Node.java
CSCI 211
Prof. Herbert
This class can be used to create and work with nodes
of a binary tree.
Last edited by Pat Doyle 7/20/20
*/

package BST;

public class Node {

        //Properties: data, left child pointer, and right child pointer.
        private int data;
        private Node left;
        private Node right;

        //constructor method
        public Node()
        {
        }//end Node

        //get and set methods for properties:

        public int getData() {
            return data;
        }//end getData()

        public void setData(int data) {
            this.data = data;
        }//end setData()

        public Node getLeft() {
            return left;
        }//end getLeft()

        public void setLeft(Node left) {
            this.left = left;
        }//end setLeft()

        public Node getRight() {
            return right;
        }//end getRight()

        public void setRight(Node right) {
            this.right = right;
        }//end setRight()



    }//end class Node
