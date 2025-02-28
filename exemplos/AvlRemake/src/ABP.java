public class ABP {
    public No no;
    public No raiz;
    public int tamanho;
    public int contador = 0;

    public ABP(Object elemento) {
        raiz = new No(elemento, null);
        tamanho = 1;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public No pai(No no) {
        return no.getPai();
    }

    public boolean ehInterno(No no) {
        return no.temFilhoEsquerdo() || no.temFilhoDireito();
    }

    public boolean ehExterno(No no) {
        if (ehInterno(no)) {
            return false;
        }
        return true;
    }

    public boolean ehRaiz(No no) {
        return no == getRaiz();
    }

    public No busca(Object elemento, No no) {
        if (ehExterno(no)) {
            return no;
        }
        //Fazendo a busca pelo lado esquerdo
        else if ((int) no.getElemento() > (int) elemento) {
            if (no.getFilhoEsquerdo() != null) {
                return busca(elemento, no.getFilhoEsquerdo());
            }
        }
        //Elemento encontrado
        else if ((int) no.getElemento() == (int) elemento) {
            return no;
        } else if ((int) no.getElemento() < (int) elemento) {
            //Busca pelo lado direito
            if (no.getFilhoDireito() != null) {
                return busca(elemento, no.getFilhoDireito());
            }
        }
        return no;
    }

    public No inserir(Object elemento) {
        No paiAtual = busca(elemento, getRaiz());
        No novoNo = new No(elemento, paiAtual);
        if ((int) elemento < (int) paiAtual.getElemento()) {
            paiAtual.setFilhoEsquerdo(novoNo);
        }
        if ((int) elemento > (int) paiAtual.getElemento()) {
            paiAtual.setFilhoDireito(novoNo);
        }
        tamanho++;
        return novoNo;

    }

    public No remover(Object elemento) throws RemocaoInvalidaExcecao {
        No removido = busca(elemento, getRaiz());
        if (removido.getElemento() != elemento) {
            throw new RemocaoInvalidaExcecao("Elemento não encontrado");
        }
        //Quando o removido é uma folha
        if (ehExterno(removido)) {
            if (removido.ehFilhoEsquerdo()) {
                removido.getPai().setFilhoEsquerdo(null);
            }
            if (removido.ehFilhoDireito()) {
                removido.getPai().setFilhoDireito(null);
            }
        }
        //Quando o removido tem um filho
        else if (removido.temFilhoEsquerdo() && !removido.temFilhoDireito()) {
            if (removido.getPai().getFilhoEsquerdo() == removido) {
                removido.getPai().setFilhoEsquerdo(removido.getFilhoEsquerdo());
                removido.getFilhoEsquerdo().setPai(removido.getPai());
            } else {
                removido.getPai().setFilhoDireito(removido.getFilhoDireito());
                removido.getFilhoDireito().setPai(removido.getPai());
            }
            removido.setPai(null);
        } else if (removido.temFilhoDireito() && !removido.temFilhoEsquerdo()) {
            if (removido.getPai().getFilhoDireito() == removido) {
                removido.getPai().setFilhoDireito(removido.getFilhoDireito());
                removido.getFilhoDireito().setPai(removido.getPai());
            } else {
                removido.getPai().setFilhoEsquerdo(removido.getFilhoEsquerdo());
                removido.getFilhoEsquerdo().setPai(removido.getPai());
            }
            removido.setPai(null);
        } else { //No removido tem dois filhos, entao acha o sucessor
            No primeiroFilhoDireito = removido.getFilhoDireito();
            No sucessor = primeiroFilhoDireito;
            while (primeiroFilhoDireito.temFilhoEsquerdo()) {
                No sucessorAtualizado = primeiroFilhoDireito.getFilhoEsquerdo();
                sucessor = sucessorAtualizado;
            }
            Object novoElemento = sucessor.getElemento();
            remover(sucessor.getElemento());
            removido.setElemento(novoElemento);
        }
        tamanho--;
        return removido;
    }

    public int altura(No no){
        if(ehExterno(no)){
            return 0;
        }
        int altura = 0;
        if(no.temFilhoEsquerdo()){
            altura = Math.max(altura, altura(no.getFilhoEsquerdo()));
        }
        if(no.temFilhoDireito()){
            altura = Math.max(altura, altura(no.getFilhoDireito()));
        }
        return altura + 1;
    }
    public int profundidade(No no){
        if(ehRaiz(no)){
            return 0;
        }
        return 1 + profundidade(no.getPai());
    }
    public void emOrdem(No no, No matriz[][]){
        if(no.temFilhoEsquerdo()){
            emOrdem(no.getFilhoEsquerdo(), matriz);
        }
        matriz[profundidade(no)][contador++] = no;
        if(no.temFilhoDireito()){
            emOrdem(no.getFilhoDireito(), matriz);
        }
    }

    public void mostrarArvore(){
        No matriz [][] = new No [altura(raiz) + 1] [getTamanho()];
        contador = 0;
        emOrdem(raiz, matriz);
        for(int i = 0; i < altura(raiz) + 1; i++){
            for (int j = 0; j < tamanho; j++){
                if(matriz[i][j] == null){
                    System.out.print("\t");
                } else {
                    System.out.printf("\t" + (matriz[i][j]).getElemento() + "[%d]",(matriz[i][j]).getFatorBalanceamento());
                }
            }
            System.out.print("\n");
        }
        System.out.println("Tamanho: " + getTamanho());
    }
}


