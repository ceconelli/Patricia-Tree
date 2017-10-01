
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) {
            File f = new File("translate.txt");
            BinaryConverter bin = new BinaryConverter(f);
            ArrayList<String> charWords = bin.convertToBin(bin.getCharWords());
            for(int i=0;i<charWords.size();i++){
                System.out.println(charWords.get(i));
                System.out.println("i="+i);
            }
            ArrayList<String> palavras_char = bin.getCharWords();
            char[] chars = palavras_char.get(0).toCharArray();
            ArrayList<String> palavras_bin = bin.convertToBin(palavras_char);
            char[] bits = palavras_bin.get(0).toCharArray();
            /*for(int i = 0; i < bits.length; i++){
                System.out.println(bits[i]);
            }*/
            //System.out.println(bits.length);
            
            
            ArvorePatriciaWord PegaFogoCabare = new ArvorePatriciaWord(128);  // Cria a arvore Patricia com strings
            for(int i = 0; i < palavras_bin.size(); i++){  // Insere as strings extraídas do arquivo
                PegaFogoCabare.insere(palavras_bin.get(i));
                //System.out.println ("Inseriu chave " + palavras_bin.get(i));
            }
            System.out.println("PESQUISA:\n");
            
            PegaFogoCabare.pesquisa("Importancia");
            /*PegaFogoCabare.pesquisa("computacao");
            PegaFogoCabare.pesquisa("dia");
            PegaFogoCabare.pesquisa("na");
            
            /*for(int i = 0; i < palavras_bin.size(); i++){  // Pesquisa as chaves inseridas anteriormente
                System.out.println ("Pesquisou chave " + palavras_bin.get(i));
                PegaFogoCabare.pesquisa(palavras_bin.get(i));
            }
            PegaFogoCabare.imprime();
            
            /*ArvorePatricia Paty = new ArvorePatricia (128);
	    int min = 32, max = 126;
	    
	    char vetor[] = new char[max-min+1];

	    for (int i = min; i <= max; i++)
	      vetor[i-min] = (char)i;

	    
	    // Insere cada chave na árvore
	    for (int i = 0; i < bits.length; i++) { 
	      char c = bits[i];
	      Paty.insere (c);
	      System.out.println ("Inseriu chave " + i + ": " + (int)c + " -- char:" + c);
	    }
	    Paty.imprime ();
            

	    // Pesquisa cada chave na árvore
	    for (int i = 0; i < bits.length; i++) {
	      char c = bits[i];
	      System.out.println ("Pesquisando chave " + i + ": " + c);
	      Paty.pesquisa (c);
	    }*/
	}
}
