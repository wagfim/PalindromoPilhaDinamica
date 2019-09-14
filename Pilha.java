package br.edu.ifpr;

public class Pilha {
    private No topo;
    private int tamanho = 0;
    
    public int getTamanho() {
        return this.tamanho;
    }
    public boolean estaVazia() {
        return topo == null;
    }
    
    public void empilhar(String elemento) {
        No novoNo = new No(elemento);
        
        if(estaVazia()) {
            topo = novoNo;
            tamanho++;
        } else {
            novoNo.setAnterior(topo);
            topo = novoNo;
            tamanho++;
        }
    }
    
    String desempilha() {
        if(estaVazia()) {
            return "Pilha Vazia";
        } else {
            No auxiliar = topo;
            topo = topo.getAnterior();
            tamanho--;
            return auxiliar.getElemento();
        }
    }
}
