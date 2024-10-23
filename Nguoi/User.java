package Nguoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Nguoi implements Purchasable {
    private String username;
    private String password;
    private List<Product> purchaseHistory;
    public static int totalUsers = 0;

    public User(String id, String name, String address, String phoneNumber, String username, String password) {
        super(id, name, address, phoneNumber);
        this.username = username;
        this.password = password;
        this.purchaseHistory = new ArrayList<>();

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.purchaseHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public List<Product> getPurchaseHistory() {
        return purchaseHistory;
    }

    @Override
    public void addPurchase(Product product) {
        purchaseHistory.add(product);
        // FileHandler.savePurchaseHistory(List.of(product)); // Lưu thông tin sản phẩm
        // đã mua vào file
    }

    @Override
    public void viewPurchaseHistory() {
        System.out.println("Lịch sử mua hàng của " + username + ":");
        if (purchaseHistory.isEmpty()) {
            System.out.println("Không có lịch sử mua hàng.");
        } else {
            for (Product product : purchaseHistory) {
                System.out.printf("- %s (Số lượng: %d)\n", product.getProductName(), product.getQuantity());
            }
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Username: " + username);
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    @Override
    public void performAction() {
        System.out.println(username + " is performing an action.");
    }

    // hiển thị sản phẩn lấy từ file
    // public void displayProductList() {
    // List<Product> productList = FileHandler.readProducts(); // Đọc danh sách sản
    // phẩm từ file
    // if (productList.isEmpty()) {
    // System.out.println("Danh sách sản phẩm rỗng.");
    // return;
    // }
    // System.out.println("Danh sách sản phẩm:");
    // for (Product product : productList) {
    // System.out.printf("ID: %s - Tên: %s - Giá: %.2f - Số lượng: %d\n",
    // product.getProductId(), product.getProductName(), product.getPrice(),
    // product.getQuantity());
    // }
    // }

}