//RELAÇÃO DE 1 PARA N, RELACIONA SALAS E INIMIGOS. SENDO SALA 1 E INIMIGOS N.
//RELAÇÃO DE M PARA N. SENDO QUE VARIAS SALAS PODEM SER ASSOCIADAS A DIVERSOS TIPOS DE INIMIGOS.

package DAO;

import java.sql.SQLException; // Importa SQLException para tratamento de exceções SQL

public class SalaInimigoDAO extends ConnectionDAO {

    // Método para inserir uma associação entre sala e inimigo no banco de dados
    public boolean insertSalaInimigo(int salaId, int inimigoId) {
        connectToDB(); // Estabelece conexão com o banco de dados (método herdado de ConnectionDAO)
        String sql = "INSERT INTO SalaInimigo (sala_id, inimigo_id) VALUES (?, ?)"; // Query SQL para inserção
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, salaId); // Define o primeiro parâmetro da query (sala_id)
            pst.setInt(2, inimigoId); // Define o segundo parâmetro da query (inimigo_id)
            pst.execute(); // Executa a query
            return true; // Retorna verdadeiro se a inserção for bem-sucedida
        } catch (SQLException exc) { // Captura exceções SQL
            System.out.println("Erro: " + exc.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na inserção
        }
    }

    // Método para excluir uma associação entre sala e inimigo no banco de dados
    public boolean deleteSalaInimigo(int salaId, int inimigoId) {
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "DELETE FROM SalaInimigo WHERE sala_id = ? AND inimigo_id = ?"; // Query SQL para exclusão
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, salaId); // Define o primeiro parâmetro da query (sala_id)
            pst.setInt(2, inimigoId); // Define o segundo parâmetro da query (inimigo_id)
            pst.execute(); // Executa a query
            return true; // Retorna verdadeiro se a exclusão for bem-sucedida
        } catch (SQLException ex) { // Captura exceções SQL
            System.out.println("Erro: " + ex.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na exclusão
        }
    }
}
