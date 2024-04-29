/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jarop
 */
public class CGastos {
    
    int idGasto;
    String nombreGasto;
    String descripcionG;
    String cantidadG;
    String fecha;
  
    
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    public String getDescripcionG() {
        return descripcionG;
    }

    public void setDescripcionG(String descripcionG) {
        this.descripcionG = descripcionG;
    }
    
      public String getCantidadG() {
        return cantidadG;
    }

    public void setCantidadG(String cantidadG) {
        this.cantidadG = cantidadG;
    }
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void insertarGasto (JTextField paramNombreGasto, JTextField paramDescripcion, JTextField paramCantidad, JTextField paramFecha) {
        
        setNombreGasto(paramNombreGasto.getText());
        setDescripcionG(paramDescripcion.getText());
        setCantidadG(paramCantidad.getText());
        setFecha(paramFecha.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO gastos (nombreGasto, descripcionG, cantidadG, fecha) VALUES (?,?,?, STR_TO_DATE(?, '%d/%m/%Y'));";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1,getNombreGasto());
            cs.setString(2,getDescripcionG());
            cs.setString(3,getCantidadG());
            cs.setString(4,getFecha());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Gasto añadido correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO se ha podido añadir el gasto, error: "+e.toString());

        }
    }
    
    public void mostrarGasto (JTable paramTablaTotalGastos){
        
        CConexion objetoConexion = new CConexion();
        
        //crear modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        //ordenar la tabla
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalGastos.setRowSorter(OrdenarTabla);
        
        String sql ="";
        
        //cabeceras columnas
        modelo.addColumn("IdGasto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        
        paramTablaTotalGastos.setModel(modelo);
        
        sql = "SELECT * FROM gastos;";
        
        String[] datos = new String[5];
        Statement st;
        
        try {
            
            st = objetoConexion.estableceConexion().createStatement();
            
            //ejecutar consulta
            ResultSet rs = st.executeQuery(sql);
            
            //recorrer tabla
            while(rs.next()){
            
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                
                modelo.addRow(datos);
            }
            
            paramTablaTotalGastos.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: "+e.toString());
        }
        
    }
    
    //metodo para recuperar los datos de la tabla en el editor de gastos y poder modificarlos
    public void seleccionarGasto(JTable paramTablaGastos, JTextField paramIdGasto, JTextField paramNombreGasto, JTextField paramDescripcion, JTextField paramCantidad, JTextField paramFecha){
        
        try {
            
            int fila = paramTablaGastos.getSelectedRow();
            
            if(fila >= 0){
                
                paramIdGasto.setText(paramTablaGastos.getValueAt(fila, 0).toString());
                paramNombreGasto.setText(paramTablaGastos.getValueAt(fila, 1).toString());
                paramDescripcion.setText(paramTablaGastos.getValueAt(fila,2).toString());
                paramCantidad.setText(paramTablaGastos.getValueAt(fila, 3).toString());
                paramFecha.setText(paramTablaGastos.getValueAt(fila, 4).toString());        
            
            }else{
                
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
           
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, "Fallo de selección, error: "+e.toString());
        }
        
    }
    
    //metodo para modificar
    public void modificarGasto(JTextField paramIdGasto, JTextField paramNombreGasto, JTextField paramDescripcion, JTextField paramCantidad, JTextField paramFecha){
        
        setIdGasto(Integer.parseInt(paramIdGasto.getText()));
        setNombreGasto(paramNombreGasto.getText());
        setDescripcionG(paramDescripcion.getText());
        setCantidadG(paramCantidad.getText());
        setFecha(paramFecha.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE gastos SET gastos.nombreGasto = ?, gastos.descripcionG = ?, gastos.cantidadG = ?, gastos.fecha = ? WHERE gastos.idGastos = ?;";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1,getNombreGasto());
            cs.setString(2, getDescripcionG());
            cs.setString(3, getCantidadG());
            cs.setString(4, getFecha());
            cs.setInt(5, getIdGasto());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificado correctamente");
            
        } catch (SQLException e) {
        
            JOptionPane.showMessageDialog(null, "Error al modificar: "+e.toString());    
        }
    }
    
    public void eliminarGasto(JTextField paramIdGasto){
        
        setIdGasto(Integer.parseInt(paramIdGasto.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM gastos WHERE gastos.idGastos = ?;";
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, getIdGasto());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al eliminar: "+e.toString());       
        }
    }

    private void setidGastos(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
