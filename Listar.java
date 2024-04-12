package br.com.alura.farmacia.teste;

import br.com.alura.farmacia.dao.ProdutoDao;
import br.com.alura.farmacia.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Listar {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("farmacia_semana7");
        EntityManager em = factory.createEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p -> System.out.println("Produto: " + p.getNome()));
    }
}
