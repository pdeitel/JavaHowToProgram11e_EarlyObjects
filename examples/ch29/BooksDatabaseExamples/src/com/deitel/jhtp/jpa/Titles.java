/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.jhtp.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PaulDeitel
 */
@Entity
@Table(name = "TITLES")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Titles.findAll", query = "SELECT t FROM Titles t")
   , @NamedQuery(name = "Titles.findByIsbn", query = "SELECT t FROM Titles t WHERE t.isbn = :isbn")
   , @NamedQuery(name = "Titles.findByTitle", query = "SELECT t FROM Titles t WHERE t.title = :title")
   , @NamedQuery(name = "Titles.findByEditionnumber", query = "SELECT t FROM Titles t WHERE t.editionnumber = :editionnumber")
   , @NamedQuery(name = "Titles.findByCopyright", query = "SELECT t FROM Titles t WHERE t.copyright = :copyright")})
public class Titles implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "ISBN")
   private String isbn;
   @Basic(optional = false)
   @Column(name = "TITLE")
   private String title;
   @Basic(optional = false)
   @Column(name = "EDITIONNUMBER")
   private int editionnumber;
   @Basic(optional = false)
   @Column(name = "COPYRIGHT")
   private String copyright;
   @ManyToMany(mappedBy = "titlesList")
   private List<Authors> authorsList;

   public Titles() {
   }

   public Titles(String isbn) {
      this.isbn = isbn;
   }

   public Titles(String isbn, String title, int editionnumber, String copyright) {
      this.isbn = isbn;
      this.title = title;
      this.editionnumber = editionnumber;
      this.copyright = copyright;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getEditionnumber() {
      return editionnumber;
   }

   public void setEditionnumber(int editionnumber) {
      this.editionnumber = editionnumber;
   }

   public String getCopyright() {
      return copyright;
   }

   public void setCopyright(String copyright) {
      this.copyright = copyright;
   }

   @XmlTransient
   public List<Authors> getAuthorsList() {
      return authorsList;
   }

   public void setAuthorsList(List<Authors> authorsList) {
      this.authorsList = authorsList;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (isbn != null ? isbn.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Titles)) {
         return false;
      }
      Titles other = (Titles) object;
      if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.deitel.jhtp.jpa.Titles[ isbn=" + isbn + " ]";
   }
   
}
