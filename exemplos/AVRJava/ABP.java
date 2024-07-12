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
  public noRemover(Object elemento) throws RemocaoInvalidaExcecao{
    No noRemovido = busca(elemento, raiz);
    if(noRemovido.getElemento() != elemento){
      throw new RemocaoInvalidaExcecao("O elemento " + elemento + "não existe na árvore");
    }
    //Quando o nó removido não tem nenhum filho
    if(ehExterno(noRemovido){
      if((int) noRemovido.getElemento() < (int) noRemovido.getPai().getElemento()){
	noRemovido.getPai().setFilhoEsquerdo(null);
      }
      else{
       noRemovido.getPai().setFilhoDireito(null);
      }
      noRemovido.setPai(null);
    }
    //Quando o nó removido tem um filho
   else if(noRemovido.temFilhoEsquerdo() && !(noRemovido.temFilhoDireito())){ //Verificando se o filho é esquerdo
    if(removido.getPai().getFilhoEsquerdo() == noRemovido){
      noRemovido.getPai().setFilhoEsquerdo(noRemovido.getFilhoEsquerdo());
      noRemovido.getFilhoEsquerdo().setPai(noRemovido.getPai());
    }
    else{
     noRemovido.getPai().setFilhoDireito(noRemovido.getFilhoDireito();
     noRemovido.getFilhoDireito.setPai(noRemovido.getPai();
    }
    noRemovido.setPai(null);
  }
  //Quando o nó a ser removido tem dois filhos
  else{
   No segundoNo = removido.getFilhoDireito();
   while(segundoNo.temFilhoEsquerdo()){
     segundoNo = segundoNo.getFilhoEsquerdo());
   }
   Object novoElemento = segundoNo.getElemento();
   tamanho++;
   remover(segundoNo.getElemento());
   noRemovido.setElemento(novoElemento);
  }
 tamanho--;
 return noRemovido;
  }

 public int altura(No noAtual){
   if(ehExterno(noAtual){
     return 0;
   }
   int alt = 0;
   if(noAtual.temFilhoEsquerdo()){
     alt = Math.max(alt, altura(noAtual.getFilhoEsquerdo());
   }
   if(noAtual.temFilhoDireito()){  
    alt = Math.max(alt, altura(noAtual.getFilhoDireito());
   }
   return alt +=1;
 }
 public int profundidade(No noAtual){
   if(ehRaiz(){
    return 0;
   }
   return 1 + profundidade(no.getPai());
 }
  

           
