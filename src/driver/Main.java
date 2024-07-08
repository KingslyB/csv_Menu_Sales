package driver;
import Bundle.business.*;
import Bundle.ui.Menu;

public class Main {
    public static void main(String[] args) {
        //load records in the file specified by SalesIO.ALL_SALES_FILENAME
        SalesList.loadAllLineItems();
        Menu.mainMenu();
    }
}