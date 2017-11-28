package com.dxfjyygy.redis;

import com.dxfjyygy.entity.Dept;
import com.dxfjyygy.entity.Role;
import com.dxfjyygy.entity.User;
import com.dxfjyygy.repository.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by longjinwen on 28/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTest {
    @Autowired
    private  UserRedis userRedis ;
    @Before
    public void setup(){
        Dept dept = new Dept();
        dept.setName("开发部2");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setCreateDate(new Date());
        user.setAge(22);
        user.setUserName("longjinwen2");
        user.setDept(dept);
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        user.setRoles(roles);

        userRedis.add(this.getClass().getName()+":userByname:"+user.getUserName(),10L,user);
    }
    @Test
    public void get(){
        User user = userRedis.get(this.getClass().getName()+":userByname:user");
    }
}
