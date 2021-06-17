package testall.tradedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import testall.tradedata.model.MaTradeRequest;
import testall.tradedata.service.MaLongformService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        MaLongformService service = context.getBean(MaLongformService.class);

        List<MaTradeRequest> requests = new ArrayList<>();
        requests.add(new MaTradeRequest("111111"));
        requests.add(new MaTradeRequest("333333"));
        requests.add(new MaTradeRequest("555555"));

        System.out.println(service.resolveTradeDataByRequest(requests));
    }
}
