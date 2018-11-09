package com.ecommerce.microcommerce.manager;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductManagerImpl implements ProductManager {

    private final ProductDao productDao;

    public ProductManagerImpl(@Autowired ProductDao dao) {
        this.productDao = dao;
    }

    /**
     * Calcul et retourne la marge effectué par produit.
     *
     * @return un map de produit/marge
     */
    @Override
    public Map<Product, Integer> getMargeParProduit() {
        Map<Product, Integer> result = new LinkedHashMap<>();
        List<Product> products = productDao.findAll(new Sort(Sort.Direction.ASC, "id"));
        products.forEach(prd -> result.put(prd, prd.getPrix() - prd.getPrixAchat()));
        return result;
    }
}
