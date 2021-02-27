import java.util.Date;

//Commodity -->> Stuff.
public class Commodity {     // this is stuff class. this class is the father of 4 classes.

    static int NUMBER_OF_Commodity;
    protected String name;
    protected String description;
    protected double height;
    protected double width;
    protected double weight;
    protected Date creationDate;

    Commodity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    Commodity(String name, String description, double height, double width, double weight) {

        this(name, description);
        this.height = height;
        this.width = width;
        this.weight = weight;
        creationDate = new Date();   // for every stuff i used Date class for creation date.
        NUMBER_OF_Commodity++;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\nname: " + name + "\ntype description: " + getDescription() + "\nheight: " + height + "\nwidth: " + width + "\nweight: " + weight + "\nCreationDate: " + getCreationDate();
    }

}