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
        ArvoreAVL arvore = new ArvoreAVL(25);
        arvore.inserir(20);
        arvore.inserir(36);
        arvore.inserir(10);
        arvore.inserir(22);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(24);
        arvore.inserir(12);
        arvore.inserir(28);
        arvore.mostrarAVL();
        //Removendo
        arvore.remover(28);
        arvore.mostrarAVL();
        
}
}