/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gayan Jayarathne
 */
public class Client {
    
    MyConnection my_connection = new MyConnection();
    
    public void fillClientTable(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT * FROM `clients`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while (rs.next()){
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    }
    
    public boolean removeClient(int id){
        
        PreparedStatement st;
        String removeQuery = "DELETE FROM `clients` WHERE `id` =?";
        
        try {
            st = my_connection.createConnection().prepareStatement(removeQuery);
            
            st.setInt(1, id);
            
            return(st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}


