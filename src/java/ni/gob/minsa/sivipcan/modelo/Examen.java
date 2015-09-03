/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import ni.gob.minsa.modelo.poblacion.Catalogos;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.modelo.poblacion.Sector;

/**
 *
 * @author WIN 7
 */
@Entity
@Table(name = "EXAMEN", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    
    @NamedQuery(name = "Examen.findByNumeroExpediente", query = "SELECT e FROM Examen e WHERE e.numeroExpediente LIKE :numeroExpediente"),
    @NamedQuery(name = "Examen.findByNumeroExpedienteTemp", query = "SELECT e FROM Examen e WHERE e.numeroExpedienteTemp = :numeroExpedienteTemp"),
    @NamedQuery(name = "Examen.findByIdExamen", query = "SELECT e FROM Examen e WHERE e.idExamen = :idExamen"),
    
    
     //N1,N2,A1,A2 
    @NamedQuery(name = "Examen.findByDosNombreDosApellido", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido"),
    
    @NamedQuery(name = "Examen.findByDosNombreDosApellidoFechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByDosNombreDosApellidoCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
     @NamedQuery(name = "Examen.findByDosNombreDosApellidoCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
     
    @NamedQuery(name = "Examen.findByDosNombreDosApellidoFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByDosNombreDosApellidoCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByDosNombreDosApellidoFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByDosNombreDosApellidoFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    //N1,A1,A2
    @NamedQuery(name = "Examen.findByNombre1DosApellido", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido"),
    
      @NamedQuery(name = "Examen.findByNombre1DosApellidoFechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
      @NamedQuery(name = "Examen.findByNombre1DosApellidoCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
      @NamedQuery(name = "Examen.findByNombre1DosApellidoCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
    
      @NamedQuery(name = "Examen.findByNombre1DosApellidoFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
      
      @NamedQuery(name = "Examen.findByNombre1DosApellidoCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
      
      @NamedQuery(name = "Examen.findByNombre1DosApellidoFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
      
      @NamedQuery(name = "Examen.findByNombre1DosApellidoFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
      
      
      
      
    //N2,A1,A2
     @NamedQuery(name = "Examen.findByNombre2DosApellido", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido"),
     
     
     
     @NamedQuery(name = "Examen.findByNombre2DosApellidoFechaNac", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
     
     @NamedQuery(name = "Examen.findByNombre2DosApellidoCelular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
     
     @NamedQuery(name = "Examen.findByNombre2DosApellidoCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
     
     @NamedQuery(name = "Examen.findByNombre2DosApellidoFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
     
     
      @NamedQuery(name = "Examen.findByNombre2DosApellidoCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
     
     
     
      @NamedQuery(name = "Examen.findByNombre2DosApellidoFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
     
     
      @NamedQuery(name = "Examen.findByNombre2DosApellidoFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "AND e.primerApellido = :primerApellido AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
     
     
     
    //N1,N2,A1
    @NamedQuery(name = "Examen.findByDosNombreApellido1", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido"),
    
    
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1FechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1Celular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1Cedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1FechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1CelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1FechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    
    @NamedQuery(name = "Examen.findByDosNombreApellido1FechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre  AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),

    //3N1,N2,A2
    @NamedQuery(name = "Examen.findByDosNombreApellido2", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido"),
    
    
    
    
     @NamedQuery(name = "Examen.findByDosNombreApellido2FechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
     @NamedQuery(name = "Examen.findByDosNombreApellido2Celular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
     @NamedQuery(name = "Examen.findByDosNombreApellido2Cedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
    
     @NamedQuery(name = "Examen.findByDosNombreApellido2FechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
     @NamedQuery(name = "Examen.findByDosNombreApellido2CelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
     
     
     @NamedQuery(name = "Examen.findByDosNombreApellido2FechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
     
     
     
     @NamedQuery(name = "Examen.findByDosNombreApellido2FechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + " AND e.segundoNombre = :segundoNombre AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
     
     
     
    
    //N1,N2
    @NamedQuery(name = "Examen.findByDosNombre", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre"),
    
    
    
    @NamedQuery(name = "Examen.findByDosNombreFechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByDosNombreCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByDosNombreCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByDosNombreFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    @NamedQuery(name = "Examen.findByDosNombreCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByDosNombreFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    
    @NamedQuery(name = "Examen.findByDosNombreFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
    
    //N1,A1
    @NamedQuery(name = "Examen.findByNombre1Apellido1", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido"),

    
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1FechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1Celular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1Cedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1FechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1CelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1FechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido1FechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
    //N1,A2
    @NamedQuery(name = "Examen.findByNombre1Apellido2", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido"),
    
    
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2FechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2Celular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2Cedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2FechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2CelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2FechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    
    @NamedQuery(name = "Examen.findByNombre1Apellido2FechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
    
    
    

    
    //N2,A1
    @NamedQuery(name = "Examen.findByNombre2Apellido1", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido"),
    
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1FechaNac", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1Celular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1Cedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1FechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1CelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1FechaNacCelular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido1FechaNacCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + " AND e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    //N2,A2
    @NamedQuery(name = "Examen.findByNombre2Apellido2", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido"),
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2FechaNac", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2Celular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2Cedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2FechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2CelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2FechaNacCelular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    
    @NamedQuery(name = "Examen.findByNombre2Apellido2FechaNacCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre "
            + "  AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
    
    //A1,A2
    @NamedQuery(name = "Examen.findByDosApellido", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido"),
    
    
     @NamedQuery(name = "Examen.findByDosApellidoFechaNac", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
     @NamedQuery(name = "Examen.findByDosApellidoCelular", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
     @NamedQuery(name = "Examen.findByDosApellidoCelula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
    
     @NamedQuery(name = "Examen.findByDosApellidoFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
     
     
     @NamedQuery(name = "Examen.findByDosApellidoCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
     
     
     @NamedQuery(name = "Examen.findByDosApellidoFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
     
     
     @NamedQuery(name = "Examen.findByDosApellidoFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido  "
            + "AND e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
     
     
     
    //N1 
     
    @NamedQuery(name = "Examen.findByPrimerNombre", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreFechaNac", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findByPrimerNombreFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerNombre = :primerNombre AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
    
    
    
    
    @NamedQuery(name = "Examen.findBySegundoNombre", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreFechaNac", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreCelular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findBySegundoNombreFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.segundoNombre = :segundoNombre AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
    
    
    
    
    
    
    
    
    @NamedQuery(name = "Examen.findByPrimerApellido", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido"), 
    
     @NamedQuery(name = "Examen.findByPrimerApellidoFechaNac", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento"), 
    
     @NamedQuery(name = "Examen.findByPrimerApellidoCelular", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.telefono = :telefono"), 
    
     @NamedQuery(name = "Examen.findByPrimerApellidoCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.cedula = :cedula"), 
    
     @NamedQuery(name = "Examen.findByPrimerApellidoFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"), 
     
      @NamedQuery(name = "Examen.findByPrimerApellidoCelularCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
      
       @NamedQuery(name = "Examen.findByPrimerApellidoFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
       
        @NamedQuery(name = "Examen.findByPrimerApellidoFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.primerApellido = :primerApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
    
    
    
     
     
     
    
    @NamedQuery(name = "Examen.findBySegundoApellido", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido"),
    
    
    @NamedQuery(name = "Examen.findBySegundoApellidoFechaNac", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento"),
    
    @NamedQuery(name = "Examen.findBySegundoApellidoCelular", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findBySegundoApellidoCedula", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findBySegundoApellidoFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findBySegundoApellidoCelularCedula", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.telefono = :telefono AND e.cedula = :cedula"),
    
    @NamedQuery(name = "Examen.findBySegundoApellidoFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
    
    @NamedQuery(name = "Examen.findBySegundoApellidoFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.segundoApellido = :segundoApellido AND e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
    
     @NamedQuery(name = "Examen.findByFechaNacCelularCedula", query = "SELECT e FROM Examen e WHERE e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono AND e.cedula = :cedula"),
    
     
     @NamedQuery(name = "Examen.findByFechaNacCelular", query = "SELECT e FROM Examen e WHERE e.fechaNacimiento = :fechaNacimiento AND e.telefono = :telefono"),
     @NamedQuery(name = "Examen.findByFechaNacCedula", query = "SELECT e FROM Examen e WHERE e.fechaNacimiento = :fechaNacimiento AND e.cedula = :cedula"),
     @NamedQuery(name = "Examen.findByCelularCedula", query = "SELECT e FROM Examen e WHERE e.telefono = :telefono AND e.cedula = :cedula"),
    
    
    
    
     
     
    
    @NamedQuery(name = "Examen.findByDireccionActual", query = "SELECT e FROM Examen e WHERE e.direccionActual = :direccionActual"),
    @NamedQuery(name = "Examen.findByEdad", query = "SELECT e FROM Examen e WHERE e.edad = :edad"),
 
    @NamedQuery(name = "Examen.findByTelefono", query = "SELECT e FROM Examen e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Examen.findByTelefono2", query = "SELECT e FROM Examen e WHERE e.telefono2 = :telefono2"),
  
    @NamedQuery(name = "Examen.findByFechaNacimiento", query = "SELECT e FROM Examen e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Examen.findByCedula", query = "SELECT e FROM Examen e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Examen.findByEstado", query = "SELECT e FROM Examen e WHERE e.estado = :estado")})
public class Examen implements Serializable {
    
    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente idPaciente;

   
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_EXPEDIENTE", nullable = false, length = 20)
    private String numeroExpediente;
    @Size(max = 20)
    @Column(name = "NUMERO_EXPEDIENTE_TEMP", length = 20)
    private String numeroExpedienteTemp;
    @Id 
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "PRUEBA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID_EXAMEN", nullable = false)
    private Long idExamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PRIMER_NOMBRE", nullable = false, length = 25)
    private String primerNombre;
    @Size(max = 25)
    @Column(name = "SEGUNDO_NOMBRE", length = 25)
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 25)
    private String primerApellido;
    @Size(max = 25)
    @Column(name = "SEGUNDO_APELLIDO", length = 25)
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCION_ACTUAL", nullable = false, length = 100)
    private String direccionActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD", nullable = false)
    private BigInteger edad;
   
    @Size(max = 15)
    @Column(name = "TELEFONO", length = 15)
    private String telefono;
    @Size(max = 15)
    @Column(name = "TELEFONO2", length = 15)
    private String telefono2;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CEDULA", nullable = false, length = 50)
    private String cedula;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @JoinColumn(name = "ID_COMUNIDAD_RESIDENCIA", referencedColumnName = "COMUNIDAD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comunidad idComunidadResidencia;
    @Size(max = 8)
    @Column(name = "TRIAJE", length = 8)
    private String triaje;
     @JoinColumn(name = "ID_SECTOR_RESIDENCIA", referencedColumnName = "SECTOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sector idSectorResidencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamen", fetch = FetchType.LAZY)
    private List<UnidadesXExamen> unidadesXExamenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamen", fetch = FetchType.LAZY)
    private List<ResultadoExamen> resultadoExamenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examen", fetch = FetchType.LAZY)
    private List<Fxexu> fxexuList;
    @JoinColumn(name = "ID_IMAGEN", referencedColumnName = "ID_IMAGEN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Imagen idImagen;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CATALOGO_X_EXAMEN", joinColumns = @JoinColumn(name="ID_EXAMEN"),
            inverseJoinColumns = @JoinColumn(name = "ID_CATALOGO"))
    private List<Catalogos> catalogoList;

    public Examen() {
    }

    public Examen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public Examen(Long idExamen,  String numeroExpediente, String primerNombre, String primerApellido, String direccionActual, BigInteger edad, Date fechaNacimiento, String cedula) {
        this.idExamen = idExamen;
        
        this.numeroExpediente = numeroExpediente;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.direccionActual = direccionActual;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
    }

    

    public List<Catalogos> getCatalogoList() {
        return catalogoList;
    }

    public void setCatalogoList(List<Catalogos> catalogoList) {
        this.catalogoList = catalogoList;
    }
    


    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNumeroExpedienteTemp() {
        return numeroExpedienteTemp;
    }

    public void setNumeroExpedienteTemp(String numeroExpedienteTemp) {
        this.numeroExpedienteTemp = numeroExpedienteTemp;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

  
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

  

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public Comunidad getIdComunidadResidencia() {
        return idComunidadResidencia;
    }

    public void setIdComunidadResidencia(Comunidad idComunidadResidencia) {
        this.idComunidadResidencia = idComunidadResidencia;
    }

    public Sector getIdSectorResidencia() {
        return idSectorResidencia;
    }

    public void setIdSectorResidencia(Sector idSectorResidencia) {
        this.idSectorResidencia = idSectorResidencia;
    }

   

    public String getTriaje() {
        return triaje;
    }

    public void setTriaje(String triaje) {
        this.triaje = triaje;
    }

    @XmlTransient
    public List<UnidadesXExamen> getUnidadesXExamenList() {
        return unidadesXExamenList;
    }

    public void setUnidadesXExamenList(List<UnidadesXExamen> unidadesXExamenList) {
        this.unidadesXExamenList = unidadesXExamenList;
    }

    @XmlTransient
    public List<ResultadoExamen> getResultadoExamenList() {
        return resultadoExamenList;
    }

    public void setResultadoExamenList(List<ResultadoExamen> resultadoExamenList) {
        this.resultadoExamenList = resultadoExamenList;
    }

    @XmlTransient
    public List<Fxexu> getFxexuList() {
        return fxexuList;
    }

    public void setFxexuList(List<Fxexu> fxexuList) {
        this.fxexuList = fxexuList;
    }

    public Imagen getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Imagen idImagen) {
        this.idImagen = idImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.Examen[ idExamen=" + idExamen + " ]";
    }

  

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

  

    

   
    
}
