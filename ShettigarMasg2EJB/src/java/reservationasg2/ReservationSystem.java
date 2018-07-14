/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationasg2;

import javax.ejb.Stateless;
import java.util.List;
import shettigardblib.Reservation;

/**
 *
 * @author Mangesh
 */
@Stateless
public class ReservationSystem implements ReservationSystemRemote {

    Reservation mdb;
    
     public ReservationSystem()
    {
        mdb = new Reservation("ism6236","ism6236bo");
    }
    
    
    @Override
    public List<String> getCustomerList() {
        return mdb.getCustomerList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<String> getReservationList(String cid) {
        return mdb.getReservationList(cid);
    }

    @Override
    public List<String> getAvailableList(String datein, String dateout) {
        return mdb.getAvailableList(datein, dateout);
    }

    @Override
    public double book(String cid, String roomno, String datein, String dateout) {
        return mdb.book(cid, roomno, datein, dateout);
    }

    @Override
    public boolean checkRoomAvailability(String roomno, String datein, String dateout) {
        return mdb.checkRoomAvailability(roomno, datein, dateout);
    }    
}
