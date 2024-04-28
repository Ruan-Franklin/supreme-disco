public class ArvoreBTest {
    public static void main(String[] args) {
        testInserir();
        testBuscar();
        testRemover();
    }

    public static void testInserir() {
        ArvoreB arvore = new ArvoreB(3); // Grau mínimo 3
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.mostrar(arvore.raiz); // Verifica se as chaves foram inseridas corretamente
    }

    public static void testBuscar() {
        ArvoreB arvore = new ArvoreB(3);
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(5);
        arvore.inserir(6);
        Pagina pagina = arvore.busca(arvore.raiz, 20);
        if (pagina != null) {
            System.out.println("Chave encontrada!");
        } else {
            System.out.println("Chave não encontrada!");
        }
    }

    public static void testRemover() {
        ArvoreB arvore = new ArvoreB(3);
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.remover(arvore.raiz, 20);
        arvore.mostrar(arvore.raiz); // Verifica se a chave foi removida corretamente
    }
}
