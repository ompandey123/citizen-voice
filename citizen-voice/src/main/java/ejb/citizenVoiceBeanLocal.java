/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface citizenVoiceBeanLocal {
    //citizen operation
    void citizenRegistration(String username, String password, String email, String adhaar_card_no, Integer village_id, Integer taluka_id, Integer zone_id, Integer ward_id, Integer city_id, Integer district_id, Integer state_id, String contact, String gender, String address, String dob, String zip_code);
    
    
}
