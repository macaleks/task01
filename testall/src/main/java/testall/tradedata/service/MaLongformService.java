package testall.tradedata.service;

import testall.tradedata.model.MaTradeData;
import testall.tradedata.model.MaTradeRequest;

import java.util.Collection;
import java.util.Map;

public interface MaLongformService {

    Map<MaTradeRequest, MaTradeData> resolveTradeDataByRequest(Collection<MaTradeRequest> requests);
}
