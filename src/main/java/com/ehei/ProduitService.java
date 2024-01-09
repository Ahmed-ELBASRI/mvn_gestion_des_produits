package com.ehei;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }
    public void ajouterProduit(Produit produit) {
        for (Produit existingProduit : produits) {
            if (existingProduit.getId().equals(produit.getId()) || existingProduit.getNom().equals(produit.getNom())) {
                throw new IllegalArgumentException("the product that you are trying to add already exists");
            }
        }

        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("price and quantity needs to be positive");
        }

        produits.add(produit);
    }
    
}
