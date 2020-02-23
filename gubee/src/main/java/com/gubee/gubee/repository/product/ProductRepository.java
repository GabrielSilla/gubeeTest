package com.gubee.gubee.repository.product;

import com.gubee.gubee.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p.* from product p\n" +
            "left join product_stack ps on p.id = ps.product_id\n" +
            "left join product_target_market ptm on p.id = ptm.product_id\n" +
            "left join stack s on ps.stack_id = s.id\n" +
            "left join target_market tm on ptm.target_market_id = tm.id\n" +
            "WHERE (p.name like CONCAT('%',:name,'%') OR '' = :name)\n" +
            "AND (p.description like CONCAT('%',:description, '%') OR '' = :description)\n" +
            "AND (s.id in (:stackIds) OR :stackIds is null)\n" +
            "AND (tm.id in (:targetMarketIds) OR :targetMarketIds is null)\n" +
            "group by p.id", nativeQuery = true)
    List<Product> findProductsByFilter(String name, String description, List<Integer> stack, List<Integer> targetMarket);
}
