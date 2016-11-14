/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinizador;

import java.util.ArrayList;

/**
 *
 * @author Tayrone, Rafahel e Fernando
 */
public class Determinizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Estado> automatoAL = new ArrayList();
        String automato = "- a b c\n"   + 
                      ">S= A,S S S\n"   +
                      "A= - B -\n"      +
                      "B= B,C B B\n"    +
                      "C= - D -\n"      +
                      "D= D D D,E\n"    +
                      "E= E E E\n";
        
        ArrayList<String> estadosFromAutomato = new Leitor().
                getEstadosFromAutomato(automato, 0);
        estadosFromAutomato.stream().forEach((item) -> {
            automatoAL.add(new Estado(item));
        });
        
        Leitor teste = new Leitor();
        for(int i = 0; i < automatoAL.size(); i++) {
            automatoAL.get(i).setMovimentos(teste.setMovimentoEstado(teste.
                    getEstadosFromAutomato(automato, 1).get(1)));
        }
        
        
    }
    
}
