package quanliSanPham.sanpham.LinkKienMayTinh;

import quanliSanPham.Product;

public class Main implements Product {
  private final String GuaranteePeriod = "36 months";
  private String mainModel;
  private String mainSocket;
  private String mainChipset;
  private Integer mainPrice;

  // constructor
  public Main() {
    this.mainModel = null;
    this.mainSocket = null;
    this.mainChipset = null;
    this.mainPrice = null;
  }

  @Override
  public Integer getPrice() {
    return this.mainPrice;
  }

  @Override
  public String getProductModel() {
    return this.mainModel;
  }

  @Override
  public String getGuaranteePeriod() {
    return this.GuaranteePeriod;
  }

  @Override
  public void displaySpecs() {
    System.out.format("%-20s %-5s %-5s %-10s ,",
        this.mainModel, this.mainSocket, this.mainChipset, this.mainPrice);
  }

  public String getMainSocket() {
    return this.mainSocket;
  }

  public String getMainChipset() {
    return this.mainChipset;
  }
}
