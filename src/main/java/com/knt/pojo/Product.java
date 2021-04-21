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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author bruce_
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByTourId", query = "SELECT p FROM Product p WHERE p.tourId = :tourId"),
    @NamedQuery(name = "Product.findByPriceForAdult", query = "SELECT p FROM Product p WHERE p.priceForAdult = :priceForAdult"),
    @NamedQuery(name = "Product.findByPriceForChild", query = "SELECT p FROM Product p WHERE p.priceForChild = :priceForChild"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Integer id;
    @Column(name = "TourId")
    private Integer tourId;
    @Column(name = "PriceForAdult")
    private Integer priceForAdult;
    @Column(name = "PriceForChild")
    private Integer priceForChild;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "productId")
    private Collection<ProductCustomer> productCustomerCollection;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getPriceForAdult() {
        return priceForAdult;
    }

    public void setPriceForAdult(Integer priceForAdult) {
        this.priceForAdult = priceForAdult;
    }

    public Integer getPriceForChild() {
        return priceForChild;
    }

    public void setPriceForChild(Integer priceForChild) {
        this.priceForChild = priceForChild;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProductCustomer> getProductCustomerCollection() {
        return productCustomerCollection;
    }

    public void setProductCustomerCollection(Collection<ProductCustomer> productCustomerCollection) {
        this.productCustomerCollection = productCustomerCollection;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.knt.pojo.Product[ id=" + id + " ]";
    }

}
