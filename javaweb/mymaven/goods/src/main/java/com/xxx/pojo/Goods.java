package com.xxx.pojo;

public class Goods {
    private Integer id;
    private String goodsImg;
    private Double goodsPrice;
    private String description;
    private String classify;

    public Goods() {
    }

    public Goods(Integer id, String goodsImg, Double goodsPrice, String description, String classify) {
        this.id = id;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.description = description;
        this.classify = classify;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", description='" + description + '\'' +
                ", classify='" + classify + '\'' +
                '}';
    }
}
