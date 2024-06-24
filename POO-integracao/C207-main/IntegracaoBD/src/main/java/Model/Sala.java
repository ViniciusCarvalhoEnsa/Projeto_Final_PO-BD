package Model;

// Definição da classe Sala dentro do pacote Model
public class Sala {

    // Declaração dos atributos privados da classe Sala
    private int id;         // Identificador único da sala
    private int numero;     // Número da sala

    // Construtor da classe Sala, recebe id e numero como parâmetros
    public Sala(int id, int numero) {
        this.id = id;       // Inicializa o atributo id com o valor recebido
        this.numero = numero;   // Inicializa o atributo numero com o valor recebido
    }

    // Método getter para obter o id da sala
    public int getId() {
        return id;  // Retorna o valor do atributo id
    }

    // Método getter para obter o número da sala
    public int getNumero() {
        return numero;  // Retorna o valor do atributo numero
    }
}
