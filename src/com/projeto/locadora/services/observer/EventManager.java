package com.projeto.locadora.services.observer;

import java.util.*;

/*
    Implementação do padrão de projeto Observer
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
