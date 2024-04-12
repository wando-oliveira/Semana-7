package br.com.alura.farmacia.dao;

import br.com.alura.farmacia.modelo.Fabricante;

import javax.persistence.EntityManager;

public class FabricanteDao {
    private EntityManager em;

    public FabricanteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrarFabricante(Fabricante fabricante){
        this.em.persist(fabricante);
    }
}
