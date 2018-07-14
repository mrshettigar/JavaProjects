/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationasg2;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Mangesh
 */
@Remote
public interface ReservationSystemRemote {

    List<String> getCustomerList();
    List<String> getReservationList(String cid);
    List<String> getAvailableList(String datein, String dateout);
    double book(String cid, String roomno, String datein, String dateout);
    boolean checkRoomAvailability(String roomno, String datein, String dateout);

}
