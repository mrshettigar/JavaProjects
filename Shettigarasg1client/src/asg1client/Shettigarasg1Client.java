/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg1client;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import shettigardblib.Reservation;
/**
 *
 * @author Mangesh
 */
public class Shettigarasg1Client {
    
    public static void main(String[] args) {

        // TODO code application logic here
        PrintStream cout = System.out;
        Scanner cin = new Scanner(System.in);

        cout.println("Please enter your password: ");
        Reservation db = null;
        int count = 0;
        String pass = cin.nextLine();
        db = new Reservation("ism6236", pass);

        List<String> aclist = db.getCustomerList();
        for (String s : aclist) {
                //String p = db.getProductDetail(s);
                cout.println(String.format("%s", s));
            }

        cout.println();
        cout.print("Enter L to List,  B to Book, Q to Quit: ");
        cout.flush();
        String input = cin.nextLine();
        boolean quit = false;    
        
        ArrayList<String> ord = new ArrayList<String>();
        while (!quit) {
            int c = input.charAt(0);
            switch (c) {
                case 'l':
                case 'L':
                    cout.print("Enter Customer ID: ");
                    cout.flush();
                    String cid = cin.nextLine();
                    List<String> arlist = db.getReservationList(cid);
                    for (String s : arlist) {
                    cout.println(String.format("%s", s));
                    }
                    break;
                case 'b':
                case 'B':
                    cout.print("Enter Date-In (mm/dd/yy): ");
                    cout.flush();
                    String datein = cin.nextLine();
                    cout.print("Enter Date-Out (mm/dd/yy): ");
                    cout.flush();
                    String dateout = cin.nextLine();
                    
                    List<String> avlist = db.getAvailableList(datein,dateout);
                    for (String s : avlist) {
                    cout.println(String.format("%s", s));
                    }
                    cout.print("Enter B to Book, C to Cancel: ");
                    cout.flush();
                    input = cin.nextLine();
                    int b = input.charAt(0);
                    switch (b) {
                        case 'B':
                        case 'b':
                            cout.print("Enter Customer ID: ");
                            cout.flush();
                            cid = cin.nextLine();
                            boolean room = false;
                            String roomno;
                            do {
                            cout.print("Enter Room No: ");
                            cout.flush();
                            roomno = cin.nextLine();
                            room = db.checkRoomAvailability(roomno,datein,dateout);
                            if(!room){
                                cout.println("Room not available");
                                cout.flush();
                                for (String s : avlist) {
                                cout.println(String.format("%s", s));
                                }
                            }
                            }while(!room);
                            double totalCost = db.book(cid,roomno,datein,dateout); 
                            cout.println(String.format("Total cost of stay is %.2f",totalCost));
                            break;
                        case 'C':
                        case 'c':
                            break;
                        default:
                            break;
                            
                    }        
                    break;
                        
                    
                default:
                    quit = true;

            }

            if (!quit) {
                cout.print("Enter L to List,  B to Book , Q to quit: ");
                cout.flush();
                input = cin.nextLine();
            }
        
        }
    }    
}
