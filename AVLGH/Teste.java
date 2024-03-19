public class Teste {
    public static void main(String[] args) {
    
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
        System.out.println('\n');
        System.out.println("----------------------------------------------------------------");
        //Removendo
        arvore.removerAVL(12);
        arvore.removerAVL(24);
        arvore.removerAVL(40);
        arvore.removerAVL(36);
        arvore.inserir(2);
        arvore.mostrarAVL();
        
}
}