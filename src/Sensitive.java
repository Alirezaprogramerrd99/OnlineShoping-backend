public class Sensitive extends Commodity {    // sensitive stuffs.

    private int stockOfSensitive;
    private String keepingDescription;

    Sensitive(String name, String description, String keepingDescription, double height, double width, double weight) {

        super(name, description, height, width, weight);
        this.keepingDescription = keepingDescription;
    }

    public void showKeepingDescription() {
        System.out.println(keepingDescription);
    }

    public void setStockOfSensitive(int value) {
        stockOfSensitive = value;

    }

    public int getStockOfSensitive() {
        return stockOfSensitive;
    }

    // get extentionDate method.
    static boolean isSensitive(Commodity stuff) {

        if (stuff instanceof Sensitive)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nstuffs KeepingDescription: " + keepingDescription + "\n";
    }
}