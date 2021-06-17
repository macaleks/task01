package testall.tradedata.model;

import java.util.Objects;

public class MaTradeRequest {

    private String tradeId;

    public MaTradeRequest(String tradeId) {
        this.tradeId = tradeId;
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
        MaTradeRequest that = (MaTradeRequest) o;
        return Objects.equals(tradeId, that.tradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId);
    }

    @Override
    public String toString() {
        return "MaTradeRequest{" +
                "tradeId='" + tradeId + '\'' +
                '}';
    }
}
