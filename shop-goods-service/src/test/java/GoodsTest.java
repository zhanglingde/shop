import com.ling.shop.GoodsServiceApplication;
import com.ling.shop.mapper.TradeGoodsMapper;
import com.ling.shop.pojo.TradeGoods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangling 2021/6/15 11:35
 */
@SpringBootTest(classes = GoodsServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsTest {

    @Autowired
    TradeGoodsMapper tradeGoodsMapper;

    @Test
    public void test01() {
        TradeGoods tradeGoods = tradeGoodsMapper.selectByPrimaryKey(345959443973935104L);
        System.out.println(tradeGoods);
    }
}
