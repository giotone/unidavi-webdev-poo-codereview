package br.unidavi.edu.br.atividade2_reescrita;

import java.util.Scanner;

public class Hangman {

    public boolean getCanPlay() {
        return this.canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }
    
    public int getWrongAttempts(){
        return this.wrongs;
    }
    
    private boolean canPlay = true;
    private boolean gotcha = false;    
    private int wrongs = 0;        
    private final int limit = 6;
    private final String senha;    
    private char[] placeholder;
        
    public String play(String attempt){
        
        String pass = senha;
        gotcha = true;
        
        boolean hit = false;
        String placeholderAsString = "";
        
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) == attempt.charAt(0)) {
                    placeholder[i] = attempt.charAt(0);
                    hit = true;
            }
            gotcha = gotcha & (pass.charAt(i) == placeholder[i]);
            placeholderAsString += placeholder[i];
        }
        
        if (!hit)
            wrongs++;
        setCanPlay(wrongs <= limit && !gotcha);
        
        return placeholderAsString;
    }
    
    public Hangman(String pass) {
        this.senha = pass;
        
        placeholder = new char[this.senha.length()];
        
        for (int i = 0; i < this.senha.length(); i++)
            placeholder[i] = '*';
    }
    
    public boolean won(){
        return gotcha;
    }
    
    public void iniciar(){        
        
        Scanner scanner = new Scanner(System.in);
            do {
                System.out.printf("Your attempt: %d/%d", wrongs, limit);
                String attempt = scanner.nextLine();                
                String placeholderAsString = play(attempt);
                System.out.println(placeholderAsString);
            } while (getCanPlay());
        
	System.out.println("You ".concat( won() ? " win" : " lose"));
    }
}
