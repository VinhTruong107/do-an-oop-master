package quanlyfile;

import Nguoi.User;
import Nguoi.Manager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String USER_FILE = "users.txt";
    private static final String MANAGER_FILE = "managers.txt";
    private static final String PURCHASE_HISTORY_FILE = "purchase_history.txt"; // Lưu lịch sử mua hàng

    // Đọc danh sách người dùng từ file
    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(USER_FILE);
        if (!file.exists()) {
            writeUsers(users); // Tạo file rỗng nếu chưa tồn tại
            return users;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    users.add(new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file người dùng: " + e.getMessage());
        }
        return users;
    }

    // Ghi danh sách người dùng vào file
    public static void writeUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getName() + "," + user.getAddress() + "," +
                        user.getPhoneNumber() + "," + user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file người dùng: " + e.getMessage());
        }
    }

    // Đọc danh sách quản lý từ file
    public static List<Manager> readManagers() {
        List<Manager> managers = new ArrayList<>();
        File file = new File(MANAGER_FILE);
        if (!file.exists()) {
            writeManagers(managers); // Tạo file rỗng nếu chưa tồn tại
            return managers;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    managers.add(new Manager(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file quản lý: " + e.getMessage());
        }
        return managers;
    }

    // Ghi danh sách quản lý vào file
    public static void writeManagers(List<Manager> managers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MANAGER_FILE))) {
            for (Manager manager : managers) {
                writer.write(manager.getId() + "," + manager.getName() + "," + manager.getAddress() + "," +
                        manager.getPhoneNumber() + "," + manager.getUsername() + "," + manager.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file quản lý: " + e.getMessage());
        }
    }
}
