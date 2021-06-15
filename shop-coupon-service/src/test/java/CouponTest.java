import com.ling.shop.CouponServiceApplication;
import com.ling.shop.mapper.TradeCouponMapper;
import com.ling.shop.pojo.TradeCoupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangling 2021/6/15 11:47
 */
@SpringBootTest(classes = CouponServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CouponTest {
    @Autowired
    TradeCouponMapper tradeCouponMapper;

    @Test
    public void test01() {
        TradeCoupon tradeCoupon = tradeCouponMapper.selectByPrimaryKey(1L);
        System.out.println("tradeCoupon = " + tradeCoupon);
    }
}
