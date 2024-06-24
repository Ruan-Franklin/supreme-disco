
public class ABP {
    public No no;
    public No raiz;
    public int contador;
    public int tamanho;

    public ABP(Object elemento) {
        raiz = new No(elemento, null);
        this.contador = 0;
        this.tamanho = 1;
    }

    public No raiz() {
        return this.raiz;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return false;
        //A árvore sempre terá pelo menos a raiz
    }

    public No pai() {
        return this.no.getPai();
    }

    public boolean ehInterno(No no) {
        return (no.temFilhoDireito() || no.temFilhoEsquerdo());
    }

    public boolean ehExterno(No no) {
        return (no.temFilhoDireito() == false && no.temFilhoEsquerdo() == false);
    }

    public boolean ehRaiz(No no) {
        return no == raiz;
    }

    public No busca(Object elemento, No no) {
        if (ehExterno(no)) {
            return no;
        }
        //Buscando pelo lado esquerdo
        else if (no.getFilhoEsquerdo() != null) {
            return busca(elemento, no.getFilhoEsquerdo());
        }
        //Encontrou o elemento
        else if ((int) no.getElemento() == (int) elemento) {
            return no;
        }

        //Buscando pelo lado direito
        else if (no.getFilhoDireito() != null) {
            return busca(elemento, no.getFilhoDireito());
        }
        return no;
    }


    public No inserir(Object elemento) {
        No noProcurado = busca(elemento, raiz);
        No novoNo = new No(elemento, noProcurado);

        //Inserindo na esquerda
        if ((int) elemento < (int) noProcurado.getElemento()) {
            noProcurado.setFilhoEsquerdo(novoNo);
        } else {
            noProcurado.setFilhoDireito(novoNo);
        }
        tamanho++;
        return novoNo;
    }

    public No remover(Object elemento) throws RemocaoInvalidaExcecao {
        No removido = busca(elemento, raiz);
        if (removido.getElemento() != elemento) {
            throw new RemocaoInvalidaExcecao("O elemento " + elemento + "Não existe na árvore!");
        }
        // Quando o nó a ser removido NÃO TEM NENHUM FILHO
        if (ehExterno(removido)) {
            if ((int) removido.getElemento() < (int) removido.getPai().getElemento()) {
                removido.getPai().setFilhoEsquerdo(null);

            } else {
                removido.getPai().setFilhoDireito(null);
            }
            removido.setPai(null);
        }
        // Quando o nó a ser removido TEM UM FILHO
        else if (removido.temFilhoEsquerdo() && !(removido.temFilhoDireito())) {

            if (removido.getPai().getFilhoEsquerdo() == removido) { //Removendo filho esquerdo
                removido.getPai().setFilhoEsquerdo(removido.getFilhoEsquerdo());
                removido.getFilhoEsquerdo().setPai(removido.getPai());
            } else {
                removido.getPai().setFilhoDireito((removido.getFilhoDireito()));
                removido.getPai().setFilhoDireito(removido.getFilhoDireito());
            }
            removido.setPai(null);
        } else if (!(removido.temFilhoEsquerdo() && removido.temFilhoDireito())) {
            if (removido.getPai().getFilhoEsquerdo() == removido) { //Removendo filho esquerdo
                removido.getPai().setFilhoEsquerdo(removido.getFilhoEsquerdo());
                removido.getFilhoEsquerdo().setPai(removido.getPai());
            } else {
                removido.getPai().setFilhoDireito(removido.getFilhoDireito());
                removido.getFilhoDireito().setPai(removido.getPai());
            }
            removido.setPai(null);
        }
        //Quando o nó a ser removido tem dois filhos
        else {
            No no2 = removido.getFilhoDireito();

            while (no2.temFilhoEsquerdo()) {
                no2 = no2.getFilhoEsquerdo();
            }
            Object novoElemento = no2.getElemento();
            tamanho++;
            remover(no2.getElemento());
            removido.setElemento(novoElemento);
        }
        tamanho--;
        return removido;

    }




    public int altura(No no){
        if(ehExterno(no)){
            return 0;
        }
        int alt = 0;
        if(no.temFilhoEsquerdo()){
            alt = Math.max(alt, altura(no.getFilhoEsquerdo()));
        }
        if(no.temFilhoDireito()){
            alt = Math.max(alt, altura(no.getFilhoDireito()));
        }
        return 1 + alt;
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
        No matriz [][] = new No [altura(raiz) + 1] [tamanho()];
        contador = 0;
        emOrdem(raiz, matriz);
        for(int i = 0 ; i < altura(raiz) +1 ; i++){
            for(int j = 0 ; j < tamanho ; j++){
                if(matriz[i][j] == null){
                    System.out.print("\t");
                }
                else{
                    System.out.printf("\t" + (matriz[i][j]).getElemento() + "[%d]",(matriz[i][j]).getFatorBalanceamento());
                }
            }
            System.out.print("\n");
        }
        System.out.println("Tamanho: " + tamanho());

    }







}
