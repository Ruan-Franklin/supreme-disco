import java.util.ArrayList;
public class ABP implements IABP {
    public No raiz;
    protected int tamanho;
    public int contador;

    //Construtor da classe Arvore Binária de Pesquisa
    public ABP(Object elemento) {
        //Criação da raiz da árvore
        this.raiz = new No(elemento);
        this.tamanho = 1;
    }

    @Override
    public No busca(Object chave, No noAtual) {
        //Verifica se o nó atual é uma folha
        if (externo(noAtual)) {
            //Se for uma folha, retorna o nó atual
            return noAtual;
        }
        //Se a chave for menor que o elemento do nó atual
        if ((int) chave < (int) noAtual.getElemento()) {
            //Chama a função de busca para o filho esquerdo do nó atual
            if (temEsquerdo(noAtual)) {
                return busca(chave, noAtual.getFilhoEsquerdo());
            }
            return noAtual;
        }
        //Se a chave for igual ao elemento do nó atual
        if ((int) chave == (int) noAtual.getElemento()) {
            //Retorna o nó atual
            return noAtual;
        }
        //Se a chave for maior que o elemento do nó atual
        if ((int) chave > (int) noAtual.getElemento()) {
            //Chama a função de busca para o filho direito do nó atual
            if (temDireito(noAtual)) {
                return busca(chave, noAtual.getFilhoDireito());
            }
            return noAtual;
        }
        return noAtual;


    }

    @Override
    public boolean externo(No no) {
        return (no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null);
    }

    @Override
    public boolean temEsquerdo(No no) {
        return no.getFilhoEsquerdo() != null;
    }

    public boolean temDireito(No no) {
        return no.getFilhoDireito() != null;
    }

    @Override
    public No filhoEsquerdo(No no) {
        return no.getFilhoEsquerdo();
    }

    @Override
    public No filhoDireito(No no) {
        return no.getFilhoDireito();
    }

    @Override
    public boolean estaVazia() {
        //Sempre retorna false, pois não permitiremos a remoção da raiz
        return false;
    }

    @Override
    public No raiz() {
        return raiz;
    }

    @Override
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    @Override
    public boolean estirpe(No no) {
        return no == raiz;
    }

