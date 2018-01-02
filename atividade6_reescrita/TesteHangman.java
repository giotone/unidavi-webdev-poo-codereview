package br.unidavi.edu.br.atividade6_reescrita;

public class TesteHangman {
    
    public static void main(String[] args){
        
        // Hangman hang = new Hangman("vinicius");  // Construtor já passando a palavra que será adivinhada
        Hangman hang = new Hangman();               // Construtor que pergunta a palavra que será adivinhada
        
        //hang.iniciar(3);  // Método que já define o número de tentativas
        hang.iniciar();     // Método que assume 6 tentativas como padrão
    }    
    
}
