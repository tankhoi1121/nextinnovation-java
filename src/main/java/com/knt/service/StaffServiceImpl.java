/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.StaffRepository;
import com.knt.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NguyenTan.Khoi
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    
    @Override
    public boolean addStaff(Staff staff) {
        try {
            if(!this.staffRepository.addStaff(staff)){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }    

    @Override
    public boolean updateStaff(int staffId, Staff staff) {
        try {
            if(!this.staffRepository.updateStaff(staffId, staff)){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Staff getStaffById(int stafffId) {
        return this.staffRepository.getStaffById(stafffId);
    }
}
