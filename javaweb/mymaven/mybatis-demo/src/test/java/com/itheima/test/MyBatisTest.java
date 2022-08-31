package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws Exception {
        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4.
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        // 5.
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception {

        int id = 1;
        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws Exception {
//        接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

//        处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//        封装对象
//        Brand brand = new Brand();
//        brand.setStatus(1);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);


        Map map = new HashMap();
        map.put("status", status);
//        map.put("companyName", companyName);
//        map.put("brandName", brandName);


        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        // 散装参数
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        //对象参数
//        List<Brand> brands = brandMapper.selectByCondition(brand);

        // Map
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }


//    添加数据

    @Test
    public void testAdd() throws Exception {
//        接受参数
        String brandName = "美的空调";
        String companyName = "美的电器有限公司";
        int ordered = 100;
        String description = "好空调，美的造";
        int status = 1;


//        封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);


        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.add(brand);
        // 提交事务(也可以给sqlSession对象设置true)
//        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }


//    修改
    @Test
    public void testUpdate() throws Exception {
//        接受参数
        String brandName = "美的变频空调";
        String companyName = "美的电器有限公司";
        int ordered = 3000;
        String description = "一晚低至一度电";
        int status = 0;
        int id = 6;


//        封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);
        brand.setId(id);


        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.update(brand);
        // 提交事务(也可以给sqlSession对象设置true)
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }



    //    删除
    @Test
    public void testDeleteById() throws Exception {
//        接收参数

        int id = 6;





        //  1. 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.deleteById(id);
        // 提交事务(也可以给sqlSession对象设置true)
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }
}
