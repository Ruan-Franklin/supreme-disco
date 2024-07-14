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
    //Caso 1: Se w, o pai de v é negro, nada mais precisa ser feito, já que o critério IV foi mantido.
    if(noAtual.getPai().getCor("Negro"){
      System.out.println("Estou no caso 1");
      return noAtual; 
  }
    //Caso 2
   // Veificando se o pai do nó é filho direito do avô
   else if(noAtual.getPai().getPai().getFilhoDireito() == noAtual.getPai() && noAtual.getPai().getPai().getFilhoEsquerddo != null && noAtual.getPai().getPai().getFilhoEsquerdo().getCor() != "negro"){
    Sytem.out.println("Estou no caso 2, filho do lado direito");
    //Caso 2: quando o avô do nó é negro e o pai e o tio dele são rubros
    if(noAtual.getPai().getCor() == "rubro" && noAtual.getPai().getCor() == "negro" && noAtual.getPai().getPai().getFilhoEsquerdo() == "rubro"){
      //Caso 2:quando o avô do nó  é raiz e o pai é vermelho e o tio é vermelho também e o avô é negro
      if(noAtual.getPai().getPai() == super.raiz){
	noAtual.getPai().setCor("negro");
	noAtual.getPai().getPai().getFilhoEsquerdo().setCor("negro");
      }
      //Caso 2: quando o avô do nó atual não é raiz, pai e tio são vermelhos e o avô é negro
      else{
        noAtual.getPai().setCor("negro");
	noAtual.getPai().getPai().getFilhoEsquerdo().setCor("negro");
	noAtual.getPai().getPai().setCor("rubro");
	repitamento(noAtual.getPai().getPai());
      }

    }
   }
   //Verificando se o pai do nó é filho esquerdo do avô
   else if(noAtual.getPai() == noAtual.getPai().getPai().getFilhoEsquerdo() && noAtual.getPai().getPai().getFilhoDireito != null && noAtual.getPai().getPai().getFilhoDireito().getCor() != "negro"){
     System.out.println("Estou no caso 2, filho do lado esquerdo");
     if(noAtual.getPai().getCor() == "rubro" && noAtual.getPai().getPai() == "negro" && noAtual.getPai().getPai().getFilhoDireito() == "rubro"){
      
       noAtual.getPai().setCor("negro");
       noAtual.getPai().getFilhoDireito().setCor("negro");
       if(noAtual.getPai().getPai() == super.raiz){
	 return noAtual;
       }
       else{
	 noAtual.getPai().setCor("rubro");
	 repitamento(noAtual.getPai().getPai());
       }
     }
   }
   //Caso 3
   //Caso 3a: rotação direita simples
   else if (noAtual.getPai().getPai().getFilhoEsquerdo() == noAtual.getPai() && noAtual.getPai().getPai().getFilhoDireito() == null && noAtual.getPai().getFilhoDireito() == null){
    System.out.println("Estou no caso 3A< rotação a direita simples");
    noAtual.getPai().setCor("negro");
    noAtual.getPai().getPai().setCor("rubro");
    rotacaoSimplesDireita(noAtual);
   }
   //Caso 3b: rotação direita simples
   else if(noAtual.getPai().getPai().getFilhoDireito() == noAtual.getPai() &&  noAtual.getPai().getPai().getFilhoEsquerdo() == null && noAtual.getPai().getFilhoEsquerdo() == null){
    System.out.println("Estou no caso 3B - Rotação direita simples");
    noAtual.getPai().setCor("negro");
    noAtual.getPai().getPai().setCor("rubro");
    rotacaoSimplesEsquerda(NoAtual);
   }
   //Caso 3C - rotação esquerda dupla
   else if(noAtual.getPai().getPai().getFilhoDireito() == noAtual.getPai() && noAtual.getPai().getPai().getFilhoesquerdo == null && noAtual.getPai().getFilhoDireito() == null){
    System.out.println("Estou no caso 3C - rotação esquerda dupla");
    noAtual.setCor("negro");
    noAtual.getPai().getPai.setCor("rubro");
    rotacaoSimplsDireita(noAtual);
    rotacaoSimplesEsquerda(noAtual.getFilhoEsquerdo();
   }
   //Caso 3d - Rotação direita dupla
   else if(noAtual.getPai().getPai().getFilhoEsquerdo() == noAtual.getPai() && noAtual.getPai().getPai().getFilhoDireito() == null && noAtual.getPai().getFilhoDireito() == noAtual){
    System.out.println("Estou no caso 3D- Rotação direita dupla");
    rotacaoSimplesEsquerda(noAtual);
    noAtual.getPai().setCor("rubro");
    noAtual.setCor("negro");

    if(noAtual.getPai().getPai() != null){
     rotacaoSimplesDireita(noAtual);
    }
   else{
     rotacaoSimplesDireita(noAtual.getFilhoEsquerdo)
   }
   }
  return noAtual;
  }

 public No inserir(Object elemento){
   No noAtual = super.inserir(elemento);
   noAtual.setCor("rubro");
   repintamento(noAtual);
   System.out.println("\n");
   mostrarArvore();
   return noAtual;
 }


