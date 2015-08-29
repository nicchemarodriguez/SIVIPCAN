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

    public List<SisPersonas> porCodigo(Long p) {
        Query query = em.createNamedQuery("SisPersonas.findByPersonaId");
        query.setParameter("personaId", p);

        return query.getResultList();

    }

    public List<SisPersonas> buscarPorPajas(String Cedula, String Celular, Date FechaNac) {

        if (!Cedula.isEmpty() && FechaNac != null && !Celular.isEmpty()) {
/**
 * no tiene query
 */
            Query query = em.createNamedQuery("SisPersonas.findByFechaNacCelularCedula");
            Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);
            query.setParameter("identificacion", Cedula);
            query.setParameter("telefonoMovil", Celular);
            query.setParameter("fechaNacimiento", FechaNac);
            return query.getResultList();
        } else {
            if (!Cedula.isEmpty() && FechaNac != null) {

                Query query = em.createNamedQuery("SisPersonas.findByFechaNacIdentificacion");
                 Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);
                
                query.setParameter("identificacion", Cedula);

                query.setParameter("fechaNacimiento", FechaNac);

                return query.getResultList();
            } else {
                if (!Celular.isEmpty() && !Cedula.isEmpty()) {
/**
 * no tiene query
 */
                    Query query = em.createNamedQuery("SisPersonas.findByCelularCedula");
                    Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);
                    
                    query.setParameter("identificacion", Cedula);
                    query.setParameter("telefonoMovil", Celular);

                    return query.getResultList();

                } else {
                    if (FechaNac != null && !Celular.isEmpty()) {
/**
 * no tiene query
 */
                        Query query = em.createNamedQuery("SisPersonas.findByFechaNacCelular");
                        query.setParameter("telefonoMovil", Celular);
                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Cedula.isEmpty()) {
                            System.out.println("tenemos cedula soloEJB");
                            String codigo_sexo = "SEXO|F";
                            Short fallecido = 0;
                            Query query = em.createNamedQuery("SisPersonas.findByIdentificacion");
                            query.setParameter("identificacion", Cedula);
                            query.setParameter("codigoSexo", codigo_sexo);
                            query.setParameter("fallecida", fallecido);

                            return query.getResultList();
                        } else {
                            if (!Celular.isEmpty()) {

                                Query query = em.createNamedQuery("SisPersonas.findByTelefonoMovil");

                                query.setParameter("telefonoMovil", Celular);

                                return query.getResultList();
                            } else {
                                if (FechaNac != null) {
                                    String codigo_sexo = "SEXO|F";
                                    Short fallecido = 0;
                                    System.out.println("davis2");
                                    Query query = em.createNamedQuery("SisPersonas.findByFechaNacimiento");
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    query.setParameter("codigoSexo", codigo_sexo);
                                    query.setParameter("fallecida", fallecido);

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

                String codigo_sexo = "SEXO|F";
                Short fallecido = 0;
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
                    String codigo_sexo = "SEXO|F";
                    Short fallecido = 0;

                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNacIdentificacion");

                    query.setParameter("primerNombre", nombre1);
                    query.setParameter("segundoNombre", nombre2);
                    query.setParameter("primerApellido", apellido1);
                    query.setParameter("segundoApellido", apellido2);
                    query.setParameter("identificacion", Identificacion);

                    query.setParameter("fechaNacimiento", FechaNac);
                    query.setParameter("codigoSexo", codigo_sexo);
                    query.setParameter("fallecida", fallecido);
                    return query.getResultList();
                } else {
                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                        String codigo_sexo = "SEXO|F";
                        Short fallecido = 0;
                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoCelularIdentificacion");

                        query.setParameter("primerNombre", nombre1);
                        query.setParameter("segundoNombre", nombre2);
                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("identificacion", Identificacion);
                        query.setParameter("telefonoMovil", Celular);
                        query.setParameter("codigoSexo", codigo_sexo);
                        query.setParameter("fallecida", fallecido);

                        return query.getResultList();

                    } else {
                        if (FechaNac != null && !Celular.isEmpty()) {

                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNacCelular");

                            Short fallecido = 0;
                            String codigo_sexo = "SEXO|F";
                            query.setParameter("fallecida", fallecido);
                            query.setParameter("codigoSexo", codigo_sexo);
                            query.setParameter("primerNombre", nombre1);
                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);

                            query.setParameter("telefonoMovil", Celular);
                            query.setParameter("fechaNacimiento", FechaNac);
                            query.setParameter("fallecida", fallecido);
                            query.setParameter("codigoSexo", codigo_sexo);
                            return query.getResultList();
                        } else {
                            if (!Identificacion.isEmpty()) {
                                Short fallecido = 0;
                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoIdentificacion");

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("identificacion", Identificacion);
                                query.setParameter("fallecida", fallecido);
                                return query.getResultList();
                            } else {
                                if (!Celular.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoCelular");

                                    Short fallecido = 0;
                                    String codigo_sexo = "SEXO|F";
                                    query.setParameter("fallecida", fallecido);
                                    query.setParameter("codigoSexo", codigo_sexo);
                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);

                                    query.setParameter("telefonoMovil", Celular);

                                    return query.getResultList();
                                } else {
                                    if (FechaNac != null) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellidoFechaNac");

                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);
                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);

                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();

                                    } else {

                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreDosApellido");

                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);
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
                    Short fallecido = 0;
                    String codigo_sexo = "SEXO|F";
                    query.setParameter("fallecida", fallecido);
                    query.setParameter("codigoSexo", codigo_sexo);
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
                        Short fallecido = 0;
                        String codigo_sexo = "SEXO|F";
                        query.setParameter("fallecida", fallecido);
                        query.setParameter("codigoSexo", codigo_sexo);
                        query.setParameter("segundoNombre", nombre2);
                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("identificacion", Identificacion);

                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                            Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoCelularIdentificacion");
                            Short fallecido = 0;
                            String codigo_sexo = "SEXO|F";
                            query.setParameter("fallecida", fallecido);
                            query.setParameter("codigoSexo", codigo_sexo);
                            query.setParameter("segundoNombre", nombre2);
                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);
                            query.setParameter("identificacion", Identificacion);
                            query.setParameter("telefonoMovil", Celular);

                            return query.getResultList();

                        } else {
                            if (FechaNac != null && !Celular.isEmpty()) {
                                Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoFechaNacCelular");
                                Short fallecido = 0;
                                String codigo_sexo = "SEXO|F";
                                query.setParameter("fallecida", fallecido);
                                query.setParameter("codigoSexo", codigo_sexo);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);

                                query.setParameter("telefonoMovil", Celular);
                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Identificacion.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoIdentificacion");
                                    Short fallecido = 0;
                                    String codigo_sexo = "SEXO|F";
                                    query.setParameter("fallecida", fallecido);
                                    query.setParameter("codigoSexo", codigo_sexo);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);
                                    query.setParameter("identificacion", Identificacion);

                                    return query.getResultList();
                                } else {
                                    if (!Celular.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoCelular");
                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);

                                        query.setParameter("telefonoMovil", Celular);

                                        return query.getResultList();
                                    } else {
                                        if (FechaNac != null) {
                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellidoFechaNac");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);
                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();

                                        } else {

                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2DosApellido");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);
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
                        Short fallecido = 0;
                        String codigo_sexo = "SEXO|F";
                        query.setParameter("fallecida", fallecido);
                        query.setParameter("codigoSexo", codigo_sexo);

                        query.setParameter("primerApellido", apellido1);
                        query.setParameter("segundoApellido", apellido2);
                        query.setParameter("identificacion", Identificacion);
                        query.setParameter("telefonoMovil", Celular);
                        query.setParameter("fechaNacimiento", FechaNac);
                        return query.getResultList();
                    } else {
                        if (!Identificacion.isEmpty() && FechaNac != null) {
                            Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNacIdentificacion");
                            Short fallecido = 0;
                            String codigo_sexo = "SEXO|F";
                            query.setParameter("fallecida", fallecido);
                            query.setParameter("codigoSexo", codigo_sexo);

                            query.setParameter("primerNombre", nombre1);

                            query.setParameter("primerApellido", apellido1);
                            query.setParameter("segundoApellido", apellido2);
                            query.setParameter("identificacion", Identificacion);

                            query.setParameter("fechaNacimiento", FechaNac);
                            return query.getResultList();
                        } else {
                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoCelularIdentificacion");
                                Short fallecido = 0;
                                String codigo_sexo = "SEXO|F";
                                query.setParameter("fallecida", fallecido);
                                query.setParameter("codigoSexo", codigo_sexo);

                                query.setParameter("primerNombre", nombre1);

                                query.setParameter("primerApellido", apellido1);
                                query.setParameter("segundoApellido", apellido2);
                                query.setParameter("identificacion", Identificacion);
                                query.setParameter("telefonoMovil", Celular);

                                return query.getResultList();

                            } else {
                                if (FechaNac != null && !Celular.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNacCelular");
                                    Short fallecido = 0;
                                    String codigo_sexo = "SEXO|F";
                                    query.setParameter("fallecida", fallecido);
                                    query.setParameter("codigoSexo", codigo_sexo);

                                    query.setParameter("primerNombre", nombre1);

                                    query.setParameter("primerApellido", apellido1);
                                    query.setParameter("segundoApellido", apellido2);

                                    query.setParameter("telefonoMovil", Celular);
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Identificacion.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoIdentificacion");
                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);

                                        query.setParameter("primerNombre", nombre1);

                                        query.setParameter("primerApellido", apellido1);
                                        query.setParameter("segundoApellido", apellido2);
                                        query.setParameter("identificacion", Identificacion);

                                        return query.getResultList();
                                    } else {
                                        if (!Celular.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoCelular");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("primerApellido", apellido1);
                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("telefonoMovil", Celular);

                                            return query.getResultList();
                                        } else {
                                            if (FechaNac != null) {
                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellidoFechaNac");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);
                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("primerApellido", apellido1);
                                                query.setParameter("segundoApellido", apellido2);

                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();

                                            } else {

                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1DosApellido");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);

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
                            Short fallecido = 0;
                            String codigo_sexo = "SEXO|F";
                            query.setParameter("fallecida", fallecido);

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
                                Short fallecido = 0;
                                String codigo_sexo = "SEXO|F";
                                query.setParameter("fallecida", fallecido);
                                query.setParameter("codigoSexo", codigo_sexo);

                                query.setParameter("primerNombre", nombre1);
                                query.setParameter("segundoNombre", nombre2);
                                query.setParameter("primerApellido", apellido1);

                                query.setParameter("identificacion", Identificacion);

                                query.setParameter("fechaNacimiento", FechaNac);
                                return query.getResultList();
                            } else {
                                if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1CelularIdentificacion");

                                    Short fallecido = 0;
                                    String codigo_sexo = "SEXO|F";
                                    query.setParameter("fallecida", fallecido);
                                    query.setParameter("codigoSexo", codigo_sexo);
                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);
                                    query.setParameter("primerApellido", apellido1);

                                    query.setParameter("identificacion", Identificacion);
                                    query.setParameter("telefonoMovil", Celular);

                                    return query.getResultList();

                                } else {
                                    if (FechaNac != null && !Celular.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1FechaNacCelular");

                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);
                                        query.setParameter("primerApellido", apellido1);

                                        query.setParameter("telefonoMovil", Celular);
                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Identificacion.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1Identificacion");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);
                                            query.setParameter("primerApellido", apellido1);

                                            query.setParameter("identificacion", Identificacion);

                                            return query.getResultList();
                                        } else {
                                            if (!Celular.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1Celular");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);
                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("telefonoMovil", Celular);

                                                return query.getResultList();
                                            } else {
                                                if (FechaNac != null) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1FechaNac");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();

                                                } else {

                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido1");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);

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
                                Short fallecido = 0;
                                String codigo_sexo = "SEXO|F";
                                query.setParameter("fallecida", fallecido);
                                query.setParameter("codigoSexo", codigo_sexo);

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
                                    Short fallecido = 0;
                                    String codigo_sexo = "SEXO|F";
                                    query.setParameter("fallecida", fallecido);
                                    query.setParameter("codigoSexo", codigo_sexo);

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);

                                    query.setParameter("segundoApellido", apellido2);
                                    query.setParameter("identificacion", Identificacion);

                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2CelularIdentificacion");
                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);

                                        query.setParameter("segundoApellido", apellido2);
                                        query.setParameter("identificacion", Identificacion);
                                        query.setParameter("telefonoMovil", Celular);

                                        return query.getResultList();

                                    } else {
                                        if (FechaNac != null && !Celular.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2FechaNacCelular");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);

                                            query.setParameter("segundoApellido", apellido2);

                                            query.setParameter("telefonoMovil", Celular);
                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Identificacion.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2Identificacion");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);

                                                query.setParameter("segundoApellido", apellido2);
                                                query.setParameter("identificacion", Identificacion);

                                                return query.getResultList();
                                            } else {
                                                if (!Celular.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2Celular");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("segundoApellido", apellido2);

                                                    query.setParameter("telefonoMovil", Celular);

                                                    return query.getResultList();
                                                } else {
                                                    if (FechaNac != null) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2FechaNac");
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("segundoApellido", apellido2);

                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();

                                                    } else {

                                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreApellido2");
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);

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
                                    Short fallecido = 0;
                                    String codigo_sexo = "SEXO|F";
                                    query.setParameter("fallecida", fallecido);
                                    query.setParameter("codigoSexo", codigo_sexo);

                                    query.setParameter("primerNombre", nombre1);
                                    query.setParameter("segundoNombre", nombre2);

                                    query.setParameter("identificacion", Identificacion);
                                    query.setParameter("telefonoMovil", Celular);
                                    query.setParameter("fechaNacimiento", FechaNac);
                                    return query.getResultList();
                                } else {
                                    if (!Identificacion.isEmpty() && FechaNac != null) {
                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNacIdentificacion");
                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);

                                        query.setParameter("primerNombre", nombre1);
                                        query.setParameter("segundoNombre", nombre2);

                                        query.setParameter("identificacion", Identificacion);

                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreCelularIdentificacion");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);

                                            query.setParameter("primerNombre", nombre1);
                                            query.setParameter("segundoNombre", nombre2);

                                            query.setParameter("identificacion", Identificacion);
                                            query.setParameter("telefonoMovil", Celular);

                                            return query.getResultList();

                                        } else {
                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNacCelular");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);

                                                query.setParameter("primerNombre", nombre1);
                                                query.setParameter("segundoNombre", nombre2);

                                                query.setParameter("telefonoMovil", Celular);
                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Identificacion.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByDosNombreIdentificacion");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);

                                                    query.setParameter("primerNombre", nombre1);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("identificacion", Identificacion);

                                                    return query.getResultList();
                                                } else {
                                                    if (!Celular.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByDosNombreCelular");
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);

                                                        query.setParameter("primerNombre", nombre1);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("telefonoMovil", Celular);

                                                        return query.getResultList();
                                                    } else {
                                                        if (FechaNac != null) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombreFechaNac");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);

                                                            query.setParameter("primerNombre", nombre1);
                                                            query.setParameter("segundoNombre", nombre2);

                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();

                                                        } else {

                                                            Query query = em.createNamedQuery("SisPersonas.findByDosNombre");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                            
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
                                        Short fallecido = 0;
                                        String codigo_sexo = "SEXO|F";
                                        query.setParameter("fallecida", fallecido);
                                        query.setParameter("codigoSexo", codigo_sexo);

                                        query.setParameter("primerNombre", nombre1);

                                        query.setParameter("primerApellido", apellido1);

                                        query.setParameter("identificacion", Identificacion);
                                        query.setParameter("telefonoMovil", Celular);
                                        query.setParameter("fechaNacimiento", FechaNac);
                                        return query.getResultList();
                                    } else {
                                        if (!Identificacion.isEmpty() && FechaNac != null) {
                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNacIdentificacion");
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("primerApellido", apellido1);

                                            query.setParameter("identificacion", Identificacion);

                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1CelularIdentificacion");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("identificacion", Identificacion);
                                                query.setParameter("telefonoMovil", Celular);

                                                return query.getResultList();

                                            } else {
                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNacCelular");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);

                                                    query.setParameter("primerNombre", nombre1);

                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("telefonoMovil", Celular);
                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Identificacion.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1Identificacion");
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);

                                                        query.setParameter("primerNombre", nombre1);

                                                        query.setParameter("primerApellido", apellido1);

                                                        query.setParameter("identificacion", Identificacion);

                                                        return query.getResultList();
                                                    } else {
                                                        if (!Celular.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1Celular");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("primerApellido", apellido1);

                                                            query.setParameter("telefonoMovil", Celular);

                                                            return query.getResultList();
                                                        } else {
                                                            if (FechaNac != null) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1FechaNac");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);

                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("primerApellido", apellido1);

                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();

                                                            } else {

                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido1");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);

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
                                            Short fallecido = 0;
                                            String codigo_sexo = "SEXO|F";
                                            query.setParameter("fallecida", fallecido);
                                            query.setParameter("codigoSexo", codigo_sexo);

                                            query.setParameter("primerNombre", nombre1);

                                            query.setParameter("segundoApellido", apellido2);
                                            query.setParameter("identificacion", Identificacion);
                                            query.setParameter("telefonoMovil", Celular);
                                            query.setParameter("fechaNacimiento", FechaNac);
                                            return query.getResultList();
                                        } else {
                                            if (!Identificacion.isEmpty() && FechaNac != null) {
                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNacIdentificacion");
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);

                                                query.setParameter("primerNombre", nombre1);

                                                query.setParameter("segundoApellido", apellido2);
                                                query.setParameter("identificacion", Identificacion);

                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2CelularIdentificacion");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);

                                                    query.setParameter("primerNombre", nombre1);

                                                    query.setParameter("segundoApellido", apellido2);
                                                    query.setParameter("identificacion", Identificacion);
                                                    query.setParameter("telefonoMovil", Celular);

                                                    return query.getResultList();

                                                } else {
                                                    if (FechaNac != null && !Celular.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNacCelular");
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);

                                                        query.setParameter("primerNombre", nombre1);

                                                        query.setParameter("segundoApellido", apellido2);

                                                        query.setParameter("telefonoMovil", Celular);
                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Identificacion.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2Identificacion");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);

                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("identificacion", Identificacion);

                                                            return query.getResultList();
                                                        } else {
                                                            if (!Celular.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2Celular");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("segundoApellido", apellido2);

                                                                query.setParameter("telefonoMovil", Celular);

                                                                return query.getResultList();
                                                            } else {
                                                                if (FechaNac != null) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2FechaNac");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                    query.setParameter("primerNombre", nombre1);

                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();

                                                                } else {

                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre1Apellido2");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
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
                                                Short fallecido = 0;
                                                String codigo_sexo = "SEXO|F";
                                                query.setParameter("fallecida", fallecido);
                                                query.setParameter("codigoSexo", codigo_sexo);

                                                query.setParameter("segundoNombre", nombre2);
                                                query.setParameter("primerApellido", apellido1);

                                                query.setParameter("identificacion", Identificacion);
                                                query.setParameter("telefonoMovil", Celular);
                                                query.setParameter("fechaNacimiento", FechaNac);
                                                return query.getResultList();
                                            } else {
                                                if (!Identificacion.isEmpty() && FechaNac != null) {
                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNacIdentificacion");
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);

                                                    query.setParameter("segundoNombre", nombre2);
                                                    query.setParameter("primerApellido", apellido1);

                                                    query.setParameter("identificacion", Identificacion);

                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1CelularIdentificacion");

                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                        query.setParameter("segundoNombre", nombre2);
                                                        query.setParameter("primerApellido", apellido1);

                                                        query.setParameter("identificacion", Identificacion);
                                                        query.setParameter("telefonoMovil", Celular);

                                                        return query.getResultList();

                                                    } else {
                                                        if (FechaNac != null && !Celular.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNacCelular");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);

                                                            query.setParameter("segundoNombre", nombre2);
                                                            query.setParameter("primerApellido", apellido1);

                                                            query.setParameter("telefonoMovil", Celular);
                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Identificacion.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1Identificacion");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);

                                                                query.setParameter("segundoNombre", nombre2);
                                                                query.setParameter("primerApellido", apellido1);

                                                                query.setParameter("identificacion", Identificacion);

                                                                return query.getResultList();
                                                            } else {
                                                                if (!Celular.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1Celular");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);

                                                                    query.setParameter("segundoNombre", nombre2);
                                                                    query.setParameter("primerApellido", apellido1);

                                                                    query.setParameter("telefonoMovil", Celular);

                                                                    return query.getResultList();
                                                                } else {
                                                                    if (FechaNac != null) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1FechaNac");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        query.setParameter("segundoNombre", nombre2);
                                                                        query.setParameter("primerApellido", apellido1);

                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();

                                                                    } else {

                                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido1");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
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
                                                    Short fallecido = 0;
                                                    String codigo_sexo = "SEXO|F";
                                                    query.setParameter("fallecida", fallecido);
                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                    query.setParameter("segundoNombre", nombre2);

                                                    query.setParameter("segundoApellido", apellido2);
                                                    query.setParameter("identificacion", Identificacion);
                                                    query.setParameter("telefonoMovil", Celular);
                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                    return query.getResultList();
                                                } else {
                                                    if (!Identificacion.isEmpty() && FechaNac != null) {
                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNacIdentificacion");
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                        query.setParameter("segundoNombre", nombre2);

                                                        query.setParameter("segundoApellido", apellido2);
                                                        query.setParameter("identificacion", Identificacion);

                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2CelularIdentificacion");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                            query.setParameter("segundoNombre", nombre2);

                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("identificacion", Identificacion);
                                                            query.setParameter("telefonoMovil", Celular);

                                                            return query.getResultList();

                                                        } else {
                                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNacCelular");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);

                                                                query.setParameter("segundoNombre", nombre2);

                                                                query.setParameter("segundoApellido", apellido2);

                                                                query.setParameter("telefonoMovil", Celular);
                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Identificacion.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2Identificacion");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                    query.setParameter("segundoNombre", nombre2);

                                                                    query.setParameter("segundoApellido", apellido2);
                                                                    query.setParameter("identificacion", Identificacion);

                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Celular.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2Celular");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        /////////////////////////////////////////////////////////////////////// AQUI QUEDE DAVIS
                                                                        query.setParameter("segundoNombre", nombre2);

                                                                        query.setParameter("segundoApellido", apellido2);

                                                                        query.setParameter("telefonoMovil", Celular);

                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (FechaNac != null) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2FechaNac");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                            query.setParameter("segundoNombre", nombre2);

                                                                            query.setParameter("segundoApellido", apellido2);

                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();

                                                                        } else {

                                                                            Query query = em.createNamedQuery("SisPersonas.findByNombre2Apellido2");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
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
                                                        Short fallecido = 0;
                                                        String codigo_sexo = "SEXO|F";
                                                        query.setParameter("fallecida", fallecido);
                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                        query.setParameter("primerApellido", apellido1);
                                                        query.setParameter("segundoApellido", apellido2);
                                                        query.setParameter("identificacion", Identificacion);
                                                        query.setParameter("telefonoMovil", Celular);
                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                        return query.getResultList();
                                                    } else {
                                                        if (!Identificacion.isEmpty() && FechaNac != null) {
                                                            Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNacIdentificacion");
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                            query.setParameter("primerApellido", apellido1);
                                                            query.setParameter("segundoApellido", apellido2);
                                                            query.setParameter("identificacion", Identificacion);

                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByDosApellidoCelularIdentificacion");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                query.setParameter("primerApellido", apellido1);
                                                                query.setParameter("segundoApellido", apellido2);
                                                                query.setParameter("identificacion", Identificacion);
                                                                query.setParameter("telefonoMovil", Celular);

                                                                return query.getResultList();

                                                            } else {
                                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNacCelular");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                    query.setParameter("primerApellido", apellido1);
                                                                    query.setParameter("segundoApellido", apellido2);

                                                                    query.setParameter("telefonoMovil", Celular);
                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Identificacion.isEmpty()) {
                                                                        /**
                                                                         * no
                                                                         * exista
                                                                         * query
                                                                         * en la
                                                                         * entity
                                                                         */
                                                                        Query query = em.createNamedQuery("SisPersonas.findByDosApellidoIdentificacion");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        query.setParameter("primerApellido", apellido1);
                                                                        query.setParameter("segundoApellido", apellido2);
                                                                        query.setParameter("identificacion", Identificacion);

                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Celular.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByDosApellidoCelular");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                            query.setParameter("primerApellido", apellido1);
                                                                            query.setParameter("segundoApellido", apellido2);

                                                                            query.setParameter("telefonoMovil", Celular);

                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (FechaNac != null) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findByDosApellidoFechaNac");
                                                                                Short fallecido = 0;
                                                                                String codigo_sexo = "SEXO|F";
                                                                                query.setParameter("fallecida", fallecido);
                                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                                query.setParameter("primerApellido", apellido1);
                                                                                query.setParameter("segundoApellido", apellido2);

                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                return query.getResultList();

                                                                            } else {

                                                                                Query query = em.createNamedQuery("SisPersonas.findByDosApellido");
                                                                                Short fallecido = 0;
                                                                                String codigo_sexo = "SEXO|F";
                                                                                query.setParameter("fallecida", fallecido);
                                                                                query.setParameter("codigoSexo", codigo_sexo);
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
                                                            Short fallecido = 0;
                                                            String codigo_sexo = "SEXO|F";
                                                            query.setParameter("fallecida", fallecido);
                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                            query.setParameter("primerNombre", nombre1);

                                                            query.setParameter("identificacion", Identificacion);
                                                            query.setParameter("telefonoMovil", Celular);
                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                            return query.getResultList();
                                                        } else {
                                                            if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNacIdentificacion");
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                query.setParameter("primerNombre", nombre1);

                                                                query.setParameter("identificacion", Identificacion);

                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreCelularIdentificacion");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                    query.setParameter("primerNombre", nombre1);

                                                                    query.setParameter("identificacion", Identificacion);
                                                                    query.setParameter("telefonoMovil", Celular);

                                                                    return query.getResultList();

                                                                } else {
                                                                    if (FechaNac != null && !Celular.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNacCelular");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        query.setParameter("primerNombre", nombre1);

                                                                        query.setParameter("telefonoMovil", Celular);
                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Identificacion.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreIdentificacion");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                            query.setParameter("primerNombre", nombre1);

                                                                            query.setParameter("identificacion", Identificacion);

                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Celular.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreCelular");
                                                                                Short fallecido = 0;
                                                                                String codigo_sexo = "SEXO|F";
                                                                                query.setParameter("fallecida", fallecido);
                                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                                query.setParameter("primerNombre", nombre1);

                                                                                query.setParameter("telefonoMovil", Celular);

                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (FechaNac != null) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerNombreFechaNac");
                                                                                    Short fallecido = 0;
                                                                                    String codigo_sexo = "SEXO|F";
                                                                                    query.setParameter("fallecida", fallecido);
                                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                                    query.setParameter("primerNombre", nombre1);

                                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                                    return query.getResultList();

                                                                                } else {

                                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerNombre");
                                                                                    Short fallecido = 0;
                                                                                    String codigo_sexo = "SEXO|F";
                                                                                    query.setParameter("fallecida", fallecido);
                                                                                    query.setParameter("codigoSexo", codigo_sexo);
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
                                                                Short fallecido = 0;
                                                                String codigo_sexo = "SEXO|F";
                                                                query.setParameter("fallecida", fallecido);
                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                query.setParameter("segundoNombre", nombre2);

                                                                query.setParameter("identificacion", Identificacion);
                                                                query.setParameter("telefonoMovil", Celular);
                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                return query.getResultList();
                                                            } else {
                                                                if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                    Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNacIdentificacion");
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                    query.setParameter("segundoNombre", nombre2);

                                                                    query.setParameter("identificacion", Identificacion);

                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreCelularIdentificacion");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        query.setParameter("segundoNombre", nombre2);

                                                                        query.setParameter("identificacion", Identificacion);
                                                                        query.setParameter("telefonoMovil", Celular);

                                                                        return query.getResultList();

                                                                    } else {
                                                                        if (FechaNac != null && !Celular.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNacCelular");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                            query.setParameter("segundoNombre", nombre2);

                                                                            query.setParameter("telefonoMovil", Celular);
                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Identificacion.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreIdentificacion");
                                                                                Short fallecido = 0;
                                                                                String codigo_sexo = "SEXO|F";
                                                                                query.setParameter("fallecida", fallecido);
                                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                                query.setParameter("segundoNombre", nombre2);

                                                                                query.setParameter("identificacion", Identificacion);

                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (!Celular.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreCelular");
                                                                                    Short fallecido = 0;
                                                                                    String codigo_sexo = "SEXO|F";
                                                                                    query.setParameter("fallecida", fallecido);
                                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                                    query.setParameter("segundoNombre", nombre2);

                                                                                    query.setParameter("telefonoMovil", Celular);

                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (FechaNac != null) {
                                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoNombreFechaNac");
                                                                                        Short fallecido = 0;
                                                                                        String codigo_sexo = "SEXO|F";
                                                                                        query.setParameter("fallecida", fallecido);
                                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                                        query.setParameter("segundoNombre", nombre2);

                                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                                        return query.getResultList();

                                                                                    } else {

                                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoNombre");
                                                                                        Short fallecido = 0;
                                                                                        String codigo_sexo = "SEXO|F";
                                                                                        query.setParameter("fallecida", fallecido);
                                                                                        query.setParameter("codigoSexo", codigo_sexo);
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
                                                                    Short fallecido = 0;
                                                                    String codigo_sexo = "SEXO|F";
                                                                    query.setParameter("fallecida", fallecido);
                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                    query.setParameter("primerApellido", apellido1);

                                                                    query.setParameter("identificacion", Identificacion);
                                                                    query.setParameter("telefonoMovil", Celular);
                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                    return query.getResultList();
                                                                } else {
                                                                    if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                        Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNacIdentificacion");
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        query.setParameter("primerApellido", apellido1);

                                                                        query.setParameter("identificacion", Identificacion);

                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoCelularIdentificacion");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                            query.setParameter("primerApellido", apellido1);

                                                                            query.setParameter("identificacion", Identificacion);
                                                                            query.setParameter("telefonoMovil", Celular);

                                                                            return query.getResultList();

                                                                        } else {
                                                                            if (FechaNac != null && !Celular.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNacCelular");
                                                                                Short fallecido = 0;
                                                                                String codigo_sexo = "SEXO|F";
                                                                                query.setParameter("fallecida", fallecido);
                                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                                query.setParameter("primerApellido", apellido1);

                                                                                query.setParameter("telefonoMovil", Celular);
                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                return query.getResultList();
                                                                            } else {
                                                                                if (!Identificacion.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoIdentificacion");
                                                                                    Short fallecido = 0;
                                                                                    String codigo_sexo = "SEXO|F";
                                                                                    query.setParameter("fallecida", fallecido);
                                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                                    query.setParameter("primerApellido", apellido1);

                                                                                    query.setParameter("identificacion", Identificacion);

                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (!Celular.isEmpty()) {
                                                                                        Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoCelular");
                                                                                        Short fallecido = 0;
                                                                                        String codigo_sexo = "SEXO|F";
                                                                                        query.setParameter("fallecida", fallecido);
                                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                                        query.setParameter("primerApellido", apellido1);

                                                                                        query.setParameter("telefonoMovil", Celular);

                                                                                        return query.getResultList();
                                                                                    } else {
                                                                                        if (FechaNac != null) {
                                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerApellidoFechaNac");
                                                                                            Short fallecido = 0;
                                                                                            String codigo_sexo = "SEXO|F";
                                                                                            query.setParameter("fallecida", fallecido);
                                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                                            query.setParameter("primerApellido", apellido1);

                                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                                            return query.getResultList();

                                                                                        } else {

                                                                                            Query query = em.createNamedQuery("SisPersonas.findByPrimerApellido");
                                                                                            Short fallecido = 0;
                                                                                            String codigo_sexo = "SEXO|F";
                                                                                            query.setParameter("fallecida", fallecido);
                                                                                            query.setParameter("codigoSexo", codigo_sexo);
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
                                                                        Short fallecido = 0;
                                                                        String codigo_sexo = "SEXO|F";
                                                                        query.setParameter("fallecida", fallecido);
                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                        query.setParameter("segundoApellido", apellido2);
                                                                        query.setParameter("identificacion", Identificacion);
                                                                        query.setParameter("telefonoMovil", Celular);
                                                                        query.setParameter("fechaNacimiento", FechaNac);
                                                                        return query.getResultList();
                                                                    } else {
                                                                        if (!Identificacion.isEmpty() && FechaNac != null) {
                                                                            Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNacIdentificacion");
                                                                            Short fallecido = 0;
                                                                            String codigo_sexo = "SEXO|F";
                                                                            query.setParameter("fallecida", fallecido);
                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                            query.setParameter("segundoApellido", apellido2);
                                                                            query.setParameter("identificacion", Identificacion);

                                                                            query.setParameter("fechaNacimiento", FechaNac);
                                                                            return query.getResultList();
                                                                        } else {
                                                                            if (!Celular.isEmpty() && !Identificacion.isEmpty()) {
                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoCelularIdentificacion");
                                                                                Short fallecido = 0;
                                                                                String codigo_sexo = "SEXO|F";
                                                                                query.setParameter("fallecida", fallecido);
                                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                                query.setParameter("segundoApellido", apellido2);
                                                                                query.setParameter("identificacion", Identificacion);
                                                                                query.setParameter("telefonoMovil", Celular);

                                                                                return query.getResultList();

                                                                            } else {
                                                                                if (FechaNac != null && !Celular.isEmpty()) {
                                                                                    Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNacCelular");
                                                                                    Short fallecido = 0;
                                                                                    String codigo_sexo = "SEXO|F";
                                                                                    query.setParameter("fallecida", fallecido);
                                                                                    query.setParameter("codigoSexo", codigo_sexo);
                                                                                    query.setParameter("segundoApellido", apellido2);

                                                                                    query.setParameter("telefonoMovil", Celular);
                                                                                    query.setParameter("fechaNacimiento", FechaNac);
                                                                                    return query.getResultList();
                                                                                } else {
                                                                                    if (!Identificacion.isEmpty()) {
                                                                                        Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoIdentificacion");
                                                                                        Short fallecido = 0;
                                                                                        String codigo_sexo = "SEXO|F";
                                                                                        query.setParameter("fallecida", fallecido);
                                                                                        query.setParameter("codigoSexo", codigo_sexo);
                                                                                        query.setParameter("segundoApellido", apellido2);
                                                                                        query.setParameter("identificacion", Identificacion);

                                                                                        return query.getResultList();
                                                                                    } else {
                                                                                        if (!Celular.isEmpty()) {
                                                                                            Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoCelular");
                                                                                            Short fallecido = 0;
                                                                                            String codigo_sexo = "SEXO|F";
                                                                                            query.setParameter("fallecida", fallecido);
                                                                                            query.setParameter("codigoSexo", codigo_sexo);
                                                                                            query.setParameter("segundoApellido", apellido2);

                                                                                            query.setParameter("telefonoMovil", Celular);

                                                                                            return query.getResultList();
                                                                                        } else {
                                                                                            if (FechaNac != null) {
                                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoApellidoFechaNac");
                                                                                                Short fallecido = 0;
                                                                                                String codigo_sexo = "SEXO|F";
                                                                                                query.setParameter("fallecida", fallecido);
                                                                                                query.setParameter("codigoSexo", codigo_sexo);
                                                                                                System.out.println("davis");
                                                                                                query.setParameter("segundoApellido", apellido2);

                                                                                                query.setParameter("fechaNacimiento", FechaNac);
                                                                                                return query.getResultList();

                                                                                            } else {

                                                                                                Query query = em.createNamedQuery("SisPersonas.findBySegundoApellido");
                                                                                                Short fallecido = 0;
                                                                                                String codigo_sexo = "SEXO|F";
                                                                                                query.setParameter("fallecida", fallecido);
                                                                                                query.setParameter("codigoSexo", codigo_sexo);
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
