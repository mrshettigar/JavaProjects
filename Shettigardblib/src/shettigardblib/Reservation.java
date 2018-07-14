/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shettigardblib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.DriverManager;
import java.util.GregorianCalendar;

/**
 *
 * @author Mangesh
 */
public class Reservation {
    
// <editor-fold defaultstate="collapsed" desc=" Data ">   
    static private String mservername;
    static private String mdbname;
    static private String url;
    static private Connection mcn;
// </editor-fold> 
    
// <editor-fold defaultstate="collapsed" desc=" Constructors ">   
    //static constructor
    static {
        mservername = "MSSQLSERVER";
        mdbname = "Reservations";
    }

    public Reservation(String uid, String pass) {

        setConnection(uid, pass);
    }
// </editor-fold> 
     
// <editor-fold defaultstate="collapsed" desc=" Utility Functions  ">    
     public boolean IsConnected()    {
        return (mcn != null ? true : false);
    }
    
    public void setConnection(String uid, String pass) {
            try {
                //Per microsoft documentation no need to load the driver explicitly. Get connection does that on our behalf.
                // See http://msdn.microsoft.com/en-us/library/ms378526.aspx

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://localhost\\" + mservername
                        + ";databaseName=" + mdbname + ";user=" + uid + ";password=" + pass + ";";

                mcn = DriverManager.getConnection(connectionUrl);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error code:" + ex.getErrorCode());//ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace(); 
                
            }
    }
    
    
    private int TransactSQL(String[] sql) {
        Statement st = null;
        int n = 0;
        try {
            st = mcn.createStatement();
            //System.out.println(mcn.getAutoCommit());
            mcn.setAutoCommit(false);

            for (int i = 0; i < sql.length; i++) {
                n += st.executeUpdate(sql[i]);
            }
            //mcn.rollback();
            mcn.commit();
        } catch (SQLException ex) {
            try {
                //rollback if there is an error
                mcn.rollback();
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return n;
    }
// </editor-fold>
    

// <editor-fold defaultstate="collapsed" desc=" Database Functions   ">
    
    public List<String> getCustomerList() {
        ArrayList<String> rval = new ArrayList<String>();
        try {
            Statement s = mcn.createStatement();
            String sql = "Select CustomerID, Name, CCNo from Customer";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                rval.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
            }
            s.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return rval;
    }
    
    public List<String> getReservationList(String cid) {
        ArrayList<String> rval = new ArrayList<String>();
        try {
            Statement s = mcn.createStatement();
            String sql = String.format("Select CustomerID, RoomNo, DateIn, DateOut, TotalPrice from Reservation where CustomerID = '%s'", cid);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                rval.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
            }
            s.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return rval;
    }
    
    public List<String> getAvailableList(String datein, String dateout) {
        ArrayList<String> rval = new ArrayList<String>();
        try {
            Statement s = mcn.createStatement();
            String sql = String.format("Select R1.RoomNo, R2.RoomType, R2.Description, R2.NumBeds, sum(P.Price) as TotalPrice from RoomInventory R1, RoomDetails R2, Pricing P \n" +
"where R1.RoomType = R2.RoomType AND R2.RoomType = P.RoomType AND P.Date Between '%s' and (SELECT DATEADD(day, -1, '%s')) \n" +
"AND RoomNo NOT IN \n" +
"(Select distinct rs.RoomNo from Reservation rs Left outer join RoomInventory ri ON rs.RoomNo = ri.RoomNo where \n" +
"(DateIn BETWEEN '%s' AND (SELECT DATEADD(day, -1, '%s'))) OR (DateOut BETWEEN '%s' AND (SELECT DATEADD(day, -1, '%s'))) OR (DateIn < '%s' AND DateOut > (SELECT DATEADD(day, -1, '%s')))   )\n" +
"Group BY R1.RoomNo, R2.RoomType, R2.Description, R2.NumBeds",datein,dateout,datein,dateout,datein,dateout,datein,dateout);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                rval.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
            }
            s.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return rval;
    }
    
    public double book(String cid, String roomno, String datein, String dateout) {
        double price = 0.0;
        try {
            Statement s = mcn.createStatement();
            String sql = String.format("Select R1.RoomNo, R1.RoomType, sum(P.Price) as TotalPrice from RoomInventory R1, Pricing P \n" +
"where R1.RoomType = P.RoomType\n" +
" AND P.Date Between '%s' and (SELECT DATEADD(day, -1, '%s')) \n" +
"AND R1.RoomNo = '%s' \n" +
"Group by R1.RoomNo, R1.RoomType",datein,dateout,roomno);
            
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                price = Double.parseDouble(rs.getString(3));
            }
            //s = mcn.createStatement();
            s.executeQuery(String.format("Insert into Reservation(CustomerID,RoomNo,DateIn,DateOut,TotalPrice) values ('%s','%s','%s','%s','%s')",cid,roomno,datein,dateout,Double.toString(price)));
            s.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return price; //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean checkRoomAvailability(String roomno, String datein, String dateout) {
        
        try {
            Statement s = mcn.createStatement();
            String sql = String.format("Select R1.RoomNo, R2.RoomType, R2.Description, R2.NumBeds from RoomInventory R1, RoomDetails R2 where R1.RoomType = R2.RoomType AND RoomNo NOT IN (Select distinct rs.RoomNo from Reservation rs Left outer join RoomInventory ri ON rs.RoomNo = ri.RoomNo where (DateIn BETWEEN '%s' AND '%s') OR (DateOut BETWEEN '%s' AND '%s') OR (DateIn < '%s' AND DateOut > '%s')   )",datein,dateout,datein,dateout,datein,dateout);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString(1).equals(roomno)){
                    s.close();
                    return true;
                }
            }
            s.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }

    
    
//</editor-fold>
    
  public static void main(String[] args) {
        // TODO code application logic here
        Reservation r = new Reservation("ism6236","ism6236bo");
    }    

}
