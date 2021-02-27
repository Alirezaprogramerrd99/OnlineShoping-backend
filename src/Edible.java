public class Edible extends Commodity {    // food stuff class.

    private int stockOfEdible;
    private String expirationDate;

    Edible(String name, String description, String expirationDate, double height, double width, double weight) {
        super(name, description, height, width, weight);
        this.expirationDate = expirationDate;
    }

    public void setStockOfEdible(int value) { /////------------------------------------
        stockOfEdible = value;
    }

    public int getStockOfEdible() {
        return stockOfEdible;
    }

    static boolean isEdible(Commodity stuff) {

        if (stuff instanceof Edible)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nExpirationDate: " + expirationDate + "\n";
    }
}