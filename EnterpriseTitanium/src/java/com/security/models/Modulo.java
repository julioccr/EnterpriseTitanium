/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "app_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByCodModulo", query = "SELECT m FROM Modulo m WHERE m.codModulo = :codModulo"),
    @NamedQuery(name = "Modulo.findByNombre", query = "SELECT m FROM Modulo m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Modulo.findByEstado", query = "SELECT m FROM Modulo m WHERE m.estado = :estado")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Modulo")
    private Integer codModulo;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appModuloCodModulo")
    private Collection<Transaccion> transaccionCollection;
    @OneToMany(mappedBy = "idAppModulo")
    private Collection<SegAccesoModulo> segAccesoModuloCollection;
    @JoinColumn(name = "Id_Aplicativo", referencedColumnName = "idAplicativo")
    @ManyToOne
    private Aplicacion idAplicativo;

    public Modulo() {
    }

    public Modulo(Integer codModulo) {
        this.codModulo = codModulo;
    }

    public Integer getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(Integer codModulo) {
        this.codModulo = codModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @XmlTransient
    public Collection<SegAccesoModulo> getSegAccesoModuloCollection() {
        return segAccesoModuloCollection;
    }

    public void setSegAccesoModuloCollection(Collection<SegAccesoModulo> segAccesoModuloCollection) {
        this.segAccesoModuloCollection = segAccesoModuloCollection;
    }

    public Aplicacion getIdAplicativo() {
        return idAplicativo;
    }

    public void setIdAplicativo(Aplicacion idAplicativo) {
        this.idAplicativo = idAplicativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.Modulo[ codModulo=" + codModulo + " ]";
    }
    
}
