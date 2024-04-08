/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.model;

/**
 *
 * @author maico
 */
public class Cliente {
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    
    public void atualizarDados(Endereco novoEndereco) {
        this.endereco = novoEndereco;
    }
   
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "CLIENTE\n" + "Nome Completo: " + nomeCompleto + "\n" + "CPF: " + cpf + "\n" +
                "Telefone: " + telefone + "\n" +"\n"+"ENDEREÇO" + endereco;
    }
    
  }
   