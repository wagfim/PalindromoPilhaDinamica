package br.edu.ifpr;
import java.util.Scanner;
/**
 * @author Wagner Bonfim
 */
public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Pilha novaPilha = new Pilha();
        
        //pede uma palavra ao usuario (ainda não suporta frases)
        System.out.println("Informe uma palavra:");
        System.out.print(">");
        String sequencia = leitor.next();
        
        //insere letra por letra na pilha
        for (int i = 0; i < sequencia.length(); i++) {
            novaPilha.empilhar(Character.toString(sequencia.charAt(i)));
        }
        
        //verifica se a palavra digitada é palindroma
        System.out.print("\nA palavra é palíndroma: ");
        if(verificaPalindromia(novaPilha))
            System.out.println("Sim.");
        else 
            System.out.println("Não.");
        
        //imprime em ordem reversa
        System.out.print("\nImprime \""+sequencia+"\" em ordem reversa: ");
        imprimeOrdemInversa(novaPilha);
    }
    
    public static void imprimeOrdemInversa(Pilha pilha) {
        Pilha copia = new Pilha();
        copiarPilha(pilha, copia);
        for (int i = copia.getTamanho(); i > 0; i--) {
            System.out.print(copia.desempilha());
        }
        System.out.println();
    }
    
    public static boolean verificaPalindromia(Pilha pilha){
        Pilha auxiliar = new Pilha();
        Pilha copia = new Pilha();
        copiarPilha(pilha, copia);
        
        if(copia.getTamanho() % 2 == 0) { //se a quantidade de caracteres for par
            for (int i = 0; i < copia.getTamanho()/2; i++) {
                auxiliar.empilhar(copia.desempilha());
            }
        } else { //se a quantidade de caracteres for impar
            for (int i = 0; i < copia.getTamanho()/2; i++) {
                auxiliar.empilhar(copia.desempilha());
            }
            copia.desempilha(); //joga fora o caractere do meio
        }
        
        for (int i = 0; i < pilha.getTamanho(); i++) {
            if(!copia.desempilha().equals(auxiliar.desempilha()))
                return false;
        }        
        return true;
    }
    
    public static void copiarPilha(Pilha original, Pilha copia) {
        if (original.getTamanho() > 0) {
            String temp = original.desempilha();
            copiarPilha(original, copia);
            copia.empilhar(temp);
            original.empilhar(temp);
        }
    }
    
}
