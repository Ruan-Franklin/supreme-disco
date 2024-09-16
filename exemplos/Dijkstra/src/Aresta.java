public class Aresta {
    private Object valor;
    private int id;
    private int v1;
    private int v2;
    private boolean direcionada;
    private double peso;

    public Aresta(int id, int v1, int v2,Object valor, boolean direcionada, double peso){
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.valor = valor;
        this.direcionada = direcionada;
        this.peso = peso;
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
    public int v1(){
        return v1;
    }
    public void setV1(int v1){
        this.v1 = v1;
    }
    public int v2(){
        return v2;
    }
    public void setV2(int v2){
        this.v2 = v2;
    }
    public boolean isDirecionada(){
        return direcionada;
    }
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
}