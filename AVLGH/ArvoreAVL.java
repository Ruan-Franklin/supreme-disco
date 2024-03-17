import java.util.ArrayList;
import java.util.List;
public class ArvoreAVL extends ABP {

    public ArvoreAVL(Object elemento) {
        super(elemento);
    }
    public void rotacaoSimplesDireita(No no){
        if(no == super.raiz()){
            if(no.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento(), no);
                no.setPai(no.getFilhoEsquerdo());
                no.getPai().setPai(null);
                no.getFilhoEsquerdo().setFilhoDireito(novoNo);
                no.setFilhoEsquerdo(novoNo);
                super.setRaiz(no.getPai());
            
        }
            else{
                no.getFilhoEsquerdo().setFilhoDireito(no);
                no.setPai(no.getFilhoEsquerdo());
                no.setFilhoEsquerdo(null);
                super.setRaiz(no.getPai());
            }
        fatorBalanceamentoRtDireita(no, no.getPai());
    }
        else{
            if(no.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento(), no);
                no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
                no.getFilhoEsquerdo().setPai(no.getPai());
                no.setPai(no.getFilhoEsquerdo());
                no.setFilhoEsquerdo(novoNo);
                no.getPai().setFilhoDireito(no);
            }
            else{
                if(no.getFatorBalanceamento() == -2 || no.getFatorBalanceamento() == 1){
                    no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
                }
                else{
                    no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
                }
                no.getFilhoEsquerdo().setPai(no.getPai());
                no.setPai(no.getFilhoEsquerdo());
                no.setFilhoEsquerdo(null);
                no.getPai().setFilhoDireito(no);
        }
        fatorBalanceamentoRtDireita(no, no.getPai());
    }
    }

    public void fatorBalanceamentoRtDireita(No noB, No noA){
        noB.setFatorBalanceamento(noB.getFatorBalanceamento() - 1 - Math.max(noA.getFatorBalanceamento(), 0));
        noA.setFatorBalanceamento(noA.getFatorBalanceamento() -1 + Math.min(noB.getFatorBalanceamento(), 0));
    }

    public void rotacaoSimplesEsquerda(No no){
        if (no == super.raiz()){
            if(no.getFilhoDireito().getFilhoEsquerdo() != null){
                No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento(), no);
                no.setPai(no.getFilhoDireito());
                no.getPai().setPai(null);
                no.getFilhoDireito().setFilhoEsquerdo(no);;
                no.setFilhoDireito(novoNo);
                super.setRaiz(no.getPai());
            }
            else{
                no.getFilhoDireito().setFilhoEsquerdo(no);
                no.setPai(no.getFilhoDireito());
                no.setFilhoDireito(null);
                super.setRaiz(no.getPai());
            }
            fatorBalanceamentoRtEsquerda(no, no.getPai());
    }
    else{
        if(no.getFilhoDireito().getFilhoEsquerdo() != null){
            No novo_no = new No(no.get_filho_direito().get_filho_esquerdo().get_elemento(), no);
            No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento(), no);
            no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
            no.getFilhoDireito().setPai(no.getPai());
            no.setPai(no.getFilhoDireito());
            no.set_filho_direito(novo_no);
            no.setFilhoDireito(novoNo);
            no.get_pai().set_filho_esquerdo(no);
            no.getPai().setFilhoEsquerdo(no);
        }
        else{
            if(no.getFatorBalanceamento == -2 || no.getFatorBalanceamento == 1){
                no.getPai().setFilhoDireito(no.getFilhoDireito());
            }
            else{
                no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
            }
            no.getFilhoDireito().setPai(no.getPai());
            no.setPai(no.getFilhoDireito());
            no.setFilhoDireito(null);
            no.getPai().setFilhoEsquerdo(no);
        }
        fatorBalanceamentoRtEsquerda(no, no.getPai());

    }
}

    public void fatorBalanceamentoRtEsquerda(No noB, No noA){
        noB.setFatorBalanceamento(noB.getFatorBalanceamento() + 1 - Math.min(noA.getFatorBalanceamento(), 0));
        noA.setFatorBalanceamento(noA.getFatorBalanceamento() + 1 + Math.max(noB.getFatorBalanceamento(), 0));
    }
    public No busca(Object elemento, No no){
        No noProcurado = super.busca(elemento, super.raiz());
        return noProcurado;
    }

    public No remover(Object elemento) throws NoInvalidoExcecao{
        No removido = busca(elemento);
        if(removido.getElemento() != elemento){
            throw new NoInvalidoExcecao("Elemento não existe!");
        }
        //Se o nó removido for a raiz
        if(estirpe(removido)){
            removido.setElemento(null);
            System.out.println("Raiz removida, árvore vazia!");
            return removido;
        }
        //Se o nó removido for uma folha
        if(externo(removido)){
            No pai = removido.getPai();
            //Remoção do nó esquerdo
            if((int) removido.getElemento() < (int) removido.getPai().getElemento()){
                while(pai != super.raiz() && pai.getFatorBalanceamento() != 2 && pai.getFatorBalanceamento() != 0 || pai != super.raiz() && pai.getFatorBalanceamento() != -2 && pai.getFatorBalanceamento() != 0){
                    pai.setFatorBalanceamento(pai.getFatorBalanceamento() - 1);
                    if(pai.getFatorBalanceamento() == 2 || pai.getFatorBalanceamento() == -2){
                        pai.getPai().setFatorBalanceamento(pai.getPai().getFatorBalanceamento() +1);
                        break;
                    }
                    pai = pai.getPai();
        }
        if(pai == super.raiz()){
            pai.setFatorBalanceamento(pai.getFatorBalanceamento() - 1);
        }
        removido.getPai().setFilhoEsquerdo(null);
        if(pai.getFatorBalanceamento() == -2){
            rotacaoSimplesEsqRemove(pai);
        }
    }
    //Remoção do nó direito
        else{
                while(pai != super.raiz() && pai.getFatorBalanceamento() != 2 && pai.getFatorBalanceamento() != 0 || pai != super.raiz() && pai.getFatorBalanceamento() != -2 && pai.getFatorBalanceamento() != 0){
                    pai.setFatorBalanceamento(pai.getFatorBalanceamento() + 1);
                    if(pai.getFatorBalanceamento() == 2 || pai.getFatorBalanceamento() == -2){
                        pai.getPai().setFatorBalanceamento(pai.getPai().getFatorBalanceamento() -1);
                        break;
                    }
                    pai = pai.getPai();
        }
                mostrarAVL();
                if(pai == super.raiz()){
                    pai.setFatorBalanceamento(pai.getFatorBalanceamento() + 1);
                }
                removido.getPai().setFilhoDireito(null);
                if(pai.getFatorBalanceamento() == 2){
                    rotacaoSimplesDirRemove(pai);
                }
        }
            pai = removido;
    }
        tamanho--;
        return removido;
    }
    public void rotacaoSimplesEsqRemove(No no){
        if (no == super.raiz()){
            if(no.getFilhoDireito().getFilhoEsquerdo() != null){
                no.setPai(no.getFilhoDireito());
                no.getPai().setPai(null);
                super.setRaiz(no.getPai());
                no.getFilhoDireito().setFilhoEsquerdo(no);
                no.setFilhoDireito(novoNo);
            }
            else{
                no.getFilhoDireito().setFilhoEsquerdo(no);
                no.setPai(no.getFilhoDireito());
                super.setRaiz(no.getFilhoDireito());
                no.setFilhoDireito(null);
            }
            fatorBalanceamentoRtEsquerda(no, no.getPai());
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
                    no.getLai().setFilhoDireito(no.getFilhoDireito());
            }
               else{
                no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
               }
               no.getFilhoDireito().setPai(no.getPai());
               no.setPai(no.getFilhoDireito());
               no.setFilhoDireito(null);
               no.getPai().setFilhoEsquerdo(no);
        }
        fbRotaEsquerda(no, no.getPai());

    }
}
    public void rotacaoSimplesDirRemove(No no){
        if(no == super.raiz()){
            if(no.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento(), no);
                no.setPai(no.getFilhoEsquerdo());
                no.getPai().setPai(null);
                super.raiz = no.getFilhoEsquerdo();
                no.getFilhoEsquerdo().setFilhoDireito(no);
                no.setFilhoEsquerdo(novo_no);
            }
            else{
                no.getFilhoEsquerdo().setFilhoDireito(no);
                no.setPai(no.getFilhoEsquerdo());
                super.setRaiz(no.getFilhoEsquerdo());
                no.setFilhoEsquerdo(null);
            }
            fatorBalanceamentoRtDireita(no, no.getPai());
        }
        else{
            if(no.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento(), no);
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
                    no.getPai().setFilhoEsquerdo(no.getFilhoEsquerdo());
                }
                no.getFilhoEsquerdo().setPai(no.getPai());
                no.setPai(no.getFilhoEsquerdo());
                no.setFilhoEsquerdo(null);
                no.getPai().setFilhoDireito(no);
            }
            fatorBalanceamentoRtDireita(no, no.getPai());
    }
}
    public No inserir(Object elemento){
        No no = super.inserir(elemento);
        if(no.ehFilhoEsquerdo()){
            no.getPai().setFatorBalanceamento(no.getPai().geFatorBalanceamento() + 1);
            no = no.getPai();
        }
        else{
            no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() - 1);
            no = no.getPai();
        }
        while(no.getFatorBalanceamento() != 0 && no != super.raiz() && no.get_fator_balanceamento()  != 2  && no.get_fator_balanceamento() != -2){
            if(no.ehFilhoEsquerdo()){
                no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() + 1);
            }
            else{
                no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() - 1);
            }
            no = no.getPai();
        }
        if(no.getFatorBalanceamento() == 2 && no.getFilhoEsquerdo().getFatorBalanceamento() == 1){
            System.out.println("Rotaçao simples para direita");
            mostrarAVL();
            System.out.println("-------------------------------------------------");
            rotacaoSimplesDireita(no);
            mostrarAVL();
    }
    else if (no.getFatorBalanceamento() == -2 && no.getFilhoDireito().getFatorBalanceamento() == -1){
        System.out.println("Rotaçao simples para esquerda");
        mostrarAVL();            
        System.out.println("-------------------------------------------------");
        rotacaoSimplesEsquerda(no);
        mostrarAVL();
    }
    else if (no.getFatorBalanceamento() == 2 && no.getFilhoEsquerdo().getFatorBalanceamento() == -1){
        System.out.println("Rotaçao simples para esquerda e rotação simples direita = Rotaçao Dupla a direita");
        mostrarAVL();
        System.out.println("-------------------------------------------------");
        no = no.getFilhoEsquerdo();
        rotacaoSimplesEsquerda(no);
        System.out.println("key:" + no.getElemento());
        mostrarAVL();
        System.out.println("-------------------------------------------------");
        rotacaoSimplesDireita(no.getPai().getPai());
        mostrarAVL();
    }
    else if (no.getFatorBalanceamento() == -2 && no.getFilhoDireito().getFatorBalanceamento() == 1){
        System.out.println("Rotaçao simples para direita e rotação simples esquerda = Rotaçao Dupla a esquerda");
        mostrarAVL();
        System.out.println("-------------------------------------------------");
        System.out.println("key:" + no.getElemento());
        no = no.getFilhoDireito();
        rotacaoSimplesDireita(no);
        mostrarAVL();
        System.out.println("-------------------------------------------------");
        rotacaoSimplesEsquerda(no.getPai().getPai());
        mostrarAVL();
    }
    return no;
    }
}    
   
