
import java.util.Date;
import java.util.Scanner;

public class OnlineShoping {

    static Scanner inputUser = new Scanner(System.in);

    public static boolean signIn(Person[] people, String Username, String Password) {  // sign in method.

        for (int i = 0; i < Person.getNumberOfPersons(); i++) {    // ta full ha peymesh mekone,

            if (((User) people[i]).checkSignIn(Username, Password)) {  // down casting.
                System.out.println("Welcome to the system " + ((User) people[i]).getUserName() + "!");
                return true;
            }
        }
        System.out.println("\nUsername or Password is wrong!\n");
        return false;
    }

    public static int findUser(Person[] people, String username, String password) {   // for searching user and returning place of it in array.

        int i;
        for (i = 0; i < Person.getNumberOfPersons(); i++)
            if (((User) people[i]).checkSignIn(username, password))
                break;
        return i;
    }

    public static void register(Person[] people) {

        System.out.println("Enter person " + (User.getNumberOfPersons() + 1) + " information.");

        System.out.println("set your Username:");
        String Username = inputUser.next();

        System.out.println("set your Password:");
        String pass = inputUser.next();

        System.out.println("Enter your name:");
        String name = inputUser.next();

        System.out.println("Enter your last name:");
        String last = inputUser.next();

        System.out.println("Enter your age:");
        int age = inputUser.nextInt();

        people[User.getNumberOfPersons()] = new User(name, last, age, Username, pass);

        System.out.println("Register was successful." + "\nYou are signed in.\n");
    }

    public static void setCommodites(Commodity[] stuff, String name, String dis, double w, double h, double wei) {

        switch (dis) {

            case "Electronic":
            case "electronic":

                System.out.println("Enter Warranty period:");
                int grantiy = inputUser.nextInt();
                System.out.println("Enter development Brand:");
                String brand = inputUser.next();

                stuff[Commodity.NUMBER_OF_Commodity] = new Electronic(name, brand, dis, h, w, wei, grantiy);

                System.out.println("new " + stuff[Commodity.NUMBER_OF_Commodity - 1].getName() + " has been created" + " with stock of: " + ((Electronic) stuff[Commodity.NUMBER_OF_Commodity - 1]).getStockOfElectronic());
                System.out.println("Company is: " + ((Electronic) stuff[Commodity.NUMBER_OF_Commodity - 1]).getBrand() + '\n');

                break;

            case "Eating":
            case "Edible":
            case "eating":
            case "edible":

                // extinction time must be added.
                System.out.println("Enter extensionTime:");
                String expirationDate = inputUser.next();
                stuff[Commodity.NUMBER_OF_Commodity] = new Edible(name, dis, expirationDate, h, w, wei);
                System.out.println("new " + stuff[Commodity.NUMBER_OF_Commodity - 1].getName() + " has been created " + "with stock of: " + ((Edible) stuff[Commodity.NUMBER_OF_Commodity - 1]).getStockOfEdible() + '\n');

                break;

            case "Sensitive":
            case "sensitive":

                System.out.println("Enter the stuff keepingDescriptions: ");
                String keeping = inputUser.next();
                stuff[Commodity.NUMBER_OF_Commodity] = new Sensitive(name, dis, keeping, h, w, wei);  //??? keeping aya metone toye constracotr bashe??
                System.out.println("new " + stuff[Commodity.NUMBER_OF_Commodity - 1].getName() + " has been created " + "with stock of: " + ((Sensitive) stuff[Commodity.NUMBER_OF_Commodity - 1]).getStockOfSensitive() + '\n');
                System.out.println("The keeping description: ");
                ((Sensitive) stuff[Commodity.NUMBER_OF_Commodity - 1]).showKeepingDescription();

                break;

            default:

                System.out.println("Other stuff has been created.");
                stuff[Commodity.NUMBER_OF_Commodity] = new Other(name, dis, h, w, wei);
                System.out.println("new " + stuff[Commodity.NUMBER_OF_Commodity - 1].getName() + " has been created " + "with stock of: " + ((Other) stuff[Commodity.NUMBER_OF_Commodity - 1]).getStockOfOther() + '\n');

                break;
        }
    }

    public static void userMode(Commodity[] stuffs, int choice) {  // this method is for the users options.

        String stuffName;

        while (choice != 4) {
            System.out.println("       <USER MODE>  ");

            System.out.println("3- enter name of stuff to see its info" + "\n4- to exit");
            choice = inputUser.nextInt();
            if (choice == 3) {

                System.out.println("Enter stuffs name to see its attribute:");
                stuffName = inputUser.next();

                if (stuffs[searchByName(stuffs, stuffName)] == null || searchByName(stuffs, stuffName) == Commodity.NUMBER_OF_Commodity)
                    System.out.println("Item not found!\n");

                else
                    System.out.println(stuffs[searchByName(stuffs, stuffName)].toString());
            }
        }


    }

