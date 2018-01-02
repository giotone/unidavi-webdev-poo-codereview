/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unidavi.edu.br.atividade4_escrita;

/**
 *
 * @author gt2a
 */
abstract class Jogo {
    
    public int getTentativa(){
        return tentativa;
    }
    
    public boolean getAcertou(){
        return acertou;
    }
    
    protected int maxTentativa;
    protected int tentativa;
    protected boolean acertou;

    abstract String Jogar(String numeroDigitado, int numSorteado);
    abstract String Jogar(int numeroDigitado, int numSorteado);
    
    abstract void inicia();
    
    protected boolean VerificaInteiroPositivo(String num) {
        try {
            return (Integer.parseInt(num) >= 0);
        } catch (NumberFormatException e) {  
            return false;  
        }  

    }
    
}
