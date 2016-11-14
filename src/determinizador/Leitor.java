/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinizador;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Administrador
 */
public class Leitor {
    private String automato = "- a b c\n" + 
                      ">S= A,S S S\n" +
                      "A= - B -\n" +
                      "B= B,C B B\n" +
                      "C= - D -\n" +
                      "D= D D D,E\n" +
                      "E= E E E\n";
    
    public ArrayList<String> setMovimentoEstado(String linha) {
        ArrayList<String> movimentos = new ArrayList();
        StringTokenizer st = new StringTokenizer(linha, " ");
        st.nextToken();
        while(st.hasMoreTokens())
            movimentos.add(st.nextToken());
        return movimentos;
    }
    
    public ArrayList<String> getEstadosFromAutomato(String automato, int option) {
        ArrayList<String> linhas = new ArrayList();
        ArrayList<String> lista = new ArrayList();
        StringTokenizer st = new StringTokenizer(automato, "\n");
        // Adiciona para o ArrayList linhas cada token parametrizado por '\n'.
        while(st.hasMoreTokens())
            linhas.add(st.nextToken());
        // Para option = 1 retorna linhas bruto.
        if(option == 1) return linhas;
        // Para cada linha em linhas, tokeniza a partir de '=' e obtem apenas o
        // nome do estado da respectiva linha.
        linhas.stream().map((linha) -> new StringTokenizer(linha, "=")).forEach((stAux) -> {
            String token = stAux.nextToken();
            if(token.startsWith(">")) lista.add(token.substring(1));
            else lista.add(token);
        });
        // Reseta linhas com os nomes dos estados obtidos.
        linhas.clear();
        for(int i = 1; i < lista.size(); i++)
            linhas.add(lista.get(i));
        return linhas;
    }
    
    public int getCountOf(String string1, String string2) {
        int i = -1;
        int count = 0;
        for( ; ; ++count) {
            i = string1.indexOf(string2, i + 1);
            if(i == -1)
                break;
        }
        return count;
    }
}