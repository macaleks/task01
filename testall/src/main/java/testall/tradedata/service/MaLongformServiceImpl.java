package testall.tradedata.service;

import org.apache.commons.lang3.tuple.Pair;
import testall.tradedata.dao.MaTradeDataDao;
import testall.tradedata.model.Longform;
import testall.tradedata.model.MaTradeData;
import testall.tradedata.model.MaTradeRequest;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaLongformServiceImpl implements MaLongformService {

    private final MaTradeDataDao dao;

    public MaLongformServiceImpl(MaTradeDataDao dao) {
        this.dao = dao;
    }

    @Override
    public Map<MaTradeRequest, MaTradeData> resolveTradeDataByRequest(Collection<MaTradeRequest> requests) {

        List<Longform> list = dao.getAllLongform();
        Map<String, Longform> map = list.stream()
                .collect(Collectors.toMap(
                        Longform::getTradeId,
                        Function.identity()
                ));

        Function<Longform, MaTradeData> toTradeData = longform ->
                MaTradeData.builder()
                        .withContractNumber(longform.getContractNumber())
                        .withSourceSystem(longform.getTradeId()).build();

        return requests.stream()
                .map(r -> Pair.of(r,toTradeData.apply(map.get(r.getTradeId()))))
                .collect(Collectors.toMap(
                        Pair::getLeft,
                        Pair::getRight
                ));
    }
}
