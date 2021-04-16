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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruce_
 */
@Entity
@Table(name = "temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temp.findAll", query = "SELECT t FROM Temp t"),
    @NamedQuery(name = "Temp.findById", query = "SELECT t FROM Temp t WHERE t.id = :id"),
    @NamedQuery(name = "Temp.findByRevernue", query = "SELECT t FROM Temp t WHERE t.revernue = :revernue"),
    @NamedQuery(name = "Temp.findByMonth", query = "SELECT t FROM Temp t WHERE t.month = :month"),
    @NamedQuery(name = "Temp.findByYear", query = "SELECT t FROM Temp t WHERE t.year = :year")})
public class Temp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "revernue")
    private Integer revernue;
    @Column(name = "_month")
    private Integer month;
    @Column(name = "_year")
    private Integer year;

    public Temp() {
    }

    public Temp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRevernue() {
        return revernue;
    }

    public void setRevernue(Integer revernue) {
        this.revernue = revernue;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        if (!(object instanceof Temp)) {
            return false;
        }
        Temp other = (Temp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.knt.pojo.Temp[ id=" + id + " ]";
    }
    
}
