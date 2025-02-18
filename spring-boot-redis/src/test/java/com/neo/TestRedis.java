package com.neo;

import com.neo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
    
    @Test
    public void testObj() throws Exception {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("com.neo.x", user);

        System.out.println(operations.get("com.neo.x"));
        operations.set("com.neo.f", user,10, TimeUnit.SECONDS); //设置key-value过期时间
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
        	System.out.println("exists is true");
        }else{
        	System.out.println("exists is false");
        }
       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
    @Test
    public void testList() throws Exception {
//        String userStr=new User("aa@126.com", "aa", "aa123456", "aa","123").toString();
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");

        ListOperations<String, User> operations=redisTemplate.opsForList();
        operations.leftPush("com.neo.x", user);
        operations.leftPush("com.neo.x", user);
        List<String> list = redisTemplate.opsForList().range("com.neo.x", 0, 2);

        System.out.println(list);

        System.out.println(operations.rightPop("com.neo.x"));
    }
}