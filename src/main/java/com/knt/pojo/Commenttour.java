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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruce_
 */
@Entity
@Table(name = "commenttour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commenttour.findAll", query = "SELECT c FROM Commenttour c"),
    @NamedQuery(name = "Commenttour.findById", query = "SELECT c FROM Commenttour c WHERE c.id = :id")})
public class Commenttour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "commentator")
    private String commentator;
    @Lob
    @Size(max = 65535)
    @Column(name = "EmailCommentator")
    private String emailCommentator;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "TourId", referencedColumnName = "id")
    @ManyToOne
    private Tour tourId;

    public Commenttour() {
    }

    public Commenttour(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getEmailCommentator() {
        return emailCommentator;
    }

    public void setEmailCommentator(String emailCommentator) {
        this.emailCommentator = emailCommentator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        if (!(object instanceof Commenttour)) {
            return false;
        }
        Commenttour other = (Commenttour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.knt.pojo.Commenttour[ id=" + id + " ]";
    }

}
