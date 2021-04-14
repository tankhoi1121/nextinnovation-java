/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NguyenTan.Khoi
 */
@Entity
@Table(name = "tour", catalog = "oihkapp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id"),
    @NamedQuery(name = "Tour.findBySeason", query = "SELECT t FROM Tour t WHERE t.season = :season")})
public class Tour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "_name", length = 65535)
    private String name;
    @Size(max = 255)
    @Column(name = "season", length = 255)
    private String season;
    @Lob
    @Size(max = 65535)
    @Column(name = "SummarySchedule", length = 65535)
    private String summarySchedule;
    @Lob
    @Size(max = 65535)
    @Column(name = "ConditionRemoveTour", length = 65535)
    private String conditionRemoveTour;
    @Lob
    @Size(max = 65535)
    @Column(name = "ServiceIncludeAndNotInclude", length = 65535)
    private String serviceIncludeAndNotInclude;
    @OneToMany(mappedBy = "tourId")
    private Collection<Tourdetails> tourdetailsCollection;

    public Tour() {
    }

    public Tour(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSummarySchedule() {
        return summarySchedule;
    }

    public void setSummarySchedule(String summarySchedule) {
        this.summarySchedule = summarySchedule;
    }

    public String getConditionRemoveTour() {
        return conditionRemoveTour;
    }

    public void setConditionRemoveTour(String conditionRemoveTour) {
        this.conditionRemoveTour = conditionRemoveTour;
    }

    public String getServiceIncludeAndNotInclude() {
        return serviceIncludeAndNotInclude;
    }

    public void setServiceIncludeAndNotInclude(String serviceIncludeAndNotInclude) {
        this.serviceIncludeAndNotInclude = serviceIncludeAndNotInclude;
    }

    @XmlTransient
    public Collection<Tourdetails> getTourdetailsCollection() {
        return tourdetailsCollection;
    }

    public void setTourdetailsCollection(Collection<Tourdetails> tourdetailsCollection) {
        this.tourdetailsCollection = tourdetailsCollection;
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
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.knt.pojo.Tour[ id=" + id + " ]";
    }
    
}
