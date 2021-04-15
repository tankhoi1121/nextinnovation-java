/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Staff;

/**
 *
 * @author NguyenTan.Khoi
 */
public interface StaffRepository {
    public boolean addStaff(Staff staff);
    public boolean updateStaff(int staffId, Staff staff);
    public Staff getStaffById(int stafffId);
}
