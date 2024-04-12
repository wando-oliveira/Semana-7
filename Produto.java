package br.com.alura.farmacia.modelo;

import javax.persistence.*;

@Entity
@Table(name="produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    @ManyToOne(fetch = FetchType.LAZY)
    private Fabricante fabricante;
    private boolean ativo;

    public Produto() {
    }

    public Produto(String nome, String descricao, double preco, Fabricante fabricante) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
