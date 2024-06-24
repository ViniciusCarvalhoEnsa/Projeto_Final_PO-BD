// Inimigo.java
package Model;

// Definição da classe Inimigo dentro do pacote Model
public class Inimigo {

    // Declaração dos atributos privados da classe Inimigo
    private int id;         // Identificador único do inimigo
    private String nome;    // Nome do inimigo
    private int vidas;      // Quantidade de vidas do inimigo

    // Construtor da classe Inimigo, recebe id, nome e vidas como parâmetros
    public Inimigo(int id, String nome, int vidas) {
        this.id = id;       // Inicializa o atributo id com o valor recebido
        this.nome = nome;   // Inicializa o atributo nome com o valor recebido
        this.vidas = vidas; // Inicializa o atributo vidas com o valor recebido
    }

    // Método getter para obter o id do inimigo
    public int getId() {
        return id;  // Retorna o valor do atributo id
    }

    // Método getter para obter o nome do inimigo
    public String getNome() {
        return nome;  // Retorna o valor do atributo nome
    }

    // Método getter para obter a quantidade de vidas do inimigo
    public int getVidas() {
        return vidas;  // Retorna o valor do atributo vidas
    }
}
