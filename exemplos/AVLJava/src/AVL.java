public class AVL extends  ABP {
    public AVL(Object elemento) {
        super(elemento);
    }

    public void rotacaoSimplesDireita(No noAtual) {
        if (noAtual == super.raiz) {
            if (noAtual.getFilhoEsquerdo().getFilhoDireito() != null) {
                No novoNo = new No(noAtual.getFilhoEsquerdo().getFilhoDireito().getElemento(), noAtual);
                noAtual.setPai(noAtual.getFilhoEsquerdo());
                noAtual.getPai().setPai(null);
                noAtual.getFilhoEsquerdo().setFilhoDireito(noAtual);
                noAtual.setFilhoEsquerdo(novoNo);
                super.raiz = noAtual.getPai();
            } else {
                noAtual.getFilhoEsquerdo().setFilhoDireito(noAtual);
                noAtual.setPai(noAtual.getFilhoDireito());
                noAtual.setFilhoEsquerdo(null);
                super.raiz = noAtual.getPai();
            }
            fatorBalanceamentoRotacaoDireita(noAtual, noAtual.getPai());
        } else {
            if (noAtual.getFilhoEsquerdo().getFilhoDireito() != null) {
                No novoNo = new No(noAtual.getFilhoEsquerdo().getFilhoDireito().getElemento(), noAtual);
                noAtual.getPai().setFilhoDireito(noAtual.getFilhoEsquerdo());
                noAtual.getFilhoEsquerdo().setPai(noAtual.getPai());
                noAtual.setPai(noAtual.getFilhoEsquerdo());
                noAtual.setFilhoEsquerdo(novoNo);
                noAtual.getPai().setFilhoDireito(noAtual);

            } else {
                if (noAtual.getFatorBalanceamento() == -2 || noAtual.getFatorBalanceamento() == 1) {
                    noAtual.getPai().setFilhoDireito(noAtual.getFilhoEsquerdo());
                } else {
                    noAtual.getPai().setFilhoEsquerdo(noAtual.getFilhoEsquerdo());
                }
                noAtual.getFilhoEsquerdo().setPai(noAtual.getPai());
                noAtual.setPai(noAtual.getFilhoEsquerdo());
                noAtual.setFilhoEsquerdo(null);
                noAtual.getPai().setFilhoDireito(noAtual);
            }
            fatorBalanceamentoRotacaoDireita(noAtual, noAtual.getPai());
        }

        public void rotaSimplesE (No no){
            if (no == super.raiz) {
                if (no.get_filho_direito().get_filho_esquerdo() != null) {
                    No novo_no = new No(no.get_filho_direito().get_filho_esquerdo().get_elemento(), no);
                    no.set_pai(no.get_filho_direito());
                    no.get_pai().set_pai(null);
                    no.get_filho_direito().set_filho_esquerdo(no);
                    no.set_filho_direito(novo_no);
                    super.raiz = no.get_pai();
                } else {
                    no.get_filho_direito().set_filho_esquerdo(no);
                    no.set_pai(no.get_filho_direito());
                    no.set_filho_direito(null);
                    super.raiz = no.get_pai();
                }
                fbRotaEsquerda(no, no.get_pai());
            } else {
                if (no.get_filho_direito().get_filho_esquerdo() != null) {
                    No novo_no = new No(no.get_filho_direito().get_filho_esquerdo().get_elemento(), no);
                    no.get_pai().set_filho_esquerdo(no.get_filho_direito());
                    no.get_filho_direito().set_pai(no.get_pai());
                    no.set_pai(no.get_filho_direito());
                    no.set_filho_direito(novo_no);
                    no.get_pai().set_filho_esquerdo(no);
                } else {
                    if (no.get_fator_balanceamento() == -2 || no.get_fator_balanceamento() == 1) {
                        no.get_pai().set_filho_direito(no.get_filho_direito());
                    } else {
                        no.get_pai().set_filho_esquerdo(no.get_filho_direito());
                    }
                    no.get_filho_direito().set_pai(no.get_pai());
                    no.set_pai(no.get_filho_direito());
                    no.set_filho_direito(null);
                    no.get_pai().set_filho_esquerdo(no);

                }
                fbRotaEsquerda(no, no.get_pai());
            }
        }
    }

    public void rotacaoSimplesEsquerda(No noAtual) {
        if (noAtual == super.raiz) {
            if (noAtual.getFilhoDireito().getFilhoEsquerdo() != null) {
                No novoNo = new No(noAtual.getFilhoDireito().getFilhoEsquerdo().getElemento(), noAtual);
                //Setando o novo pai do noAtual que será o filho direito do noAtual
                no.setPai(no.getFilhoDireito());
                //Setando o pai do filho esquerdo do noAtual como null
                noAtual.getPai().setPai(null);
                //Setando o filho direito do noAtual como o filho esquerdo do filho direito do noAtual
                noAtual.getFilhoDireito().setFilhoEsquerdo(no);
                //Setando o filho direito do noAtual como o novoNo
                no.setFilhoDireito(novoNo);
                //Setando a raiz como o novo pai do noAtual
                super.raiz = noAtual.getPai();
            } else {
                //Setando o filho esquerdo do filho direito do noAtual como o noAtual
                noAtual.getFilhoDireito().setFilhoEsquerdo(noAtual);
                //Setando o pai do noAtual como o filho direito do noAtual
                noAtual.setPai(noAtual.getFilhoDireito());
                //Deixando o filho direito como pai e raiz
                super.raiz = noAtual.getPai();


            }
            fatorBalanceamentoRotacaoEsquerda(noAtual, noAtual.getPai());
        }
        //Caso o nó seja diferente da raiz
        else {
            //Caso o nó atual já tenha filho esquerdo
            if(noAtual.getFilhoDireito().getFilhoEsquerdo() != null){
                No novoNo  = new No(noAtual.getFilhoDireito().getFilhoEsquerdo().getElemento(), noAtual);
                noAtual.getPai().setFilhoEsquerdo(noAtual.getFilhoDireito());
                noAtual.getFilhoDireito().setPai(noAtual.getPai());
                noAtual.setPai(noAtual.getFilhoDireito());
                noAtual.setFilhoDireito(novoNo);
		noAtual.getPai().setFilhoEsquerdo(noAtual);
            }else{
	       if(noAtual.getFatorBalanceamento() == -2 || noAtual.getFatorBalanceamento() == 1){
		 noAtual.getPai.setFilhoDireito(noAtual.getFilhoDireito());
        }
	      else{
		noAtual.getPai().setFilhoEsquerdo(noAtual.getFilhoDireito());
	      }
	      noAtual.getFilhoDireito().setPai(noAtual.getPai());
	      noAtual.setPai(noAtual.getFilhoDireito());
	      noAtual.setFilhoDireito(null);
	      noAtual.getPai().setFilhoEsquerdo(noAtual);
    }
	}
	fatorBalanceamentoRotacaoEsquerda(noAtual, noAtual.getPai());

    public void fatorBalanceamentoRotacaoDireita(No noB, No noA) {
        noB.setFatorBalanceamento(noB.getFatorBalanceamento() - 1 - Math.max(noA.getFatorBalanceamento(), 0));
        noA.setFatorBalanceamento(noA.getFatorBalanceamento() - 1 + Math.min(noB.getFatorBalanceamento(), 0));

    }

    public void fatorBalanceamentoRotacaoEsquerda(No noB, No noA) {
        noB.setFatorBalanceamento(noB.getFatorBalanceamento() + 1 - Math.min(noA.getFatorBalanceamento(), 0));
        noA.setFatorBalanceamento(noA.getFatorBalanceamento() + 1 + Math.max(noB.getFatorBalanceamento(), 0));
    }

    public No busca(Object elemento){
      No noAtual = super.busca(elemento, raiz);
      return noAtual;

    }
   
    public No remover(Object elemento) throw RemocaoInvalidaExceccao{
       No noRmovido = busca(elemento)
       if(noRemovido.getElemento() != elemento){
         throw new RemocaoInvalidaExcecao("O elemento " + elemento + "não está na árvore!");
         }
       if(ehRaiz(noRemovido){
         noRemovido.setElemento(null);
         System.out.println("A árvore está vazia porque a raíz fok removida.");
         return noRemovido;
         }
       if(ehExterno(noRemovido){
         noPai = noRemovido.getPai();
         //Nó esquerdo removido
         if((int) noRemovido.getElemento() < (int) noRemovido.getPai().getElemento()){
           while(pai != super.raiz && pai.getFatorBalanceamento != 2 && pai.getFatorBalanceamento() != 0 || pai != super.raiz && pai.getFatorBalanceamento != -2 && pai.getFatorBalanceamento() != 0){
             pai.getPai()pai.setFatorBalanceamento(pai.getFatorBalanceamento() -1);
             if(pai.getFatorBalanceamento() == -2 || pai.getFatorBalanceamento == 2){
               pai.getPai().setFatorBalanceamento(pai.getFatorBalanceamento() + 1);
               break;
               }
             pai=pai.getPai();
             if(pai == super.raiz){
               pai.setFatorBalanceamento(pai.getFatorBalanceamento() -1);
               }
             noRemovido.getPai().setFilhoEsquerdo(null);
             if(pai.getFatorBalanceamento() == -2){
               rotaSimplesERemove(pai);
             }
             }
             else{
               //Nó direito removido
               while(pai != super.raiz && pai.getFatorBalanceamento() == 2 && pai.getFatorBalanceamento() == 0 || pai != super.raiz && pai.getFatorBalanceamento() == -2 || pai.getFatorBalanceamento() == 0){
                 pai.setFatorBalanceamento(pai.getFatorBalanceamento() + 1);
                 if(pai.getFatorBalanceamento() == -2 || pai.getFatorBalanceamento() == 2){
                   pai.getPai().setFatorBalanceamento(pai.getPai().getFatorBalanceamento() -1);
                   break;
                 }
                 pai = pai.getPai();
                 }
                 mostrarArvore();
                 if(pai==super.raiz){
                   pai.setFatorBalanceamento(pai.getFatorBalanceamento() + 1);
                   noRemovido.getPai().setFilhoDireito(null);
                   if(pai.getFatorBalanceamento() == 2){
                     rotaSimplesDRemove(pai);
                     }
                   pai = noRemovido;
                   }
                   tamanho --;
                   return noRemovido;
                   }
                   }
     public void rotaSimplesERemove(No no){
        if(no == super.raiz){
          if(no.getFilhoDireito().getFIlhoEsquerdo() != null){
             No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento(), no);
             no.getPai().setPai(null);
             super.raiz = no.getPai();
             no.getFilhoDireito().setFilhoEsquerdo(no);
             no.setFilhoDireito(novoNo);
             }
          else{
            no.getFilhoDireito().setFilhoEsquerdo(no);
            no.setPai(no.getFilhoDireito());
            super.raiz = no.getFilhoDireito();
            no.setFilhoDireito(null):
            }
        else{
          if(no.getFilhoDireito().getFilhoEsquerdo() != null){
            No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento(), no);
            no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
            no.getFilhoDireito().setPai(no.getPai());
            no.setPai(no.getFilhoDireito());
            no.setFilhoDireito(novoNo);
            no.getPai().setFilhoEsquerdo(no);
            }
         else{
           if(no.getFatorBalanceamento() == -2){
             no.getPai().setFilhoDireito(no.getFilhoDireito());
           }
           else{
             no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
             }
       no.getFilhoDireito().setPai(no.getPai()
       no.setPai(no.getFilhoDireito());
       no.setFilhoDireito(null);
       }
       
       fbRotaEsquerda(no, no.getPai());
       }
       }
       }
       
       public No inserir(Object elemento){
         No noAtual = super.inserir(elemento);
         if(noAtual.EhEsquerdo()){
           noAtual.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() +1);
           noAtual = noAtual.getPai();
           }
         else{
           noAtual.getPai()no.setFatorBalancamento(no.getPai().getFatorBalanceamento() -1);
           noAtual = noAtual.getPai();
       }
        while(noAtual.getFatorBalanceamento() != 0 && noAtual != super.raiz && noAtual.getFatorBalanceamento() != 2 && noAtual.getFatorBalanceamento() != -2){
           if(noAtual.EhEsquerdo()){
             noAtual.getPai().setFatorBalanceamento(noAtual.getPai().getFatorBalanceamento() +1);
           }
           else{
             noAtual.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() -1);
            }
           noAtual = noAtual.getPai();
           }
           if(noAtual.getFatorBalanceamento() == 2 && noAtual.getFilhoEsquerdo() == 1){
             System.out.println("Rotação simples para a direita");
             mostrarArvore();
             System.out.println("-------------------------------------------------");
             rotaSimplesD(noAtual);
             mostrarArvore();
             }
          else if(noAtual.getFatorBalanceamento() == -2 && noAtual.getFilhoDireito() == -1){
            System.out.println("Rotação simples para a esquerda");
            mostrarArvore();
            System.out.println("-------------------------------------------------");
            rotaSimplesD(noAtual);
          }
          else if(noAtual.getFatorBalanceamento() == 2 && noAtual.getFilhoEsquerdo() == -1){
             System.out.println("Rotação simples para esquerda e rotação simples para a direita = Rotação dupla para a direita");
             mostrarArvore();
             System.out.println("-------------------------------------------------");
             No noAtual = noAtual.getFilhoEsquerdo();
             rotacaoSImplesE(noAtual);
             System.out.println("Elemento: " + noAtual.getElemento());
             mostrarArvore();
             rotaSimplesD(noAtual.getPai().getPai());
             mostrarArvore();
             
             }
        else if(noAtual.getFatorBalanceamento() == -2 && noAtual.getFilhoDireito() == 1){
          System.out.println("Rotação simples para a direita + rotação  simples para a direita = rotação dupla para a direita");
          mostrarArvore();
          System.out.println("-------------------------------------------------");
          System.out.println("Elemento: " + noAtual.getElemento());
          noAtual = noAtual.getFIlhoDireito());
          rotaSImplesD(noAtual);
          mostrarArvore();
          System.out.println("-------------------------------------------------");
          rotaSImplesE(noAtual.getPai().getPai());
          mostrarArvore();
          }
          
       return noAtual;


             

             
       public void rotaSimplesDRemove(No no){
         if(no == super.raiz){
           if(no.getFilhoEsquerdo().getFilhoDireito() !+ null){
             No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento(), no);
             no.setPai(no.getFilhoEsquerdo());
             no.getPai().setPai(null);
             super.raiz = no.getFilhoEsquerdo());
             no.getFilhoEsquerdo().setFilhoDireito(no);
             no.setFilhoEsquerdo(novoNo);
             }
           else{
             no.getFilhoEsquerdo().setFilhoDireito(no);
             no.setPai(no.getFIlhoEsquerdo());
             super.raiz = no.getFilhoEsquerdo()
             no.setFilhoEsquerdo(null);
             }
           fbRotaDireita(no, no.getPai());
           }
       else{
         if(no.getFilhoEsquerdo().getFilhoDireito() != null){
           No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo(), no);
           no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
           no.getFilhoDireito().setPai(no.getPai());
           no.setPai(no.getFilhoDireito());
           no.setFilhoDireito(novoNo);
           no.getPai().setFilhoEsquerdo(no);
           }
        else{
          if(no.getFatorBalanceamento() == -2){
            no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
           }
          else{
            no.getPai().setFilhoEsquerdo(no.getFIlhoEsquerdo());
             }
          no.getFilhoEsquerdo().setPai(no.getPai());
          no.setPai(no.getFIlhoEsquerdo());
          no.setFilhoEsquerdo(null);
          no.getPai().setFIlhoDIreito(no);
          }
          fbRotaDireita(no, no.getPai());
          }
          }            

