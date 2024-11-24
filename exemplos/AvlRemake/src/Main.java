public class Main {
    public static void main(String[] args) {
        ABP arvore = new ABP(10);
        arvore.inserir(5);
        System.out.println(arvore.getRaiz().getFilhoEsquerdo().getElemento());
        arvore.inserir(15);
        System.out.println(arvore.getRaiz().getFilhoDireito().getElemento());
        arvore.inserir(3);
        System.out.println(arvore.getRaiz().getFilhoEsquerdo().getFilhoEsquerdo().getElemento());
        arvore.remover(3);
        arvore.remover(15);
        arvore.mostrarArvore();


    }
}