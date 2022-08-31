package com.xxx.test;

import com.xxx.mapper.GoodsMapper;
import com.xxx.pojo.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GoodsTest {

    /*
     * 添加
     * */
    @Test
    public void testAdd() throws IOException {
        // 数据
//        String goodsImg = "goodsIMG/1.jpg";
//        Double goodsPrice = 1000.00;
//        String description = "格力空调";
//        String classify = "电器";

//        String goodsImg = "goodsIMG/2.jpg";
//        Double goodsPrice = 2000.00;
//        String description = "大棉袄";
//        String classify = "服装";

        String goodsImg = "goodsIMG/4.jpg";
        Double goodsPrice = 1000.00;
        String description = "裤子";
        String classify = "服装";

        // 封装对象
        Goods goods = new Goods();
        goods.setGoodsImg(goodsImg);
        goods.setGoodsPrice(goodsPrice);
        goods.setDescription(description);
        goods.setClassify(classify);

        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 获取 Mapper 接口的代理对象
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        // 4. 执行方法
        goodsMapper.add(goods);
        // 提交事务(也可以给sqlSession对象设置true)
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }


    /*
     * 修改
     * */
    @Test
    public void testUpdate() throws IOException {
        // 数据
        int id = 4; // 要修改的id
//        String goodsImg = "goodsIMG/1.jpg";
        Double goodsPrice = 2000.00;
//        String description = "格力空调";
//        String classify = "电器";


        // 封装对象

        Goods goods = new Goods();
        goods.setId(4);
//        goods.setGoodsImg(goodsImg);
        goods.setGoodsPrice(goodsPrice);
//        goods.setDescription(description);
//        goods.setClassify(classify);

        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 获取 Mapper 接口的代理对象
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        // 4. 执行方法
        int count = goodsMapper.update(goods);
        System.out.println(count);
        // 提交事务(也可以给sqlSession对象设置true)
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }


    /*
     * 查询所有
     * */

    @Test
    public void testSelectAll() throws IOException {

        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 获取 Mapper 接口的代理对象
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        // 4. 执行方法
        List<Goods> goods = goodsMapper.selectAll();
        System.out.println(goods);


        // 5. 释放资源
        sqlSession.close();

    }

    /*
     * 条件查询
     * */
    @Test
    public void testSelectByClassify() throws IOException {
        // 数据

        String classify = "服装";


        // 封装对象

        Goods goods = new Goods();
        goods.setClassify(classify);

        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 3. 获取 Mapper 接口的代理对象
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        // 4. 执行方法
        List<Goods> g = goodsMapper.selectByClassify(goods);
        System.out.println(g);

        // 5. 释放资源
        sqlSession.close();
    }
}
