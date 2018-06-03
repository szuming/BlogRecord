package cn.szu.ming.util;

import cn.szu.ming.service.redis.ListService;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class redisAspect {
    @Autowired
    ListService listService;
    private static Logger logger = Logger.getLogger(redisAspect.class.getName());

    @Before(value = "execution(public * cn.szu.ming.controller.RecordController.*(..))")
    public void getRecordList(){
        listService.getJedisFromPool();
        logger.debug(1);
    }


}
