package Bundle.business;

import Bundle.data.SalesIO;

import java.util.ArrayList;

/**
 * Class for the total grouping of sales that the program works with throughout its runtime.
 */
public final class SalesList {
    /********************** Constructors *****************************/
    /**
     * Default Constructor
     */
    private SalesList(){}

    /********************** Attributes *****************************/
    private static ArrayList<LineItem> allLineItems = new ArrayList();

    /********************** Methods *****************************/
    public static ArrayList<LineItem> getAllLineItems() {
        return allLineItems;
    }

    public static void loadAllLineItems() {
        allLineItems = SalesIO.getAllSales();
    }

    public static void addLineItemList(ArrayList<LineItem> newList){
        allLineItems.addAll(newList);
    }

    public static boolean isValidData(ArrayList<LineItem> listToVerify){
        for (LineItem sale: listToVerify) {
            if(!sale.isValid()) return false;
        }
        return true;
    }
}
