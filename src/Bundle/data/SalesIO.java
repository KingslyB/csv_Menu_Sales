package Bundle.data;
import Bundle.business.LineItem;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles input and output of csv files that contain sales records (what would be LineItems)
 */
public final class SalesIO {

    /********************** Constructors *****************************/
    /**
     * Default constructor
     */
    private SalesIO(){}

    /********************** ATTRIBUTES *****************************/
    private final static String ALL_SALES_FILENAME= "all_sales.csv";
    private final static String CURRENT_IMPORTS_FILENAME = "imported_files.txt";
    private static File allSalesCSV = new File(Convert.getCsvFolderDirectory() + ALL_SALES_FILENAME);
    private static File importedFiles = new File(Convert.getCsvFolderDirectory() + CURRENT_IMPORTS_FILENAME);
    private static Scanner fileScanner;


    public static void updateImportedFiles(String filename){
        if(!importedFiles.exists()){
            try {
                importedFiles.createNewFile();
            }
            catch (IOException ex){
                System.out.println("An error occurred when trying to create a new imported_files.txt\n" + ex);
            }
        }
        try{
            FileWriter importedFilesWriter = new FileWriter(importedFiles);
            importedFilesWriter.append(filename);
        }
        catch (IOException ex){
            System.out.println("An error occurred when trying to append to the imported_files.txt\n" + ex);
        }
    }
    public static boolean isImported(String filename){
        try{
            fileScanner = new Scanner(importedFiles);
            while(fileScanner.hasNextLine()){
                if(fileScanner.nextLine().equals(filename)){
                    return true;
                }
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("An error occurred when trying to locate the imported_files.txt");
        }
        return false;

    }
    public static ArrayList<LineItem> getAllSales(){
        ArrayList<LineItem> foundSales = new ArrayList<>();
        if(Convert.verifyFile(ALL_SALES_FILENAME)){
            foundSales = Convert.importSales(ALL_SALES_FILENAME);
        }
        return foundSales;

    }

    public static boolean saveAllSales(ArrayList<LineItem> allSalesList){
        if(!Convert.verifyFile(ALL_SALES_FILENAME)){
            try{
                allSalesCSV.createNewFile();
            }
            catch (IOException ex){
                System.out.println("An error occurred when trying to create all_sales.csv\n" + ex);
                return false;
            }
        }
        try{
            FileWriter allSalesCsvWriter = new FileWriter(allSalesCSV);
            for (LineItem sale: allSalesList) {
                allSalesCsvWriter.append(sale.getYearOfSale() + ","
                + sale.getMonthOfSale() + ","
                + sale.getYearOfSale() + ","
                + sale.getRegion() + ","
                + sale.getAmount() + "\n");
            }
            allSalesCsvWriter.close();
        }
        catch (IOException ex){
            System.out.println("An error occurred when trying to save all sales\n" + ex);
            return false;
        }

        return true;

    }
}
