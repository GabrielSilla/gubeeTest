package com.gubee.gubee.repository.product;

import com.gubee.gubee.model.dto.product.ProductFilterDTO;
import com.gubee.gubee.model.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

import static com.gubee.gubee.util.FunctionUtils.isNullOrEmpty;

@Repository
public class ProductCustomRepository {
    private EntityManager em;

    @Autowired
    public ProductCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Product> listProduct(String name, String  description, List<Integer> stack, List<Integer> targetMarket) {
        StringBuilder query = new StringBuilder("select p.* from product p\n" +
                "left join product_stack ps on p.id = ps.product_id \n" +
                "left join product_target_market ptm on p.id = ptm.product_id \n" +
                "left join stack s on ps.stack_id = s.id\n" +
                "left join target_market tm on ptm.target_market_id = tm.id\n" +
                "WHERE 0 = 0 \n");

        if(!isNullOrEmpty(name))
            query.append("AND (p.name like CONCAT('%" + name + "%'))\n");

        if(!isNullOrEmpty(description))
            query.append("AND (p.description like CONCAT('%" + description + "%'))\n");

        if(!isNullOrEmpty(stack)) {
            String joinedIds = stack.stream().map(s -> s.toString())
                    .collect(Collectors.joining(","));

            query.append("AND (s.id in (").append(joinedIds).append("))\n");
        }

        if(!isNullOrEmpty(targetMarket)) {
            String joinedIds = targetMarket.stream().map(tm -> tm.toString())
                    .collect(Collectors.joining(","));

            query.append("AND (tm.id in (").append(joinedIds).append("))\n");
        }

        query.append(" group by p.id");

        Query createdQuery = em.createNativeQuery(query.toString(), Product.class);
        List<Product> productList = createdQuery.getResultList();

        return productList;
    }
}