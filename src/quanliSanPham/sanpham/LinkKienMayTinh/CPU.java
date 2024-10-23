package quanliSanPham.sanpham.LinkKienMayTinh;

import quanliSanPham.Product;

public class CPU implements Product {
  private final String GuaranteePeriod = "36 months";
  private String cpuModel;
  private Integer cpuCores;
  private Double cpuGhz;
  private Integer cpuTdp;
  private Integer cpuPrice;

  // default constructor
  public CPU() {
    this.cpuModel = null;
    this.cpuCores = null;
    this.cpuGhz = null;
    this.cpuTdp = null;
    this.cpuPrice = null;
  }

  // constructor
  public CPU(String cpuModel,int cpuCores,double cpuGhz,
    int cpuTdp,int cpuPrice) {
    this.cpuModel = cpuModel;
    this.cpuCores = cpuCores;
    this.cpuGhz = cpuGhz;
    this.cpuTdp = cpuTdp;
    this.cpuPrice = cpuPrice;
  }

  @Override
  public Integer getPrice() {
    return this.cpuPrice;
  }

  @Override
  public String getProductModel() {
    return this.cpuModel;
  }

  @Override
  public String getGuaranteePeriod() {
    return this.GuaranteePeriod;
  }

  @Override
  public void displaySpecs() {
    System.out.format("%-20s %-5s %-5s %-10s ,",
        this.cpuModel, this.cpuCores, this.cpuGhz, this.cpuTdp);
  }

  public int getCpuCore() {
    return this.cpuCores;
  }

  public double getCpuGhz() {
    return this.cpuGhz;
  }

  public int getCpuTdp() {
    return this.cpuTdp;
  }
}
