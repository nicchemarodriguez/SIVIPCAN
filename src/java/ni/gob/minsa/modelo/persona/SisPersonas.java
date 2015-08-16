/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.modelo.persona;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "SIS_PERSONAS", catalog = "", schema = "SIS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"IDENTIFICACION_HSE"})})
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellido", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
     @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
     
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreDosApellidoFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    //N1,A1,A2
    @NamedQuery(name = "SisPersonas.findByNombre1DosApellido", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido"),
    
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
    
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
      
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
      
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
      
      @NamedQuery(name = "SisPersonas.findByNombre1DosApellidoFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
      
      
      
      
    //N2,A1,A2
     @NamedQuery(name = "SisPersonas.findByNombre2DosApellido", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido"),
     
     
     
     @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
     
     @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
     
     @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
     
     @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
     
     
      @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
     
     
     
      @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
     
     
      @NamedQuery(name = "SisPersonas.findByNombre2DosApellidoFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
     
     
     
    //N1,N2,A1
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido"),
    
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1FechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1Celular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1Identificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1FechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1CelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1FechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido1FechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),

    //3N1,N2,A2
    @NamedQuery(name = "SisPersonas.findByDosNombreApellido2", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido"),
    
    
    
    
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2FechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2Celular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2Identificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
    
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2FechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2CelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
     
     
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2FechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
     
     
     
     @NamedQuery(name = "SisPersonas.findByDosNombreApellido2FechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
     
     
     
    
    //N1,N2
    @NamedQuery(name = "SisPersonas.findByDosNombre", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre"),
    
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByDosNombreFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    
    @NamedQuery(name = "SisPersonas.findByDosNombreFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
    
    //N1,A1
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido"),

    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1FechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1Celular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1Identificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1FechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1CelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1FechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido1FechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
    //N1,A2
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido"),
    
    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2FechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2Celular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2Identificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2FechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2CelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2FechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre1Apellido2FechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
    
    
    

    
    //N2,A1
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido"),
    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1FechaNac", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1Celular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1Identificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1FechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1CelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1FechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido1FechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    //N2,A2
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2FechaNac", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2Celular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2Identificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2FechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2CelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2FechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    
    @NamedQuery(name = "SisPersonas.findByNombre2Apellido2FechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
    
    //A1,A2
    @NamedQuery(name = "SisPersonas.findByDosApellido", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido"),
    
    
     @NamedQuery(name = "SisPersonas.findByDosApellidoFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
     @NamedQuery(name = "SisPersonas.findByDosApellidoCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
     @NamedQuery(name = "SisPersonas.findByDosApellidoCelula", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
    
     @NamedQuery(name = "SisPersonas.findByDosApellidoFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
     
     
     @NamedQuery(name = "SisPersonas.findByDosApellidoCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
     
     
     @NamedQuery(name = "SisPersonas.findByDosApellidoFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
     
     
     @NamedQuery(name = "SisPersonas.findByDosApellidoFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
     
     
     
    //N1 
     
    @NamedQuery(name = "SisPersonas.findByPrimerNombre", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findByPrimerNombreFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
    
    
    
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombre", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoNombreFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
    
    
    
    
    
    
    
    
    @NamedQuery(name = "SisPersonas.findByPrimerApellido", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido"), 
    
     @NamedQuery(name = "SisPersonas.findByPrimerApellidoFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"), 
    
     @NamedQuery(name = "SisPersonas.findByPrimerApellidoCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil"), 
    
     @NamedQuery(name = "SisPersonas.findByPrimerApellidoIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.identificacion = :identificacion"), 
    
     @NamedQuery(name = "SisPersonas.findByPrimerApellidoFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"), 
     
      @NamedQuery(name = "SisPersonas.findByPrimerApellidoCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
      
       @NamedQuery(name = "SisPersonas.findByPrimerApellidoFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
       
        @NamedQuery(name = "SisPersonas.findByPrimerApellidoFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
    
     
     
     
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellido", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido"),
    
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoFechaNac", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
    
    @NamedQuery(name = "SisPersonas.findBySegundoApellidoFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
    
    
    
     @NamedQuery(name = "SisPersonas.findByFechaNacCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
    
    
     
      @NamedQuery(name = "SisPersonas.findByFechaNacIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.fechaNacimiento = :fechaNacimiento AND e.identificacion = :identificacion"),
      
       @NamedQuery(name = "SisPersonas.findByFechaNacCelular", query = "SELECT e FROM SisPersonas e WHERE e.fechaNacimiento = :fechaNacimiento AND e.telefonoMovil = :telefonoMovil"),
       
        @NamedQuery(name = "SisPersonas.findByCelularIdentificacion", query = "SELECT e FROM SisPersonas e WHERE e.telefonoMovil = :telefonoMovil AND e.identificacion = :identificacion"),
     
     
     
     
     
    @NamedQuery(name = "SisPersonas.findAll", query = "SELECT s FROM SisPersonas s"),
    @NamedQuery(name = "SisPersonas.findByPersonaId", query = "SELECT s FROM SisPersonas s WHERE s.personaId = :personaId"),
    @NamedQuery(name = "SisPersonas.findByIdentificacionHse", query = "SELECT s FROM SisPersonas s WHERE s.identificacionHse = :identificacionHse"),
    @NamedQuery(name = "SisPersonas.findByIdentificacion", query = "SELECT s FROM SisPersonas s WHERE s.identificacion = :identificacion"),
    @NamedQuery(name = "SisPersonas.findByFechaNacimiento", query = "SELECT s FROM SisPersonas s WHERE s.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "SisPersonas.findByDireccionResidencia", query = "SELECT s FROM SisPersonas s WHERE s.direccionResidencia = :direccionResidencia"),
    @NamedQuery(name = "SisPersonas.findByTelefonoResidencia", query = "SELECT s FROM SisPersonas s WHERE s.telefonoResidencia = :telefonoResidencia"),
    @NamedQuery(name = "SisPersonas.findByTelefonoMovil", query = "SELECT s FROM SisPersonas s WHERE s.telefonoMovil = :telefonoMovil"),
    @NamedQuery(name = "SisPersonas.findByNumeroAsegurado", query = "SELECT s FROM SisPersonas s WHERE s.numeroAsegurado = :numeroAsegurado"),
    @NamedQuery(name = "SisPersonas.findByCodigoTipoidentificacion", query = "SELECT s FROM SisPersonas s WHERE s.codigoTipoidentificacion = :codigoTipoidentificacion"),
    @NamedQuery(name = "SisPersonas.findByCodigoEtnia", query = "SELECT s FROM SisPersonas s WHERE s.codigoEtnia = :codigoEtnia"),
    @NamedQuery(name = "SisPersonas.findByCodigoEscolaridad", query = "SELECT s FROM SisPersonas s WHERE s.codigoEscolaridad = :codigoEscolaridad"),
    @NamedQuery(name = "SisPersonas.findByCodigoEstadocivil", query = "SELECT s FROM SisPersonas s WHERE s.codigoEstadocivil = :codigoEstadocivil"),
    @NamedQuery(name = "SisPersonas.findByCodigoTipoasegurado", query = "SELECT s FROM SisPersonas s WHERE s.codigoTipoasegurado = :codigoTipoasegurado"),
    @NamedQuery(name = "SisPersonas.findByCodigoSexo", query = "SELECT s FROM SisPersonas s WHERE s.codigoSexo = :codigoSexo"),
    @NamedQuery(name = "SisPersonas.findByCodigoOcupacion", query = "SELECT s FROM SisPersonas s WHERE s.codigoOcupacion = :codigoOcupacion"),
    @NamedQuery(name = "SisPersonas.findByCodigoMunicipioResidencia", query = "SELECT s FROM SisPersonas s WHERE s.codigoMunicipioResidencia = :codigoMunicipioResidencia"),
    @NamedQuery(name = "SisPersonas.findByCodigoComunidadResidencia", query = "SELECT s FROM SisPersonas s WHERE s.codigoComunidadResidencia = :codigoComunidadResidencia"),
    @NamedQuery(name = "SisPersonas.findByCodigoMunicipioNacimiento", query = "SELECT s FROM SisPersonas s WHERE s.codigoMunicipioNacimiento = :codigoMunicipioNacimiento"),
    @NamedQuery(name = "SisPersonas.findByCodigoPaisNacimiento", query = "SELECT s FROM SisPersonas s WHERE s.codigoPaisNacimiento = :codigoPaisNacimiento"),
    @NamedQuery(name = "SisPersonas.findByConfirmado", query = "SELECT s FROM SisPersonas s WHERE s.confirmado = :confirmado"),
    @NamedQuery(name = "SisPersonas.findByFechaRegistro", query = "SELECT s FROM SisPersonas s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "SisPersonas.findByUsuarioRegistro", query = "SELECT s FROM SisPersonas s WHERE s.usuarioRegistro = :usuarioRegistro"),
    @NamedQuery(name = "SisPersonas.findBySndNombre", query = "SELECT s FROM SisPersonas s WHERE s.sndNombre = :sndNombre"),
    @NamedQuery(name = "SisPersonas.findByFallecida", query = "SELECT s FROM SisPersonas s WHERE s.fallecida = :fallecida"),
    @NamedQuery(name = "SisPersonas.findByPasivo", query = "SELECT s FROM SisPersonas s WHERE s.pasivo = :pasivo"),
    //@NamedQuery(name = "SisPersonas.findByIdRegistroCentral", query = "SELECT s FROM SisPersonas s WHERE s.idRegistroCentral = :idRegistroCentral"),
    @NamedQuery(name = "SisPersonas.findByEmail", query = "SELECT s FROM SisPersonas s WHERE s.email = :email"),
    @NamedQuery(name = "SisPersonas.findByFax", query = "SELECT s FROM SisPersonas s WHERE s.fax = :fax")})
public class SisPersonas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA_ID", nullable = false)
    private Long personaId;
    @Size(max = 50)
    @Column(name = "IDENTIFICACION_HSE", length = 50)
    private String identificacionHse;
    @Size(max = 20)
    @Column(name = "IDENTIFICACION", length = 20)
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMER_NOMBRE", nullable = false, length = 50)
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 50)
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE", length = 50)
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO", length = 50)
    private String segundoApellido;
    @Size(max = 200)
    @Column(name = "DIRECCION_RESIDENCIA", length = 200)
    private String direccionResidencia;
    @Size(max = 20)
    @Column(name = "TELEFONO_RESIDENCIA", length = 20)
    private String telefonoResidencia;
    @Size(max = 20)
    @Column(name = "TELEFONO_MOVIL", length = 20)
    private String telefonoMovil;
    @Size(max = 20)
    @Column(name = "NUMERO_ASEGURADO", length = 20)
    private String numeroAsegurado;
    @Size(max = 50)
    @Column(name = "CODIGO_TIPOIDENTIFICACION", length = 50)
    private String codigoTipoidentificacion;
    @Size(max = 50)
    @Column(name = "CODIGO_ETNIA", length = 50)
    private String codigoEtnia;
    @Size(max = 50)
    @Column(name = "CODIGO_ESCOLARIDAD", length = 50)
    private String codigoEscolaridad;
    @Size(max = 50)
    @Column(name = "CODIGO_ESTADOCIVIL", length = 50)
    private String codigoEstadocivil;
    @Size(max = 50)
    @Column(name = "CODIGO_TIPOASEGURADO", length = 50)
    private String codigoTipoasegurado;
    @Size(max = 50)
    @Column(name = "CODIGO_SEXO", length = 50)
    private String codigoSexo;
    @Size(max = 50)
    @Column(name = "CODIGO_OCUPACION", length = 50)
    private String codigoOcupacion;
    @Size(max = 4)
    @Column(name = "CODIGO_MUNICIPIO_RESIDENCIA", length = 4)
    private String codigoMunicipioResidencia;
    @Size(max = 9)
    @Column(name = "CODIGO_COMUNIDAD_RESIDENCIA", length = 9)
    private String codigoComunidadResidencia;
    @Size(max = 4)
    @Column(name = "CODIGO_MUNICIPIO_NACIMIENTO", length = 4)
    private String codigoMunicipioNacimiento;
    @Size(max = 2)
    @Column(name = "CODIGO_PAIS_NACIMIENTO", length = 2)
    private String codigoPaisNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFIRMADO", nullable = false)
    private short confirmado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 100)
    private String usuarioRegistro;
    @Size(max = 200)
    @Column(name = "SND_NOMBRE", length = 200)
    private String sndNombre;
    @Column(name = "FALLECIDA")
    private Short fallecida;
    @Column(name = "PASIVO")
    private Short pasivo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "FAX", length = 20)
    private String fax;

    public SisPersonas() {
    }

    public SisPersonas(Long personaId) {
        this.personaId = personaId;
    }

    public SisPersonas(Long personaId, Date fechaNacimiento, String primerNombre, String primerApellido, short confirmado, Date fechaRegistro, String usuarioRegistro) {
        this.personaId = personaId;
        this.fechaNacimiento = fechaNacimiento;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.confirmado = confirmado;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getIdentificacionHse() {
        return identificacionHse;
    }

    public void setIdentificacionHse(String identificacionHse) {
        this.identificacionHse = identificacionHse;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getNumeroAsegurado() {
        return numeroAsegurado;
    }

    public void setNumeroAsegurado(String numeroAsegurado) {
        this.numeroAsegurado = numeroAsegurado;
    }

    public String getCodigoTipoidentificacion() {
        return codigoTipoidentificacion;
    }

    public void setCodigoTipoidentificacion(String codigoTipoidentificacion) {
        this.codigoTipoidentificacion = codigoTipoidentificacion;
    }

    public String getCodigoEtnia() {
        return codigoEtnia;
    }

    public void setCodigoEtnia(String codigoEtnia) {
        this.codigoEtnia = codigoEtnia;
    }

    public String getCodigoEscolaridad() {
        return codigoEscolaridad;
    }

    public void setCodigoEscolaridad(String codigoEscolaridad) {
        this.codigoEscolaridad = codigoEscolaridad;
    }

    public String getCodigoEstadocivil() {
        return codigoEstadocivil;
    }

    public void setCodigoEstadocivil(String codigoEstadocivil) {
        this.codigoEstadocivil = codigoEstadocivil;
    }

    public String getCodigoTipoasegurado() {
        return codigoTipoasegurado;
    }

    public void setCodigoTipoasegurado(String codigoTipoasegurado) {
        this.codigoTipoasegurado = codigoTipoasegurado;
    }

    public String getCodigoSexo() {
        return codigoSexo;
    }

    public void setCodigoSexo(String codigoSexo) {
        this.codigoSexo = codigoSexo;
    }

    public String getCodigoOcupacion() {
        return codigoOcupacion;
    }

    public void setCodigoOcupacion(String codigoOcupacion) {
        this.codigoOcupacion = codigoOcupacion;
    }

    public String getCodigoMunicipioResidencia() {
        return codigoMunicipioResidencia;
    }

    public void setCodigoMunicipioResidencia(String codigoMunicipioResidencia) {
        this.codigoMunicipioResidencia = codigoMunicipioResidencia;
    }

    public String getCodigoComunidadResidencia() {
        return codigoComunidadResidencia;
    }

    public void setCodigoComunidadResidencia(String codigoComunidadResidencia) {
        this.codigoComunidadResidencia = codigoComunidadResidencia;
    }

    public String getCodigoMunicipioNacimiento() {
        return codigoMunicipioNacimiento;
    }

    public void setCodigoMunicipioNacimiento(String codigoMunicipioNacimiento) {
        this.codigoMunicipioNacimiento = codigoMunicipioNacimiento;
    }

    public String getCodigoPaisNacimiento() {
        return codigoPaisNacimiento;
    }

    public void setCodigoPaisNacimiento(String codigoPaisNacimiento) {
        this.codigoPaisNacimiento = codigoPaisNacimiento;
    }

    public short getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(short confirmado) {
        this.confirmado = confirmado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public String getSndNombre() {
        return sndNombre;
    }

    public void setSndNombre(String sndNombre) {
        this.sndNombre = sndNombre;
    }

    public Short getFallecida() {
        return fallecida;
    }

    public void setFallecida(Short fallecida) {
        this.fallecida = fallecida;
    }

    public Short getPasivo() {
        return pasivo;
    }

    public void setPasivo(Short pasivo) {
        this.pasivo = pasivo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisPersonas)) {
            return false;
        }
        SisPersonas other = (SisPersonas) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.modelo.persona.SisPersonas[ personaId=" + personaId + " ]";
    }
    
}
