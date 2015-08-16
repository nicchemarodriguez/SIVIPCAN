/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.controlador;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ni.gob.minsa.modelo.estructura.EntidadAdtva;
import ni.gob.minsa.modelo.estructura.Unidad;
import ni.gob.minsa.modelo.poblacion.Comunidad;
import ni.gob.minsa.modelo.poblacion.DivisionPolitica;
import ni.gob.minsa.modelo.poblacion.Sector;
import ni.gob.minsa.sivipcan.modelo.Categoria;
import ni.gob.minsa.sivipcan.modelo.Examen;
import ni.gob.minsa.sivipcan.modelo.Fxexu;
import ni.gob.minsa.sivipcan.modelo.SubCategoria;
import ni.gob.minsa.sivipcan.modelo.Valores;

/**
 *
 * @author WIN 7
 */
@Stateless
public class ExamenEJB {

   @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;
     
   
   
   
  public List<Examen> buscarID(Long idPersona) {
        Query query = em.createNamedQuery("Examen.findByIdExamen");
        query.setParameter("idExamen", idPersona);
        return query.getResultList();
    }
  
 public List<Examen> buscarPorPajas(String Cedula, String Celular, Date FechaNac) {
       
        if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {
            System.out.println("tenemos los 3EJB");
            Query query = em.createNamedQuery("Examen.findByFechaNacCelularCedula");
            query.setParameter("cedula", Cedula);
            query.setParameter("telefono", Celular);
            query.setParameter("fechaNacimiento", FechaNac);
            return query.getResultList();
        } else {
            if (!Cedula.isEmpty() && FechaNac != null) {
                
                Query query = em.createNamedQuery("Examen.findByFechaNacCedula");
                query.setParameter("cedula", Cedula);

                query.setParameter("fechaNacimiento", FechaNac);

                return query.getResultList();
            } else {
                if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                   
                    Query query = em.createNamedQuery("Examen.findByCelularCedula");
                    query.setParameter("cedula", Cedula);
                    query.setParameter("telefono", Celular);

                    return query.getResultList();

                } else {
                    if (FechaNac != null && !Celular.isEmpty()) {
                        

                        Query query = em.createNamedQuery("Examen.findByFechaNacCelular");
                        query.setParameter("telefono", Celular);
                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Cedula.isEmpty()) {
                            

                            Query query = em.createNamedQuery("Examen.findByCedula");
                            query.setParameter("cedula", Cedula);

                            return query.getResultList();
                        } else {
                            if (!Celular.isEmpty()) {
                               

                                Query query = em.createNamedQuery("Examen.findByTelefono");

                                query.setParameter("telefono", Celular);

                                return query.getResultList();
                            } else {
                                if (FechaNac != null) {
                                  

                                    Query query = em.createNamedQuery("Examen.findByFechaNacimiento");
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();

                                }
                                return null;
                            }
                        }

                    }
                }
            }
        }

    }

    public List<Examen> buscarExamenPorDosNombreDosApellido(String nombre1, String nombre2, String apellido1, String apellido2, String Cedula, String Celular, Date FechaNac) {

        //n1,n2,a1,a2
        if (nombre1 != "" && nombre2 != "" && apellido1 != "" && apellido2 != "") {

            if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoFechaNacCelularCedula");

                query.setParameter("primerNombre", nombre1);
                query.setParameter("segundoNombre", nombre2);
                query.setParameter("primerApellido", apellido1);
                query.setParameter("segundoApellido", apellido2);
                query.setParameter("cedula", Cedula);
                query.setParameter("telefono", Celular);
                query.setParameter("fechaNacimiento", FechaNac);
                return query.getResultList();
            } else {
                if (!Cedula.isEmpty() && FechaNac != null) {
                    Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoFechaNacCedula");

                    query.setParameter("primerNombre", nombre1);
                    query.setParameter("segundoNombre", nombre2);
                    query.setParameter("primerApellido", apellido1);
                    query.setParameter("segundoApellido", apellido2);
                    query.setParameter("cedula", Cedula);

                    query.setParameter("fechaNacimiento", FechaNac);
                    return query.getResultList();
                } else {
                    if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                        Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoCelularCedula");

                        query.setParameter("primerNombre", nombre1);
                        query.setParameter("segundoNombre", nombre2);
                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("cedula", Cedula);
                        query.setParameter("telefono", Celular);

                        return query.getResultList();

                    } else {
                        if (FechaNac != null && !Celular.isEmpty()) {
                            Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoFechaNacCelular");

                            query.setParameter("primerNombre", nombre1);
                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);

                            query.setParameter("telefono", Celular);
                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Cedula.isEmpty()) {
                                Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoCedula");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("cedula", Cedula);

                                return query.getResultList();
                            } else {
                                if (!Celular.isEmpty()) {
                                    Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoCelular");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);

                                    query.setParameter("telefono", Celular);

                                    return query.getResultList();
                                } else {
                                    if (FechaNac != null) {
                                        Query query = em.createNamedQuery("Examen.findByDosNombreDosApellidoFechaNac");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);

                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();

                                    } else {

                                        Query query = em.createNamedQuery("Examen.findByDosNombreDosApellido");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);
                                        return query.getResultList();

                                    }

                                }
                            }

                        }
                    }
                }
            }

        } else {
            //n2,a1,a2
            if (nombre1 == "" && nombre2 != "" && apellido1 != "" && apellido2 != "") {

                if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                    Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoFechaNacCelularCedula");

                    query.setParameter("segundoNombre", nombre2);
                    query.setParameter("primerApellido", apellido1);
                    query.setParameter("segundoApellido", apellido2);
                    query.setParameter("cedula", Cedula);
                    query.setParameter("telefono", Celular);
                    query.setParameter("fechaNacimiento", FechaNac);
                    return query.getResultList();
                } else {
                    if (!Cedula.isEmpty() && FechaNac != null) {
                        Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoFechaNacCedula");

                        query.setParameter("segundoNombre", nombre2);
                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("cedula", Cedula);

                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                            Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoCelularCedula");

                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);
                            query.setParameter("cedula", Cedula);
                            query.setParameter("telefono", Celular);

                            return query.getResultList();

                        } else {
                            if (FechaNac != null && !Celular.isEmpty()) {
                                Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoFechaNacCelular");

                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);

                                query.setParameter("telefono", Celular);
                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Cedula.isEmpty()) {
                                    Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoCedula");

                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);
                                    query.setParameter("cedula", Cedula);

                                    return query.getResultList();
                                } else {
                                    if (!Celular.isEmpty()) {
                                        Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoCelular");

                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);

                                        query.setParameter("telefono", Celular);

                                        return query.getResultList();
                                    } else {
                                        if (FechaNac != null) {
                                            Query query = em.createNamedQuery("Examen.findByNombre2DosApellidoFechaNac");

                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();

                                        } else {

                                            Query query = em.createNamedQuery("Examen.findByNombre2DosApellido");

                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);
                                            return query.getResultList();

                                        }

                                    }
                                }

                            }
                        }
                    }
                }

            } else {
                //n1,a1,a2
                if (nombre1 != "" && nombre2 == "" && apellido1 != "" && apellido2 != "") {
                    if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                        Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoFechaNacCelularCedula");

                        query.setParameter("primerNombre", nombre1);

                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("cedula", Cedula);
                        query.setParameter("telefono", Celular);
                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Cedula.isEmpty() && FechaNac != null) {
                            Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoFechaNacCedula");

                            query.setParameter("primerNombre", nombre1);

                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);
                            query.setParameter("cedula", Cedula);

                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoCelularCedula");

                                query.setParameter("primerNombre", nombre1);

                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("cedula", Cedula);
                                query.setParameter("telefono", Celular);

                                return query.getResultList();

                            } else {
                                if (FechaNac != null && !Celular.isEmpty()) {
                                    Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoFechaNacCelular");

                                    query.setParameter("primerNombre", nombre1);

                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);

                                    query.setParameter("telefono", Celular);
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Cedula.isEmpty()) {
                                        Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoCedula");

                                        query.setParameter("primerNombre", nombre1);

                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);
                                        query.setParameter("cedula", Cedula);

                                        return query.getResultList();
                                    } else {
                                        if (!Celular.isEmpty()) {
                                            Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoCelular");

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("telefono", Celular);

                                            return query.getResultList();
                                        } else {
                                            if (FechaNac != null) {
                                                Query query = em.createNamedQuery("Examen.findByNombre1DosApellidoFechaNac");

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("primerApellido", apellido1);
                                                query.setParameter("segundoApellido", apellido2);

                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();

                                            } else {

                                                Query query = em.createNamedQuery("Examen.findByNombre1DosApellido");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("primerApellido", apellido1);
                                                query.setParameter("segundoApellido", apellido2);
                                                return query.getResultList();
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }

                } else {
                    //n1,n2,a1
                    if (nombre1 != "" && nombre2 != "" && apellido1 != "" && apellido2 == "") {

                        if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                            Query query = em.createNamedQuery("Examen.findByDosNombreApellido1FechaNacCelularCedula");

                            query.setParameter("primerNombre", nombre1);
                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);

                            query.setParameter("cedula", Cedula);
                            query.setParameter("telefono", Celular);
                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Cedula.isEmpty() && FechaNac != null) {
                                Query query = em.createNamedQuery("Examen.findByDosNombreApellido1FechaNacCedula");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);

                                query.setParameter("cedula", Cedula);

                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                    Query query = em.createNamedQuery("Examen.findByDosNombreApellido1CelularCedula");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);

                                    query.setParameter("cedula", Cedula);
                                    query.setParameter("telefono", Celular);

                                    return query.getResultList();

                                } else {
                                    if (FechaNac != null && !Celular.isEmpty()) {
                                        Query query = em.createNamedQuery("Examen.findByDosNombreApellido1FechaNacCelular");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);

                                        query.setParameter("telefono", Celular);
                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Cedula.isEmpty()) {
                                            Query query = em.createNamedQuery("Examen.findByDosNombreApellido1Cedula");

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);

                                            query.setParameter("cedula", Cedula);

                                            return query.getResultList();
                                        } else {
                                            if (!Celular.isEmpty()) {
                                                Query query = em.createNamedQuery("Examen.findByDosNombreApellido1Celular");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);
                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("telefono", Celular);

                                                return query.getResultList();
                                            } else {
                                                if (FechaNac != null) {
                                                    Query query = em.createNamedQuery("Examen.findByDosNombreApellido1FechaNac");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();

                                                } else {

                                                    Query query = em.createNamedQuery("Examen.findByDosNombreApellido1");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    return query.getResultList();

                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }

                    } else {
                        //n1,n2,a2
                        if (nombre1 != "" && nombre2 != "" && apellido1 == "" && apellido2 != "") {

                            if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                Query query = em.createNamedQuery("Examen.findByDosNombreApellido2FechaNacCelularCedula");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);

                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("cedula", Cedula);
                                query.setParameter("telefono", Celular);
                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Cedula.isEmpty() && FechaNac != null) {
                                    Query query = em.createNamedQuery("Examen.findByDosNombreApellido2FechaNacCedula");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);

                                    query.setParameter("segundoApellido", apellido2);
                                    query.setParameter("cedula", Cedula);

                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                        Query query = em.createNamedQuery("Examen.findByDosNombreApellido2CelularCedula");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);

                                        query.setParameter("segundoApellido", apellido2);
                                        query.setParameter("cedula", Cedula);
                                        query.setParameter("telefono", Celular);

                                        return query.getResultList();

                                    } else {
                                        if (FechaNac != null && !Celular.isEmpty()) {
                                            Query query = em.createNamedQuery("Examen.findByDosNombreApellido2FechaNacCelular");

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);

                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("telefono", Celular);
                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Cedula.isEmpty()) {
                                                Query query = em.createNamedQuery("Examen.findByDosNombreApellido2Cedula");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);

                                                query.setParameter("segundoApellido", apellido2);
                                                query.setParameter("cedula", Cedula);

                                                return query.getResultList();
                                            } else {
                                                if (!Celular.isEmpty()) {
                                                    Query query = em.createNamedQuery("Examen.findByDosNombreApellido2Celular");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("segundoApellido", apellido2);

                                                    query.setParameter("telefono", Celular);

                                                    return query.getResultList();
                                                } else {
                                                    if (FechaNac != null) {
                                                        Query query = em.createNamedQuery("Examen.findByDosNombreApellido2FechaNac");

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("segundoApellido", apellido2);

                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();

                                                    } else {

                                                        Query query = em.createNamedQuery("Examen.findByDosNombreApellido2");

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);
                                                        query.setParameter("segundoApellido", apellido2);
                                                        return query.getResultList();

                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }

                        } else {
                            //n1,n2
                            if (nombre1 != "" && nombre2 != "" && apellido1 == "" && apellido2 == "") {
                                if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                    Query query = em.createNamedQuery("Examen.findByDosNombreFechaNacCelularCedula");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);

                                    query.setParameter("cedula", Cedula);
                                    query.setParameter("telefono", Celular);
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Cedula.isEmpty() && FechaNac != null) {
                                        Query query = em.createNamedQuery("Examen.findByDosNombreFechaNacCedula");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);

                                        query.setParameter("cedula", Cedula);

                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                            Query query = em.createNamedQuery("Examen.findByDosNombreCelularCedula");

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);

                                            query.setParameter("cedula", Cedula);
                                            query.setParameter("telefono", Celular);

                                            return query.getResultList();

                                        } else {
                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                Query query = em.createNamedQuery("Examen.findByDosNombreFechaNacCelular");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);

                                                query.setParameter("telefono", Celular);
                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Cedula.isEmpty()) {
                                                    Query query = em.createNamedQuery("Examen.findByDosNombreCedula");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("cedula", Cedula);

                                                    return query.getResultList();
                                                } else {
                                                    if (!Celular.isEmpty()) {
                                                        Query query = em.createNamedQuery("Examen.findByDosNombreCelular");

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("telefono", Celular);

                                                        return query.getResultList();
                                                    } else {
                                                        if (FechaNac != null) {
                                                            Query query = em.createNamedQuery("Examen.findByDosNombreFechaNac");

                                                            query.setParameter("primerNombre", nombre1);
                                                            query.setParameter("segundoNombre", nombre2);

                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();

                                                        } else {

                                                            Query query = em.createNamedQuery("Examen.findByDosNombre");

                                                            query.setParameter("primerNombre", nombre1);
                                                            query.setParameter("segundoNombre", nombre2);
                                                            return query.getResultList();

                                                        }

                                                    }
                                                }

                                            }
                                        }
                                    }
                                }

                            } else {
                                //n1,a1
                                if (nombre1 != "" && nombre2 == "" && apellido1 != "" && apellido2 == "") {
                                    if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                        Query query = em.createNamedQuery("Examen.findByNombre1Apellido1FechaNacCelularCedula");

                                        query.setParameter("primerNombre", nombre1);

                                        query.setParameter("primerApellido", apellido1);

                                        query.setParameter("cedula", Cedula);
                                        query.setParameter("telefono", Celular);
                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Cedula.isEmpty() && FechaNac != null) {
                                            Query query = em.createNamedQuery("Examen.findByNombre1Apellido1FechaNacCedula");

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("primerApellido", apellido1);

                                            query.setParameter("cedula", Cedula);

                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                Query query = em.createNamedQuery("Examen.findByNombre1Apellido1CelularCedula");

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("cedula", Cedula);
                                                query.setParameter("telefono", Celular);

                                                return query.getResultList();

                                            } else {
                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                    Query query = em.createNamedQuery("Examen.findByNombre1Apellido1FechaNacCelular");

                                                    query.setParameter("primerNombre", nombre1);

                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("telefono", Celular);
                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Cedula.isEmpty()) {
                                                        Query query = em.createNamedQuery("Examen.findByNombre1Apellido1Cedula");

                                                        query.setParameter("primerNombre", nombre1);

                                                        query.setParameter("primerApellido", apellido1);

                                                        query.setParameter("cedula", Cedula);

                                                        return query.getResultList();
                                                    } else {
                                                        if (!Celular.isEmpty()) {
                                                            Query query = em.createNamedQuery("Examen.findByNombre1Apellido1Celular");

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("primerApellido", apellido1);

                                                            query.setParameter("telefono", Celular);

                                                            return query.getResultList();
                                                        } else {
                                                            if (FechaNac != null) {
                                                                Query query = em.createNamedQuery("Examen.findByNombre1Apellido1FechaNac");

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("primerApellido", apellido1);

                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();

                                                            } else {

                                                                Query query = em.createNamedQuery("Examen.findByNombre1Apellido1");

                                                                query.setParameter("primerNombre", nombre1);
                                                                query.setParameter("primerApellido", apellido1);

                                                                return query.getResultList();

                                                            }

                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }

                                } else {
                                    //n1,a2
                                    if (nombre1 != "" && nombre2 == "" && apellido1 == "" && apellido2 != "") {
                                        if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                            Query query = em.createNamedQuery("Examen.findByNombre1Apellido2FechaNacCelularCedula");

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("segundoApellido", apellido2);
                                            query.setParameter("cedula", Cedula);
                                            query.setParameter("telefono", Celular);
                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Cedula.isEmpty() && FechaNac != null) {
                                                Query query = em.createNamedQuery("Examen.findByNombre1Apellido2FechaNacCedula");

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("segundoApellido", apellido2);
                                                query.setParameter("cedula", Cedula);

                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                    Query query = em.createNamedQuery("Examen.findByNombre1Apellido2CelularCedula");

                                                    query.setParameter("primerNombre", nombre1);

                                                    query.setParameter("segundoApellido", apellido2);
                                                    query.setParameter("cedula", Cedula);
                                                    query.setParameter("telefono", Celular);

                                                    return query.getResultList();

                                                } else {
                                                    if (FechaNac != null && !Celular.isEmpty()) {
                                                        Query query = em.createNamedQuery("Examen.findByNombre1Apellido2FechaNacCelular");

                                                        query.setParameter("primerNombre", nombre1);

                                                        query.setParameter("segundoApellido", apellido2);

                                                        query.setParameter("telefono", Celular);
                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Cedula.isEmpty()) {
                                                            Query query = em.createNamedQuery("Examen.findByNombre1Apellido2Cedula");

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("cedula", Cedula);

                                                            return query.getResultList();
                                                        } else {
                                                            if (!Celular.isEmpty()) {
                                                                Query query = em.createNamedQuery("Examen.findByNombre1Apellido2Celular");

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("segundoApellido", apellido2);

                                                                query.setParameter("telefono", Celular);

                                                                return query.getResultList();
                                                            } else {
                                                                if (FechaNac != null) {
                                                                    Query query = em.createNamedQuery("Examen.findByNombre1Apellido2FechaNac");

                                                                    query.setParameter("primerNombre", nombre1);

                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();

                                                                } else {

                                                                    Query query = em.createNamedQuery("Examen.findByNombre1Apellido2");
                                                                    query.setParameter("primerNombre", nombre1);
                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    return query.getResultList();

                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }

                                    } else {
                                        //n2,a1
                                        if (nombre1 == "" && nombre2 != "" && apellido1 != "" && apellido2 == "") {
                                            if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                Query query = em.createNamedQuery("Examen.findByNombre2Apellido1FechaNacCelularCedula");

                                                query.setParameter("segundoNombre", nombre2);
                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("cedula", Cedula);
                                                query.setParameter("telefono", Celular);
                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Cedula.isEmpty() && FechaNac != null) {
                                                    Query query = em.createNamedQuery("Examen.findByNombre2Apellido1FechaNacCedula");

                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("cedula", Cedula);

                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                        Query query = em.createNamedQuery("Examen.findByNombre2Apellido1CelularCedula");

                                                        query.setParameter("segundoNombre", nombre2);
                                                        query.setParameter("primerApellido", apellido1);

                                                        query.setParameter("cedula", Cedula);
                                                        query.setParameter("telefono", Celular);

                                                        return query.getResultList();

                                                    } else {
                                                        if (FechaNac != null && !Celular.isEmpty()) {
                                                            Query query = em.createNamedQuery("Examen.findByNombre2Apellido1FechaNacCelular");

                                                            query.setParameter("segundoNombre", nombre2);
                                                            query.setParameter("primerApellido", apellido1);

                                                            query.setParameter("telefono", Celular);
                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Cedula.isEmpty()) {
                                                                Query query = em.createNamedQuery("Examen.findByNombre2Apellido1Cedula");

                                                                query.setParameter("segundoNombre", nombre2);
                                                                query.setParameter("primerApellido", apellido1);

                                                                query.setParameter("cedula", Cedula);

                                                                return query.getResultList();
                                                            } else {
                                                                if (!Celular.isEmpty()) {
                                                                    Query query = em.createNamedQuery("Examen.findByNombre2Apellido1Celular");

                                                                    query.setParameter("segundoNombre", nombre2);
                                                                    query.setParameter("primerApellido", apellido1);

                                                                    query.setParameter("telefono", Celular);

                                                                    return query.getResultList();
                                                                } else {
                                                                    if (FechaNac != null) {
                                                                        Query query = em.createNamedQuery("Examen.findByNombre2Apellido1FechaNac");

                                                                        query.setParameter("segundoNombre", nombre2);
                                                                        query.setParameter("primerApellido", apellido1);

                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();

                                                                    } else {

                                                                        Query query = em.createNamedQuery("Examen.findByNombre2Apellido1");

                                                                        query.setParameter("segundoNombre", nombre2);
                                                                        query.setParameter("primerApellido", apellido1);

                                                                        return query.getResultList();

                                                                    }

                                                                }
                                                            }

                                                        }
                                                    }
                                                }
                                            }

                                        } else {
                                            //n2,a2
                                            if (nombre1 == "" && nombre2 != "" && apellido1 == "" && apellido2 != "") {

                                                if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                    Query query = em.createNamedQuery("Examen.findByNombre2Apellido2FechaNacCelularCedula");

                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("segundoApellido", apellido2);
                                                    query.setParameter("cedula", Cedula);
                                                    query.setParameter("telefono", Celular);
                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Cedula.isEmpty() && FechaNac != null) {
                                                        Query query = em.createNamedQuery("Examen.findByNombre2Apellido2FechaNacCedula");

                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("segundoApellido", apellido2);
                                                        query.setParameter("cedula", Cedula);

                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                            Query query = em.createNamedQuery("Examen.findByNombre2Apellido2CelularCedula");

                                                            query.setParameter("segundoNombre", nombre2);

                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("cedula", Cedula);
                                                            query.setParameter("telefono", Celular);

                                                            return query.getResultList();

                                                        } else {
                                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                                Query query = em.createNamedQuery("Examen.findByNombre2Apellido2FechaNacCelular");

                                                                query.setParameter("segundoNombre", nombre2);

                                                                query.setParameter("segundoApellido", apellido2);

                                                                query.setParameter("telefono", Celular);
                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Cedula.isEmpty()) {
                                                                    Query query = em.createNamedQuery("Examen.findByNombre2Apellido2Cedula");

                                                                    query.setParameter("segundoNombre", nombre2);

                                                                    query.setParameter("segundoApellido", apellido2);
                                                                    query.setParameter("cedula", Cedula);

                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Celular.isEmpty()) {
                                                                        Query query = em.createNamedQuery("Examen.findByNombre2Apellido2Celular");

                                                                        query.setParameter("segundoNombre", nombre2);

                                                                        query.setParameter("segundoApellido", apellido2);

                                                                        query.setParameter("telefono", Celular);

                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (FechaNac != null) {
                                                                            Query query = em.createNamedQuery("Examen.findByNombre2Apellido2FechaNac");

                                                                            query.setParameter("segundoNombre", nombre2);

                                                                            query.setParameter("segundoApellido", apellido2);

                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();

                                                                        } else {

                                                                            Query query = em.createNamedQuery("Examen.findByNombre2Apellido2");
                                                                            query.setParameter("segundoNombre", nombre2);
                                                                            query.setParameter("segundoApellido", apellido2);
                                                                            return query.getResultList();

                                                                        }

                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }

                                            } else {
                                                //a1,a2
                                                if (nombre1 == "" && nombre2 == "" && apellido1 != "" && apellido2 != "") {
                                                    if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                        Query query = em.createNamedQuery("Examen.findByDosApellidoFechaNacCelularCedula");

                                                        query.setParameter("primerApellido", apellido1);
                                                        query.setParameter("segundoApellido", apellido2);
                                                        query.setParameter("cedula", Cedula);
                                                        query.setParameter("telefono", Celular);
                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Cedula.isEmpty() && FechaNac != null) {
                                                            Query query = em.createNamedQuery("Examen.findByDosApellidoFechaNacCedula");

                                                            query.setParameter("primerApellido", apellido1);
                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("cedula", Cedula);

                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                                Query query = em.createNamedQuery("Examen.findByDosApellidoCelularCedula");

                                                                query.setParameter("primerApellido", apellido1);
                                                                query.setParameter("segundoApellido", apellido2);
                                                                query.setParameter("cedula", Cedula);
                                                                query.setParameter("telefono", Celular);

                                                                return query.getResultList();

                                                            } else {
                                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                                    Query query = em.createNamedQuery("Examen.findByDosApellidoFechaNacCelular");

                                                                    query.setParameter("primerApellido", apellido1);
                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    query.setParameter("telefono", Celular);
                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Cedula.isEmpty()) {
                                                                        Query query = em.createNamedQuery("Examen.findByDosApellidoCedula");

                                                                        query.setParameter("primerApellido", apellido1);
                                                                        query.setParameter("segundoApellido", apellido2);
                                                                        query.setParameter("cedula", Cedula);

                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Celular.isEmpty()) {
                                                                            Query query = em.createNamedQuery("Examen.findByDosApellidoCelular");

                                                                            query.setParameter("primerApellido", apellido1);
                                                                            query.setParameter("segundoApellido", apellido2);

                                                                            query.setParameter("telefono", Celular);

                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (FechaNac != null) {
                                                                                Query query = em.createNamedQuery("Examen.findByDosApellidoFechaNac");

                                                                                query.setParameter("primerApellido", apellido1);
                                                                                query.setParameter("segundoApellido", apellido2);

                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                return query.getResultList();

                                                                            } else {

                                                                                Query query = em.createNamedQuery("Examen.findByDosApellido");
                                                                                query.setParameter("primerApellido", apellido1);
                                                                                query.setParameter("segundoApellido", apellido2);
                                                                                return query.getResultList();

                                                                            }

                                                                        }
                                                                    }

                                                                }
                                                            }
                                                        }
                                                    }

                                                } else {
                                                    //n1
                                                    if (nombre1 != "" && nombre2 == "" && apellido1 == "" && apellido2 == "") {

                                                        if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                            Query query = em.createNamedQuery("Examen.findByPrimerNombreFechaNacCelularCedula");

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("cedula", Cedula);
                                                            query.setParameter("telefono", Celular);
                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Cedula.isEmpty() && FechaNac != null) {
                                                                Query query = em.createNamedQuery("Examen.findByPrimerNombreFechaNacCedula");

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("cedula", Cedula);

                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                                    Query query = em.createNamedQuery("Examen.findByPrimerNombreCelularCedula");

                                                                    query.setParameter("primerNombre", nombre1);

                                                                    query.setParameter("cedula", Cedula);
                                                                    query.setParameter("telefono", Celular);

                                                                    return query.getResultList();

                                                                } else {
                                                                    if (FechaNac != null && !Celular.isEmpty()) {
                                                                        Query query = em.createNamedQuery("Examen.findByPrimerNombreFechaNacCelular");

                                                                        query.setParameter("primerNombre", nombre1);

                                                                        query.setParameter("telefono", Celular);
                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Cedula.isEmpty()) {
                                                                            Query query = em.createNamedQuery("Examen.findByPrimerNombreCedula");

                                                                            query.setParameter("primerNombre", nombre1);

                                                                            query.setParameter("cedula", Cedula);

                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Celular.isEmpty()) {
                                                                                Query query = em.createNamedQuery("Examen.findByPrimerNombreCelular");

                                                                                query.setParameter("primerNombre", nombre1);

                                                                                query.setParameter("telefono", Celular);

                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (FechaNac != null) {
                                                                                    Query query = em.createNamedQuery("Examen.findByPrimerNombreFechaNac");

                                                                                    query.setParameter("primerNombre", nombre1);

                                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                                    return query.getResultList();

                                                                                } else {

                                                                                    Query query = em.createNamedQuery("Examen.findByPrimerNombre");
                                                                                    query.setParameter("primerNombre", nombre1);
                                                                                    return query.getResultList();

                                                                                }

                                                                            }
                                                                        }

                                                                    }
                                                                }
                                                            }
                                                        }

                                                    } else {
                                                        //n2
                                                        if (nombre1 == "" && nombre2 != "" && apellido1 == "" && apellido2 == "") {

                                                            if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                                Query query = em.createNamedQuery("Examen.findBySegundoNombreFechaNacCelularCedula");

                                                                query.setParameter("segundoNombre", nombre2);

                                                                query.setParameter("cedula", Cedula);
                                                                query.setParameter("telefono", Celular);
                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Cedula.isEmpty() && FechaNac != null) {
                                                                    Query query = em.createNamedQuery("Examen.findBySegundoNombreFechaNacCedula");

                                                                    query.setParameter("segundoNombre", nombre2);

                                                                    query.setParameter("cedula", Cedula);

                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                                        Query query = em.createNamedQuery("Examen.findBySegundoNombreCelularCedula");

                                                                        query.setParameter("segundoNombre", nombre2);

                                                                        query.setParameter("cedula", Cedula);
                                                                        query.setParameter("telefono", Celular);

                                                                        return query.getResultList();

                                                                    } else {
                                                                        if (FechaNac != null && !Celular.isEmpty()) {
                                                                            Query query = em.createNamedQuery("Examen.findBySegundoNombreFechaNacCelular");

                                                                            query.setParameter("segundoNombre", nombre2);

                                                                            query.setParameter("telefono", Celular);
                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Cedula.isEmpty()) {
                                                                                Query query = em.createNamedQuery("Examen.findBySegundoNombreCedula");

                                                                                query.setParameter("segundoNombre", nombre2);

                                                                                query.setParameter("cedula", Cedula);

                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (!Celular.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("Examen.findBySegundoNombreCelular");

                                                                                    query.setParameter("segundoNombre", nombre2);

                                                                                    query.setParameter("telefono", Celular);

                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (FechaNac != null) {
                                                                                        Query query = em.createNamedQuery("Examen.findBySegundoNombreFechaNac");

                                                                                        query.setParameter("segundoNombre", nombre2);

                                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                                        return query.getResultList();

                                                                                    } else {

                                                                                        Query query = em.createNamedQuery("Examen.findBySegundoNombre");
                                                                                        query.setParameter("segundoNombre", nombre2);
                                                                                        return query.getResultList();

                                                                                    }

                                                                                }
                                                                            }

                                                                        }
                                                                    }
                                                                }
                                                            }

                                                        } else {
                                                            //a1
                                                            if (nombre1 == "" && nombre2 == "" && apellido1 != "" && apellido2 == "") {

                                                                if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                                    Query query = em.createNamedQuery("Examen.findByPrimerApellidoFechaNacCelularCedula");

                                                                    query.setParameter("primerApellido", apellido1);

                                                                    query.setParameter("cedula", Cedula);
                                                                    query.setParameter("telefono", Celular);
                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Cedula.isEmpty() && FechaNac != null) {
                                                                        Query query = em.createNamedQuery("Examen.findByPrimerApellidoFechaNacCedula");

                                                                        query.setParameter("primerApellido", apellido1);

                                                                        query.setParameter("cedula", Cedula);

                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                                            Query query = em.createNamedQuery("Examen.findByPrimerApellidoCelularCedula");

                                                                            query.setParameter("primerApellido", apellido1);

                                                                            query.setParameter("cedula", Cedula);
                                                                            query.setParameter("telefono", Celular);

                                                                            return query.getResultList();

                                                                        } else {
                                                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                                                Query query = em.createNamedQuery("Examen.findByPrimerApellidoFechaNacCelular");

                                                                                query.setParameter("primerApellido", apellido1);

                                                                                query.setParameter("telefono", Celular);
                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (!Cedula.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("Examen.findByPrimerApellidoCedula");

                                                                                    query.setParameter("primerApellido", apellido1);

                                                                                    query.setParameter("cedula", Cedula);

                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (!Celular.isEmpty()) {
                                                                                        Query query = em.createNamedQuery("Examen.findByPrimerApellidoCelular");

                                                                                        query.setParameter("primerApellido", apellido1);

                                                                                        query.setParameter("telefono", Celular);

                                                                                        return query.getResultList();
                                                                                    } else {
                                                                                        if (FechaNac != null) {
                                                                                            Query query = em.createNamedQuery("Examen.findByPrimerApellidoFechaNac");

                                                                                            query.setParameter("primerApellido", apellido1);

                                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                                            return query.getResultList();

                                                                                        } else {

                                                                                            Query query = em.createNamedQuery("Examen.findByPrimerApellido");
                                                                                            query.setParameter("primerApellido", apellido1);
                                                                                            return query.getResultList();

                                                                                        }

                                                                                    }
                                                                                }

                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                            } else {
                                                                //a2
                                                                if (nombre1 == "" && nombre2 == "" && apellido1 == "" && apellido2 != "") {
                                                                    if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                                        Query query = em.createNamedQuery("Examen.findBySegundoApellidoFechaNacCelularCedula");

                                                                        query.setParameter("segundoApellido", apellido2);
                                                                        query.setParameter("cedula", Cedula);
                                                                        query.setParameter("telefono", Celular);
                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Cedula.isEmpty() && FechaNac != null) {
                                                                            Query query = em.createNamedQuery("Examen.findBySegundoApellidoFechaNacCedula");

                                                                            query.setParameter("segundoApellido", apellido2);
                                                                            query.setParameter("cedula", Cedula);

                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                                                                                Query query = em.createNamedQuery("Examen.findBySegundoApellidoCelularCedula");

                                                                                query.setParameter("segundoApellido", apellido2);
                                                                                query.setParameter("cedula", Cedula);
                                                                                query.setParameter("telefono", Celular);

                                                                                return query.getResultList();

                                                                            } else {
                                                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("Examen.findBySegundoApellidoFechaNacCelular");

                                                                                    query.setParameter("segundoApellido", apellido2);

                                                                                    query.setParameter("telefono", Celular);
                                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (!Cedula.isEmpty()) {
                                                                                        Query query = em.createNamedQuery("Examen.findBySegundoApellidoCedula");

                                                                                        query.setParameter("segundoApellido", apellido2);
                                                                                        query.setParameter("cedula", Cedula);

                                                                                        return query.getResultList();
                                                                                    } else {
                                                                                        if (!Celular.isEmpty()) {
                                                                                            Query query = em.createNamedQuery("Examen.findBySegundoApellidoCelular");

                                                                                            query.setParameter("segundoApellido", apellido2);

                                                                                            query.setParameter("telefono", Celular);

                                                                                            return query.getResultList();
                                                                                        } else {
                                                                                            if (FechaNac != null) {
                                                                                                Query query = em.createNamedQuery("Examen.findBySegundoApellidoFechaNac");

                                                                                                query.setParameter("segundoApellido", apellido2);

                                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                                return query.getResultList();

                                                                                            } else {

                                                                                                Query query = em.createNamedQuery("Examen.findBySegundoApellido");
                                                                                                query.setParameter("segundoApellido", apellido2);
                                                                                                return query.getResultList();

                                                                                            }

                                                                                        }
                                                                                    }

                                                                                }
                                                                            }
                                                                        }
                                                                    }

                                                                }
                                                                return null;

                                                            }
                                                        }

                                                    }

                                                }
                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

    }

    public List<Examen> buscarExamenPendiente(long idPersona)
    {
     Query query = em.createNamedQuery("Examen.findExamenPendiente");
     query.setParameter("idPersona", idPersona);
     query.setParameter("estado1", 3);
     return query.getResultList();
    }
    
    public List<Examen> buscarExamenCompleto(Long idExamen)
    {
     Query query = em.createNamedQuery("Examen.findByIdExamen");
     query.setParameter("idExamen", idExamen);
     return query.getResultList();
    }
    
   public Examen crearNuevo(Examen examen) {
        em.persist(examen);
        return examen;

    }

    public Examen actualizar(Examen examen) {
        em.merge(examen);
        em.flush();
        return examen;
    }
    
    public Examen RefrescarObjetoExamen(Examen examen )
    {
        Examen examen1 = em.find(Examen.class, examen.getIdExamen());
        em.refresh(examen1);
        return examen;
    }

   public List<Examen> porCodExpediente(String num) {
        Query query = em.createNamedQuery("Examen.findByNumeroExpediente");
        query.setParameter("numeroExpediente", '%'+num+'%');
        return query.getResultList();
    }
    

   
   public List<Categoria> buscarSubCategoriaFrotis( )
    {
        Query query = em.createNamedQuery("Categoria.findByIdCategoria");
        query.setParameter("idCategoria", 5);
        return query.getResultList();
    }
   
   public List<Categoria> buscarSubCategoriaObservacion( )
    {
        Query query = em.createNamedQuery("Categoria.findAll");
        return query.getResultList();
    }
   
   public List<Categoria> buscarSubCategoriaResultado( )
    {
        Query query = em.createNamedQuery("Categoria.findByIdCategoria");
        query.setParameter("idCategoria", 6);
        return query.getResultList();
    }
    
   public List<SubCategoria> buscarValoresFrotis( BigDecimal codigo )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", codigo);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValoresResultado( BigDecimal codigo )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", codigo);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValorFuma( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 7);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValorToma( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 8);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarValorEmbarazoActual( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 9);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarObservaciones( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 23);
        return query.getResultList();
    }
   
   
   
   
   
       //Codigo Angelo para Antecedentes Ginecobtetrico
        
   
   
   public List<Categoria> CargarTodasLasCategorias()
    {
        Query query = em.createNamedQuery("Categoria.findAll");
        return query.getResultList();
        
    }
   //davis parte
   public List<SubCategoria> buscarProcedencia( )
    {
        
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 10);
        return query.getResultList();
    }
   
   public List<SubCategoria> buscarAspectoClinico( )
    {
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 11);
        return query.getResultList();
    }
    
     public List<SubCategoria> buscarSecrecion( )
    {
        
        
        Query query = em.createNamedQuery("SubCategoria.findByIdSubcategoria");
        query.setParameter("idSubcategoria", 12);
        return query.getResultList();
    }
   
     
     //codigo angelo recidencia
     
      public List<Comunidad> buscarLasComunidadesPorSectores(String CodigoSector) {
        Query query = em.createNamedQuery("Comunidad.findBySector");
        query.setParameter("sector", CodigoSector);
        return query.getResultList();
    }
     
     
    
      
     public List<Sector> buscarSectoresPormunicipios(String Codigomunicipio) {
        Query query = em.createNamedQuery("Sector.findByMunicipio");
        query.setParameter("municipio", Codigomunicipio);
        return query.getResultList();
    }
     
     
     
     public Sector BuscarSectorPorComunidad(String codigosector){
     
          Query query = em.createNamedQuery("Sector.findByCodigo");
        query.setParameter("codigo", codigosector);
        return (Sector) query.getResultList().get(0);
     
     }
     
     
     
     public  DivisionPolitica BuscarMunicipioPorSector(String codMunicipio){
    
      Query query = em.createNamedQuery("DivisionPolitica.findByCodigoNacional");
        query.setParameter("codigoNacional", codMunicipio);
        return (DivisionPolitica) query.getResultList().get(0);
     }
   
     
     
     public Unidad BuscarUnidadPorSector(Long codUnidad){
          Query query = em.createNamedQuery("Unidad.findByCodigo");
          query.setParameter("codigo", codUnidad);
          
              return (Unidad) query.getResultList().get(0); 
     }
      public List<Fxexu> buscarReporte(Date fechaRango1, Date fechaRango2, int codigo) {
        Query query = em.createNamedQuery("Fxexu.findByValorXfechaMeustra");
        query.setParameter("valor1", fechaRango1);
          query.setParameter("valor2", fechaRango2);
            query.setParameter("idFecha", codigo);
            
         
        return query.getResultList();    
    }
     
     public List<EntidadAdtva> buscarSilaisReporte(BigInteger silais){
          Query query = em.createNamedQuery("EntidadAdtva.findByEntidadAdtvaId");
        query.setParameter("entidadAdtvaId", silais);
        
        return query.getResultList();   
     }
}