    public static int searchByName(Commodity[] stuff, String suffName) {  // this method searches the wanted stuff using name of its stuff.

        int i;
        for (i = 0; i < Commodity.NUMBER_OF_Commodity; i++) {
            if (stuff[i].getName().equals(suffName))
                break;
        }
        return i;
    }

    public static boolean CheckExistStuff(Commodity[] stuff, String newStuffName) { // this method checks and dont let the same name stuff added to Commodity array.

        for (int i = 0; i < Commodity.NUMBER_OF_Commodity; i++) {
            if (stuff[i].getName().equals(newStuffName))
                return true;
        }
        return false;
    }

    public static void setArrayofCommodites(Commodity[] stuff) {

        String name, dis;
        double hight, width, weight;

        System.out.println("Enter stuff`s name:");
        name = inputUser.next();

        if (CheckExistStuff(stuff, name))
            System.out.println("this stuff with name of " + name + " has already exist!\n");

        else {

            System.out.println("Enter stuff`s description:");
            dis = inputUser.next();

            System.out.println("Enter stuff`s height:");
            hight = inputUser.nextDouble();

            System.out.println("Enter stuff`s width:");
            width = inputUser.nextDouble();

            System.out.println("Enter stuff`s weight:");
            weight = inputUser.nextDouble();

            setCommodites(stuff, name, dis, width, hight, weight);
        }
    }

