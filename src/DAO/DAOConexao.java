package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class DAOConexao {

    protected Connection con;    
    protected Statement comando;

    //METODO RESPONSAVEL POR CONECTAR AO BANCO DE DADOS
    protected void conectar(){
        try{
            con = (Connection) ConFactory.conexão(ConFactory.MYSQL);
            comando = (Statement) con.createStatement();
        }catch(ClassNotFoundException ex) {
            imprimirErros("Erro ao carregar o drive do banco de dados", ex.getMessage());
        }catch (SQLException ex) {
            imprimirErros("Erro ao conectar ao banco de dados", ex.getMessage());
        }
    }

    //METODO PARA RETORNAR ERROS
    protected void imprimirErros(String msg, String msgErro){
        JOptionPane.showMessageDialog(null, msg + "\n Erro: "+msgErro, "Erro Critico", 0);
        System.exit(0); 
    }

    //METODO PARA FECHAR A CONEXÃO COM BANCO DE DADOS
    protected void fechar(){
        try {
            comando.close();
            con.close();
        } catch (SQLException ex) {
             imprimirErros("Erro ao fechar a conexão com o banco de dados", ex.getMessage());
        }
        

    } 
    
}
