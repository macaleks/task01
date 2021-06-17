package testall.tradedata.model;

import java.util.Objects;

public class MaTradeData {

    private String contractNumber;
    private String sourceSystem;

    public MaTradeData(String contractNumber, String sourceSystem) {
        this.contractNumber = contractNumber;
        this.sourceSystem = sourceSystem;
    }

    public MaTradeData() {
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public static MaTradeData builder() {
        return new MaTradeData();
    }

    public MaTradeData withContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
        return this;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public MaTradeData withSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    public MaTradeData build() {
        return new MaTradeData(contractNumber, sourceSystem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaTradeData that = (MaTradeData) o;
        return Objects.equals(contractNumber, that.contractNumber) && Objects.equals(sourceSystem, that.sourceSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractNumber, sourceSystem);
    }

    @Override
    public String toString() {
        return "MaTradeData{" +
                "contractNumber='" + contractNumber + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                '}';
    }
}
