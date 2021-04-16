/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knt.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruce_
 */
@Entity
@Table(name = "product_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCustomer.findAll", query = "SELECT p FROM ProductCustomer p"),
    @NamedQuery(name = "ProductCustomer.findById", query = "SELECT p FROM ProductCustomer p WHERE p.id = :id"),
    @NamedQuery(name = "ProductCustomer.findByQty", query = "SELECT p FROM ProductCustomer p WHERE p.qty = :qty"),
    @NamedQuery(name = "ProductCustomer.findByConfirmStatus", query = "SELECT p FROM ProductCustomer p WHERE p.confirmStatus = :confirmStatus"),
    @NamedQuery(name = "ProductCustomer.findByInputDate", query = "SELECT p FROM ProductCustomer p WHERE p.inputDate = :inputDate")})
public class ProductCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Qty")
    private Integer qty;
    @Size(max = 50)
    @Column(name = "ConfirmStatus")
    private String confirmStatus;
    @Column(name = "InputDate")
    @Temporal(TemporalType.DATE)
    private Date inputDate;
    @JoinColumn(name = "CustomerId", referencedColumnName = "id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "ProductId", referencedColumnName = "id")
    @ManyToOne
    private Product productId;

    public ProductCustomer() {
    }

    public ProductCustomer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof ProductCustomer)) {
            return false;
        }
        ProductCustomer other = (ProductCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.knt.pojo.ProductCustomer[ id=" + id + " ]";
    }
    
}
