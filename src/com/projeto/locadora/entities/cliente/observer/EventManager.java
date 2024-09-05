package com.projeto.locadora.entities.cliente.observer;

import java.util.*;

/*
    Essa classe é responsável por registrar os inscritos para o observer,
    contendo uma lista para armazenar qualquer objeto que implemente
    EventListener, que, no nosso caso, se trata de objetos do tipo Cliente.
    Além disso, a classe fornece métodos de cadastrar incritos e de 
    excluir inscritos. O método "notificar" envia uma mensagem para
    cada um dos clientes cadastrados, usando o método update de cada um.
*/
public class EventManager {
    
    private List<EventListener> inscricoes;
    private static final EventManager event = new EventManager();

    private EventManager() {
        inscricoes = new ArrayList<>();
    }
    
    public void inscrever(EventListener e){
        if(!inscricoes.contains(e)){
            inscricoes.add(e);
        }
    }
    
    public void remover(EventListener e){
        if(inscricoes.contains(e)){
            inscricoes.remove(e);
        }
    }
    
    public void notificar(String mensagem){
        for(EventListener e : inscricoes){
            e.update(mensagem);
        }
    }
    
    public static EventManager getInstance() {
        return event;
    }
}
