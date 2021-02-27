class Admin extends User {     // Admin is specific form of user. that can controls many things.

    Admin(String Username, String Password) {
        super(Username, Password);
    }

    public static boolean isAdmin(Person user) {
        if (user instanceof Admin)
            return true;

        else return false;
    }
}
