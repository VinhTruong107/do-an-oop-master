import Nguoi.User;
import Nguoi.UserManager;
import Nguoi.Manager;
import Nguoi.Product;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserManager userManager = new UserManager();
    private static Scanner scanner = new Scanner(System.in);
    private static User loggedInUser = null;
    private static Manager loggedInManager = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ CỬA HÀNG ---");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");

            int choice = getChoice();
            switch (choice) {
                case 1 -> registerUserOrManager();
                case 2 -> loginUserOrManager();
                case 3 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static int getChoice() {
        System.out.print("Nhập lựa chọn: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập số.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n--- MENU KHÁCH HÀNG ---");
            System.out.println("1. Xem sản phẩm đã mua");
            System.out.println("2. Đăng xuất");

            int choice = getChoice();
            switch (choice) {
                case 1 -> viewPurchasedProducts();
                case 2 -> {
                    System.out.println("Đăng xuất thành công.");
                    loggedInUser = null;
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void managerMenu() {
        while (true) {
            System.out.println("\n--- MENU QUẢN LÝ ---");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Sửa thông tin người dùng");
            System.out.println("4. Tìm người dùng theo tên");
            System.out.println("5. Xem danh sách người dùng");
            System.out.println("6. Đăng xuất");

            int choice = getChoice();
            switch (choice) {
                case 1 -> addUser();
                case 2 -> deleteUser();
                case 3 -> updateUser();
                case 4 -> searchUserByName();
                case 5 -> userManager.viewUsers();
                case 6 -> {
                    System.out.println("Đăng xuất thành công.");
                    loggedInManager = null;
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void registerUserOrManager() {
        System.out.println("Đăng ký:");
        System.out.println("1. Khách hàng");
        System.out.println("2. Quản lý");

        int choice = getChoice();
        if (choice == 1) {
            addUser();
        } else if (choice == 2) {
            addManager();
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void loginUserOrManager() {
        scanner.nextLine();
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        User user = userManager.loginUser(username, password);
        Manager manager = userManager.loginManager(username, password);

        // Kiểm tra nếu đăng nhập thành công với User
        if (user != null) {
            loggedInUser = user;
            userMenu();
        }
        // Kiểm tra nếu đăng nhập thành công với Manager
        else if (manager != null) {
            loggedInManager = manager;
            managerMenu();
        }

        else {
            System.out.println("Đăng nhập thất bại. Tên đăng nhập hoặc mật khẩu không đúng.");
        }
    }

    private static void addUser() {
        scanner.nextLine();
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        User user = new User(id, name, address, phoneNumber, username, password);
        userManager.addUser(user);
        System.out.println("Đăng ký người dùng thành công.");
    }

    private static void addManager() {
        scanner.nextLine();
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        Manager manager = new Manager(id, name, address, phoneNumber, username, password);
        userManager.addManager(manager);
        System.out.println("Đăng ký quản lý thành công.");
    }

    private static void deleteUser() {
        scanner.nextLine();
        System.out.print("Nhập ID người dùng cần xóa: ");
        String userId = scanner.nextLine();
        userManager.deleteUser(userId);
    }

    private static void updateUser() {
        scanner.nextLine();
        System.out.print("Nhập ID người dùng cần sửa: ");
        String userId = scanner.nextLine();
        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ mới: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập username mới: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password mới: ");
        String password = scanner.nextLine();

        User updatedUser = new User(userId, name, address, phoneNumber, username, password);
        userManager.updateUser(userId, updatedUser);
    }

    private static void searchUserByName() {
        scanner.nextLine();
        System.out.print("Nhập tên người dùng cần tìm: ");
        String name = scanner.nextLine();
        userManager.viewUsersByName(name);
    }

    private static void viewPurchasedProducts() {
        List<Product> purchasedProducts = loggedInUser.getPurchaseHistory();
        if (purchasedProducts.isEmpty()) {
            System.out.println("Chưa mua sản phẩm nào.");
        } else {
            for (Product product : purchasedProducts) {
                product.displayProduct();
            }
        }
    }
}
