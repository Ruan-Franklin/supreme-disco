import java.util.ArrayList;
import java.util.List;
public class ArvoreAVL extends ABP {
    private Object elemento;
    public List<No> nos = new ArrayList<No>();

    public ArvoreAVL(Object elemento) {
        super(elemento);
        setRaiz(new No(elemento));
    }
    public void inserir(Object elemento) throws NoInvalidoExcecao {
        if (estaVazia()) {
            setRaiz(new No(elemento));
        } else {
            No tmp = busca(elemento, raiz());
            No novoNo = new No(elemento);
            if ((int) elemento == (int) tmp.getElemento()) {
                throw new NoInvalidoExcecao("Elemento já existe!");
            } else if ((int) elemento > (int) tmp.getElemento()) {
                if (temDireito(tmp)) {
                    tmp.getFilhoDireito().setPai(novoNo);
                    if ((int) tmp.getFilhoDireito().getElemento() > (int) elemento) {
                        novoNo.setFilhoDireito(tmp.getFilhoDireito());
                    } else {
                        novoNo.setFilhoEsquerdo(tmp.getFilhoDireito());
                    }
                } else {
                    novoNo.setPai(tmp);
                }
                tmp.setFilhoDireito(novoNo);
                atualizaFatorBalanceamento(novoNo.getPai(), false, 1);

            } else {
                if (temEsquerdo(tmp)) {
                    tmp.getFilhoEsquerdo().setPai(novoNo);
                    if ((int) tmp.getFilhoEsquerdo().getElemento() <= (int) elemento) {
                        novoNo.setFilhoEsquerdo(tmp.getFilhoEsquerdo());
                    } else {
                        novoNo.setFilhoDireito(tmp.getFilhoEsquerdo());
                    }
                } else {
                    novoNo.setPai(tmp);
                }
                tmp.setFilhoEsquerdo(novoNo);
                atualizaFatorBalanceamento(novoNo.getPai(), true, 1);
            }
        }
    }

    public void remover(Object elemento) throws NoInvalidoExcecao {
        No tmp = busca(elemento, raiz());
        No noPai = tmp.getPai();
        boolean ehFilhoEsquerdo = ehFilhoEsquerdo(tmp);
        if (elemento != tmp.getElemento()) {
            throw new NoInvalidoExcecao("Elemento não existe!");
        }
        if (externo(tmp)) {
            if (tmp.getPai().getFilhoEsquerdo() == tmp) {
                tmp.getPai().setFilhoEsquerdo(null);
            } else {
                tmp.getPai().setFilhoDireito(null);
            }
            atualizaFatorBalanceamento(noPai, ehFilhoEsquerdo, 2);
        }
        else if(tmp.getFilhoDireito() == null){
            if(tmp.getPai().getFilhoDireito() == tmp){
                tmp.getPai().setFilhoDireito(tmp.getFilhoEsquerdo());
                tmp.getFilhoEsquerdo().setPai(tmp.getPai());
                atualizaFatorBalanceamento(noPai, ehFilhoEsquerdo, 2);
            }
            else{
                tmp.getPai().setFilhoEsquerdo(tmp.getFilhoDireito());
                tmp.getFilhoDireito().setPai(tmp.getPai());
                atualizaFatorBalanceamento(noPai, ehFilhoEsquerdo, 2);
            }
        }
        else{
            No minimo = tmp;
            minimo = tmp.getFilhoDireito();
            No pai = minimo.getPai();
            ehFilhoEsquerdo = ehFilhoEsquerdo(minimo);
            while(minimo.getFilhoEsquerdo() != null){
                minimo = minimo.getFilhoEsquerdo();
            }
            remover(minimo.getElemento());
            tmp.setElemento(minimo.getElemento());
            atualizaFatorBalanceamento(pai, ehFilhoEsquerdo, 2);
        }
    }
    

