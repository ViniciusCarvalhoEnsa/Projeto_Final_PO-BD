import DAO.*;
import Model.*;

public class Main {
    public static void main(String[] args) {
        // Instanciando os DAOs necessários
        MagoDAO magoDAO = new MagoDAO();
        InimigoDAO inimigoDAO = new InimigoDAO();
        SalaDAO salaDAO = new SalaDAO();
        MagoSalaDAO magoSalaDAO = new MagoSalaDAO();
        SalaInimigoDAO salaInimigoDAO = new SalaInimigoDAO();

        // Inserir dados de exemplo

        // Exemplo de inserção de um Mago
        Mago mago1 = new Mago(1, "Gandalf", 3);
        magoDAO.insertMago(mago1);

        // Exemplo de inserçãjo de um Inimigo
        Inimigo inimigo1 = new Inimigo(1, "Orc", 2);
        inimigoDAO.insertInimigo(inimigo1);

        // Exemplo de inserção de uma Sala
        Sala sala1 = new Sala(1, 1);
        salaDAO.insertSala(sala1);

        // Relacionamentos N para M

        // Exemplo de inserção de relação Mago-Sala
        magoSalaDAO.insertMagoSala(mago1.getId(), sala1.getId());

        // Exemplo de inserção de relação Sala-Inimigo
        salaInimigoDAO.insertSalaInimigo(sala1.getId(), inimigo1.getId());
    }
}
