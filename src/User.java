public class User extends Person {

    protected String userName;
    protected String passWord;

    User(String name, String familyName, int age, String userName, String passWord) {

        super(name, familyName, age);
        this.userName = userName;
        this.passWord = passWord;
    }

    User(String userName, String passWord) {

        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return super.toString() + "\nUsername: " + userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserPass(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public boolean checkSignIn(String inputUsernname, String inputPassword) {

        if (inputPassword.equals(passWord) && inputUsernname.equals(userName))
            return true;
        else return false;
    }
}
