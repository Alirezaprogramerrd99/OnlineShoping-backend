public class Person {   // in this program we have Persons normal users and Admin.

    protected String name;
    protected int age;
    protected String familyName;
    private static int NUMBER_OF_PERSONS;

    Person(String name, String familyName, int age) {

        this.name = name;
        this.familyName = familyName;
        this.age = age;
        NUMBER_OF_PERSONS++;
    }

    Person() {
    }

    @Override
    public String toString() {
        return "Person has been created " + "\nname: " + name + "\nFamilyName: " + familyName + "\nperson age: " + age;
    }

    protected static int getNumberOfPersons() {
        return NUMBER_OF_PERSONS;
    }
}