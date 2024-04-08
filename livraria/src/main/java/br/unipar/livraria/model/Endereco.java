/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.model;

/**
 *
 * @author maico
 */
public class Endereco {
    private String cidade;
    private String rua;
    private String bairro;
    private String estado;
    private String pais;
    private int num;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return  "\nCidade: " + cidade + "\n" + "Rua: " + rua + "\n" + "Bairro: " + bairro + "\n" +
                "Numero da casa: " + num + "\n" + "Estado: " + estado + "\n" + "Pais: " + pais;
    }
    
}
