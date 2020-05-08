package br.com.pitagorasac.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO transformar esta classe em um singleton
 */
public class ConnectionFactory {
    public static String status;

    public Connection getConnection() {
        Connection conexao;
        /**
         * TODO Alterar os dados para acesso ao banco de dados.
         */
        String URLDB = "jdbc:mysql://172.17.0.2:3306/cadastro";
        String user = "fabricio";
        String password = "senha.123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URLDB, user, password);
            if (conexao != null)
                status = "Conectado com sucesso!";
            else status = "Falha na conexão com o banco de dados...";

            return conexao;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado!\nFalha na conexão com o banco de dados.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Falha ao obter uma conexão com o banco de dados.");
        }
        return null;
    }

    public boolean closeConnection() {
        try {
            this.getConnection().close();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public Connection restartConnection() {
        this.closeConnection();
        return this.getConnection();
    }

}
