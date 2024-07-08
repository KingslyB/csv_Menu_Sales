package utility;
import java.util.Scanner;

/**
 * Personal utility class for simple validation
 */
public final class Utility {
    static Scanner keyboardInput  = new Scanner(System.in);

    private Utility(){}

    public static boolean isInRange(String testNumber, double minimumValue, double maximumValue){
        return Integer.parseInt(testNumber) >= minimumValue && Integer.parseInt(testNumber) <= maximumValue;
    }
    public static boolean isInRange(int testNumber, double minimumValue, double maximumValue){
        return testNumber >= minimumValue && testNumber <= maximumValue;
    }
    public static boolean isInRange(double testNumber, double minimumValue, double maximumValue){
        return testNumber >= minimumValue && testNumber <= maximumValue;
    }


    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public static boolean isDecimal(String s){
        try{
            Double.parseDouble(s);
            return true;
        }
        catch (Exception ex){
            return false;
        }

    }
    public static String getString(){
        return keyboardInput.nextLine();
    }

    public static String getString(String prompt){
        System.out.printf(prompt);
        return keyboardInput.nextLine();
    }

/*
    Create a Utility.requiredInput function that forces a user provide valid input, looping endlessly

    void requiredInput(type)
    requiredInput(type, typeErrorMessage)
    requiredInput(type, MIN)
    requiredInput(type, MIN, typeErrorMessasge, MINerrorMessage)
    requiredInput(type, MIN, MAX)
    requiredInput(type, MIN, MAX, typeErrorMessage)
    requiredInput(type, MIN, MAX, typeErrorMessasge, MINerrorMessage)
    requiredInput(type, MIN, MAX, typeErrorMessasge, MINerrorMessage, MAXerrorMessage)

    bool isValidInput(type, MIN, MAX) same but does not loop and returns false upon failure


    figure out the best way to output a menu. Might need enums

    double initialValue = keyboardInput.nextDouble();
-Throws an InputMismatchException if the next input is not a double.
Is it better to handle this with try catch, prevent it with validation, or both?

     */
}