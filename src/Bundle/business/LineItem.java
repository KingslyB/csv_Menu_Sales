package Bundle.business;

import utility.Utility;

/**
 * Individual sales records
 */
public class LineItem {
    /********************** Attributes *****************************/
    private String dayOfSale;
    private String monthOfSale;
    private String yearOfSale;
    private String quarterOfSale;
    private String region;
    private String amount;


    //<editor-fold> desc="Constructors"
    /********************** Constructors *****************************/
    /**
     * Default Constructor
     */
    public LineItem() {}

    /**
     * Parameterized Constructor
     * @param dayOfSale
     * @param monthOfSale
     * @param yearOfSale
     * @param quarterOfSale
     * @param region
     * @param amount
     */
    public LineItem(String dayOfSale, String monthOfSale, String yearOfSale, String quarterOfSale, String region, String amount) {
        this.dayOfSale = dayOfSale;
        this.monthOfSale = monthOfSale;
        this.yearOfSale = yearOfSale;
        this.quarterOfSale = quarterOfSale;
        this.region = region;
        this.amount = amount;
    }
    //</editor-fold>

    //<editor-fold> desc="Accessors & Mutators"
    /********************** Accessors & Mutators *****************************/
    public String getDayOfSale() {
        return dayOfSale;
    }

    public void setDayOfSale(String dayOfSale) {
        int MAX_LONG_MONTH_DAY = 31;
        int MIN_DAY = 1;
        if(Utility.isInteger(dayOfSale) && Utility.isInRange(dayOfSale, MIN_DAY, MAX_LONG_MONTH_DAY)) {
            this.dayOfSale = dayOfSale;
        }
        else{
            this.dayOfSale = "?";
        }
    }

    public String getMonthOfSale() {
        return monthOfSale;
    }

    public void setMonthOfSale(String monthOfSale) {
        int MIN_MONTH = 1;
        int MAX_MONTH = 12;
        if(Utility.isInteger(monthOfSale) && Utility.isInRange(monthOfSale, MIN_MONTH, MAX_MONTH)) {
            this.monthOfSale = monthOfSale;
        }
        else{
            this.monthOfSale = "?";
        }
    }

    public String getYearOfSale() {
        return yearOfSale;
    }

    public void setYearOfSale(String yearOfSale) {
        int MAX_YEAR = 9999;
        int MIN_YEAR = 2000;
        if(Utility.isInteger(yearOfSale) && Utility.isInRange(yearOfSale, MIN_YEAR, MAX_YEAR)) {
            this.yearOfSale = yearOfSale;
        }
        else{
            this.yearOfSale = "?";
        }
    }

    public String getQuarterOfSale() {
        return quarterOfSale;
    }

    public void setQuarterOfSale() {
        switch (this.getMonthOfSale()){
            case "1","2","3": this.quarterOfSale = "1"; break;
            case "4","5","6": this.quarterOfSale = "2"; break;
            case "7","8","9": this.quarterOfSale = "3"; break;
            case "10","11","12": this.quarterOfSale = "4"; break;
            default: this.quarterOfSale = "?";
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    //</editor-fold> desc="Accessors & Mutators"

    //<editor-fold> desc="Methods"
    /********************** Methods *****************************/

    /**
     *
     * @return
     */
    public boolean isValid(){
        if (this.getDayOfSale().equals("?")
        || this.getMonthOfSale().equals("?")
        || this.getYearOfSale().equals("?")
        || this.getQuarterOfSale().equals("?")
        || this.getRegion().equals("?")
        || this.getAmount().equals("?")){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "dayOfSale='" + dayOfSale + '\'' +
                ", monthOfSale='" + monthOfSale + '\'' +
                ", yearOfSale='" + yearOfSale + '\'' +
                ", quarterOfSale='" + quarterOfSale + '\'' +
                ", region='" + region + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
    //</editor-fold> desc="Methods"




}
