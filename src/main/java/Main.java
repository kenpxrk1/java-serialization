
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;


public class Main {

    public static final String userFilePath = "src/main/resources/users";
    public static final String usersFilePath = "src/main/resources/users";

    public static void main(String[] args) {
        User firstUser = new User(1, "user1", LocalDate.now());
        User secondUser = new User(2, "user2", LocalDate.now().minusDays(1));
        User thirdUser = new User(3, "user3", LocalDate.now().minusDays(2));
        User[] users = {firstUser, secondUser, thirdUser};
        serialize(users, usersFilePath);
        serialize(firstUser, userFilePath);
        System.out.println(deserialize(userFilePath));
        System.out.println(Arrays.toString(deserializeArray(usersFilePath)));
    }

    public static void serialize(User user, String filepath) {
        Path file = Paths.get(filepath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serialize(User[] user, String filepath) {
        Path file = Paths.get(filepath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User deserialize(String filepath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static User[] deserializeArray(String filepath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            return (User[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}