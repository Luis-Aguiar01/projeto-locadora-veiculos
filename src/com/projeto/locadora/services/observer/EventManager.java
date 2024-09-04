package com.projeto.locadora.services.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    
    private List<EventListener> inscricoes;

    public EventManager() {
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
}
