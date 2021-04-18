/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.pojo.Tour;
import com.knt.pojo.Tourdetails;
import java.util.List;

/**
 *
 * @author NguyenTan.Khoi
 */
public interface TourService {

    public Tour getTourById(int id);

    public List<Tour> getAllTour();

    public Tour getTourBySeason(String season);

    public List<Tourdetails> getTourDetailByTourId(int tourId);

    public Tourdetails x(int tourId);

    public boolean addTour(Tour tour);

    public boolean updateTour(Tour tour);

    public boolean addListTourDetails(List<Tourdetails> tour);
}
