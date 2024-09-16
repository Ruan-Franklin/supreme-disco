public class Vertice {
    private Object valor;
    private int id;

    public Vertice(Object valor){
        this.valor = valor;
    }

    public Object getValor(){
        return valor;
    }
    public void setValor(Object valor){
        this.valor = valor;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}