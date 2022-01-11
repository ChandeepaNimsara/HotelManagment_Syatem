package hotelmanagment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chandeepa
 */
public class Rooms {
    
    MyConnection my_connection = new MyConnection();
    
    //function to display all rooms type in jtable
    public void FillRoomsType_JTable(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT * FROM `type`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while (rs.next()){
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
       //function combobox with room
       public void FillRoomsType_JCombobox(JComboBox combobox){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT * FROM `type`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
     
            while (rs.next()){
                
               combobox.addItem(rs.getInt(1));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
       
       //create a function to add a new room
       public void fillRoomTable(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT * FROM `rooms`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while (rs.next()){
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4); 
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    }
        public boolean removeRoom(int roomNumber){
        
        PreparedStatement st;
        String removeQuery = "DELETE FROM `rooms` WHERE `r_number`= ?";
        
        try {
            st = my_connection.createConnection().prepareStatement(removeQuery);
            
            st.setInt(1, roomNumber);
            
            return(st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
