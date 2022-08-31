package com.xxx.mapper;

import com.xxx.pojo.Goods;

import java.util.List;


public interface GoodsMapper {
    // 添加两个商品
    void add(Goods goods);

    // 修改商品
    int update(Goods goods);

    // 查询所有
    List<Goods> selectAll();

    // 通过 服装 查询
    List<Goods> selectByClassify(Goods goods);

}
