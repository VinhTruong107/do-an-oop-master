package     quanlinguoi.Nguoi; // Định nghĩa package là Nguoi

import java.util.ArrayList; // Nhập khẩu lớp ArrayList từ thư viện java.util
import java.util.List;
import java.util.Scanner;

// Lớp Manager kế thừa từ lớp User và triển khai giao diện InfoDisplayable
public class Manager extends User implements InfoDisplayable {
    
    // Constructor với tất cả các thông tin chi tiết
    public Manager(String id, String name, String address, String phoneNumber, String username, String password) {
        super(id, name, address, phoneNumber, username, password); // Gọi constructor của lớp cha User
    }


        // Phương thức xem danh sách sản phẩm
    public void viewProducts(List<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
    
        System.out.println("Danh sách sản phẩm:");
        for (Product product : productList) {
            System.out.println("ID: " + product.getProductId() +
                               " - Tên: " + product.getProductName() +
                               " - Giá: " + product.getPrice() +
                               " - Số lượng: " + product.getQuantity());
        }
    }

    // Phương thức thêm sản phẩm
    public void addProduct(Scanner scanner, List<Product> productList) {
        System.out.print("Nhập ID sản phẩm: ");
        String productId = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Tiêu thụ ký tự xuống dòng

        productList.add(new Product(productId, productName, price, quantity));
        System.out.println("Đã thêm sản phẩm thành công.");
    }

    // Phương thức xóa sản phẩm
    public void removeProduct(Scanner scanner, List<Product> productList) {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String productId = scanner.nextLine();

        if (productList.removeIf(product -> product.getProductId().equals(productId))) {
            System.out.println("Đã xóa sản phẩm thành công.");
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

 /*   public void viewPurchasedUsers(ArrayList<User> userList) {
        System.out.println("Danh sách người dùng đã mua hàng:");
        
        for (User user : userList) {
            // Hiển thị thông tin người dùng
            user.displayInfo(); // Bạn có thể sử dụng phương thức này để hiển thị thông tin người dùng
            user.viewPurchaseHistory(); // Hiển thị lịch sử mua hàng của người dùng
            System.out.println(); // Thêm dòng trống giữa các người dùng
        }
    } */
    public void addUser(Scanner scanner, ArrayList<User> userList) {
        System.out.print("Nhập ID người dùng: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên người dùng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ người dùng: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại người dùng: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
    
        User newUser = new User(id, name, address, phoneNumber, username, password); // Tạo người dùng mới
        userList.add(newUser); // Thêm vào danh sách
        System.out.println("Đã thêm người dùng thành công.");
    }
    
    public void updateUser(Scanner scanner, ArrayList<User> userList) {
        System.out.print("Nhập tên người dùng cần sửa: ");
        String username = scanner.nextLine();
    
        User foundUser = null;
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                foundUser = user;
                break;
            }
        }
    
        if (foundUser != null) {
            System.out.print("Nhập tên mới (hoặc giữ nguyên nếu không thay đổi): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                foundUser.setName(newName);
            }
            System.out.print("Nhập địa chỉ mới (hoặc giữ nguyên nếu không thay đổi): ");
            String newAddress = scanner.nextLine();
            if (!newAddress.isEmpty()) {
                foundUser.setAddress(newAddress);
            }
            System.out.print("Nhập số điện thoại mới (hoặc giữ nguyên nếu không thay đổi): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.isEmpty()) {
                foundUser.setPhoneNumber(newPhone);
            }
            System.out.println("Đã cập nhật thông tin người dùng thành công.");
        } else {
            System.out.println("Không tìm thấy người dùng với tên " + username);
        }
    }
    
    public void removeUser(Scanner scanner, ArrayList<User> userList) {
        System.out.print("Nhập tên người dùng cần xóa: ");
        String username = scanner.nextLine();
    
        if (userList.removeIf(user -> user.getUsername().equals(username))) {
            System.out.println("Đã xóa người dùng thành công.");
        } else {
            System.out.println("Không tìm thấy người dùng với tên " + username);
        }
    }

    
    
    

    // Phương thức thực hiện hành động quản lý người dùng
    @Override
    public void performAction() {
        System.out.println(getUsername() + " đang quản lý người dùng."); // Hiển thị thông báo người quản lý đang thực hiện hành động
    }
}
