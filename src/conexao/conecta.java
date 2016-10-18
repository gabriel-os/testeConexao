package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Início da classe de conexão//
public class conecta {

    public static String status = "Não conectou...";

    public conecta() {
    }

    public static java.sql.Connection getConnection(String ip) {
        Connection conn = null;
        //pro compilador ficar feliz
        try {
            // Carrega o driver JDBC 
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configuração da conexão com um banco de dados//
            //troque por seu ip, senha, user, etc
            String mydatabase = "dbTeste";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + ip + "/" + mydatabase;
            String user = "rede";        //nome de um usuário de seu BD      
            String key = "189440";      //sua senha de acesso
            conn = DriverManager.getConnection(url, user, key);

            //Testa sua conexão// 
            if (conn != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return conn;

        } catch (ClassNotFoundException e) {  //Driver não encontrado 
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }
}
