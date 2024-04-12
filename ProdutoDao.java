package br.com.alura.farmacia.dao;

import br.com.alura.farmacia.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrarProduto(Produto produto){
        this.em.persist(produto);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public void atualizarDescricao(Produto produto){
        Produto p = this.em.find(Produto.class, 1);
        p.setDescricao("Descricao do produto atualizada pela JPA");
    }

    public void deletarProduto(){
        Produto p = this.em.find(Produto.class, 6);
        em.remove(p);
    }

}
