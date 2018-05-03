/** Class that determines whether or not a year is a leap year.
 *  @author Sissi
 */

public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}

/**
 * 
 * - Java is a compiled language. You can use javac and java to compile and run your code.
 * - Java is an object-oriented language. Every Java file must contain either a class, interface, or enum.
 * - When running a Java program, the main method runs. This main method can call other methods/classes in the program.
 * - Git is a version control system that tracks the history of a set of files in the form of commits.
 * - Commit often and use informative commit messages.
 * - Pull from the skeleton remote repository to get or update starter code for assignments.
 *       $ git pull skeleton master
 *       $ git pull --rebase --allow-unrelated-histories skeleton master
 * 
 */