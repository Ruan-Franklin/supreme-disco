public class ABP{
  public No no;
  public No raiz;
  private int tamanho;
  public int contador = 0;
  public static final String ANSI_RESET = "\u001B[m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31M";
  public static final String ANSI_GREEN = "\u001B[32M";

  public ABP(Object elemento){
    raiz = new No(elemento, null);
    tamanho = 1;
  }
  public No raiz(){
    return raiz;
  }
  public int tamanho(){
    return tamanho;
  }
  public boolean estaVazio(){
    return false;
  }
  public No pai(No noAtual){
    return noAtual.getpai();
  }
  public boolean ehInterno(No noAtual){
    return noAtual.temFilhoDireito() || noAtual.temFilhoEsquerdo();
  }
  public boolean ehExterno(No noAtual){
    return !ehInterno(noAtual);
  }
  public boolean ehRaiz(No noAtual){
    return raiz == noAtual;
  }
  public No busca(Object elemento, noAtual){
    if(ehExterno(noAtual){
      return noAtual;
    }
    //Busca pelo lado esquerdo
    else if((int)noAtual.getElemento() > (int) elemento){
     if(no.getFilhoEsquerdo() != null){
      return busca(elemento, noAtual.getFilhoEsquerdo());
     }
    }
   //Elemento encontrado
   else if(int) noAtual.getElemento() == (int) elemento){
    return noAtual;
   }
   //Busca pelo lado direito
   else if(noAtual.getFilhoDireito() != null){
     return busca(elemento, noAtual.getFilhoDireito());
   }
   return noAtual;
  }
  public No inserir(Object elemento){
    No noProcurado = busca(elemento, raiz);
    No novoNo = new No(elemento, noProcurado);
    //Inserindo no à esquerda
    if((int) elemento < (int) noProcurado.getElemento()){
      noProcurado.setFilhoEsquerdo(novoNo);  
  }
  //Inserindo nó à direita
    else{

      noProcurado.setFilhoDireito(novoNo);
    }
    tamanho++;
    return novoNo;
  }

 
