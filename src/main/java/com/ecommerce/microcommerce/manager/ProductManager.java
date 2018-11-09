package com.ecommerce.microcommerce.manager;

import com.ecommerce.microcommerce.model.Product;

import java.util.Map;

/**
 * Contract to manage {@link Product}
 */
public interface ProductManager {

    /**
     * Calcul et retourne la marge effectué par produit.
     *
     * @return un map de produit/marge
     */
    Map<Product, Integer> getMargeParProduit();
}
