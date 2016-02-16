/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tolerancia.ricartagrawala;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.jgroups.JChannel;

/**
 *
 * @author Eric <itseric@mail.ru>
 */
public class Monitor {
    
    static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Digite o número de processos que deseja iniciar: ");
        System.out.flush();
        int numProcessos = Integer.parseInt(entrada.readLine());
        for (int i = 0; i < numProcessos; i++) {
            Processo p = new Processo();
            Thread t = new Thread(p);
            t.start();
        }
        
        // Como processos vão enxergar recursos?
        
        
    }
    
    
    
    
}
