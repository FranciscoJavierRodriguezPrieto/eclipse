/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jarop
 */
public class CConexion {
    Connection conectar;
    
    String usuario = "root";
    String contraseña = "admin";
    String bd = "coexpenses";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion (){
        
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            
           //JOptionPane.showMessageDialog(null, "Se ha conectado correctamente a la Base de Datos");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Problemas en la conexion" + e.toString());
        }
        return conectar;
    }
   
}