    @Override
    public No pai(No no) {
        return no.getPai();
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public int profundidade(No no) {
        if (estirpe(no)) {
            return 0;
        }
        return 1 + profundidade(pai(no));
    }

    @Override
    public Object substitui(No no, Object elemento) {
        Object item = no.getElemento();
        no.setElemento(elemento);
        return item;
    }

    public int altura(No no) {
        //Se for uma folha, retorna 0, porque a altura da folha é 0
        if (externo(no)) {
            return 0;
        }
        //Se não for uma folha, retorna 1 + a maior altura entre os filhos
        else {
            int altura1 = 0;

            if (temEsquerdo(no)) {
                altura1 = 1 + altura(no.getFilhoEsquerdo());
            }
            int altura2 = 0;
            if (temDireito(no)) {
                altura2 = 1 + altura(no.getFilhoDireito());
            }
            if (altura1 > altura2) {
                return altura1;
            }
            return altura2;
        }
    }

    public boolean interno(No no) {
        return no.getFilhoDireito() != null || no.getFilhoEsquerdo() != null;
    }

    @Override
    public No inserir(Object elemento) {

        //Encontra o local apropriado para inserir o elemento
        No temp = busca(elemento, raiz);
        //Cria o nó a ser inserido com o elemento
        No novoNo = new No(elemento);
        //Verifica se o elemento inserido já existe na árvore
        if (elemento.equals(temp.getElemento())){
            throw new NoInvalidoExcecao("Elemento " + elemento + " já existe na árvore");

        }
        //Inserção na direita
        //Se o elemento for maior que o elemento do nó encontrado
        else if ((int) elemento > (int) temp.getElemento()) {
            if (temDireito(temp)) {
                temp.getFilhoDireito().setPai(novoNo);
                if ((int) temp.getFilhoDireito().getElemento() > (int) elemento) {
                    novoNo.setFilhoDireito(temp.getFilhoDireito());
                } else {
                    novoNo.setFilhoEsquerdo((temp.getFilhoDireito()));
                }
            } else {
                novoNo.setPai(temp);
            }
            temp.setFilhoDireito(novoNo);
        } else if (temEsquerdo(temp)) {
            temp.getFilhoEsquerdo().setPai(novoNo);
            if ((int) temp.getFilhoEsquerdo().getElemento() <= (int) elemento) {
                novoNo.setFilhoEsquerdo(temp.getFilhoEsquerdo());
            } else {
                novoNo.setFilhoDireito(temp.getFilhoEsquerdo());
            }
        } else {
            novoNo.setPai(temp);
            temp.setFilhoEsquerdo(novoNo);
        }
        tamanho++;
        return novoNo;
    }
    @Override
    public void remover(Object chave) {
        No temp = busca(chave, raiz);
        if(chave != temp.getElemento()){
            throw new NoInvalidoExcecao("Chave " + chave +  "não encontrada");
        }
        //Se o nó a ser removido for uma folha (não tem filhos)
        if(externo(temp)){
            //Remover a folha ajustando o ponteiro do pai
            if(temp.getPai().getFilhoEsquerdo().equals(temp)){
                temp.getPai().setFilhoEsquerdo(null);
            }
            else{
                temp.getPai().setFilhoDireito(null);
            }
        }
        //Se o nó a ser removido tiver apenas um filho
        else if(temp.getFilhoDireito() == null){
            //Remover o nó ajustando o ponteiro do pai para o filho não nulo
            if(temp.getPai().getFilhoDireito().equals(temp)){
                temp.getPai().setFilhoDireito(temp.getFilhoEsquerdo());
                temp.getFilhoEsquerdo().setPai(temp.getPai());
            }
            else{
                temp.getPai().setFilhoEsquerdo(temp.getFilhoDireito());
                temp.getFilhoDireito().setPai(temp.getPai());
            }
        }
        //Se não for nenhuma dessas condições, quer dizer que o nó tem dois filhos
        else{
            //Encontrar o sucessor in order
            No minimo = temp;
            minimo = minimo.getFilhoDireito();
            while(minimo.getFilhoEsquerdo() != null){
                minimo = minimo.getFilhoEsquerdo();
            }
            //Remover o sucessor in order recursivamente
            remover(minimo.getElemento());
            //Substitui o elemento do nó a ser removido pelo elemento do sucessor in order
            temp.setElemento(minimo.getElemento());
        }
        tamanho--;
    }
    @Override
    public void preOrdem(No no){
        //Se o nó não for nulo
        if(no != null){
            System.out.println("Elemento: " + no.getElemento());
            if(no.getFilhoDireito() != null){
                //Chama a função recursivamente para o filho direito
                preOrdem(no.getFilhoDireito());
            }
            else if (no.getFilhoEsquerdo() != null){
                //Chama a função recursivamente para o filho esquerdo
                preOrdem(no.getFilhoEsquerdo());
            }
        }
    }
    @Override
    public void emOrdem(No no){
        //Se o nó não for nulo
        if(no != null){
            if(no.getFilhoDireito() != null){
                //Chama o pré-ordem  para o filho direito
                preOrdem(no.getFilhoDireito());
            }
            System.out.println("Elemento: " + no.getElemento());
            if(no.getFilhoEsquerdo() != null){
                //Chama o pré-ordem  para o filho esquerdo
                preOrdem(no.getFilhoEsquerdo());
            }
        }
    }
    @Override
    public void posOrdem(No no){
        //Se o nó não for nulo
        if(no != null){
            if(no.getFilhoDireito() != null){
                //Chama o pré-ordem  para o filho direito
                preOrdem(no.getFilhoDireito());
            }
            else if(no.getFilhoEsquerdo() != null){
                //Chama o pré-ordem  para o filho esquerdo
                preOrdem(no.getFilhoEsquerdo());
            }
            System.out.println("Elemento: " + no.getElemento());
        }
    }
    protected void mostrarEmOrdem(ArrayList<No> itens, No no){
        if(no.getFilhoEsquerdo() != null){
            //Chama recursivamente   para o filho esquerdo
            mostrarEmOrdem(itens, no.getFilhoEsquerdo());
        }
        itens.add(no);
        if(no.getFilhoDireito() != null){
            //Chama recursivamente   para o filho direito
            mostrarEmOrdem(itens, no.getFilhoDireito());
        }
    }
    @Override
    public void imprimirArvore(){
        //Cria uma lista para armazenar os itens da árvore em ordem
        ArrayList<No> itens = new ArrayList<>();
        // Preenche a lista com os elementos da árvore na ordem correta (in-order traversal)
        mostrarEmOrdem(itens, raiz);
        System.out.println("ABP: ");
        //Loop para iterar sobre cada nível da árvore
        for(int c = 0 ; c <= altura(raiz) ; c++){
            //Loop para iterar sobre cada elemento da lista
            for(int i = 0 ; i < tamanho() ;  i++){
                //Verifica se o nó na posição i tem a profundidade c
                if(profundidade(itens.get(i)) == c){
                    //Imprime o elemento do nó
                    System.out.print("{ " + itens.get(i).getElemento() + " }");
                }
                //Se não tiver, imprime um espaço em branco
                else{
                    System.out.print(" ");
                }
            }
            //Imprime uma quebra de linha para separar os níveis da árvore
            System.out.println();
        }
    }

    public void AVLEmOrdem(No no, No matriz[][]){
        if(no.getFilhoEsquerdo() != null ){
            AVLEmOrdem(no.getFilhoEsquerdo(), matriz);}
        matriz[profundidade(no)][contador++] = no;

        if(no.getFilhoDireito() != null){
            AVLEmOrdem(no.getFilhoDireito(), matriz);
        }
    }
    public void mostrarAVL(){
        No matriz [][] = new No [altura(raiz) + 1] [tamanho()];
        contador = 0;
        AVLEmOrdem(raiz, matriz);
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
    }
    




}