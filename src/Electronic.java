public class Electronic extends Commodity {   // Electronic stuff class.

    private int stockOfElectronic;
    private int WarrantyPeriod;
    private String brand;

    Electronic(String name, String brand, String description, double height, double width, double weight, int warrantyPeriod) {

        super(name, description, height, width, weight);
        this.WarrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    public int getStockOfElectronic() {
        return stockOfElectronic;
    }

    public int getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public void setStockOfElectronic(int value) { /////------------------------------------
        stockOfElectronic = value;
    }

    public String getBrand() {
        return brand;
    }

    static boolean isElectronic(Commodity stuff) {

        if (stuff instanceof Electronic)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWarranty Period: " + getWarrantyPeriod() + "\nCompany Brand: " + getBrand() + "\n";
    }
}
