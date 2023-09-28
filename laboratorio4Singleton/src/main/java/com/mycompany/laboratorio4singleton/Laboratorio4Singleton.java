/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laboratorio4singleton;

import data.DBConnection;

/**
 * @author Ledy Astudillo
 * @author Santiago Nieto
 */
public class Laboratorio4Singleton {
    public static void main(String[] args) {
        DBConnection conn = DBConnection.GetDBConnection();
        conn.Connect("empleados");
        conn.Disconnect();
        DBConnection conn2 = DBConnection.GetDBConnection();
        conn2.Connect("nomina");
        conn2.Disconnect();
    }
}


