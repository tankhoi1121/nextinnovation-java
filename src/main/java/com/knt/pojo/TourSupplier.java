/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruce_
 */
@Entity
@Table(name = "tour_supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourSupplier.findAll", query = "SELECT t FROM TourSupplier t"),
    @NamedQuery(name = "TourSupplier.findById", query = "SELECT t FROM TourSupplier t WHERE t.id = :id")})
public class TourSupplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "SupplierId", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplierId;
    @JoinColumn(name = "TourId", referencedColumnName = "id")
    @ManyToOne
    private Tour tourId;

    public TourSupplier() {
    }

    public TourSupplier(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourSupplier)) {
            return false;
        }
        TourSupplier other = (TourSupplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.knt.pojo.TourSupplier[ id=" + id + " ]";
    }
    
}