    public static void main(String[] args) {

        Person[] people = new User[100];     // i made it with polymorphism.
        Person defAdmin = new Admin("Admin", "Admin");   // our Default admin.
        Commodity[] stuffs = new Commodity[100];
        int choice, stock, index;
        String username, pass, tempUsername = "", tempPassword = "", stuffName = "";
        boolean isAdminLoged = false, exited = false, exited2, isUserSigned = false;

        while (true) {
            System.out.println("Welcome to the online retail store!");
            System.out.println("Please select one of the options below:");
            System.out.println("1- Register" + "\n2- Sign in");

            choice = inputUser.nextInt();

            //---------------for normal or admin log in.------------------//
            switch (choice) {

                case 1:
                    register(people);
                    userMode(stuffs, choice);

                    break;

                case 2:

                    System.out.println("Enter Username:");
                    username = inputUser.next();

                    System.out.println("Enter Password:");
                    pass = inputUser.next();

                    if (!(username.equals(((Admin) defAdmin).getUserName()) && pass.equals(((Admin) defAdmin).getPassWord()) || Admin.isAdmin(people[findUser(people, username, pass)]))) {
                        isUserSigned = signIn(people, username, pass);
                        isAdminLoged = false;

                    } else if (Admin.isAdmin(people[findUser(people, username, pass)]) || (username.equals("Admin") && username.equals("Admin"))) {

                        if (Admin.isAdmin(people[findUser(people, username, pass)])) {
                            tempUsername = username;
                            tempPassword = pass;

                        } else if ((username.equals("Admin") && username.equals("Admin"))) {
                            tempUsername = "Admin";
                            tempPassword = "Admin";
                        }
                        isAdminLoged = true;

                        // this block with statements checks that if the default admin or userAdmin User and Password are correct save user and pass for each of them and flag will be trued.
                    }

                    if (!isAdminLoged && isUserSigned)
                        userMode(stuffs, choice);

                    break;

                default:
                    continue;
            }

            if (isAdminLoged) {

                while (true) {

                    System.out.println("       <ADMIN MODE>     ");
                    if (Admin.isAdmin(people[findUser(people, tempUsername, tempPassword)]))
                        System.out.println("Welcome admin " + ((Admin) people[findUser(people, tempUsername, tempPassword)]).getUserName() + "\n");

                    else if (tempUsername.equals("Admin") && tempPassword.equals("Admin"))
                        System.out.println("Welcome default admin\n");

                    System.out.println("What do you want to do admin ?");
                    System.out.println("1- make another Admin" + "\n2- Change Username and Password" + "\n3- to Store mode" + "\n4- to exit");
                    choice = inputUser.nextInt();

                    switch (choice) {
                        case 1:

                            System.out.println("Enter Username:");
                            username = inputUser.next();
                            System.out.println("Enter Password:");
                            pass = inputUser.next();

                            if (Admin.isAdmin(people[findUser(people, username, pass)])) {

                                System.out.println("The user " + ((Admin) people[findUser(people, username, pass)]).getUserName() + " is already admin.\n");
                                continue;

                            } else if (findUser(people, username, pass) == Person.getNumberOfPersons()) {
                                System.out.println("This user is not in the system!\n");
                                continue;

                            } else {
                                people[findUser(people, username, pass)] = new Admin(username, pass);
                                System.out.println(((Admin) people[findUser(people, username, pass)]).getUserName() + " you are now new admin :)\n");
                            }
                            break;

                        case 2:
                            //*** MUST ADD Change Username and Password logic.

                            if (tempUsername.equals("Admin") && tempPassword.equals("Admin")) {
                                System.out.println("Default admin is unique!\n");
                                continue;
                            }

                            System.out.println("Enter new Username:");
                            username = inputUser.next();
                            System.out.println("Enter new Password:");
                            pass = inputUser.next();

                            ((Admin) people[findUser(people, tempUsername, tempPassword)]).setUserPass(username, pass);
                            System.out.println("the Username and password have been changed.\n");

                            break;

                        //*** in case 3 Admin can Create stuffs and change their stock if he or she wanted ***
                        case 3:
                            // *** must add the logic if commodity and other options.
                            /*case 3 is store mode that only admin can control he or she can create stuffs
                            and Admin can see the value of every stock by entering its name.
                            * */

                            while (true) {

                                System.out.println("       <STORE MODE>  ");

                                System.out.println("1- create the stuff\n2- change stock of stuff using name of it\n3- show stock of searched stuff name" + "\n4- to admin mode");

                                choice = inputUser.nextInt();
                                switch (choice) {

                                    case 1:
                                        setArrayofCommodites(stuffs);   // this method sets input stuffs.(Creates).
                                        break;

                                    case 2:
                                        //*** must add the name search and stock change logic.

                                        System.out.println("Enter name of existed stuff to change stock of it:");
                                        stuffName = inputUser.next();

                                        if (stuffs[searchByName(stuffs, stuffName)] == null || searchByName(stuffs, stuffName) == Commodity.NUMBER_OF_Commodity) {
                                            System.out.println("Item not found!\n");
                                            continue;

                                        } else {

                                            if (Electronic.isElectronic(stuffs[searchByName(stuffs, stuffName)])) {

                                                index = searchByName(stuffs, stuffName);
                                                System.out.println("Enter " + stuffs[index].getName() + " new stock:");
                                                stock = inputUser.nextInt();
                                                ((Electronic) stuffs[index]).setStockOfElectronic(stock);
                                                System.out.println("The stock of " + stuffs[index].getName() + " is " + ((Electronic) stuffs[index]).getStockOfElectronic() + '\n');

                                            } else if (Edible.isEdible(stuffs[searchByName(stuffs, stuffName)])) {

                                                index = searchByName(stuffs, stuffName);
                                                System.out.println("Enter " + stuffs[index].getName() + " new stock:");
                                                stock = inputUser.nextInt();
                                                ((Edible) stuffs[index]).setStockOfEdible(stock);
                                                System.out.println("The stock of " + stuffs[index].getName() + " is " + ((Edible) stuffs[index]).getStockOfEdible() + '\n');

                                            } else if (Sensitive.isSensitive(stuffs[searchByName(stuffs, stuffName)])) {

                                                index = searchByName(stuffs, stuffName);
                                                System.out.println("Enter " + stuffs[index].getName() + " new stock:");
                                                stock = inputUser.nextInt();
                                                ((Sensitive) stuffs[index]).setStockOfSensitive(stock);
                                                System.out.println("The stock of " + stuffs[index].getName() + " is " + ((Sensitive) stuffs[index]).getStockOfSensitive() + '\n');

                                            } else {
                                                index = searchByName(stuffs, stuffName);
                                                System.out.println("Enter " + stuffs[index].getName() + " new stock:");
                                                stock = inputUser.nextInt();
                                                ((Other) stuffs[index]).setStockOfOther(stock);
                                                System.out.println("The stock of " + stuffs[index].getName() + " is " + ((Other) stuffs[index]).getStockOfOther() + '\n');
                                            }
                                        }

                                        break;

                                    case 3:

                                        System.out.println("Enter name of stuff:");
                                        stuffName = inputUser.next();

                                        if (Electronic.isElectronic(stuffs[searchByName(stuffs, stuffName)]))
                                            System.out.println((((Electronic) stuffs[searchByName(stuffs, stuffName)]).getStockOfElectronic()) + "\n");

                                        else if (Edible.isEdible(stuffs[searchByName(stuffs, stuffName)]))
                                            System.out.println((((Edible) stuffs[searchByName(stuffs, stuffName)]).getStockOfEdible()) + "\n");

                                        else if (Sensitive.isSensitive(stuffs[searchByName(stuffs, stuffName)]))
                                            System.out.println((((Sensitive) stuffs[searchByName(stuffs, stuffName)]).getStockOfSensitive()) + "\n");

                                        else if (Other.isOther(stuffs[searchByName(stuffs, stuffName)]))
                                            System.out.println((((Other) stuffs[searchByName(stuffs, stuffName)]).getStockOfOther()) + "\n");

                                        else
                                            System.out.println("Item not found!\n");

                                        break;

                                    case 4:
                                        break;

                                    default:
                                        continue;

                                }
                                if (choice == 4) {
                                    exited2 = true;
                                    break;
                                }
                            }

                            if (exited2) {
                                continue;
                            }

                        case 4:
                            exited = true;
                            break;

                        default:
                            continue;
                    }
                    if (exited)
                        break;
                }
                isAdminLoged = false;
            }
        }
    }
}
