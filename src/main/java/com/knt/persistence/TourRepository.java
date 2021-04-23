/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.persistence;

import com.knt.pojo.Tour;
import com.knt.pojo.Tourdetails;
import java.util.List;

/**
 *
 * @author NguyenTan.Khoi
 */
public interface TourRepository {

    public Tour getTourById(int id);

    public List<Tour> getAllTour();

    public List<Tour> getTourBySeason(String season);

    public List<Tourdetails> getTourDetailByTourId(int tourId);

    public boolean addTour(Tour tour);

    public boolean updateTour(Tour tour);

    public boolean addListTourDetails(List<Tourdetails> tour);

    public Tourdetails x(int tourId);

    public boolean deleteTour(int tourId);
}
