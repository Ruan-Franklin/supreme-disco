public class Teste {
    public static void main(String[] args) {
    
        ArvoreAVL arvore = new ArvoreAVL(1);
        arvore.inserirAVL(2);
        arvore.inserirAVL(3);
        arvore.inserirAVL(4);
        arvore.inserirAVL(5);
        //Removendo
        System.out.println("Após a remoção do nó 3:");

        arvore.removerAVL(3);
        arvore.mostrarAVL();

        
}
}