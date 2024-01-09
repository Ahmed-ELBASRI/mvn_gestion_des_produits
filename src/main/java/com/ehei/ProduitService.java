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
    public Produit findProduit(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        return null;
    }
    public List<Produit> getAllProduct() {
        return new ArrayList<>(produits);
    }
    public void mettreAjourProduit(Produit produitUpdate) {
        Produit produitExist = findProduit(produitUpdate.getId());
        if (produitExist == null) {
            throw new IllegalArgumentException("product doesn't existe");
        }

        if (produitUpdate.getPrix() < 0 || produitUpdate.getQuantite() < 0) {
            throw new IllegalArgumentException("price and quantity needs to be positive");
        }

        produitExist.setNom(produitUpdate.getNom());
        produitExist.setPrix(produitUpdate.getPrix());
        produitExist.setQuantite(produitUpdate.getQuantite());
    }
    public void deleteProduit(Long id) {
    	Produit produitToRemove=null;
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
            	produitToRemove=produit;
                break;
            }
        }
        produits.remove(produitToRemove); 

    }
}
