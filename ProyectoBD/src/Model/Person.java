
package Model;

public class Person {
    private int id;
    private String first_name;
    private String last_name;
    private String birthDate;
    private int id_gender;

    public Person(int id, String First_Name, String Last_Name, String BirthDate, int id_gender) {
        this.id = id;
        this.first_name = First_Name;
        this.last_name = Last_Name;
        this.birthDate = BirthDate;
        this.id_gender = id_gender;
    }

    public int getId() {
        return id;
    }

    public String getFirst_Name() {
        return first_name;
    }

    public String getLast_Name() {
        return last_name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getId_gender() {
        return id_gender;
    }
    
    
    @Override
    public String toString() {
        return "" + first_name + " " + last_name + "";
    }
}
