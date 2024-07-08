package Bundle.ui;
import Bundle.business.*;
import Bundle.data.Convert;
import Bundle.data.SalesIO;
import utility.*;

import java.util.ArrayList;

public final class Menu {
    private static String userInput;
    public static void mainMenu(){
        System.out.println("Command Menu");
        System.out.printf("view - View all sales" +
                "\nadd (NOT IMPLEMENTED) - Add sales" +
                "\nimport - Import sales from file" +
                "\nmenu - Show menu" +
                "\nexit - Exit program" +
                "\n\nPlease enter a command: ");
        userInput = Utility.getString();
        System.out.printf("\n\n");

        switch(userInput){
            case "view": {
                viewMenu();
                break;
            }
            case "add":
            {
                addMenu();
                break;
            }
            case "import": {
                importMenu();
                break;
            }
            case "menu": {
                mainMenu();
                break;
            }
            case "exit": {
                exitMenu();
                break;
            }
            default: {
                System.out.println("Invalid Command\n");
                mainMenu();
            }
        }
    }

    public static void viewMenu(){
        for (LineItem sale: SalesList.getAllLineItems()) {
            System.out.println(sale.toString());
        }

    }

    public static void addMenu(){
        mainMenu();
    }

    public static void importMenu(){
        String filename = "";
        System.out.printf("Enter the filename: ");
        filename = Utility.getString(filename);
        if(Convert.verifyFile(filename)){
            if (!SalesIO.isImported(filename)){

                ArrayList<LineItem> importedSalesList = Convert.importSales(filename);
                if(SalesList.isValidData(importedSalesList)){
                    SalesList.addLineItemList(importedSalesList);

                    SalesIO.updateImportedFiles(filename);
                    System.out.println("******This import was added******\n\n");

                }
                else{
                    System.out.println("******This import contained invalid data and was not added******\n\n");
                }
            }
            else{
                System.out.println("******This import was already imported******");
            }
        }
        else {
            System.out.println("******This import does not exist******");
        }

        mainMenu();
    }

    public static void exitMenu(){
        SalesIO.saveAllSales(SalesList.getAllLineItems());
        System.exit(0);
    }

}
