public class Teste {
    public static void main(String[] args) {
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
        //Impressão da árvore
        arvore.imprimirArvore();
    }
}