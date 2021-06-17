package testall.tradedata.model;

import java.util.Objects;

public class Longform {

    private String contractNumber;
    private String tradeId;

    public Longform(String contractNumber, String tradeId) {
        this.contractNumber = contractNumber;
        this.tradeId = tradeId;
    }

    public Longform(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Longform longform = (Longform) o;
        return Objects.equals(contractNumber, longform.contractNumber) && Objects.equals(tradeId, longform.tradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractNumber, tradeId);
    }

    @Override
    public String toString() {
        return "Longform{" +
                "contractNumber='" + contractNumber + '\'' +
                ", tradeId='" + tradeId + '\'' +
                '}';
    }
}
