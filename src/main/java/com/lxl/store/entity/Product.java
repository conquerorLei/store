package com.lxl.store.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

/**
 * @author LiXianLei
 * @since 2022/06/04 20:38
 */
@Data
@ToString
public class Product extends BaseEntity{
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Integer price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(categoryId, product.categoryId) && Objects.equals(itemType, product.itemType) && Objects.equals(title, product.title) && Objects.equals(sellPoint, product.sellPoint) && Objects.equals(price, product.price) && Objects.equals(num, product.num) && Objects.equals(image, product.image) && Objects.equals(status, product.status) && Objects.equals(priority, product.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, categoryId, itemType, title, sellPoint, price, num, image, status, priority);
    }
}
