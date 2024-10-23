package quanliSanPham.sanpham.fileSanPham;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import quanliSanPham.sanpham.ElectronicComponents.CPU;

public class ProductReader {
  private static final String cpuListFile = "cpu_list.csv";

  public static ArrayList<CPU> getCpuList() {
    ArrayList<CPU> cpu = new ArrayList<CPU>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(cpuListFile));
      String line = null;
      while ((line = br.readLine()) != null) {
        String[] Split = line.split(",");
        cpu.add(new CPU(
          Split[0],
          Integer.parseInt(Split[1]),
          Double.parseDouble(Split[2]),
          Integer.parseInt(Split[3]),
          Integer.parseInt(Split[4])
        )); 
      }
      br.close();
    } catch (Exception e) {
      System.out.println("file product error");
    }

    return cpu;
  }
}