    public void atualizaFatorBalanceamento(No no, boolean FilhoEsquerdo, int controle){
        //Se for 1, insere
        if(controle == 1){
            if (FilhoEsquerdo){
                //Se for o filho esquerdo, o fator de balanceamento é incrementado
                no.setFatorBalanceamento(no.getFatorBalanceamento() + 1);
            } else{
                //Se for o filho direito, o fator de balanceamento é decrementado
                no.setFatorBalanceamento(no.getFatorBalanceamento() - 1);
            }
        }
        //Se for 2, remove
        else if(controle == 2){
            if (FilhoEsquerdo || raiz() == no){
                //Decrementa o fator de balanceamento
                no.setFatorBalanceamento(no.getFatorBalanceamento() - 1);
            }
            else{
                //Incrementa o fator de balanceamento
                no.setFatorBalanceamento(no.getFatorBalanceamento() + 1);
            }
            //Rotaciona para a esquerda
            if (no.getFatorBalanceamento() <= 2){
                No subArvoreDireita = no.getFilhoDireito();
                //Rotação simples à esquerda
                if (subArvoreDireita.getFatorBalanceamento() <= 0){
                    rotacaoSimplesEsquerda(no);
                }
                //Rotação dupla à esquerda
                else{
                    rotacaoSimplesDireita(subArvoreDireita);
                    rotacaoSimplesEsquerda(no);
                }

            }
            //Rotaciona para a direita
            else if(no.getFatorBalanceamento() >= 2){
                No subArvoreEsquerda = no.getFilhoEsquerdo();
                //Rotação simples à direita
                if (subArvoreEsquerda.getFatorBalanceamento() >= 0){
                    rotacaoSimplesDireita(no);
                }
                //Rotação dupla à direita
                else{
                    rotacaoSimplesEsquerda(subArvoreEsquerda);
                    rotacaoSimplesDireita(no);
                }
            }



         }
        //Caso não seja necessário rotacionar
        else if(no.getFatorBalanceamento() != 0 && no != raiz() && controle == 1){
            //Chama o método atualizaFatorBalanceamento para o pai do nó
            atualizaFatorBalanceamento(pai(no), ehFilhoEsquerdo(no), 1);
        }
        else if(no.getFatorBalanceamento() != 0 && no != raiz && controle == 2){
            //Chama o método atualizaFatorBalanceamento para o pai do nó
            atualizaFatorBalanceamento(pai(no), ehFilhoEsquerdo(no), 2);
        }
    }
    public void rotacaoSimplesEsquerda(No no){
        No novoNo = no.getFilhoDireito();
        if(temEsquerdo(novoNo)){
            no.setFilhoDireito(novoNo.getFilhoEsquerdo());
            novoNo.getFilhoEsquerdo().setPai(no);
            novoNo.setFilhoEsquerdo(no);
            if(no != raiz()){
                if (no == no.getPai().getFilhoEsquerdo()){
                    no.getPai().setFilhoEsquerdo(novoNo);
                }
                else{
                    no.getPai().setFilhoDireito(novoNo);
                }
                novoNo.setPai(no.getPai());
            }
            no.setPai(novoNo);
        }
        else{
            novoNo.setFilhoEsquerdo(no);
            if(no != raiz()){
                if (no == no.getPai().getFilhoEsquerdo()) {
                    no.getPai().setFilhoEsquerdo(novoNo);
                }
                else{
                    no.getPai().setFilhoDireito(novoNo);
                }
                novoNo.setPai(no.getPai());
            }
            no.setPai(novoNo);
            no.setFilhoDireito(null);
        }
        no.setFatorBalanceamento(no.getFatorBalanceamento() +1 - Math.min(novoNo.getFatorBalanceamento(), 0));
        novoNo.setFatorBalanceamento(novoNo.getFatorBalanceamento() +1 + Math.max(no.getFatorBalanceamento(), 0));
        if (no == raiz()){
            setRaiz(novoNo);
        }
    }

    public void rotacaoSimplesDireita(No no){
        No novoNo = no.getFilhoEsquerdo();
        if (temDireito(novoNo)){
            no.setFilhoEsquerdo(novoNo.getFilhoDireito());
            novoNo.getFilhoDireito().setPai(no);
            novoNo.setFilhoDireito(no);
            if(no != raiz()) {
                if (no == no.getPai().getFilhoEsquerdo()) {
                    no.getPai().setFilhoEsquerdo(novoNo);
                } else {
                    no.getPai().setFilhoDireito(novoNo);

                }
                novoNo.setPai(novoNo);
            }
        }
        else{
            novoNo.setFilhoDireito(no);
            if(no != raiz()){
                if(no == no.getPai().getFilhoEsquerdo()){
                    no.getPai().setFilhoEsquerdo(novoNo);
                }
                else{
                    no.getPai().setFilhoDireito(novoNo);
                }
                novoNo.setPai(no.getPai());
                no.setFilhoEsquerdo(null);
            }
        }
        //Atualizando fator balanceamento
        no.setFatorBalanceamento((no.getFatorBalanceamento()-1) - Math.max(no.getFatorBalanceamento(), 0));
        novoNo.setFatorBalanceamento((novoNo.getFatorBalanceamento() -1) + Math.min(no.getFatorBalanceamento(), 0));
        if(estirpe(no)){
            setRaiz(novoNo);
        }
    }


    public boolean ehFilhoEsquerdo(No no){
        return no.getPai().getFilhoEsquerdo() == no;
    }
    public boolean ehFIlhoDireito(No no){
        return no.getPai().getFilhoDireito() == no;
    }
    public void edificador(No no) {
        if (no.getFilhoEsquerdo() != null) {
            edificador(no.getFilhoEsquerdo());
        }
        nos.add(no);
        if (no.getFilhoDireito() != null) {
            edificador(no.getFilhoDireito());
        }
    }
    public int alturaTotal(No no){
        if(no == null){
            return -1;
        }
        else{
            return 1 + Math.max(alturaTotal(no.getFilhoEsquerdo()), alturaTotal(no.getFilhoDireito()));
        }
    }

    public void imprimirArvore(){
        edificador(raiz());
        int altura = alturaTotal(raiz());
        System.out.println("Árvore AVL de pesquisa binária");
        for(int i = 0 ; i <= altura ; i++){
            for(int j = 0 ; j < nos.size() ; j++){
                if(profundidade(nos.get(j)) == i){
                    System.out.print("\t"+nos.get(j).getElemento() + "[" + nos.get(j).getFatorBalanceamento() + "]");
            }
            else{
                System.out.print("\t");
                }
        }
        System.out.println();
    }
    nos.clear();
    }
}
