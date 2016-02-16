package com.tolerancia.ricartagrawala;

import java.util.List;
import org.jgroups.JChannel;

/**
 *
 * @author Eric <itseric@mail.ru>
 */
public class Processo implements Runnable {
    
    private List<Processo> listaEspera;
    long minhaTimestamp;
    int estado; // 0 = RELEASED, 1 = WANTED, 2 = HELD
    JChannel channel;
    int tamanhoGrupo;
    
    public Processo() {
        estado = 0;
    }
    
    private void conectar() throws Exception {

        channel = new JChannel();
        channel.connect("Cluster");

    }
 
    /*
        Método onde o processo envia um pedido para acessar a seção crítica
        passando seu id e timestamp do pedido.
    */
    boolean requisitarSecaoCritica(long ts, int idProcesso){
         estado = 1;
         minhaTimestamp = System.nanoTime();
         int numeroRespostas = 0;
         // Enviar pedido secao crítica para todos com JGroups
         if(numeroRespostas == tamanhoGrupo){
             estado = 2;
             entrarSecaoCritica();
         }
        return false;    
    }
    
    void responderSecaoCritica(long ts, int idProcesso){
        /* Lógica: o processo que recebe o pedido responde OK SE nao está ele
                mesmo executando OU pedindo secao crítica, OU SE ele mesmo está
                pedindo MAS o processo que enviou pedido tem timestamp menor.
        ELSE os pedidos aguardam. Fila é automatica e nao precisa ser implementada.
        */
                
    }
    
    void entrarSecaoCritica(){
       
    }
    
    void soltarSecaoCritica(){
        for (Processo p : listaEspera) {
            // Enviar OK para os processos que aguardam
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
