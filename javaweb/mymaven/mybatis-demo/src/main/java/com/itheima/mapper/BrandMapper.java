package com.itheima.mapper;

import com.itheima.pojo.Brand;


import java.util.List;
import java.util.Map;

public interface BrandMapper {
    // 查询所有
    List<Brand> selectAll();


    // 通过id查询
    Brand selectById(int id);

//    多条件查询

//    散装参数
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    对象参数
//    List<Brand> selectByCondition(Brand brand);

//    Map 参数
    List<Brand> selectByCondition(Map map);






//    添加

    void add(Brand brand);



//    修改
    void update(Brand brand);


//    删除
    void deleteById(int id);
}

