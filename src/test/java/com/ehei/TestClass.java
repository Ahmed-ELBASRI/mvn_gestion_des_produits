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
}
