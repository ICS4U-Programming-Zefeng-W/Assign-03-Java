/*
 * The program reads the integers in input.txt and prints
 * an hourglass pattern with astericks to the console
 *
 * By Zefeng Wang
 * Created on January 31, 2022
 *
*/

// import classes
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

// class Recursion
class Recursion {
  public static void main(String[] args) throws IOException {

    // Reads each line of the input.txt file
    List<String> lines = Files.readAllLines(Paths.get("input.txt"),
                               StandardCharsets.UTF_8);
    Iterator<String> itr = lines.iterator();
    
    // Casts numbers and calls the function to output the pattern with error checking
    if (lines.size() != 0) {
      for (int i = 0; itr.hasNext(); i++) {
        String str = itr.next();
        try {
          int num = Integer.parseInt(str);
          if (num < 1) {
            System.out.println("The number you entered was " + num
                                 + ". Please enter an integer greater or equal to 1.");
            continue;
          } else { 
            System.out.println("Number: " + num);
            hourglass(num, 0);
          }
        } catch (Exception e) {
          System.out.println("The value you entered was " + str + ". Please enter an integer");
          continue;
        }
      }
    } else {
      System.out.println("Please enter at least one integer in input.txt");
    }
  }

  // Recursively produces the hourglass pattern
  public static void hourglass(int asterisks, int spaces) {
    System.out.println(format(asterisks, spaces));
    if (asterisks > 1) {
      hourglass(asterisks - 1, spaces + 1);
      System.out.println(format(asterisks, spaces));
    } else if (asterisks == 1) {
      System.out.println(format(asterisks, spaces));
    }
  }

  // Output the astericks for each line
  public static String format(int asterisks, int spaces) {
    return " ".repeat(spaces) + "* ".repeat(asterisks);
  }
}
