package br.com.alura.farmacia.teste;

import br.com.alura.farmacia.dao.FabricanteDao;
import br.com.alura.farmacia.dao.ProdutoDao;
import br.com.alura.farmacia.modelo.Fabricante;
import br.com.alura.farmacia.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("farmacia_semana7");
        EntityManager em = factory.createEntityManager();

        Fabricante fab1 = new Fabricante("Bayer");
        Fabricante fab2 = new Fabricante("Avon");
        Fabricante fab3 = new Fabricante("Pfyzer");

        Produto prod1 = new Produto("Aspirina", "Para dor de cabeça", 25.50, fab1);
        Produto prod2 = new Produto("Chá", "Mel e agrião", 125.00, fab3);
        Produto prod3 = new Produto("Xarope", "Contra tosse e pigarro", 4.75, fab2);
        Produto prod4 = new Produto("Pomada", "Previne assaduras", 37.82, fab2);
        Produto prod5 = new Produto("Desodorante", "Refrescante e anti odor", 9.80, fab3);
        Produto prod6 = new Produto("Paracetamol", "Para gripe e resfriado", 83.25, fab3);

        FabricanteDao fabricanteDao = new FabricanteDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        fabricanteDao.cadastrarFabricante(fab1);
        fabricanteDao.cadastrarFabricante(fab2);
        fabricanteDao.cadastrarFabricante(fab3);
        produtoDao.cadastrarProduto(prod1);
        produtoDao.cadastrarProduto(prod2);
        produtoDao.cadastrarProduto(prod3);
        produtoDao.cadastrarProduto(prod4);
        produtoDao.cadastrarProduto(prod5);
        produtoDao.cadastrarProduto(prod6);
        produtoDao.atualizarDescricao(prod1);
        Produto produto1 = em.find(Produto.class, 1);
        System.out.println("Produto 1 preço = " + produto1.getPreco());
        em.getTransaction().commit();
        em.close();
        System.out.println("Pronto");
    }
}
