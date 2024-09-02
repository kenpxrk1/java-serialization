import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1, "user1", LocalDate.now());
        User user2 = new User(2, "user2", LocalDate.now().minusDays(1));
        User user3 = new User(3, "user3", LocalDate.now().minusDays(2));
        User[] users = {user1, user2, user3};
        serialize(users, "src/main/resources/users");
        serialize(user1, "src/main/resources/user");
        System.out.println(deserialize("src/main/resources/user"));
        System.out.println(Arrays.toString(deserializeArray("src/main/resources/users")));
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