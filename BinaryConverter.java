
import java.io.*;
import java.util.*;


public class BinaryConverter {
    ArrayList<String> charWords = new ArrayList();
    ArrayList<Integer> binaryWords = new ArrayList();
    ArrayList<Integer> binaryChars = new ArrayList();

    public ArrayList<Integer> getBinaryWords() {
        return binaryWords;
    }

    public ArrayList<Integer> getBinaryChars() {
        return binaryChars;
    }

    public ArrayList<String> getCharWords() {
        return charWords;
    }

    public BinaryConverter(File f) {
        Scanner sc2 = null;
            try {
                sc2 = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();  
            }
            while (sc2.hasNextLine()) {
                    Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String s = s2.next();
                    this.charWords.add(s);
                    //System.out.println(s);
                }
        }
    }
    
    
    public ArrayList<String> convertToBin(ArrayList<String> lista){  //isso é pra passar uma lista de palavras em string e passar pra binario;
        ArrayList<String> lista_final = new ArrayList<String>();
        String string_final = "";
        
        for(int i = 0; i < lista.size(); i++){ //percorre a lista do parametro
            String word = lista.get(i);  //considera cada string da lista como um vetor de char
            
            for(int j = 0; j < word.length(); j++){  //percorre o vetor de char
                int aux1 = (int)word.charAt(j); //transforma o char para inteiro
                String aux2 = Integer.toBinaryString(aux1);  //transforma o inteiro em uma string de binario
                
                if(aux2.length() < 8){  //padroniza a string de char para 8bits
                    int dif = 8 - aux2.length();
                    for(int k = 0; k < dif; k++){
                        aux2 = "0" + aux2;    
                    }
                    //System.out.println(chars[j] + " = " + aux2);
                }
                
                string_final = string_final + aux2;
                if(string_final.length() < 128){  //padroniza a string final(palavra) para 128bits
                //System.out.println("Tamanho inicial = " + string_final.length());
                    int dif = 128 - string_final.length();
                    for(int k = 0; k < dif; k++){
                        string_final = "0" + string_final;    
                    }
                //System.out.println("Tamanho final = " + string_final.length());
                }
        //System.out.println(string_final);
                lista_final.add(string_final);//concatena a String de char a uma string final que será a palavra 
            }
            //System.out.println("Palavra final: " + string_final);
        }  
       
        //System.out.print("\n\n\n");
        
        
        return lista_final;
    }
    
    public ArrayList<String> readFile(File f){
        Scanner sc2 = null;
            try {
                sc2 = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();  
            }
            while (sc2.hasNextLine()) {
                    Scanner s2 = new Scanner(sc2.nextLine());
                while (s2.hasNext()) {
                    String s = s2.next();
                    this.charWords.add(s);
                    //System.out.println(s);
                }
        }
        return this.charWords;
    }
}
