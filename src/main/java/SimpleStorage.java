import java.util.HashMap;
import java.util.Map;

public class SimpleStorage implements Storage {
    private Map<Integer, String> storage;
    private int idCounter;

    public SimpleStorage() {
        // Инициализация хранилища и счетчика идентификаторов
        storage = new HashMap<>();
        idCounter = 0;
    }

    @Override
    public int create(String value) {
        // Проверка валидности значения
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Недопустимое значение");
            return -1;
        }
        // Генерация идентификатора и сохранение значения
        int id = generateId();
        storage.put(id, value);
        return id;
    }

    @Override
    public String read(int id) {
        // Проверка валидности идентификатора
        if (!isValidId(id)) {
            System.out.println("Недопустимый ID");
            return null;
        }
        return storage.get(id);
    }

    @Override
    public boolean update(int id, String newValue) {
        // Проверка валидности идентификатора и нового значения
        if (!isValidId(id) || newValue == null || newValue.trim().isEmpty()) {
            System.out.println("Недопустимый ID или значение");
            return false;
        }
        // Обновление значения
        storage.put(id, newValue);
        return true;
    }

    @Override
    public boolean delete(int id) {
        // Проверка валидности идентификатора
        if (!isValidId(id)) {
            System.out.println("Недопустимый ID");
            return false;
        }
        // Удаление значения
        storage.remove(id);
        return true;
    }

    private int generateId() {
        // Генерация нового идентификатора
        return idCounter++;
    }

    private boolean isValidId(int id) {
        // Проверка существования идентификатора в хранилище
        return storage.containsKey(id);
    }
}
