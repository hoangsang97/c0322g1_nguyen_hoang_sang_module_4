package vn.codegym.dto;

public class TotalMoneyDto {
    private int quantity;
    private double costContractDetail;

    public TotalMoneyDto() {
    }

    public TotalMoneyDto(int quantity, double costContractDetail) {
        this.quantity = quantity;
        this.costContractDetail = costContractDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCostContractDetail() {
        return costContractDetail;
    }

    public void setCostContractDetail(double costContractDetail) {
        this.costContractDetail = costContractDetail;
    }
}
