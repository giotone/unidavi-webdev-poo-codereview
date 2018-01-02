/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unidavi.edu.br.atividade2_escrita;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author gt2a
 */
public class Adivinhacao {
    
    public int getTentativa(){
        return tentativa;
    }
    
    public boolean getAcertou(){
        return acertou;
    }
    
    private int numMaximo;
    private int maxTentativa;
    private int tentativa = 0;
    private boolean acertou = false;
    
    private boolean VerificaInteiroPositivo(String num) {
        try {
            return (Integer.parseInt(num) >= 0);
        } catch (NumberFormatException e) {  
            return false;  
        }  

    }
    
    public String opcaoMenu(String opcao){
        String retorno;
        switch (opcao){
            case "1":
                numMaximo = 20;
                maxTentativa = 5;
                retorno = "ok";
                break;
            case "2":
                numMaximo = 100;
                maxTentativa = 6;
                retorno = "ok";
                break;
            case "3":
                retorno = "pergunta";
                break;
            default:
                retorno = "invalido";
        }
        return retorno;
    }
    
    private void Menu(){
        
        boolean continuarOpcao;
        
        System.out.println("Olá Jogador");
        System.out.println("Bem vindo ao jogo de adivinhação de números");
        System.out.println("");
        
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.println("Escolha um nível de jogo:");
            System.out.println(" 1 - Número com limite de 0 a 20 com 5 tentativas");
            System.out.println(" 2 - Número com limite de 0 a 100 com 6 tentativas");
            System.out.println(" 3 - Escolher o limite de possibilidades e o número de tentativas");
            String opcao = scan.nextLine();
            
            String retornoOpcaoMenu = opcaoMenu(opcao);
            
            switch (retornoOpcaoMenu){
                
                case "pergunta":
                    System.out.printf("Informe o limite desejado:");
                    numMaximo = scan.nextInt();
                    System.out.printf("Informe o número de tentativas:");
                    maxTentativa = scan.nextInt();
                    break;
                case "invalido" :
                    System.out.println("Informe uma opção válida");
                    System.out.println("");
            }
            
            continuarOpcao = "invalido".equals(retornoOpcaoMenu);
            
        }while (continuarOpcao);
        
    }
    
    public Adivinhacao (){
        
    }
    
    public boolean ValidaNumeroInformado(String numeroDigitado){

        boolean retorno = false;
        
        if (VerificaInteiroPositivo(numeroDigitado)){
            
            int numero = Integer.parseInt(numeroDigitado);
            
            if (numero <= numMaximo){
                retorno = true;                
            }
        }
        
        return retorno;
    }
    
    public String Jogar(String numeroDigitado, int numSorteado){
        
        if (ValidaNumeroInformado(numeroDigitado)){
            int numero = Integer.parseInt(numeroDigitado);
            
            tentativa++;
            acertou = false;
            if (numSorteado == numero) {
                acertou = true;
                return "igual";
            }else{
                if (numero > numSorteado){
                    //System.out.println("O número sorteado é menor.");
                    return "menor";
                }else{
                    //System.out.println("O número sorteado é maior.");
                    return "maior";
                }
            }
        }else{
            return "invalido";
        }
    }
    
    public void inicia(){
                
        boolean continuar = true;
        int numSorteado;
        
        Menu();
        
        Random rand = new Random();
                
        numSorteado = rand.nextInt(numMaximo+1);
        
        Scanner scan = new Scanner(System.in);
                
        do {
            System.out.printf("Escolha um número de 0 a %d (tentativa %d/%d)", numMaximo,tentativa,maxTentativa);
            String numeroDigitado = scan.nextLine();

            String jogada = Jogar(numeroDigitado,numSorteado);

            if(!"igual".equals(jogada)){
                if ("invalido".equals(jogada)){
                    System.out.println("Informe um número entre 0 e "+numMaximo);
                }else{
                    System.out.println("O número sorteado é "+jogada);
                }
            }
                
            continuar = tentativa <= maxTentativa && !acertou;

        } while (continuar);
        scan.close();
        System.out.println("Você ".concat(getAcertou() ? "'Venceu'" : "'Perdeu', o número era "+numSorteado));
    }
}

