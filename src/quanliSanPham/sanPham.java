package Tutorials.Proj;

class MatHang{
    protected int maHang;
    protected String tenHang;
    protected String hangSX;
    protected String ngaySX;
    protected String ngayNhapKho;
    protected String tenNV;
    protected int giaHang;
    protected double chieuDai;
    protected double chieuRong;
    protected double chieuCao;
    private int maGiamGia;

    public MatHang(){
        maHang = 0;
        tenHang = "";
        hangSX = "";
        ngaySX = "";
        ngayNhapKho = "";
        tenNV = "";
        giaHang = 0;
        chieuDai = 0;
        chieuRong = 0;
        chieuCao = 0;
    }

    public MatHang(int maHang, String tenHang, String hangSX, String ngaySX, 
                   String ngayNK, String nhanVienPT, int gia, double dai, double rong, double cao){
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.hangSX = hangSX;
        this.ngaySX = ngaySX;
        this.ngayNhapKho = ngayNK;
        this.tenNV = nhanVienPT;
        this.giaHang = gia;
        chieuDai = dai;
        chieuRong = rong;
        chieuCao = cao;
    }

    protected void themMaGiamGia(int phanTram){
        if (maGiamGia != 0){
            System.out.println("Ma giam gia da ton tai trong san pham!");
            return;
        }
        if (phanTram < 5 || phanTram > 95){
            System.out.println("Phan tram qua lon hay qua nho!");
            return;
        }
        maGiamGia = phanTram;
        giaHang = giaHang * (100 - phanTram) / 100;
    }

    protected void khoiPhucMaGiamGia(){
        giaHang = giaHang * 100 / (100 - maGiamGia);
        maGiamGia = 0;
    }

    public void setMatHang(){
    
    }

    public void NhapMatHang(){
        
    }

    public void XuatMatHang(){
        System.out.println("--------------------");
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang hoa: " + tenHang);
        System.out.println("Hang san xuat: " + hangSX);
        System.out.println("Ngay san xuat: " + ngaySX);
        System.out.println("Ngay nhap kho: " + ngayNhapKho);
        System.out.println("Ten nhan vien phu trach nhap kho: " + tenNV);
        System.out.println("Gia mat hang: " + giaHang);
        if (maGiamGia > 0){
            System.out.println("Ma giam gia: " + maGiamGia);
        }
        
    }

}


class Loa extends MatHang{

    private int congSuat; // 75 W
    private String tenCongSac; // Type-C
    private int khoangCachToiDa; // 10 met
    private boolean hoTroBluetooth; // Co, khong
    private String nguon; // Pin, cam dien


    public Loa(){
        super();
    }

    public Loa(int maHang, String tenHang, String hangSX, String ngaySX, 
    String ngayNK, String nhanVienPT, int gia, double dai, double rong, double cao){
        super(maHang, tenHang, hangSX, ngaySX, ngayNK, nhanVienPT, gia, dai, rong, cao);

    }

    public void NhapMatHang(){
        
    }

    public void XuatMatHang(){
        super.XuatMatHang();
    }

    
}

class ManHinh extends MatHang{

    private float kichThuocMH; // 21.3"
    private int[] doPhanGiai = new int[2]; // 1920 x 1080
    private String tamNen; // IPS
    private int tanSoQuet; // 100 Hz
    private float soLuongMau; // 16.7 trieu
    private boolean coCamUng; // Co, khong

    public void NhapMatHang(){

    }

    public void XuatMatHang(){
        super.XuatMatHang();
    }
}


public class sanPham{
    public static void main(String[] args){
        // MatHang t = new MatHang(123, "Man hinh 4K", "LG",
        //  "10/10/2001", "12/12/2001", "Nguyen Van A", 400);
        // t.XuatMatHang();
        // t.themMaGiamGia(50);
        // t.XuatMatHang();
        
         
    }
}

