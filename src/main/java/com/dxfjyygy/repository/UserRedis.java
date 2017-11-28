package com.dxfjyygy.repository;

import com.google.gson.Gson;
import com.dxfjyygy.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by longjinwen on 28/11/2017.
 */
@Repository
public class UserRedis {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public void add(String key, Long time, User user){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(user),time, TimeUnit.MINUTES);
    }


    public void add(String key, Long time, List<User> users){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(users),time,TimeUnit.MINUTES);
    }

    public User get(String key){
        Gson gson = new Gson();
        User user = null;
         // get the string according to json string
        String userJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(userJson)){
            user = gson.fromJson(userJson,User.class);
        }
        return user;
    }
    public List<User> getList(String key){
        Gson gson = new Gson();
        return null;
    }
}
