/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */  
package com.modules.schedule.models;  

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cortorreal
 */
@Entity  
@Table(name = "comp_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompSchedule.findAll", query = "SELECT c FROM CompSchedule c"),
    @NamedQuery(name = "CompSchedule.findByIdSchedule", query = "SELECT c FROM CompSchedule c WHERE c.idSchedule = :idSchedule"),
    @NamedQuery(name = "CompSchedule.findByAsunto", query = "SELECT c FROM CompSchedule c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "CompSchedule.findByDescripcion", query = "SELECT c FROM CompSchedule c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CompSchedule.findByPrioridad", query = "SELECT c FROM CompSchedule c WHERE c.prioridad = :prioridad"),
    @NamedQuery(name = "CompSchedule.findByEstado", query = "SELECT c FROM CompSchedule c WHERE c.estado = :estado"),
    @NamedQuery(name = "CompSchedule.findByCategoria", query = "SELECT c FROM CompSchedule c WHERE c.categoria = :categoria"),
    @NamedQuery(name = "CompSchedule.findByTipo", query = "SELECT c FROM CompSchedule c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CompSchedule.findByFechaInicio", query = "SELECT c FROM CompSchedule c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "CompSchedule.findByFechaFin", query = "SELECT c FROM CompSchedule c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "CompSchedule.findByDLunes", query = "SELECT c FROM CompSchedule c WHERE c.dLunes = :dLunes"),
    @NamedQuery(name = "CompSchedule.findByDMartes", query = "SELECT c FROM CompSchedule c WHERE c.dMartes = :dMartes"),
    @NamedQuery(name = "CompSchedule.findByDMiercoles", query = "SELECT c FROM CompSchedule c WHERE c.dMiercoles = :dMiercoles"),
    @NamedQuery(name = "CompSchedule.findByDJueves", query = "SELECT c FROM CompSchedule c WHERE c.dJueves = :dJueves"),
    @NamedQuery(name = "CompSchedule.findByDViernes", query = "SELECT c FROM CompSchedule c WHERE c.dViernes = :dViernes"),
    @NamedQuery(name = "CompSchedule.findByDSabado", query = "SELECT c FROM CompSchedule c WHERE c.dSabado = :dSabado"),
    @NamedQuery(name = "CompSchedule.findByDDomingo", query = "SELECT c FROM CompSchedule c WHERE c.dDomingo = :dDomingo")})
public class CompSchedule implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "idSchedule")
    private Integer idSchedule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 10, max = 45)
    @Column(name = "Asunto")
    private String asunto;
    @Basic(optional = true)
    @Size(min = 0, max = 120)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 3000)
    @Column(name = "prioridad")
    private String prioridad;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 1)
    @Column(name = "d_lunes")
    private String dLunes;
    @Size(max = 1)
    @Column(name = "d_martes")
    private String dMartes;
    @Size(max = 1)
    @Column(name = "d_miercoles")
    private String dMiercoles;
    @Size(max = 1)
    @Column(name = "d_jueves")
    private String dJueves;
    @Size(max = 1)
    @Column(name = "d_viernes")
    private String dViernes;
    @Size(max = 45)
    @Column(name = "d_sabado")
    private String dSabado;
    @Size(max = 45)
    @Column(name = "d_domingo")
    private String dDomingo;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "Cuenta_Id")
    @ManyToOne
    private CuentaUsuarioComp idCuenta;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
     
    
    public CompSchedule() {
    }

    public CompSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public CompSchedule( String asunto, Date fechaInicio, Date fechaFin) {
        //this.idSchedule = idSchedule;
        this.asunto = asunto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = "A";
    }

     public CompSchedule( String asunto, Date fechaInicio, Date fechaFin, String Descripcion ) {
        //this.idSchedule = idSchedule;
        this.asunto = asunto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = "A";
        this.descripcion = Descripcion;
    }
     
       public CompSchedule(Integer idSchedule,   Date fechaInicio, Date fechaFin  ) {
        this.idSchedule = idSchedule;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    
      
    }
      
      public CompSchedule(Integer idSchedule, String asunto,
                          Date fechaInicio, Date fechaFin, 
                          String Descripcion, String Categoria,
                          String Ubicacion,  String Prioridad, 
                          Date Fecha_Registro,
                          Date Fecha_Actualidacion) {
          
        this.idSchedule = idSchedule;
        this.asunto = asunto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = "A";
        this.descripcion = Descripcion;
        this.categoria = Categoria;
        this.ubicacion = Ubicacion;
        this.prioridad = Prioridad;
        this.fechaRegistro = Fecha_Registro;
        this.fechaActualizacion = Fecha_Actualidacion;
    }
       
      public CompSchedule(Integer idSchedule, String asunto, Date fechaInicio, Date fechaFin ) {
        this.idSchedule = idSchedule;
        this.asunto = asunto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = "A";
        
    }
      //Constructor para actualizacion
      
    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    

    public String getDLunes() {
        return dLunes;
    }

    public void setDLunes(String dLunes) {
        this.dLunes = dLunes;
    }

    public String getDMartes() {
        return dMartes;
    }

    public void setDMartes(String dMartes) {
        this.dMartes = dMartes;
    }

    public String getDMiercoles() {
        return dMiercoles;
    }

    public void setDMiercoles(String dMiercoles) {
        this.dMiercoles = dMiercoles;
    }

    public String getDJueves() {
        return dJueves;
    }

    public void setDJueves(String dJueves) {
        this.dJueves = dJueves;
    }

    public String getDViernes() {
        return dViernes;
    }

    public void setDViernes(String dViernes) {
        this.dViernes = dViernes;
    }

    public String getDSabado() {
        return dSabado;
    }

    public void setDSabado(String dSabado) {
        this.dSabado = dSabado;
    }

    public String getDDomingo() {
        return dDomingo;
    }

    public void setDDomingo(String dDomingo) {
        this.dDomingo = dDomingo;
    }

    public CuentaUsuarioComp getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaUsuarioComp idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSchedule != null ? idSchedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompSchedule)) {
            return false;
        }
        CompSchedule other = (CompSchedule) object;
        if ((this.idSchedule == null && other.idSchedule != null) || (this.idSchedule != null && !this.idSchedule.equals(other.idSchedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.models.CompSchedule[ idSchedule=" + idSchedule + " ]";
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    
}