public class AVR extends ABP{
  public ARN(Object elemento){
    super(elemento);
  }
  public No busca(Object elemento){
    No noAtual = super.busca(elemento, super.raiz);
    return noAtual;
  }

  public void rotacaoSimplesDireita(No noAtual){
    if(noAtual.getPai().getPai() == super.raiz){
      //Rotação direita simples com filho esquerdo e com raiz
      if(noAtual.getPai().getFilhoEsquerdo() == noAtual && noAtual.getPai().getPai().getFilhoDireito() == null){
       System.out.println("rotação direita simples com raiz 1");
       noAtual.getPai().getPai().setPai(noAtual.getPai());
       noAtual.getPai().setFilhoDireito(noAtual.getPai().getPai();
       noAtual.getPai().getPai().setFilhoEsquerdo(null);
       super.raiz = noAtual.getPai();
      }
      //Rotação direita simples com filho direito e com raiz
      else{
       System.out.println(Simples esquerdo com raiz 2");
       No novoNo = noAtual.getPai().getPai();
       noAtual.getPai().setPai(noAtual);
       noAtual.setFilhoDireito(noAtual.getPai());
       noAtual.getFilhoDireito().setFilhoEsquerdo(null);
       novoNo.setFilhoDireito(noAtual);
       noAtual.setPai(novoNo);
      }
    }
    else{ //Quando o avô não é raiz e o irmão é null
     //Rotação direita simples com filho esquerdo e sem raiz
     if(noAtual.getPai() == noAtual && noAtual.getPai().getPai().getFilhoDireito() == null){
      System.out.println("Simples esquerdo com raiz 3");
      mostrarArvore();
      No novoNo = noAtual.getPai().getPai().getPai();
      noAtual.getPai().getPai().setPai(noAtual.getPai();
      noAtual.getPai().setFilhoDireito(noAtual.getPai().getPai());
      noAtual.getPai().getPai().setFilhoEsquerdo(null);
      novoNo.setFilhoEsquerdo(noAtual.getPai());
      noAtual.getPai().setPai(novoNo);
     }
     //Rotação direita simples com filho direito e sem raiz
     else{
      Sysem.out.println("Simples esquerdo com raiz 4");
      No novoNo = noAtual.getPai().getPai();
      System.out.println("Novo: " + novoNo.getElemento());
      noAtual.getPai().setPai(noAtual);
      noAtual.setFilhoDireito(noAtual.getPai());
      noAtual.getFilhoDireito().setFilhoEsquerdo(null);
      novoNo.setFilhoDireito(noAtual);
      noAtual.setPai(novoNo);
     }
    }
  }
}
 public void rotacaoSimplesEsquerda(No noAtual){
   if(noAtual.getPai().getPai() == super.raiz){
     //Rotação direita esquerdo com filho direito e com raiz
     if(noAtual.getPai().getFilhoDireito() == noAtual && noAtual.getPai().getPai().getFilhoEsquerdo() == null){
       System.out.println("Rotação esquerda simples com raiz 1");
       noAtual.getPai().getPai().setPai(noAtual.getPai());
       noAtual.getPai().setFilhoEsquerdo(noAtual.getPai().getPai());
       noAtual.getPai().getPai().setFilhoDireito(null);
       super.raiz = noAtual.getPai();
     }
   
    //Rotação direita esquerdo com filho esquerdo e com raiz
     else{
      System.out.println("Rotação esquerda simples com raiz 2");
      No novoNo = noAtual.getPai().getPai();
      noAtual.getPai().setPai(noAtual);
      noAtual.setFilhoEsquerdo(noAtual.getPai());
      noAtual.getFilhoEsquerdo().setFilhoDireito(null);
      novoNo.setFilhoEsquerdo(noAtual);
      noAtual.setPai(novoNo);

  }
   }
   else{ //Quando o avó não é a raiz e o irmão é null
    //Rotação direito esquerdo com filho direito e sem raiz
    if(noAtual.getPai().getFilhoDireito() == noAtual && noAtual.getPai().getPai().getFilhoEsquerdo == null){
      System.out.println("Rotação simples esquerda sem raiz 3");
      No novoNo = noAtual.getPai().getPai().getPai();
      noAtual.getPai().getPai().setPai(noAtual.getPai());
      noAtual.getPai().setFilhoEsquerdo(noAtual.getPai().getPai());
      noAtual.getPai().getPai().setFilhoDireito(null);
      novoNo.setFilhoDireito(noAtual.getPai());
      noAtual.getPai().setPai(novoNo);
 }
  else{
    System.out.println("Rotação esquerda simples sem raiz 4");
    No novoNo = noAtual.getPai().getPai();
    noAtual.getPai().setPai(noAtual);
    noAtual.setEsquerdo(noAtual.getPai());
    noAtual.getPai().setFilhoDireito(null);
    novoNo.setFilhoEsquerdo(noAtual);
    noAtual.setPai(novoNo);
  }
   }
 }
  public No repintamento(No noAtual){
    
 

