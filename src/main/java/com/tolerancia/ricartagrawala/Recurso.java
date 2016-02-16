/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tolerancia.ricartagrawala;

/**
 *
 * @author Eric <itseric@mail.ru>
 */
public class Recurso {
    
    private String nome;

    public Recurso(String nome) {
        this.nome = nome;
        System.out.println("O recurso " + nome + " agora está disponível para uso!");
    }
    
    
}
