package br.com.pitagorasac.dao;

import br.com.pitagorasac.factory.ConnectionFactory;
import br.com.pitagorasac.model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
    private Connection connection;

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public ContatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insert(Contato contato) {
        String sql = "INSERT INT contato (nome, telefone, email) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
