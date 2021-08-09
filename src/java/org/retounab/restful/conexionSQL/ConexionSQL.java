package org.retounab.restful.conexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSQL {

    Connection conex;

    public  ConexionSQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conex = DriverManager.getConnection("jdbc:mysql://mysql-41419-0.cloudclusters.net:19839/"
                    + "contacto?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", 
                    "admin", "Dn2cXbBx");
        } catch (Exception e) {
            System.out.println("mal"+e.getMessage() );;
        }
       
    }
    public Connection getConnection(){
        return this.conex;
    }

}
