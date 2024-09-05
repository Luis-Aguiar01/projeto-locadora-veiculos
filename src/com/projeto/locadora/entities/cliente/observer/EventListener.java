package com.projeto.locadora.entities.cliente.observer;

/*
    Interface responsável por fornecer um método que
    funciona como uma mensagem, passando uma string
    como parâmetro. Essa classe faz parte da implementação
    do Padrão Observer.
*/
public interface EventListener { 
    void update(String mensagem);
}
