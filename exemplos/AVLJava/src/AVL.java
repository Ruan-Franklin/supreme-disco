public class AVL extends  ABP{
    public AVL(Object elemento) {
        super(elemento);
    }
    public void rotacaoSimplesDireita(No noAtual){
        if(noAtual == super.raiz){
            if(noAtual.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(noAtual.getFilhoEsquerdo().getFilhoDireito().getElemento(), noAtual);
                noAtual.setPai(noAtual.getFilhoEsquerdo());
                noAtual.getPai().setPai(null);
                noAtual.getFilhoEsquerdo().setFilhoDireito(noAtual);
                noAtual.setFilhoEsquerdo(novoNo);
                super.raiz = noAtual.getPai();
            }
            else{
                noAtual.getFilhoEsquerdo().setFilhoDireito(noAtual);
                noAtual.setPai(noAtual.getFilhoDireito());
                noAtual.setFilhoEsquerdo(null);
                super.raiz = noAtual.getPai();
            }
            fatorBalanceamentoRotacaoDireita(noAtual, noAtual.getPai());
        }
        else{
            if(noAtual.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(noAtual.getFilhoEsquerdo().getFilhoDireito().getElemento(), noAtual);
                noAtual.getPai().setFilhoDireito(noAtual.getFilhoEsquerdo());
                noAtual.getFilhoEsquerdo().setPai(noAtual.getPai());
                noAtual.setPai(noAtual.getFilhoEsquerdo());
                noAtual.setFilhoEsquerdo(novoNo);
                noAtual.getPai().setFilhoDireito(noAtual);

            }
            else{
                if(noAtual.getFatorBalanceamento() == -2 || noAtual.getFatorBalanceamento() == 1){
                    noAtual.getPai().setFilhoDireito(noAtual.getFilhoEsquerdo());
                }
                else{
                    noAtual.getPai().setFilhoEsquerdo(noAtual.getFilhoEsquerdo());
                }
                noAtual.getFilhoEsquerdo().setPai(noAtual.getPai());
                noAtual.setPai(noAtual.getFilhoEsquerdo());
                noAtual.setFilhoEsquerdo(null);
                noAtual.getPai().setFilhoDireito(noAtual);
            }
            fatorBalanceamentoRotacaoDireita(noAtual, noAtual.getPai());
        }
    }

    public void fatorBalanceamentoRotacaoDireita(No noB, No noA){
        noB.setFatorBalanceamento(noB.getFatorBalanceamento() -1 - Math.max(noA.getFatorBalanceamento(), 0));
        noA.setFatorBalanceamento(noA.getFatorBalanceamento() -1 + Math.min(noB.getFatorBalanceamento(), 0));

    }
}
