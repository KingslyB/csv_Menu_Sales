package Bundle.data;
import Bundle.business.LineItem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Convert {
    /********************** Attributes *****************************/
    private final static String CSV_FOLDER_DIRECTORY = "src\\oop3200\\data\\";

    /**Scanner for reading records (individual LineItems) from csv files found in CSV_FOLDER_DIRECTORY.
     */
    private static Scanner fileScanner;


    /********************** Constructors *****************************/
    /**
     * Default constructor
     */
    private Convert(){}


    /**
     *
     * @param filename csv file to be scanned. Should be located in CSV_FOLDER_DIRECTORY and include extension.
     * @return A new ArrayList of LineItems that represent the records imported from the file.
     */
    public static ArrayList<LineItem> importSales(String filename){
        ArrayList<LineItem> importedSalesList = new ArrayList<>();
        try{
            File fileToRead = new File(CSV_FOLDER_DIRECTORY + filename);
            fileScanner = new Scanner(fileToRead);
            fileScanner.useDelimiter(",");
            String nextLine = "";

            while (fileScanner.hasNextLine()){
                System.out.println("\n");
                LineItem lineItemToAdd = new LineItem();
                nextLine = fileScanner.nextLine() + ",";
                Scanner fileScannerTwo = new Scanner(nextLine);
                fileScannerTwo.useDelimiter(",");
                if(fileScannerTwo.hasNext()){
                    lineItemToAdd.setYearOfSale(fileScannerTwo.next());
                    lineItemToAdd.setMonthOfSale(fileScannerTwo.next());
                    lineItemToAdd.setDayOfSale(fileScannerTwo.next());
                    lineItemToAdd.setRegion(fileScannerTwo.next());
                    lineItemToAdd.setAmount(fileScannerTwo.next());
                    lineItemToAdd.setQuarterOfSale();
                    System.out.println(lineItemToAdd);
                    System.out.println(nextLine);
                    importedSalesList.add(lineItemToAdd);
                }
            }

        }
        catch (Exception ex){
            System.out.println("An error occurred at import of sales: " + ex + "\n");
        }

        return importedSalesList;
    }

    public static boolean verifyFile(String filename){
        return new File(CSV_FOLDER_DIRECTORY + filename).exists();
    }

    public static String getCsvFolderDirectory() {
        return CSV_FOLDER_DIRECTORY;
    }



}
