package br.com.alura.farmacia.teste;

import br.com.alura.farmacia.dao.ProdutoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Deletar {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("farmacia_semana7");
        EntityManager em = factory.createEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        produtoDao.deletarProduto();
        em.getTransaction().commit();
        em.close();
        System.out.println("Removido");
    }
}