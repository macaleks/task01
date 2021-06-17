package testall.tradedata.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import testall.tradedata.model.Longform;

import java.util.ArrayList;
import java.util.List;

public class MaTradeDataDaoImpl implements MaTradeDataDao {

    private final JdbcTemplate jdbcTemplate;

    public MaTradeDataDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Longform> getAllLongform() {
        String sql = "select * from ma_longform";
//        return jdbcTemplate.query(sql, mapper);
        List<Longform> list = new ArrayList<>();
        list.add(new Longform("1", "111111"));
        list.add(new Longform("2", "222222"));
        list.add(new Longform("3", "333333"));
        list.add(new Longform("4", "444444"));
        list.add(new Longform("5", "555555"));
        list.add(new Longform("6", "666666"));
        list.add(new Longform("7", "777777"));
        list.add(new Longform("8", "888888"));
        return list;
    }

    private final RowMapper<Longform> mapper = (rs, i) -> {
        String contractNumber = rs.getString("CONTRACTNUMBER");
        String tradeId = rs.getString("TRADEID");
        return new Longform(contractNumber, tradeId);
    };
}
