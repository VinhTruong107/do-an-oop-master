package Nguoi;

import java.util.ArrayList;
import java.util.List;
import quanlyfile.FileHandler;

public class UserManager {
    private List<User> userList = new ArrayList<>(); // Danh sách người dùng
    private List<Manager> managerList = new ArrayList<>(); // Danh sách quản lý

    // Constructor khởi tạo và tải người dùng, quản lý từ file
    public UserManager() {
        userList = FileHandler.readUsers(); // Tải người dùng từ file
        managerList = FileHandler.readManagers(); // Tải quản lý từ file
    }

    // Thêm người dùng mới
    public void addUser(User user) {
        userList.add(user);
        FileHandler.writeUsers(userList); // Lưu danh sách vào file
        System.out.println("Người dùng đã được thêm.");
        User.totalUsers++;
    }

    // Thêm quản lý mới
    public void addManager(Manager manager) {
        managerList.add(manager);
        FileHandler.writeManagers(managerList); // Lưu danh sách vào file
        System.out.println("Quản lý đã được thêm.");
    }

    public User loginUser(String username, String password) {
        for (User user : userList) {
            if (user.login(username, password)) {
                System.out.println("Đăng nhập thành công (Khách hàng).");
                return user;
            }
        }
        return null;
    }

    // Đăng nhập quản lý
    public Manager loginManager(String username, String password) {
        for (Manager manager : managerList) {
            if (manager.login(username, password)) {
                System.out.println("Đăng nhập thành công (Quản lý).");
                return manager;
            }
        }
        return null;
        //
    }

    // Cập nhật thông tin người dùng
    public void updateUser(String userId, User updatedUser) {
        User existingUser = findUserById(userId);
        if (existingUser != null) {
            int index = userList.indexOf(existingUser);
            userList.set(index, updatedUser);
            FileHandler.writeUsers(userList);
            System.out.println("Thông tin người dùng đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy người dùng với ID này.");
        }
    }

    // Xóa người dùng
    public void deleteUser(String userId) {
        User userToDelete = findUserById(userId);
        displayUserInfo(userToDelete);
        if (userToDelete != null) {
            userList.remove(userToDelete);
            User.totalUsers--;
            FileHandler.writeUsers(userList);
            System.out.println("Người dùng này đã được xóa.");
        } else {
            System.out.println("Không tìm thấy người dùng với ID này.");
        }
    }

    // Tìm kiếm người dùng theo ID mà không sử dụng Optional
    public User findUserById(String userId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Tìm kiếm người dùng theo tên
    public List<User> searchUsersByName(String name) {
        List<User> matchingUsers = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }

    // Hiển thị danh sách tất cả người dùng
    // Hiển thị danh sách tất cả người dùng
    public void viewUsers() {
        if (userList.isEmpty()) {
            System.out.println("Chưa có người dùng nào.");
        } else {
            System.out.println("\n--- DANH SÁCH NGƯỜI DÙNG ---");

            // Đếm số lượng người dùng trong danh sách
            int count = userList.size();
            System.out.printf("Tổng số người dùng: %d\n", count);

            // Hiển thị tiêu đề cho bảng
            System.out.printf("%-15s %-25s %-30s %-15s %-15s%n", "ID", "Tên", "Địa chỉ", "Số điện thoại", "Username");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------");

            for (User user : userList) {
                displayUserInfo(user);
            }
        }
    }

    private void displayUserInfo(User user) {
        System.out.printf("ID: %-15s Tên: %-25s Địa chỉ: %-30s Số điện thoại: %-15s Username: %-15s%n",
                user.getId(),
                user.getName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getUsername());
        System.out.println("-------------------------------------------------------------------------------");
    }

    // Hiển thị người dùng theo tên
    public void viewUsersByName(String name) {
        List<User> matchingUsers = searchUsersByName(name);
        if (matchingUsers.isEmpty()) {
            System.out.println("Không tìm thấy người dùng có tên phù hợp.");
        } else {
            System.out.println("\n--- DANH SÁCH NGƯỜI DÙNG TÌM ĐƯỢC ---");
            for (User user : matchingUsers) {
                displayUserInfo(user);
            }
        }
    }
}
