// Fig. 21.16: TreeTest.java
// Binary tree test program.
import java.security.SecureRandom;
import com.deitel.datastructures.Tree;

public class TreeTest {
   public static void main(String[] args) {
      Tree<Integer> tree = new Tree<Integer>();
      SecureRandom randomNumber = new SecureRandom();

      System.out.println("Inserting the following values: ");

      // insert 10 random integers from 0-99 in tree 
      for (int i = 1; i <= 10; i++) {
         int value = randomNumber.nextInt(100);
         System.out.printf("%d ", value);
         tree.insertNode(value);
      } 

      System.out.printf("%n%nPreorder traversal%n");
      tree.preorderTraversal();

      System.out.printf("%n%nInorder traversal%n");
      tree.inorderTraversal();

      System.out.printf("%n%nPostorder traversal%n");
      tree.postorderTraversal();
      System.out.println();
   } 
} 



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
