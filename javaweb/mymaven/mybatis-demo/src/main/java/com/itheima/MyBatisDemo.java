package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws Exception {
        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 sqlSession 对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行 sql
        List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);

        // 4. 释放资源
        sqlSession.close();

    }
}
