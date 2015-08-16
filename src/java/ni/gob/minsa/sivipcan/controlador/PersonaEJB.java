/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.controlador;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ni.gob.minsa.modelo.persona.SisPersonas;
//import ni.gob.minsa.sivipcan.modelo.SisPersonas;

/**
 *
 * @author WIN 7
 */
@Stateless
public class PersonaEJB {

    //local: PSisLocal
    @PersistenceContext(unitName = "PerLocal")
    private EntityManager em;

    public List<SisPersonas> buscarTodasLasPersonas() {
        Query query = em.createNamedQuery("SisPersonas.findAll");
        return query.getResultList();
    }
    
    
    public List<SisPersonas> porCodigo(Long p){
     Query query = em.createNamedQuery("SisPersonas.findByPersonaId");
            query.setParameter("personaId", p);
           
            return query.getResultList();
    
    
    }

    public List<SisPersonas> buscarPorPajas(String Cedula, String Celular, Date FechaNac) {
      

        if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {
           
            Query query = em.createNamedQuery("SisPersonas.findByFechaNacCelularCedula");
            query.setParameter("identificacion", Cedula);
            query.setParameter("telefonoMovil", Celular);
            query.setParameter("fechaNacimiento", FechaNac);
            return query.getResultList();
        } else {
            if (!Cedula.isEmpty() && FechaNac != null) {
               
                
                Query query = em.createNamedQuery("SisPersonas.findByFechaNacIdentificacion");
                query.setParameter("identificacion", Cedula);

                query.setParameter("fechaNacimiento", FechaNac);

                return query.getResultList();
            } else {
                if (!Celular.isEmpty() && !Cedula.isEmpty()) {
                   
                    Query query = em.createNamedQuery("SisPersonas.findByCelularCedula");
                    query.setParameter("identificacion", Cedula);
                    query.setParameter("telefonoMovil", Celular);

                    return query.getResultList();

                } else {
                    if (FechaNac != null && !Celular.isEmpty()) {
                        

                        Query query = em.createNamedQuery("SisPersonas.findByFechaNacCelular");
                        query.setParameter("telefonoMovil", Celular);
                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Cedula.isEmpty()) {
                            System.out.println("tenemos cedula soloEJB");

                            Query query = em.createNamedQuery("SisPersonas.findByIdentificacion");
                            query.setParameter("identificacion", Cedula);

                            return query.getResultList();
                        } else {
                            if (!Celular.isEmpty()) {
                               

                                Query query = em.createNamedQuery("SisPersonas.findByTelefonoMovil");

                                query.setParameter("telefonoMovil", Celular);

                                return query.getResultList();
                            } else {
                                if (FechaNac != null) {
                                   

                                    Query query = em.createNamedQuery("SisPersonas.findByFechaNacimiento");
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

   public List<SisPersonas> buscarSisPersonasPorDosNombreDosApellido(String nombre1, String nombre2, String apellido1, String apellido2, String Identificacion, String Celular, Date FechaNac) {

        //n1,n2,a1,a2
        if (nombre1 != "" && nombre2 != "" && apellido1 != "" && apellido2 != "") {

            if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNacCelularIdentificacion");

                query.setParameter("primerNombre", nombre1);
                query.setParameter("segundoNombre", nombre2);
                query.setParameter("primerApellido", apellido1);
                query.setParameter("segundoApellido", apellido2);
                query.setParameter("identificacion", Identificacion);
                query.setParameter("telefonoMovil", Celular);
                query.setParameter("fechaNacimiento", FechaNac);
                return query.getResultList();
            } else {
                if (!Identificacion.isEmpty() && FechaNac != null) {
                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNacIdentificacion");

                    query.setParameter("primerNombre", nombre1);
                    query.setParameter("segundoNombre", nombre2);
                    query.setParameter("primerApellido", apellido1);
                    query.setParameter("segundoApellido", apellido2);
                    query.setParameter("identificacion", Identificacion);

                    query.setParameter("fechaNacimiento", FechaNac);
                    return query.getResultList();
                } else {
                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoCelularIdentificacion");

                        query.setParameter("primerNombre", nombre1);
                        query.setParameter("segundoNombre", nombre2);
                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("identificacion", Identificacion);
                        query.setParameter("telefonoMovil", Celular);

                        return query.getResultList();

                    } else {
                        if (FechaNac != null && !Celular.isEmpty()) {
                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNacCelular");

                            query.setParameter("primerNombre", nombre1);
                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);

                            query.setParameter("telefonoMovil", Celular);
                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Identificacion.isEmpty()) {
                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoIdentificacion");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("identificacion", Identificacion);

                                return query.getResultList();
                            } else {
                                if (!Celular.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoCelular");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);

                                    query.setParameter("telefonoMovil", Celular);

                                    return query.getResultList();
                                } else {
                                    if (FechaNac != null) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNac");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);

                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();

                                    } else {

                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellido");

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

                if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                    Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoFechaNacCelularIdentificacion");

                    query.setParameter("segundoNombre", nombre2);
                    query.setParameter("primerApellido", apellido1);
                    query.setParameter("segundoApellido", apellido2);
                    query.setParameter("identificacion", Identificacion);
                    query.setParameter("telefonoMovil", Celular);
                    query.setParameter("fechaNacimiento", FechaNac);
                    return query.getResultList();
                } else {
                    if (!Identificacion.isEmpty() && FechaNac != null) {
                        Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoFechaNacIdentificacion");

                        query.setParameter("segundoNombre", nombre2);
                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("identificacion", Identificacion);

                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                            Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoCelularIdentificacion");

                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);
                            query.setParameter("identificacion", Identificacion);
                            query.setParameter("telefonoMovil", Celular);

                            return query.getResultList();

                        } else {
                            if (FechaNac != null && !Celular.isEmpty()) {
                                Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoFechaNacCelular");

                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);

                                query.setParameter("telefonoMovil", Celular);
                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Identificacion.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoIdentificacion");

                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);
                                    query.setParameter("identificacion", Identificacion);

                                    return query.getResultList();
                                } else {
                                    if (!Celular.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoCelular");

                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);

                                        query.setParameter("telefonoMovil", Celular);

                                        return query.getResultList();
                                    } else {
                                        if (FechaNac != null) {
                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoFechaNac");

                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();

                                        } else {

                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellido");

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
                    if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                        Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNacCelularIdentificacion");

                        query.setParameter("primerNombre", nombre1);

                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("identificacion", Identificacion);
                        query.setParameter("telefonoMovil", Celular);
                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Identificacion.isEmpty() && FechaNac != null) {
                            Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNacIdentificacion");

                            query.setParameter("primerNombre", nombre1);

                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);
                            query.setParameter("identificacion", Identificacion);

                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoCelularIdentificacion");

                                query.setParameter("primerNombre", nombre1);

                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("identificacion", Identificacion);
                                query.setParameter("telefonoMovil", Celular);

                                return query.getResultList();

                            } else {
                                if (FechaNac != null && !Celular.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNacCelular");

                                    query.setParameter("primerNombre", nombre1);

                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);

                                    query.setParameter("telefonoMovil", Celular);
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Identificacion.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoIdentificacion");

                                        query.setParameter("primerNombre", nombre1);

                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);
                                        query.setParameter("identificacion", Identificacion);

                                        return query.getResultList();
                                    } else {
                                        if (!Celular.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoCelular");

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("telefonoMovil", Celular);

                                            return query.getResultList();
                                        } else {
                                            if (FechaNac != null) {
                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNac");

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("primerApellido", apellido1);
                                                query.setParameter("segundoApellido", apellido2);

                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();

                                            } else {

                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellido");

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

                        if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1FechaNacCelularIdentificacion");

                            query.setParameter("primerNombre", nombre1);
                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);

                            query.setParameter("identificacion", Identificacion);
                            query.setParameter("telefonoMovil", Celular);
                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Identificacion.isEmpty() && FechaNac != null) {
                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1FechaNacIdentificacion");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);

                                query.setParameter("identificacion", Identificacion);

                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1CelularIdentificacion");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);

                                    query.setParameter("identificacion", Identificacion);
                                    query.setParameter("telefonoMovil", Celular);

                                    return query.getResultList();

                                } else {
                                    if (FechaNac != null && !Celular.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1FechaNacCelular");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);

                                        query.setParameter("telefonoMovil", Celular);
                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Identificacion.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1Identificacion");

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);

                                            query.setParameter("identificacion", Identificacion);

                                            return query.getResultList();
                                        } else {
                                            if (!Celular.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1Celular");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);
                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("telefonoMovil", Celular);

                                                return query.getResultList();
                                            } else {
                                                if (FechaNac != null) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1FechaNac");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();

                                                } else {

                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1");

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

                            if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2FechaNacCelularIdentificacion");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);

                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("identificacion", Identificacion);
                                query.setParameter("telefonoMovil", Celular);
                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Identificacion.isEmpty() && FechaNac != null) {
                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2FechaNacIdentificacion");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);

                                    query.setParameter("segundoApellido", apellido2);
                                    query.setParameter("identificacion", Identificacion);

                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2CelularIdentificacion");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);

                                        query.setParameter("segundoApellido", apellido2);
                                        query.setParameter("identificacion", Identificacion);
                                        query.setParameter("telefonoMovil", Celular);

                                        return query.getResultList();

                                    } else {
                                        if (FechaNac != null && !Celular.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2FechaNacCelular");

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);

                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("telefonoMovil", Celular);
                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Identificacion.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2Identificacion");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);

                                                query.setParameter("segundoApellido", apellido2);
                                                query.setParameter("identificacion", Identificacion);

                                                return query.getResultList();
                                            } else {
                                                if (!Celular.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2Celular");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("segundoApellido", apellido2);

                                                    query.setParameter("telefonoMovil", Celular);

                                                    return query.getResultList();
                                                } else {
                                                    if (FechaNac != null) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2FechaNac");

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("segundoApellido", apellido2);

                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();

                                                    } else {

                                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2");

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
                                if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNacCelularIdentificacion");

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);

                                    query.setParameter("identificacion", Identificacion);
                                    query.setParameter("telefonoMovil", Celular);
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Identificacion.isEmpty() && FechaNac != null) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNacIdentificacion");

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);

                                        query.setParameter("identificacion", Identificacion);

                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreCelularIdentificacion");

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);

                                            query.setParameter("identificacion", Identificacion);
                                            query.setParameter("telefonoMovil", Celular);

                                            return query.getResultList();

                                        } else {
                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNacCelular");

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);

                                                query.setParameter("telefonoMovil", Celular);
                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Identificacion.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreIdentificacion");

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("identificacion", Identificacion);

                                                    return query.getResultList();
                                                } else {
                                                    if (!Celular.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreCelular");

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("telefonoMovil", Celular);

                                                        return query.getResultList();
                                                    } else {
                                                        if (FechaNac != null) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNac");

                                                            query.setParameter("primerNombre", nombre1);
                                                            query.setParameter("segundoNombre", nombre2);

                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();

                                                        } else {

                                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombre");

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
                                    if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNacCelularIdentificacion");

                                        query.setParameter("primerNombre", nombre1);

                                        query.setParameter("primerApellido", apellido1);

                                        query.setParameter("identificacion", Identificacion);
                                        query.setParameter("telefonoMovil", Celular);
                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Identificacion.isEmpty() && FechaNac != null) {
                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNacIdentificacion");

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("primerApellido", apellido1);

                                            query.setParameter("identificacion", Identificacion);

                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1CelularIdentificacion");

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("identificacion", Identificacion);
                                                query.setParameter("telefonoMovil", Celular);

                                                return query.getResultList();

                                            } else {
                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNacCelular");

                                                    query.setParameter("primerNombre", nombre1);

                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("telefonoMovil", Celular);
                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Identificacion.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1Identificacion");

                                                        query.setParameter("primerNombre", nombre1);

                                                        query.setParameter("primerApellido", apellido1);

                                                        query.setParameter("identificacion", Identificacion);

                                                        return query.getResultList();
                                                    } else {
                                                        if (!Celular.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1Celular");

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("primerApellido", apellido1);

                                                            query.setParameter("telefonoMovil", Celular);

                                                            return query.getResultList();
                                                        } else {
                                                            if (FechaNac != null) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNac");

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("primerApellido", apellido1);

                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();

                                                            } else {

                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1");

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
                                        if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNacCelularIdentificacion");

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("segundoApellido", apellido2);
                                            query.setParameter("identificacion", Identificacion);
                                            query.setParameter("telefonoMovil", Celular);
                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Identificacion.isEmpty() && FechaNac != null) {
                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNacIdentificacion");

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("segundoApellido", apellido2);
                                                query.setParameter("identificacion", Identificacion);

                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2CelularIdentificacion");

                                                    query.setParameter("primerNombre", nombre1);

                                                    query.setParameter("segundoApellido", apellido2);
                                                    query.setParameter("identificacion", Identificacion);
                                                    query.setParameter("telefonoMovil", Celular);

                                                    return query.getResultList();

                                                } else {
                                                    if (FechaNac != null && !Celular.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNacCelular");

                                                        query.setParameter("primerNombre", nombre1);

                                                        query.setParameter("segundoApellido", apellido2);

                                                        query.setParameter("telefonoMovil", Celular);
                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Identificacion.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2Identificacion");

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("identificacion", Identificacion);

                                                            return query.getResultList();
                                                        } else {
                                                            if (!Celular.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2Celular");

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("segundoApellido", apellido2);

                                                                query.setParameter("telefonoMovil", Celular);

                                                                return query.getResultList();
                                                            } else {
                                                                if (FechaNac != null) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNac");

                                                                    query.setParameter("primerNombre", nombre1);

                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();

                                                                } else {

                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2");
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
                                            if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNacCelularIdentificacion");

                                                query.setParameter("segundoNombre", nombre2);
                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("identificacion", Identificacion);
                                                query.setParameter("telefonoMovil", Celular);
                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Identificacion.isEmpty() && FechaNac != null) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNacIdentificacion");

                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("identificacion", Identificacion);

                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1CelularIdentificacion");

                                                        query.setParameter("segundoNombre", nombre2);
                                                        query.setParameter("primerApellido", apellido1);

                                                        query.setParameter("identificacion", Identificacion);
                                                        query.setParameter("telefonoMovil", Celular);

                                                        return query.getResultList();

                                                    } else {
                                                        if (FechaNac != null && !Celular.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNacCelular");

                                                            query.setParameter("segundoNombre", nombre2);
                                                            query.setParameter("primerApellido", apellido1);

                                                            query.setParameter("telefonoMovil", Celular);
                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Identificacion.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1Identificacion");

                                                                query.setParameter("segundoNombre", nombre2);
                                                                query.setParameter("primerApellido", apellido1);

                                                                query.setParameter("identificacion", Identificacion);

                                                                return query.getResultList();
                                                            } else {
                                                                if (!Celular.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1Celular");

                                                                    query.setParameter("segundoNombre", nombre2);
                                                                    query.setParameter("primerApellido", apellido1);

                                                                    query.setParameter("telefonoMovil", Celular);

                                                                    return query.getResultList();
                                                                } else {
                                                                    if (FechaNac != null) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNac");

                                                                        query.setParameter("segundoNombre", nombre2);
                                                                        query.setParameter("primerApellido", apellido1);

                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();

                                                                    } else {

                                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1");

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

                                                if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNacCelularIdentificacion");

                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("segundoApellido", apellido2);
                                                    query.setParameter("identificacion", Identificacion);
                                                    query.setParameter("telefonoMovil", Celular);
                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Identificacion.isEmpty() && FechaNac != null) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNacIdentificacion");

                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("segundoApellido", apellido2);
                                                        query.setParameter("identificacion", Identificacion);

                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2CelularIdentificacion");

                                                            query.setParameter("segundoNombre", nombre2);

                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("identificacion", Identificacion);
                                                            query.setParameter("telefonoMovil", Celular);

                                                            return query.getResultList();

                                                        } else {
                                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNacCelular");

                                                                query.setParameter("segundoNombre", nombre2);

                                                                query.setParameter("segundoApellido", apellido2);

                                                                query.setParameter("telefonoMovil", Celular);
                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Identificacion.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2Identificacion");

                                                                    query.setParameter("segundoNombre", nombre2);

                                                                    query.setParameter("segundoApellido", apellido2);
                                                                    query.setParameter("identificacion", Identificacion);

                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Celular.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2Celular");

                                                                        query.setParameter("segundoNombre", nombre2);

                                                                        query.setParameter("segundoApellido", apellido2);

                                                                        query.setParameter("telefonoMovil", Celular);

                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (FechaNac != null) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNac");

                                                                            query.setParameter("segundoNombre", nombre2);

                                                                            query.setParameter("segundoApellido", apellido2);

                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();

                                                                        } else {

                                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2");
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
                                                    if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                        Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNacCelularIdentificacion");

                                                        query.setParameter("primerApellido", apellido1);
                                                        query.setParameter("segundoApellido", apellido2);
                                                        query.setParameter("identificacion", Identificacion);
                                                        query.setParameter("telefonoMovil", Celular);
                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Identificacion.isEmpty() && FechaNac != null) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNacIdentificacion");

                                                            query.setParameter("primerApellido", apellido1);
                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("identificacion", Identificacion);

                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByDosApellidoCelularIdentificacion");

                                                                query.setParameter("primerApellido", apellido1);
                                                                query.setParameter("segundoApellido", apellido2);
                                                                query.setParameter("identificacion", Identificacion);
                                                                query.setParameter("telefonoMovil", Celular);

                                                                return query.getResultList();

                                                            } else {
                                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNacCelular");

                                                                    query.setParameter("primerApellido", apellido1);
                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    query.setParameter("telefonoMovil", Celular);
                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Identificacion.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByDosApellidoIdentificacion");

                                                                        query.setParameter("primerApellido", apellido1);
                                                                        query.setParameter("segundoApellido", apellido2);
                                                                        query.setParameter("identificacion", Identificacion);

                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Celular.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByDosApellidoCelular");

                                                                            query.setParameter("primerApellido", apellido1);
                                                                            query.setParameter("segundoApellido", apellido2);

                                                                            query.setParameter("telefonoMovil", Celular);

                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (FechaNac != null) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNac");

                                                                                query.setParameter("primerApellido", apellido1);
                                                                                query.setParameter("segundoApellido", apellido2);

                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                return query.getResultList();

                                                                            } else {

                                                                                Query query = em.createNamedQuery("SisPersonas.findByDosApellido");
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

                                                        if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNacCelularIdentificacion");

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("identificacion", Identificacion);
                                                            query.setParameter("telefonoMovil", Celular);
                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNacIdentificacion");

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("identificacion", Identificacion);

                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreCelularIdentificacion");

                                                                    query.setParameter("primerNombre", nombre1);

                                                                    query.setParameter("identificacion", Identificacion);
                                                                    query.setParameter("telefonoMovil", Celular);

                                                                    return query.getResultList();

                                                                } else {
                                                                    if (FechaNac != null && !Celular.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNacCelular");

                                                                        query.setParameter("primerNombre", nombre1);

                                                                        query.setParameter("telefonoMovil", Celular);
                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Identificacion.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreIdentificacion");

                                                                            query.setParameter("primerNombre", nombre1);

                                                                            query.setParameter("identificacion", Identificacion);

                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Celular.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreCelular");

                                                                                query.setParameter("primerNombre", nombre1);

                                                                                query.setParameter("telefonoMovil", Celular);

                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (FechaNac != null) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNac");

                                                                                    query.setParameter("primerNombre", nombre1);

                                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                                    return query.getResultList();

                                                                                } else {

                                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerNombre");
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

                                                            if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNacCelularIdentificacion");

                                                                query.setParameter("segundoNombre", nombre2);

                                                                query.setParameter("identificacion", Identificacion);
                                                                query.setParameter("telefonoMovil", Celular);
                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNacIdentificacion");

                                                                    query.setParameter("segundoNombre", nombre2);

                                                                    query.setParameter("identificacion", Identificacion);

                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreCelularIdentificacion");

                                                                        query.setParameter("segundoNombre", nombre2);

                                                                        query.setParameter("identificacion", Identificacion);
                                                                        query.setParameter("telefonoMovil", Celular);

                                                                        return query.getResultList();

                                                                    } else {
                                                                        if (FechaNac != null && !Celular.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNacCelular");

                                                                            query.setParameter("segundoNombre", nombre2);

                                                                            query.setParameter("telefonoMovil", Celular);
                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Identificacion.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreIdentificacion");

                                                                                query.setParameter("segundoNombre", nombre2);

                                                                                query.setParameter("identificacion", Identificacion);

                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (!Celular.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreCelular");

                                                                                    query.setParameter("segundoNombre", nombre2);

                                                                                    query.setParameter("telefonoMovil", Celular);

                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (FechaNac != null) {
                                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNac");

                                                                                        query.setParameter("segundoNombre", nombre2);

                                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                                        return query.getResultList();

                                                                                    } else {

                                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoNombre");
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

                                                                if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNacCelularIdentificacion");

                                                                    query.setParameter("primerApellido", apellido1);

                                                                    query.setParameter("identificacion", Identificacion);
                                                                    query.setParameter("telefonoMovil", Celular);
                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNacIdentificacion");

                                                                        query.setParameter("primerApellido", apellido1);

                                                                        query.setParameter("identificacion", Identificacion);

                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoCelularIdentificacion");

                                                                            query.setParameter("primerApellido", apellido1);

                                                                            query.setParameter("identificacion", Identificacion);
                                                                            query.setParameter("telefonoMovil", Celular);

                                                                            return query.getResultList();

                                                                        } else {
                                                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNacCelular");

                                                                                query.setParameter("primerApellido", apellido1);

                                                                                query.setParameter("telefonoMovil", Celular);
                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (!Identificacion.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoIdentificacion");

                                                                                    query.setParameter("primerApellido", apellido1);

                                                                                    query.setParameter("identificacion", Identificacion);

                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (!Celular.isEmpty()) {
                                                                                        Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoCelular");

                                                                                        query.setParameter("primerApellido", apellido1);

                                                                                        query.setParameter("telefonoMovil", Celular);

                                                                                        return query.getResultList();
                                                                                    } else {
                                                                                        if (FechaNac != null) {
                                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNac");

                                                                                            query.setParameter("primerApellido", apellido1);

                                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                                            return query.getResultList();

                                                                                        } else {

                                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerApellido");
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
                                                                    if (!Identificacion.isEmpty() && FechaNac != null && !Celular.isEmpty()) {

                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNacCelularIdentificacion");

                                                                        query.setParameter("segundoApellido", apellido2);
                                                                        query.setParameter("identificacion", Identificacion);
                                                                        query.setParameter("telefonoMovil", Celular);
                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNacIdentificacion");

                                                                            query.setParameter("segundoApellido", apellido2);
                                                                            query.setParameter("identificacion", Identificacion);

                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoCelularIdentificacion");

                                                                                query.setParameter("segundoApellido", apellido2);
                                                                                query.setParameter("identificacion", Identificacion);
                                                                                query.setParameter("telefonoMovil", Celular);

                                                                                return query.getResultList();

                                                                            } else {
                                                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNacCelular");

                                                                                    query.setParameter("segundoApellido", apellido2);

                                                                                    query.setParameter("telefonoMovil", Celular);
                                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (!Identificacion.isEmpty()) {
                                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoIdentificacion");

                                                                                        query.setParameter("segundoApellido", apellido2);
                                                                                        query.setParameter("identificacion", Identificacion);

                                                                                        return query.getResultList();
                                                                                    } else {
                                                                                        if (!Celular.isEmpty()) {
                                                                                            Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoCelular");

                                                                                            query.setParameter("segundoApellido", apellido2);

                                                                                            query.setParameter("telefonoMovil", Celular);

                                                                                            return query.getResultList();
                                                                                        } else {
                                                                                            if (FechaNac != null) {
                                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNac");

                                                                                                query.setParameter("segundoApellido", apellido2);

                                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                                return query.getResultList();

                                                                                            } else {

                                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoApellido");
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
}
