// Mago.java
package Model;

public class Mago {
    private int id;
    private String nome;
    private int vidas;

    public Mago(int id, String nome, int vidas) {
        this.id = id;
        this.nome = nome;
        this.vidas = vidas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
