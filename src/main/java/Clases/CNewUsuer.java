/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.co.expenses.Gastos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jarop
 */
public class CNewUsuer {

    public void crearUsuario(JTextField jNuevoUsuario, JPasswordField jContraseña2) {
        
      try {
            PreparedStatement pps = null;
         
            Clases.CConexion objetoConexion = new Clases.CConexion();
            
            String consulta = "Insert into Usuarios(ingresoUsuario,ingresoContrasenia) values (?, ?);";
            
            pps = objetoConexion.estableceConexion().prepareStatement(consulta);
            
            pps.setString(1, jNuevoUsuario.getText());
            pps.setString(2, jContraseña2.getText());
            
            pps.executeUpdate();        
           
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente, por favor, introduzcalos en el otro boton para acceder. ");

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }         
    }
    
}
