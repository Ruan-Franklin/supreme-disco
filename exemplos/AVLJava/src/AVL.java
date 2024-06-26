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

}
