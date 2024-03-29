import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
public class ArvoreAVL extends ABP {
    private List<No> nos = new ArrayList<No>();

    public ArvoreAVL(Object elemento) {
        super(elemento);
    }
    public void rotacaoSimplesDireita(No no){
        if(no == super.raiz()){
            if(no.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento());
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
                No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento());
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
        if (no == super.raiz){
            if(no.getFilhoDireito().getFilhoEsquerdo() != null){
                No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento());
                no.setPai(no.getFilhoDireito());
                no.getPai().setPai(null);
                no.getFilhoDireito().setFilhoEsquerdo(no);
                no.setFilhoDireito(novoNo);
                super.raiz = no.getPai();
            }
            else{
                no.getFilhoDireito().setFilhoEsquerdo(no);
                no.setPai(no.getFilhoDireito());
                no.setFilhoDireito(null);
                super.raiz = no.getPai();
            }
            fatorBalanceamentoRtEsquerda(no, no.getPai());
    }
    else{
        if(no.getFilhoDireito().getFilhoEsquerdo() != null){
            No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento());
            no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
            no.getFilhoDireito().setPai(no.getPai());
            no.setPai(no.getFilhoDireito());
            no.setFilhoDireito(novoNo);
            no.getPai().setFilhoEsquerdo(no);
        }
        else{
            if(no.getFatorBalanceamento() == -2 || no.getFatorBalanceamento() == 1){
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
        No noProcurado = super.busca(elemento, no);
        return noProcurado;
    }

    public No removerAVL(Object elemento) throws NoInvalidoExcecao{
        No removido = busca(elemento, super.raiz());
        if(removido.getElemento() != elemento){
            throw new NoInvalidoExcecao("Elemento não existe!");
        }
        //Se o nó removido for a raiz
        if(estirpe(removido)){
            removido.setElemento(null);
            System.out.println("Raiz removida, árvore vazia!");
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
            while (pai != super.raiz && pai.getFatorBalanceamento() != 2 && pai.getFatorBalanceamento() != 0 || pai != super.raiz && pai.getFatorBalanceamento() != -2 && pai.getFatorBalanceamento() != 0) {
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
                no.setFilhoDireito(null);
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
                No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento());
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
               no.getFilhoDireito().setPai(no.getPai());
               no.setPai(no.getFilhoDireito());
               no.setFilhoDireito(null);
               no.getPai().setFilhoEsquerdo(no);
        }
        fatorBalanceamentoRtEsquerda(no, no.getPai());

    }
}
    public void rotacaoSimplesDirRemove(No no){
        if(no == super.raiz()){
            if(no.getFilhoEsquerdo().getFilhoDireito() != null){
                No novoNo = new No(no.getFilhoEsquerdo().getFilhoDireito().getElemento());
                no.setPai(no.getFilhoEsquerdo());
                no.getPai().setPai(null);
                super.raiz = no.getFilhoEsquerdo();
                no.getFilhoEsquerdo().setFilhoDireito(no);
                no.setFilhoEsquerdo(novoNo);
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
                No novoNo = new No(no.getFilhoDireito().getFilhoEsquerdo().getElemento());
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
    public No inserirAVL(Object elemento){
        No no = super.inserir(elemento);
        if(ehFilhoEsquerdo(no)){
            no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() + 1);
            no = no.getPai();
        }
        else{
            no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() - 1);
            no = no.getPai();
        }
        while(no.getFatorBalanceamento() != 0 && no != super.raiz() && no.getFatorBalanceamento()  != 2  && no.getFatorBalanceamento() != -2){
            if(ehFilhoEsquerdo(no)){
                no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() + 1);
            }
            else{
                no.getPai().setFatorBalanceamento(no.getPai().getFatorBalanceamento() - 1);
            }
            no = no.getPai();
        }
        if(no.getFatorBalanceamento() == 2 && no.getFilhoEsquerdo().getFatorBalanceamento() == 1){
            System.out.println("Rotaçao simples para a  direita");
            mostrarAVL();
            System.out.println("____________________________________");
            rotacaoSimplesDireita(no);
            mostrarAVL();
    }
    else if (no.getFatorBalanceamento() == -2 && no.getFilhoDireito().getFatorBalanceamento() == -1){
        System.out.println("O FB de algum elemento chegou a -2, então, Rotaçao simples para a esquerda");
        mostrarAVL();            
        System.out.println("___________________________________________________");
        rotacaoSimplesEsquerda(no);
        mostrarAVL();
    }
    else if (no.getFatorBalanceamento() == 2 && no.getFilhoEsquerdo().getFatorBalanceamento() == -1){
        System.out.println("O FB de algum elemento chegou A 2 e um dos descedentes tem FB -1, então Rotaçao Dupla  para a direita");
        mostrarAVL();
        System.out.println("________________________________________________");
        no = no.getFilhoEsquerdo();
        rotacaoSimplesEsquerda(no);
        System.out.println("key:" + no.getElemento());
        mostrarAVL();
        System.out.println("_______________________________________");
        rotacaoSimplesDireita(no.getPai().getPai());
        mostrarAVL();
    }
    else if (no.getFatorBalanceamento() == -2 && no.getFilhoDireito().getFatorBalanceamento() == 1){
        System.out.println("O FB de algum dos elementos chegou a a -2 e um dos seus descedentes é igual a 1, então, Rotaçao Dupla para a esquerda");
        mostrarAVL();
        System.out.println("_________________________________________________");
        System.out.println("key:" + no.getElemento());
        no = no.getFilhoDireito();
        rotacaoSimplesDireita(no);
        mostrarAVL();
        System.out.println("______________________________________________________");
        rotacaoSimplesEsquerda(no.getPai().getPai());
        mostrarAVL();
    }
    return no;
    }
    public boolean ehFilhoDireito(No no){
        return no.getPai().getFilhoDireito() == no;
    }
    public boolean ehFilhoEsquerdo(No no){
        return no.getPai().getFilhoEsquerdo() == no;
    }

  
   

    public int alturaBalanceada(No no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = (no.getFilhoEsquerdo() != null) ? alturaBalanceada(no.getFilhoEsquerdo()) : 0;
        int alturaDireita = (no.getFilhoDireito() != null) ? alturaBalanceada(no.getFilhoDireito()) : 0;
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int calcularFatorBalanceamento(No no) {
        int alturaEsquerda = (no.getFilhoEsquerdo() != null) ? alturaBalanceada(no.getFilhoEsquerdo()) : 0;
        int alturaDireita = (no.getFilhoDireito() != null) ? alturaBalanceada(no.getFilhoDireito()) : 0;
        return alturaEsquerda - alturaDireita;
}
}