public class Avl extends ABP{
    public Avl(Object elemento){
        super(elemento);
    }
    public void rotacaoSimplesDireita(No noDesbalanceado) {
        //Se o nó desequilibrado for a raiz
        if (noDesbalanceado == super.getRaiz()) {
            if (noDesbalanceado.getFilhoEsquerdo().getFilhoDireito() != null) {
                No novoPai = noDesbalanceado.getFilhoEsquerdo();
                No noBalanceado = noDesbalanceado;
                noBalanceado.setPai(novoPai);
                noBalanceado.setFilhoEsquerdo(novoPai.getFilhoDireito());
                novoPai.setFilhoDireito(noBalanceado);
                super.setRaiz(novoPai);
            } else {
                No novoPai = noDesbalanceado.getFilhoEsquerdo();
                No noBalanceado = noDesbalanceado;
                noBalanceado.setPai(novoPai);
                noBalanceado.setFilhoEsquerdo(null);
                novoPai.setFilhoDireito(noBalanceado);
                super.setRaiz(novoPai);
            }
            fbRotacaoDireita(noDesbalanceado, noDesbalanceado.getPai());
        }
        else{
            if(noDesbalanceado.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoPai = noDesbalanceado.getFilhoEsquerdo();
                No noBalanceado = noDesbalanceado;
                novoPai.setPai(noBalanceado.getPai());
                noBalanceado.setPai(novoPai);
                noBalanceado.setFilhoEsquerdo(novoPai.getFilhoDireito());
                novoPai.setFilhoDireito(noBalanceado);
            }
            else{
                if(noDesbalanceado.getFatorBalanceamento() == -2 || noDesbalanceado.getFatorBalanceamento() == 1){
                    noDesbalanceado.getPai().setFilhoDireito(noDesbalanceado.getFilhoDireito());
                }

                else{
                    noDesbalanceado.getPai().setFilhoDireito(no.getFilhoEsquerdo());
            }
                No noBalanceado = noDesbalanceado;
                No novoPai = noBalanceado.getFilhoEsquerdo();
                novoPai.setPai(noBalanceado.getPai());
                novoPai.setFilhoDireito(noBalanceado);
                noBalanceado.setPai(novoPai);
                noBalanceado.setFilhoEsquerdo(null);
        }
        fbRotacaoDireita(noDesbalanceado, noDesbalanceado.getPai());
    }
