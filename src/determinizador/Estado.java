/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinizador;

import java.util.ArrayList;

/**
 *
 * @author Tayrone
 */
public class Estado {
    private String nome;
    private ArrayList<String> movimentos;

    public Estado(String nome) {
        this.nome = nome;
        movimentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(ArrayList<String> movimentos) {
        this.movimentos = movimentos;
    }
}
