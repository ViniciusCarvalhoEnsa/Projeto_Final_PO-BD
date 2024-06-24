// InimigoDAO.java
package DAO;

import Model.Inimigo; // Importa a classe Inimigo do pacote Model

import java.sql.SQLException; // Importa SQLException para tratamento de exceções SQL
import java.util.ArrayList; // Importa ArrayList para armazenar coleções de objetos

public class InimigoDAO extends ConnectionDAO {

    // Método para inserir um novo inimigo no banco de dados
    public boolean insertInimigo(Inimigo inimigo) {
        connectToDB(); // Estabelece conexão com o banco de dados (método herdado de ConnectionDAO)
        String sql = "INSERT INTO Inimigo (nome, vidas) VALUES (?, ?)"; // Query SQL para inserção
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setString(1, inimigo.getNome()); // Define o primeiro parâmetro da query (nome)
            pst.setInt(2, inimigo.getVidas());   // Define o segundo parâmetro da query (vidas)
            pst.execute(); // Executa a query
            return true;   // Retorna verdadeiro se a inserção for bem-sucedida
        } catch (SQLException exc) { // Captura exceções SQL
            System.out.println("Erro: " + exc.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na inserção
        }
    }

    // Método para atualizar o número de vidas de um inimigo no banco de dados
    public boolean updateInimigoVidas(int id, int vidas) {
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "UPDATE Inimigo SET vidas = ? WHERE id = ?"; // Query SQL para atualização
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, vidas); // Define o primeiro parâmetro da query (vidas)
            pst.setInt(2, id);    // Define o segundo parâmetro da query (id)
            pst.execute(); // Executa a query
            return true;   // Retorna verdadeiro se a atualização for bem-sucedida
        } catch (SQLException ex) { // Captura exceções SQL
            System.out.println("Erro: " + ex.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na atualização
        }
    }

    // Método para excluir um inimigo do banco de dados pelo seu id
    public boolean deleteInimigo(int id) {
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "DELETE FROM Inimigo WHERE id = ?"; // Query SQL para exclusão
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, id); // Define o parâmetro da query (id)
            pst.execute(); // Executa a query
            return true;   // Retorna verdadeiro se a exclusão for bem-sucedida
        } catch (SQLException ex) { // Captura exceções SQL
            System.out.println("Erro: " + ex.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na exclusão
        }
    }

    // Método para selecionar todos os inimigos do banco de dados
    public ArrayList<Inimigo> selectInimigo() {
        ArrayList<Inimigo> inimigos = new ArrayList<>(); // Cria um ArrayList para armazenar os inimigos selecionados
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "SELECT * FROM Inimigo"; // Query SQL para seleção de todos os inimigos
        try {
            st = con.createStatement(); // Cria uma declaração SQL
            rs = st.executeQuery(sql); // Executa a query de consulta

            while (rs.next()) { // Itera sobre o resultado da consulta
                // Cria um novo objeto Inimigo com os dados obtidos do resultado da consulta
                Inimigo inimigoAux = new Inimigo(rs.getInt("id"), rs.getString("nome"), rs.getInt("vidas"));
                inimigos.add(inimigoAux); // Adiciona o inimigo à lista de inimigos
            }
            return inimigos; // Retorna a lista de inimigos selecionados
        } catch (SQLException e) { // Captura exceções SQL
            System.out.println("Erro: " + e.getMessage()); // Exibe mensagem de erro
            return null; // Retorna null se ocorrer um erro na seleção
        }
    }
}
