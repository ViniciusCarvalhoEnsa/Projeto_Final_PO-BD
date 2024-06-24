// RELAÇÃO DE 1 PARA N. SENDO 1 O MAGO E SALA N.
// RELAÇÃO DE M PARA N. SENDO QUE VARIOS MAGOS PODEM ESTAR RELACIONADOS A DIFERENTES SALAS.

package DAO;

import java.sql.SQLException; // Importa SQLException para tratamento de exceções SQL

public class MagoSalaDAO extends ConnectionDAO {

    // Método para inserir uma associação entre mago e sala no banco de dados
    public boolean insertMagoSala(int magoId, int salaId) {
        connectToDB(); // Estabelece conexão com o banco de dados (método herdado de ConnectionDAO)
        String sql = "INSERT INTO MagoSala (mago_id, sala_id) VALUES (?, ?)"; // Query SQL para inserção
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, magoId); // Define o primeiro parâmetro da query (mago_id)
            pst.setInt(2, salaId); // Define o segundo parâmetro da query (sala_id)
            pst.execute(); // Executa a query
            return true; // Retorna verdadeiro se a inserção for bem-sucedida
        } catch (SQLException exc) { // Captura exceções SQL
            System.out.println("Erro: " + exc.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na inserção
        }
    }

    // Método para excluir uma associação entre mago e sala no banco de dados
    public boolean deleteMagoSala(int magoId, int salaId) {
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "DELETE FROM MagoSala WHERE mago_id = ? AND sala_id = ?"; // Query SQL para exclusão
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, magoId); // Define o primeiro parâmetro da query (mago_id)
            pst.setInt(2, salaId); // Define o segundo parâmetro da query (sala_id)
            pst.execute(); // Executa a query
            return true; // Retorna verdadeiro se a exclusão for bem-sucedida
        } catch (SQLException ex) { // Captura exceções SQL
            System.out.println("Erro: " + ex.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na exclusão
        }
    }
}
