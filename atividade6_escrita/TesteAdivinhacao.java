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
public class TesteAdivinhacao {
    public static void main(String args[]){
        
        //Adivinhacao adivinha = new Adivinhacao(); // Executa o menu para perguntar as opções de jogo        
        //adivinha.inicia();// Sorteia um numero para ser adivinhado
        
        Adivinhacao adivinha = new Adivinhacao(30,7);// Inicia o jogo com o intervalo de 0 a 30 com 7 tentativas
        adivinha.inicia(21);// Recebe o número que deve ser adivinhado
        
    }
}
