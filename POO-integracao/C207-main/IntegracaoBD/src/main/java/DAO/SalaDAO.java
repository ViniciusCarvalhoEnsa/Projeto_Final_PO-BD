package DAO;

import Model.Sala; // Importa a classe Sala do pacote Model

import java.sql.SQLException; // Importa SQLException para tratamento de exceções SQL
import java.util.ArrayList; // Importa ArrayList para armazenar coleções de objetos

public class SalaDAO extends ConnectionDAO {

    // Método para inserir uma nova sala no banco de dados
    public boolean insertSala(Sala sala) {
        connectToDB(); // Estabelece conexão com o banco de dados (método herdado de ConnectionDAO)
        String sql = "INSERT INTO Sala (numero) VALUES (?)"; // Query SQL para inserção
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, sala.getNumero()); // Define o parâmetro da query (numero)
            pst.execute(); // Executa a query
            return true; // Retorna verdadeiro se a inserção for bem-sucedida
        } catch (SQLException exc) { // Captura exceções SQL
            System.out.println("Erro: " + exc.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na inserção
        }
    }

    // Método para excluir uma sala do banco de dados pelo seu id
    public boolean deleteSala(int id) {
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "DELETE FROM Sala WHERE id = ?"; // Query SQL para exclusão
        try {
            pst = con.prepareStatement(sql); // Prepara a declaração SQL
            pst.setInt(1, id); // Define o parâmetro da query (id)
            pst.execute(); // Executa a query
            return true; // Retorna verdadeiro se a exclusão for bem-sucedida
        } catch (SQLException ex) { // Captura exceções SQL
            System.out.println("Erro: " + ex.getMessage()); // Exibe mensagem de erro
            return false; // Retorna falso se ocorrer um erro na exclusão
        }
    }

    // Método para selecionar todas as salas do banco de dados
    public ArrayList<Sala> selectSala() {
        ArrayList<Sala> salas = new ArrayList<>(); // Cria um ArrayList para armazenar as salas selecionadas
        connectToDB(); // Estabelece conexão com o banco de dados
        String sql = "SELECT * FROM Sala"; // Query SQL para seleção de todas as salas
        try {
            st = con.createStatement(); // Cria uma declaração SQL
            rs = st.executeQuery(sql); // Executa a query de consulta

            while (rs.next()) { // Itera sobre o resultado da consulta
                // Cria um novo objeto Sala com os dados obtidos do resultado da consulta
                Sala salaAux = new Sala(rs.getInt("id"), rs.getInt("numero"));
                salas.add(salaAux); // Adiciona a sala à lista de salas
            }
            return salas; // Retorna a lista de salas selecionadas
        } catch (SQLException e) { // Captura exceções SQL
            System.out.println("Erro: " + e.getMessage()); // Exibe mensagem de erro
            return null; // Retorna null se ocorrer um erro na seleção
        }
    }
}
