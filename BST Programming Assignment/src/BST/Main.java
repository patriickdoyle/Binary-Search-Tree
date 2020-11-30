/*
Main.java
CSCI 211
Prof. Herbert
Main method creates an array and calls methods for a BST
Last edited by Pat Doyle 8/2/2020
 */
package BST;

public class Main {

    public static void main(String[] args)
    {
        //create new
        BST myBST = new BST();

        int[] myArray = {4, 8, 17, 18, 2, 22, 36, 1, 93, 107, 223, 333};

        myBST.insert(myArray);
        System.out.println(myBST.search(9));
        System.out.println("Minimum value: " + myBST.min().getData());
        System.out.println("Maximum value: " + myBST.max().getData());
        myBST.print();


    }//end main
}
