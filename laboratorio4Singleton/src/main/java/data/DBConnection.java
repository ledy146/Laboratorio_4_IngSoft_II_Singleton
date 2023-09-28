/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ledy Astudillo
 * @author Santiago Nieto
 */
public class DBConnection {
    // Instancia única de la clase DBConnection
    private static DBConnection instance;
    private Connection conn;

    // Constructor privado para evitar la creación de instancias directamente
    private DBConnection() {
        System.out.println("data.DBConnection.<init>()");
    }

    // Método estático para obtener la instancia única
    public static synchronized DBConnection GetDBConnection() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Método para conectarse a la base de datos
    public void Connect(String databaseName) {
        String url = "jdbc:sqlite::memory:";

        try {
           conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para desconectarse de la base de datos
    public void Disconnect() {
         try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

