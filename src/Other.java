public class Other extends Commodity {   // other stuff class.

    private int stockOfOther;

    Other(String name, String description, double height, double width, double weight) {

        super(name, description, height, width, weight);
    }

    public int getStockOfOther() {
        return stockOfOther;
    }

    public void setStockOfOther(int value) {
        stockOfOther = value;
    }

    public static boolean isOther(Commodity stuff) {
        if (stuff instanceof Other)
            return true;
        else return false;
    }
}