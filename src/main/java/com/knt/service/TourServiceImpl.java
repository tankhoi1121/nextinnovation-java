/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.service;

import com.knt.persistence.TourRepository;
import com.knt.pojo.Tour;
import com.knt.pojo.Tourdetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NguyenTan.Khoi
 */
@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour getTourById(int id) {
        return tourRepository.getTourById(id);
    }

    @Override
    public List<Tourdetails> getTourDetailByTourId(int tourId) {
        return this.tourRepository.getTourDetailByTourId(tourId);
    }

    @Override
    public Tourdetails x(int tourId) {
        return this.tourRepository.x(tourId);
    }

    @Override
    public List<Tour> getAllTour() {
        return this.tourRepository.getAllTour();
    }

    @Override
    public Tour getTourBySeason(String season) {
        return this.tourRepository.getTourBySeason(season);
    }

    @Override
    public boolean addTour(Tour tour) {
        try {
            if (!this.tourRepository.addTour(tour)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTour(Tour tour) {
        try {
            if (!this.tourRepository.updateTour(tour)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
