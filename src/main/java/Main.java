import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage storage = (Storage) new SimpleStorage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию: создать, прочитать, обновить, удалить, выход");
            String operation = scanner.nextLine();

            if ("выход".equals(operation)) {
                break;
            }

            int id;
            String value;

            switch (operation) {
                case "создать":
                    System.out.println("Введите значение:");
                    value = scanner.nextLine();
                    id = storage.create(value);
                    if (id != -1) {
                        System.out.println("Создано с ID: " + id);
                    }
                    break;
                case "прочитать":
                    System.out.println("Введите ID:");
                    id = Integer.parseInt(scanner.nextLine());
                    value = storage.read(id);
                    if (value != null) {
                        System.out.println("Значение: " + value);
                    }
                    break;
                case "обновить":
                    System.out.println("Введите ID:");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите новое значение:");
                    value = scanner.nextLine();
                    if (storage.update(id, value)) {
                        System.out.println("Успешно обновлено");
                    }
                    break;
                case "удалить":
                    System.out.println("Введите ID:");
                    id = Integer.parseInt(scanner.nextLine());
                    if (storage.delete(id)) {
                        System.out.println("Успешно удалено");
                    }
                    break;
                default:
                    System.out.println("Недопустимая операция");
            }
        }

        scanner.close();
    }
}