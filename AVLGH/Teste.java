public class Teste {
    public static void main(String[] args) {
        /* 
        System.out.println(" Árvore Binária de Pesquisa");
        //Criação da árvore com a raiz
        ABP arvore = new ABP(6);
        //Inserção dos elementos
        arvore.inserir(2);
        arvore.inserir(8);
        arvore.inserir(1);
        arvore.inserir(4);
        arvore.inserir(3);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(10);
        //Impressão da árvore
        arvore.imprimirArvore(); */
        //AVL
        ArvoreAVL avl = new ArvoreAVL(2);
        avl.inserir(3);
        avl.inserir(4);
        avl.inserir(5);
        avl.inserir(6);
        avl.inserir(7);
        avl.inserir(8);
        avl.inserir(1);
        avl.imprimirArvore();
    }

}