/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateus
 */
public class ArvorePatriciaWord {
    private static abstract class PatNo { }
	  private static class PatNoInt extends PatNo {
	    int index; PatNo esq, dir;
	  }  
	  private static class PatNoExt extends PatNo {
	    String chave; // O tipo da chave depende da aplicação
	  }
	  
	  private PatNo raiz;
	  private int nbitsChave;
	 
	  // Retorna o i-ésimo bit da chave k a partir da esquerda
	  private int bit (int i, String s) {
            if (i == 0) {
                return 0;
            }
            char chars[] = s.toCharArray();
            System.out.println(chars[i-1]);
            return chars[i-1];
	  }

	  // Verifica se p é nó externo
	  private boolean eExterno (PatNo p) {    
	    Class classe = p.getClass ();
	    return classe.getName().equals(PatNoExt.class.getName());
	  }

	  private PatNo criaNoInt (int i, PatNo esq, PatNo dir) {
	    PatNoInt p = new PatNoInt ();
	    p.index = i; p.esq = esq; p.dir = dir;
	    return p;
	  }

	  private PatNo criaNoExt (String s) {
	    PatNoExt p = new PatNoExt ();
	    p.chave = s;
	    return p;
	  }
	  
	  private void pesquisa (String s, PatNo t) {
	    if (this.eExterno (t)) {
	      PatNoExt aux = (PatNoExt)t;
	      if (aux.chave == s) System.out.println ("Elemento encontrado");
	      else System.out.println ("Elemento nao encontrado");
	    }
	    else { 
	      PatNoInt aux = (PatNoInt)t; System.out.print("else da pesquisa");
              System.out.println ("     //     Bit comparado: " + aux.index + "  " + s);
	      if (this.bit(aux.index, s) == 0) pesquisa (s, aux.esq);
	      else pesquisa (s, aux.dir);
	    }
	  }

	  private PatNo insereEntre (String s, PatNo t, int i) {
	    PatNoInt aux = null; 
	    if (!this.eExterno (t)) aux = (PatNoInt)t;
	    if (this.eExterno (t) || (i < aux.index)) { // Cria um novo nó externo
	      PatNo p = this.criaNoExt (s);
	      if (this.bit (i, s) == 1) return this.criaNoInt (i, t, p);
	      else return this.criaNoInt (i, p, t);
	    }
	    else {
	      if (this.bit (aux.index, s) == 1) 
	        aux.dir = this.insereEntre (s, aux.dir, i);
	      else aux.esq = this.insereEntre (s, aux.esq, i);
	      return aux;
	    }
	  }
	  
	  private PatNo insere (String s, PatNo t) {
	    if (t == null){
                System.out.println("Inseriu");
                return this.criaNoExt (s);
            } 
	    else {
	      PatNo p = t;
	      while (!this.eExterno (p)) {
	        PatNoInt aux = (PatNoInt)p;
	        if (this.bit (aux.index, s) == 1) {
                    System.out.println("Foi para direita");
                    p = aux.dir;
                } else p = aux.esq;
	      }
	      PatNoExt aux = (PatNoExt)p;
	      int i = 1; // acha o primeiro bit diferente
	      while ((i <= this.nbitsChave)&&
	             (this.bit (i, s) == this.bit (i, aux.chave))) i++;
	      if (i > this.nbitsChave) {
	        System.out.println ("Erro: chave ja esta na arvore"); 
	        return t;
	      }
	      else return this.insereEntre (s, t, i);
	    }
	  }
	  
	  private void central (PatNo pai, PatNo filho, String msg) {
	    if (filho != null) {
	      if (!this.eExterno (filho)) {
	        PatNoInt aux = (PatNoInt)filho; 
	        central (filho, aux.esq, "ESQ");
	        if (pai != null)
	          System.out.println ("Pai: "+ ((PatNoInt)pai).index + " " + msg+ " Int: " + aux.index);
	        else System.out.println ("Pai: "+ pai + " " + msg+ " Int: " + aux.index);
	        central (filho, aux.dir, "DIR");
	      } else {
	        PatNoExt aux = (PatNoExt)filho;
	        if (pai != null)
	          System.out.println ("Pai: "+ ((PatNoInt)pai).index + " " + msg+ " Ext: " + aux.chave);
	        else System.out.println ("Pai: "+ pai + " " + msg+ " Ext: " + aux.chave);
	      }
	    }
            else System.out.println("Arvore vazia");
	  }

	  public void imprime () {
	    this.central (null, this.raiz, "RAIZ");
	  }

	  public ArvorePatriciaWord (int nbitsChave) {
	    this.raiz = null; this.nbitsChave = nbitsChave; 
	  }
	  
	  public void pesquisa (String s) { this.pesquisa (s, this.raiz); }
	  
	  public void insere (String s) { this.raiz = this.insere (s, this.raiz); }
}
