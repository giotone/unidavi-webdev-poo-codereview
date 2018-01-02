/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unidavi.edu.br.atividade6_escrita;

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

    // esse recebe uma string e valida se é um inteiro positivo
    abstract String Jogar(String numeroDigitado, int numSorteado);
    
    // esse já recebe um inteiro validado
    abstract String Jogar(int numeroDigitado, int numSorteado);
    
    
    abstract void inicia();
    abstract void inicia(int numAdivinhar);
    
    protected boolean VerificaInteiroPositivo(String num) {
        try {
            return (Integer.parseInt(num) >= 0);
        } catch (NumberFormatException e) {  
            return false;  
        }  

    }
    
    protected boolean VerificaInteiroPositivo(int num) {
        return num >= 0;
    }
    
}
