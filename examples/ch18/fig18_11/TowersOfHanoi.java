// Fig. 18.11: TowersOfHanoi.java
// Towers of Hanoi solution with a recursive method.
public class TowersOfHanoi {
   // recursively move disks between towers
   public static void solveTowers(int disks, int sourcePeg, 
      int destinationPeg, int tempPeg) {
      // base case -- only one disk to move
      if (disks == 1) {
         System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
         return;
      } 

      // recursion step -- move (disk - 1) disks from sourcePeg
      // to tempPeg using destinationPeg
      solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);

      // move last disk from sourcePeg to destinationPeg
      System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);

      // move (disks - 1) disks from tempPeg to destinationPeg
      solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);
   }

   public static void main(String[] args) {
      int startPeg = 1; // value 1 used to indicate startPeg in output
      int endPeg = 3; // value 3 used to indicate endPeg in output
      int tempPeg = 2; // value 2 used to indicate tempPeg in output
      int totalDisks = 3; // number of disks
      
      // initial nonrecursive call: move all disks.
      solveTowers(totalDisks, startPeg, endPeg, tempPeg);
   }
}

/*************************************************************************
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