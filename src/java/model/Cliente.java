/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author negro
 */
public class Cliente {

    private int codContato;
    private String nome;
    private String sexo;
    private String cidade;
    private String data;

    public Cliente(String nome, String sexo, String cidade, String data) {
        this.nome = nome;
        this.sexo = sexo;
        this.cidade = cidade;
        this.data = data;
    }

    public Cliente() {
    }

    public int getCodContato() {
        return codContato;
    }

    public void setCodContato(int codContato) {
        this.codContato = codContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
private Boolean temCidade(ArrayList<String> cidades){
    
     for (String cidade : cidades){
            if(this.cidade.equals(cidade)){
            return true;}
        }
return false;

}
    private ArrayList separaCEP(ArrayList<Cliente> clientes) {
        ArrayList<String> cidades = new ArrayList<String>();
        for (Cliente cliente : clientes){
          if(cliente.temCidade(cidades)){
              cidades.add(cliente.cidade);
          }  
        }
        return cidades;

    }

    public static String analiseGeral(ArrayList clientes) {
        String resultado = "";
        resultado += clientes.size() + " clientes cadastados ";
        resultado += "</br>(" + contMasc(clientes) + ") masculinos";
        resultado += "(" + contFem(clientes) + ") femininos";

        return resultado;
    }

    public static String analiseCEP(ArrayList clientes) {
        ArrayList cidade = new ArrayList<String>();
        String resultado = "";
        resultado += clientes.size() + " clientes cadastados ";
        resultado += "</br>(" + contMasc(clientes) + ") masculinos";
        resultado += "(" + contFem(clientes) + ") femininos";

        return resultado;
    }

    private static int contMasc(ArrayList<Cliente> clientes) {
        int totalMasc = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getSexo().equals("Masculino")) {
                totalMasc++;
            };
        }
        return totalMasc;
    }

    private static int contFem(ArrayList<Cliente> clientes) {
        int totalFem = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getSexo().equals("Feminino")) {
                totalFem++;
            };
        }
        return totalFem;
    }
}
