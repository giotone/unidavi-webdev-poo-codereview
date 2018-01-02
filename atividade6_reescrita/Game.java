package br.unidavi.edu.br.atividade6_reescrita;

abstract class Game {
    abstract String play(String attempt);
    
    abstract void iniciar();
    abstract void iniciar(int tentativa);
}
