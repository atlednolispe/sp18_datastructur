/** Class that determines whether or not a year is a leap year.
 *  @author YOUR NAME HERE
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

    /** Judge if the year is leap.
     *
     */
    public static boolean isLeapYear(int year) {
        int mod100;
        int mod400;
        int mod4;
        mod100 = year % 100;
        if (mod100 == 0) {
            mod400 = year % 400;
            if (mod400 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            mod4 = year % 4;
            if (mod4 == 0) {
                return true;
            } else {
                return false;
            }
        }
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

