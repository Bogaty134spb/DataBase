import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Интерфейс для хранилища
 public interface Storage {
    int create(String value);
    String read(int id);
    boolean update(int id, String newValue);
    boolean delete(int id);
}
