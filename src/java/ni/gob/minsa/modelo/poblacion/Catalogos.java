/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.poblacion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.Examen;
import ni.gob.minsa.sivipcan.modelo.Fxexu;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "CATALOGOS", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"VALOR", "DEPENDENCIA"}),
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogos.findAll", query = "SELECT c FROM Catalogos c"),
    @NamedQuery(name = "Catalogos.findByCatalogoId", query = "SELECT c FROM Catalogos c WHERE c.catalogoId = :catalogoId"),
    @NamedQuery(name = "Catalogos.findByValor", query = "SELECT c FROM Catalogos c WHERE c.valor = :valor"),
    @NamedQuery(name = "Catalogos.findByCodigo", query = "SELECT c FROM Catalogos c WHERE c.codigo LIKE :codigo"),
    @NamedQuery(name = "Catalogos.buscarRespuestaMetodo", query = "SELECT c FROM Catalogos c WHERE c.codigo = :codigo OR c.codigo = :codigo1"),
    @NamedQuery(name = "Catalogos.findByPasivo", query = "SELECT c FROM Catalogos c WHERE c.pasivo = :pasivo"),
    @NamedQuery(name = "Catalogos.findByOrden", query = "SELECT c FROM Catalogos c WHERE c.orden = :orden"),
    @NamedQuery(name = "Catalogos.findByDescripcion", query = "SELECT c FROM Catalogos c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Catalogos.findByDependencia", query = "SELECT c FROM Catalogos c WHERE c.dependencia = :dependencia"),
    @NamedQuery(name = "Catalogos.findByUsuarioRegistro", query = "SELECT c FROM Catalogos c WHERE c.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "Catalogos.findByFechaRegistro", query = "SELECT c FROM Catalogos c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Catalogos.findByFinal1", query = "SELECT c FROM Catalogos c WHERE c.final1 = :final1")})
public class Catalogos implements Serializable { 
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATALOGO_ID", nullable = false)
    private Long catalogoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VALOR", nullable = false, length = 100)
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODIGO", nullable = false, length = 50)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASIVO", nullable = false)
    private short pasivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN", nullable = false)
    private short orden;
    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @Size(max = 50)
    @Column(name = "DEPENDENCIA", length = 50)
    private String dependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 100)
    private String usuarioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FINAL", nullable = false)
    private short final1;
    @ManyToMany(mappedBy = "catalogoList", fetch = FetchType.LAZY)
    private List<Examen> examenList;
   
    @OneToMany(mappedBy = "Catalogos", fetch = FetchType.LAZY)
    private List<Categoria> categoriaList;
    

    public Catalogos() {
    }

    public Catalogos(Long catalogoId) {
        this.catalogoId = catalogoId;
    }

    public Catalogos(Long catalogoId, String valor, String codigo, short pasivo, short orden, String usuarioRegistro, Date fechaRegistro, short final1) {
        this.catalogoId = catalogoId;
        this.valor = valor;
        this.codigo = codigo;
        this.pasivo = pasivo;
        this.orden = orden;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.final1 = final1;
    }

    public Long getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Long catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public short getPasivo() {
        return pasivo;
    }

    public void setPasivo(short pasivo) {
        this.pasivo = pasivo;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }
    
    @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public short getFinal1() {
        return final1;
    }

    public void setFinal1(short final1) {
        this.final1 = final1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogoId != null ? catalogoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogos)) {
            return false;
        }
        Catalogos other = (Catalogos) object;
        if ((this.catalogoId == null && other.catalogoId != null) || (this.catalogoId != null && !this.catalogoId.equals(other.catalogoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.poblacion.Catalogos[ catalogoId=" + catalogoId + " ]";
    }
    
}
