import cn.szu.ming.entity.Record;
import cn.szu.ming.util.JsonUtil;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class redisTest {
    @Test
    public void testRedis() throws IOException {
        Timestamp timestamp=new Timestamp(11111);
        Record record=new Record(1,"123","456",timestamp,"789");
        String recordJson=JsonUtil.serializer(record);
        Record record1= (Record) JsonUtil.deserializer(recordJson,Record.class);
        assertEquals (record,record1);
    }
}

