import java.io.Serializable;
import java.time.LocalDate;


public class User implements Serializable {
    private final int id;
    private final String name;
    private final LocalDate birthdate;

    public User(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", birthdate=" + birthdate + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public LocalDate getBirthdate() {
        return birthdate;
    }

}
