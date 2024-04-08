/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.model;

/**
 *
 * @author maico
 */
public class Livro {
    private String nomeLivro;
    private String editora;
    private String autores;
    private String genero;
    private int anoLancamento;
    private int numeroPag;
    private int qtdEstoque;
    private double precoVenda;

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
    
    

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "Livro\n" + "Nome livro: " + nomeLivro +"\n"+ "Editora: " + editora + "\n"+
                "Autores: " + autores + "\n"+ "Genero: " + genero + "\n" + "Ano de lançamento: " 
                  + anoLancamento +"\n" + "Numero de páginas: " + numeroPag + "\n" +
                "Preço de venda: " + precoVenda + "\n" + "Quantidade em estoque: " + qtdEstoque +"\n";
    }
   
    }
   
