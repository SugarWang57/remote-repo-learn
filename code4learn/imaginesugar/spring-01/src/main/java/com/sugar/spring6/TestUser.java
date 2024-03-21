package com.sugar.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    // 创建日志对象
    private Logger logger= LoggerFactory.getLogger(TestUser.class);

    //测试user的创建
    @Test
    public void testUserObj(){
        //1. 加载spring配置文件，加载出来得到id和class，来创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2. 创建对象
        User user = (User) context.getBean("user");
        //3. 调用对象方法
        System.out.println(user);
        user.add();
        // 输出日志
        logger.info("====执行调用ing====\n");
    }

    // 这里就是利用反射创建的对象，如下所示
    //利用反射创建对象
    @Test
    public void testRelect() throws Exception {
        // 1. 获得Class对象
        Class clazz = Class.forName("com.sugar.spring6.User");
        // 2. 利用Class对象利用反射创建对象
        User userByRelect = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(userByRelect);
        userByRelect.add();
    }

}
