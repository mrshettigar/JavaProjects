/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem;

import java.time.LocalDate;

/**
 *
 * @author Mangesh
 */
public class RentalItem {
    private int itemId;
    private String title;
    private String producer;
    private int year;
    private int rentalDuration;
    private double rentalRate;
    private double lateFeesPerDay;
    private LocalDate dueDate;
    private Customer customer;
    
    public int getItemId() { return itemId;}
    public String getTitle() { return title;}
    public double getRentalRate() {return rentalRate;}
    public void setRentalDuration(int dur) {rentalDuration = dur;}
    
    
    public String ToString() { return itemId + ",";}
    
    public boolean checkOut(Customer cust) { }

    
}
