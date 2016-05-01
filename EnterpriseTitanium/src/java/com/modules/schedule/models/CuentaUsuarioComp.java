/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "seg_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaUsuario.findAll", query = "SELECT c FROM CuentaUsuario c"),
    @NamedQuery(name = "CuentaUsuario.findByCuentaId", query = "SELECT c FROM CuentaUsuario c WHERE c.cuentaId = :cuentaId"),
    @NamedQuery(name = "CuentaUsuario.findByPassword", query = "SELECT c FROM CuentaUsuario c WHERE c.password = :password"),
    @NamedQuery(name = "CuentaUsuario.findByGrupos", query = "SELECT c FROM CuentaUsuario c WHERE c.grupos = :grupos"),
    @NamedQuery(name = "CuentaUsuario.findByFechaRegistro", query = "SELECT c FROM CuentaUsuario c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CuentaUsuario.findByCantidadIntentos", query = "SELECT c FROM CuentaUsuario c WHERE c.cantidadIntentos = :cantidadIntentos"),
    @NamedQuery(name = "CuentaUsuario.findByCodigoVerificacion", query = "SELECT c FROM CuentaUsuario c WHERE c.codigoVerificacion = :codigoVerificacion"),
    @NamedQuery(name = "CuentaUsuario.findByAccEmail", query = "SELECT c FROM CuentaUsuario c WHERE c.accEmail = :accEmail"),
    @NamedQuery(name = "CuentaUsuario.findByAccTmovil", query = "SELECT c FROM CuentaUsuario c WHERE c.accTmovil = :accTmovil"),
    @NamedQuery(name = "CuentaUsuario.findByAccNid", query = "SELECT c FROM CuentaUsuario c WHERE c.accNid = :accNid"),
    @NamedQuery(name = "CuentaUsuario.findByAccUrl", query = "SELECT c FROM CuentaUsuario c WHERE c.accUrl = :accUrl"),
    @NamedQuery(name = "CuentaUsuario.findByAccCodigo", query = "SELECT c FROM CuentaUsuario c WHERE c.accCodigo = :accCodigo"),
    @NamedQuery(name = "CuentaUsuario.findByEstado", query = "SELECT c FROM CuentaUsuario c WHERE c.estado = :estado")})
public class CuentaUsuarioComp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cuenta_Id")
    private Integer cuentaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Password")
    private String password;
    @Column(name = "Grupos")
    private Integer grupos;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "Cantidad_Intentos")
    private String cantidadIntentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Codigo_Verificacion")
    private String codigoVerificacion;
    @Column(name = "acc_email")
    private Integer accEmail;
    @Column(name = "acc_tmovil")
    private Integer accTmovil;
    @Column(name = "acc_nid")
    private Integer accNid;
    @Column(name = "acc_url")
    private Integer accUrl;
    @Column(name = "acc_codigo")
    private Integer accCodigo;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
    @OneToOne(optional = false)
    private EntidadComp idEntidad;
    @OneToMany(mappedBy = "idCuenta")
    private Collection<CompSchedule> compScheduleCollection;

    public CuentaUsuarioComp() {
    }

    public CuentaUsuarioComp(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public CuentaUsuarioComp(Integer cuentaId, String password, String codigoVerificacion) {
        this.cuentaId = cuentaId;
        this.password = password;
        this.codigoVerificacion = codigoVerificacion;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGrupos() {
        return grupos;
    }

    public void setGrupos(Integer grupos) {
        this.grupos = grupos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCantidadIntentos() {
        return cantidadIntentos;
    }

    public void setCantidadIntentos(String cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }

    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public Integer getAccEmail() {
        return accEmail;
    }

    public void setAccEmail(Integer accEmail) {
        this.accEmail = accEmail;
    }

    public Integer getAccTmovil() {
        return accTmovil;
    }

    public void setAccTmovil(Integer accTmovil) {
        this.accTmovil = accTmovil;
    }

    public Integer getAccNid() {
        return accNid;
    }

    public void setAccNid(Integer accNid) {
        this.accNid = accNid;
    }

    public Integer getAccUrl() {
        return accUrl;
    }

    public void setAccUrl(Integer accUrl) {
        this.accUrl = accUrl;
    }

    public Integer getAccCodigo() {
        return accCodigo;
    }

    public void setAccCodigo(Integer accCodigo) {
        this.accCodigo = accCodigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EntidadComp getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(EntidadComp idEntidad) {
        this.idEntidad = idEntidad;
    }

    @XmlTransient
    public Collection<CompSchedule> getCompScheduleCollection() {
        return compScheduleCollection;
    }

    public void setCompScheduleCollection(Collection<CompSchedule> compScheduleCollection) {
        this.compScheduleCollection = compScheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaId != null ? cuentaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaUsuarioComp)) {
            return false;
        }
        CuentaUsuarioComp other = (CuentaUsuarioComp) object;
        if ((this.cuentaId == null && other.cuentaId != null) || (this.cuentaId != null && !this.cuentaId.equals(other.cuentaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.models.CuentaUsuario[ cuentaId=" + cuentaId + " ]";
    }
    
}
