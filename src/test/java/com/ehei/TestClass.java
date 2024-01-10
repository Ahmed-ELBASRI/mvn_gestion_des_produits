package com.ehei;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class TestClass extends TestCase {
	private ProduitService produitService;

    @Before
    public void initialisation() {
        produitService = new ProduitService();
    }

    @Test
    public void testAjouterProduit() {
        Produit p1 = new Produit(1L, "Car", 20.0, 10);
        produitService.ajouterProduit(p1);
        assertEquals(1, produitService.getAllProduct().size());
    }
    
    @Test
    public void testAjouterProduitUnicite() {
        Produit p1 = new Produit(1L, "Car", 20.0, 10);
        Produit p2 = new Produit(1L, "Bike", 15.0, 8);
        produitService.ajouterProduit(p1);
        try {
            produitService.ajouterProduit(p2);
        } catch (IllegalArgumentException e) {
            assertEquals("the product that you are trying to add already exists", e.getMessage());
        }
    }
    
    @Test
    public void testAjouterProduitValidation() {
        Produit p1 = new Produit(1L, "Car", -20.0, 10);
        try {
            produitService.ajouterProduit(p1);
        } catch (IllegalArgumentException e) {
            assertEquals("price and quantity needs to be positive", e.getMessage());
        }
    }
}
