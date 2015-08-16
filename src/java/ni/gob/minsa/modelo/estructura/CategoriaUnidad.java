/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.estructura;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "CATEGORIAS_UNIDADES", catalog = "", schema = "GENERAL", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBRE"}),
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaUnidad.findAll", query = "SELECT c FROM CategoriaUnidad c"),
    @NamedQuery(name = "CategoriaUnidad.findByCategoriaUnidadId", query = "SELECT c FROM CategoriaUnidad c WHERE c.categoriaUnidadId = :categoriaUnidadId"),
    @NamedQuery(name = "CategoriaUnidad.findByNombre", query = "SELECT c FROM CategoriaUnidad c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CategoriaUnidad.findByUrlImagen", query = "SELECT c FROM CategoriaUnidad c WHERE c.urlImagen = :urlImagen"),
    @NamedQuery(name = "CategoriaUnidad.findByCodigo", query = "SELECT c FROM CategoriaUnidad c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CategoriaUnidad.findByPasivo", query = "SELECT c FROM CategoriaUnidad c WHERE c.pasivo = :pasivo")})
public class CategoriaUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIA_UNIDAD_ID", nullable = false)
    private Long categoriaUnidadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE", nullable = false, length = 25)
    private String nombre;
    @Size(max = 500)
    @Column(name = "URL_IMAGEN", length = 500)
    private String urlImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    private long codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASIVO", nullable = false)
    private char pasivo;

    public CategoriaUnidad() {
    }

    public CategoriaUnidad(Long categoriaUnidadId) {
        this.categoriaUnidadId = categoriaUnidadId;
    }

    public CategoriaUnidad(Long categoriaUnidadId, String nombre, long codigo, char pasivo) {
        this.categoriaUnidadId = categoriaUnidadId;
        this.nombre = nombre;
        this.codigo = codigo;
        this.pasivo = pasivo;
    }

    public Long getCategoriaUnidadId() {
        return categoriaUnidadId;
    }

    public void setCategoriaUnidadId(Long categoriaUnidadId) {
        this.categoriaUnidadId = categoriaUnidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public char getPasivo() {
        return pasivo;
    }

    public void setPasivo(char pasivo) {
        this.pasivo = pasivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaUnidadId != null ? categoriaUnidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaUnidad)) {
            return false;
        }
        CategoriaUnidad other = (CategoriaUnidad) object;
        if ((this.categoriaUnidadId == null && other.categoriaUnidadId != null) || (this.categoriaUnidadId != null && !this.categoriaUnidadId.equals(other.categoriaUnidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.estructura.CategoriaUnidad[ categoriaUnidadId=" + categoriaUnidadId + " ]";
    }
    
}
