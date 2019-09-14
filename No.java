package br.edu.ifpr;
public class No {
    private String elemento;
    private No anterior;
    
    public No(String elemento){
        this.elemento = elemento;
        anterior = null;
    }

    public String getElemento() {
        return elemento;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
