
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConFactory {

    public static final int MYSQL = 0;
    private static final String MYSQLDriver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/agendacompromisso";
    private static final String USUARIO = "root";
    private static final String SENHA = "Aj17062010";

    //METODO RESPONSAVEL POR RETORNAR O DRIVER QYUE SERÁ UTILIZADO

public static Connection conexão(int bancoDados) throws ClassNotFoundException, SQLException{
    switch (bancoDados) {
        case MYSQL:
            Class.forName(MYSQLDriver);
            break;
    }
        
    return  DriverManager.getConnection(URL, USUARIO, SENHA);
}

    

    
}
