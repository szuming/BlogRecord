package cn.szu.ming.service.redis;

import cn.szu.ming.entity.Record;
import cn.szu.ming.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {
    @Autowired
    JedisPool jedisPool=new JedisPool();
    Jedis jedis=jedisPool.getResource();
    private static Logger logger = Logger.getLogger(ListService.class.getName());

    ListService(){}
    //从连接池里获取redis，供redisAspect调用
    public void getJedisFromPool(){
        jedis=jedisPool.getResource();
    }

    //关闭redis，供redisAspect调用
    public void closeJedis(){
        if(jedis!=null){
            jedis.close();
            jedis=null;
        }
    }

    /**
     * 将record插入key列表
     * @param key      列表键
     * @param record    要插入的记录
     */
    public void rightAddRecord(String key,Record record) throws IOException {
        //将record序列化再存储
        jedis.rpush(key,JsonUtil.serializer(record));
    }

    /**
     * 得到record的list
     * @param key
     * @return
     */
    public List<Record> getRecordList(String key) throws IOException {
        //得到序列化的链表
        List<String> recordList=jedis.lrange(key,0,-1);
        //一个个反序列化为Record加入到result中
        List<Record> result=new ArrayList<>();
        for(String temp:recordList){
            result.add((Record) JsonUtil.deserializer(temp,Record.class));
        }
        if(result.isEmpty())return null;
        return result;
    }


    /**
     * 将新的链表更新到redis中
     * @param key
     * @param list
     */
    public void addList(String key,List<Record> list) throws IOException {
        for(Record record:list){
            rightAddRecord(key,record);
        }
    }

    /**
     * 最新插入的record，直接在list的左边插入
     * @param key
     * @param record
     */
    public void leftAddRecord(String key,Record record) throws IOException {
        //将record序列化再存储
        jedis.lpush(key,JsonUtil.serializer(record));
    }


}
