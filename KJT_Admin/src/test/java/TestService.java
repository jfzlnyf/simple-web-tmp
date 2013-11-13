import com.snda.sysdev.gplusshop.web.model.Message;
import com.snda.sysdev.gplusshop.web.service.RestaurantService;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: nieyunfei
 * Date: 13-7-11
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public class TestService {


    @Test
    public void testName() throws Exception {
        System.out.println(new RestaurantService().getRestaurantList("ETLbewAAAUJM9L2GABRBRVMvQ0JDL1BLQ1M1UGFkZGluZwCAABAAEOLRArtpATDTLbaz6EKnhM4AAAAwksI/5mH5VeoYbFqvbOizcTCLHsaMJOVavlVYdaFlcbSuzQzTEFPq5thAmxqCbTkmABSTZnpCcnbskcX3WDwEubyPD7vlxA=="));
    }

}
