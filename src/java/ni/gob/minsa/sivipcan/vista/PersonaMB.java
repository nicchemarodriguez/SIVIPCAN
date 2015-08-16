/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.gob.minsa.sivipcan.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import ni.gob.minsa.ejbPersona.dto.Persona;
import ni.gob.minsa.modelo.persona.SisPersonas;
import ni.gob.minsa.sivipcan.controlador.PersonaEJB;
import ni.gob.minsa.sivipcan.modelo.Examen;

/**
 *
 * @author WIN 7
 */
@ManagedBean
@RequestScoped
public class PersonaMB implements Serializable {

    @EJB
    private PersonaEJB PersonaEJB;
    private SisPersonas Persona;
    private Examen ExamenSelect;
    private List<SisPersonas> listaPersonas = new ArrayList<SisPersonas>();
    public List<SisPersonas> listapersonas = new ArrayList<SisPersonas>();
    public String nombreCompleto;
    public String[] a;
     private Date fechaNac;
    private String numeroCel;
    private String cedula;

     public PersonaMB() {
    }
     
    public PersonaMB(PersonaEJB PersonaEJB, SisPersonas Persona, Examen ExamenSelect) {
        this.PersonaEJB = PersonaEJB;
        this.Persona = Persona;
        this.ExamenSelect = ExamenSelect;

    }
     public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(String numeroCel) {
        this.numeroCel = numeroCel;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public PersonaEJB getPersonaEJB() {
        return PersonaEJB;
    }

    public SisPersonas getPersona() {
        return Persona;
    }

    public void setPersona(SisPersonas Persona) {
        this.Persona = Persona;
    }

    public List<SisPersonas> getListaPersonas() {
         HashSet st = new HashSet();
        st.addAll(listaPersonas);
        listaPersonas.clear();
        listaPersonas.addAll(st);
        return listaPersonas;
    }

    public void setListaPersonas(List<SisPersonas> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setPersonaEJB(PersonaEJB PersonaEJB) {
        this.PersonaEJB = PersonaEJB;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Examen getExamenSelect() {
        return ExamenSelect;
    }

    public void setExamenSelect(Examen ExamenSelect) {
        this.ExamenSelect = ExamenSelect;
    }

   

    public void porNombreCompleto() {
//        System.out.println(nombreCompleto + " :/");

        if (nombreCompleto.isEmpty()) {
            if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
              
                listaPersonas=PersonaEJB.buscarPorPajas(cedula, numeroCel, fechaNac);
            } else {
                if (!cedula.isEmpty() && fechaNac != null) {
                  
                     listaPersonas=PersonaEJB.buscarPorPajas(cedula, "", fechaNac);
                } else {
                    if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                       
                         listaPersonas=PersonaEJB.buscarPorPajas(cedula, numeroCel, null);
                    } else {
                        if (fechaNac != null && !numeroCel.isEmpty()) {
                           
                             listaPersonas=PersonaEJB.buscarPorPajas("", numeroCel, fechaNac);
                        } else {
                            if (!cedula.isEmpty()) {
                               
                                 listaPersonas=PersonaEJB.buscarPorPajas(cedula, "", null);
                            } else {
                                if (!numeroCel.isEmpty()) {
                                 
                                     listaPersonas=PersonaEJB.buscarPorPajas("", numeroCel, null);
                                } else {
                                    if (fechaNac != null) {
                                        
                                     listaPersonas=PersonaEJB.buscarPorPajas("", "", fechaNac);

                                    } else {
                                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "no sea pendejo ingrese algo"));

                                    }

                                }
                            }

                        }
                    }
                }
            }

        } else {
            StringTokenizer st = new StringTokenizer(nombreCompleto);

            int i = 0;
            a = new String[st.countTokens()];
            while (st.hasMoreTokens()) {
                a[i] = st.nextElement().toString();
                i++;
            }

            if (a != null) {
                if (a.length > 6) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "PENDEJO", "se murio"));
                } else {
                    if (a.length == 6) {
                        String n1;
                        n1 = a[1] + " " + a[2] + " " + a[3];

                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                            listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],cedula,numeroCel,fechaNac);
                          
                        } else {
                            if (!cedula.isEmpty() && fechaNac != null) {
                                listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],cedula,"",fechaNac);
                               
                            } else {
                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],cedula,numeroCel,null);
                                   
                                } else {
                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                        listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],"",numeroCel,fechaNac);
                                     
                                    } else {
                                        if (!cedula.isEmpty()) {
                                            listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],cedula,"",null);
                                          
                                        } else {
                                            if (!numeroCel.isEmpty()) {
                                                listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],"",numeroCel,null);
                                               
                                            } else {
                                                if (fechaNac != null) {
                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],"","",fechaNac);
                                                  

                                                } else {
                                               
                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[4], a[5],"","",null);
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }

                    } else {

                        if (a.length == 5) {
                            if ("LOS".equals(a[2]) || "LA".equals(a[2])) {
                                String n3;
                                n3 = a[1] + " " + a[2] + " " + a[3];

                                if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "",cedula,numeroCel,fechaNac);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],cedula,numeroCel,fechaNac));
                                   
                                } else {
                                    if (!cedula.isEmpty() && fechaNac != null) {
                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "",cedula,"",fechaNac);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],cedula,"",fechaNac));
                                       
                                    } else {
                                        if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "",cedula,numeroCel,null);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],cedula,numeroCel,null));
                                          
                                        } else {
                                            if (fechaNac != null && !numeroCel.isEmpty()) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "","",numeroCel,fechaNac);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],"",numeroCel,fechaNac));
                                               
                                            } else {
                                                if (!cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "",cedula,"",null);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],cedula,"",null));
                                                  
                                                } else {
                                                    if (!numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "","",numeroCel,null);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],"",numeroCel,null));
                                                       
                                                    } else {
                                                        if (fechaNac != null) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "","","",fechaNac);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],"","",fechaNac));
                                                           

                                                        } else {
                                                            listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, a[4], "","","",null);
                                                            listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", a[4],"","",null));
                                                        }

                                                    }
                                                }

                                            }
                                        }
                                    }
                                }

                            } else {
                                String n2;
                                n2 = a[1] + " " + a[2];

                                if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],cedula,numeroCel,fechaNac);
                                   
                                } else {
                                    if (!cedula.isEmpty() && fechaNac != null) {
                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],cedula,"",fechaNac);
                                      
                                    } else {
                                        if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],cedula,numeroCel,null);
                                           
                                        } else {
                                            if (fechaNac != null && !numeroCel.isEmpty()) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],"",numeroCel,fechaNac);
                                                
                                            } else {
                                                if (!cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],cedula,"",null);
                                                   
                                                } else {
                                                    if (!numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],"",numeroCel,null);
                                                       
                                                    } else {
                                                        if (fechaNac != null) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],"","",fechaNac);
                                                            

                                                        } else {
                                                            listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n2, a[3], a[4],"","",null);
                                                        }

                                                    }
                                                }

                                            }
                                        }
                                    }
                                }

                            }
                        } else {
                            if (a.length == 4) {

                                if ("LOS".equals(a[2]) || "LA".equals(a[2])) {
                                    String n3;
                                    n3 = a[1] + " " + a[2] + " " + a[3];

                                    if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "",cedula,numeroCel,fechaNac);
                                     
                                    } else {
                                        if (!cedula.isEmpty() && fechaNac != null) {
                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "",cedula,"",fechaNac);
                                          
                                        } else {
                                            if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "",cedula,numeroCel,null);
                                               
                                            } else {
                                                if (fechaNac != null && !numeroCel.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "","",numeroCel,fechaNac);
                                                   
                                                } else {
                                                    if (!cedula.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "",cedula,"",null);
                                                        
                                                    } else {
                                                        if (!numeroCel.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "","",numeroCel,null);
                                                           
                                                        } else {
                                                            if (fechaNac != null) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "","","",fechaNac);
                                                               

                                                            } else {
                                                                listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n3, "", "","","",null);
                                                            }

                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }

                                } else {

                                    if ("DEL".equals(a[1]) || "DE".equals(a[1])) {
                                        String n1;
                                        n1 = a[1] + " " + a[2];

                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "",cedula,numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],cedula,numeroCel,fechaNac));
                                           
                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "",cedula,"",fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],cedula,"",fechaNac));
                                               
                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "",cedula,numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],cedula,numeroCel,null));
                                                   
                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "","",numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],"",numeroCel,fechaNac));
                                                       
                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "",cedula,"",null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],cedula,"",null));
                                                          
                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "","",numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],"",numeroCel,null));
                                                               
                                                            } else {
                                                                if (fechaNac != null) {
                                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "","","",fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],"","",fechaNac));
                                                                  
                                                                } else {
                                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, a[3], "","","",null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", a[3],"","",null));
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }

                                    } else {
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],cedula,numeroCel,fechaNac);
                                          
                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],cedula,"",fechaNac);
                                              
                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],cedula,numeroCel,null);
                                                   
                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],"",numeroCel,fechaNac);
                                                       
                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],cedula,"",null);
                                                           
                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],"",numeroCel,null);
                                                               
                                                            } else {
                                                                if (fechaNac != null) {
                                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],"","",fechaNac);
                                                                   

                                                                } else {
                                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], a[3],"","",null);
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            } else {
                                if (a.length == 3) {

                                    if ("DEL".equals(a[1]) || "DE".equals(a[1])) {
                                        String n1;
                                        n1 = a[1] + " " + a[2];

                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "",cedula,numeroCel,fechaNac);
                                           
                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "",cedula,"",fechaNac);
                                               
                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "",cedula,numeroCel,null);
                                                    
                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "","",numeroCel,fechaNac);
                                                       
                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "",cedula,"",null);
                                                           
                                                           
                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "","",numeroCel,null);
                                                               
                                                            } else {
                                                                if (fechaNac != null) {
                                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "","","",fechaNac);
                                                                   

                                                                } else {
                                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], n1, "", "","","",null);
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }

                                    } else {
                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],cedula,numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],cedula,numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],cedula,numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "",cedula,numeroCel,fechaNac));
                                            
                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],cedula,"",fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],cedula,"",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],cedula,"",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "",cedula,"",fechaNac));
                                               
                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],cedula,numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],cedula,numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],cedula,numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "",cedula,numeroCel,null));
                                                    
                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],"",numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],"",numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],"",numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "","",numeroCel,fechaNac));
                                                        
                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],cedula,numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],cedula,"",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],cedula,"",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "",cedula,"",null));
                                                            
                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],"",numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],"",numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],"",numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "","",numeroCel,null));
                                                                
                                                            } else {
                                                                if (fechaNac != null) {
                                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],"","",fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],"","",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],"","",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "","","",fechaNac));
                                                                    

                                                                } else {
                                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], a[2],"","",null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], a[2],"","",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", a[2],"","",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], a[2], "","","",null));
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }

                                    }
                                } else {
                                    if (a.length == 2) {

                                        if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                            listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],cedula,numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "",cedula,numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],cedula,numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "",cedula,numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],cedula,numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "",cedula,numeroCel,fechaNac));
                                          
                                        } else {
                                            if (!cedula.isEmpty() && fechaNac != null) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],cedula,numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "",cedula,"",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],cedula,"",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "",cedula,"",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],cedula,"",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "",cedula,"",fechaNac));
                                               
                                            } else {
                                                if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],cedula,numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "",cedula,numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],cedula,numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "",cedula,numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],cedula,numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "",cedula,numeroCel,null));
                                                  
                                                } else {
                                                    if (fechaNac != null && !numeroCel.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],"",numeroCel,fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "","",numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],"",numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "","",numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],"",numeroCel,fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "","",numeroCel,fechaNac));
                                                       
                                                    } else {
                                                        if (!cedula.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],cedula,"",null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "",cedula,"",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],cedula,"",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "",cedula,"",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],cedula,"",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "",cedula,"",null));
                                                            
                                                        } else {
                                                            if (!numeroCel.isEmpty()) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],"",numeroCel,null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "","",numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],"",numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "","",numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],"",numeroCel,null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "","",numeroCel,null));
                                                               
                                                            } else {
                                                                if (fechaNac != null) {
                                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],"","",fechaNac);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "","","",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],"","",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "","","",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],"","",fechaNac));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "","","",fechaNac));
                                                                   

                                                                } else {
                                                                    listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], a[1],"","",null);
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", a[1], "","","",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", a[1],"","",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], a[1], "","","",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", a[1],"","",null));
                                                                    listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], a[1], "", "","","",null));
                                                                }

                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }

                                    } else {
                                        if (a.length == 1) {
                                            if (!cedula.isEmpty() && fechaNac != null && !numeroCel.isEmpty()) {
                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "",cedula,numeroCel,fechaNac);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "",cedula,numeroCel,fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "",cedula,numeroCel,fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],cedula,numeroCel,fechaNac));
                                               
                                            } else {
                                                if (!cedula.isEmpty() && fechaNac != null) {
                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "",cedula,"",fechaNac);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "",cedula,"",fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "",cedula,"",fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],cedula,"",fechaNac));
                                                    
                                                } else {
                                                    if (!numeroCel.isEmpty() && !cedula.isEmpty()) {
                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "",cedula,numeroCel,null);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "",cedula,numeroCel,null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "",cedula,numeroCel,null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],cedula,numeroCel,null));
                                                        
                                                    } else {
                                                        if (fechaNac != null && !numeroCel.isEmpty()) {
                                                             listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "","",numeroCel,fechaNac);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "","",numeroCel,fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "","",numeroCel,fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],"",numeroCel,fechaNac));
                                                            
                                                        } else {
                                                            if (!cedula.isEmpty()) {
                                                                 listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "",cedula,"",null);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "",cedula,"",null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "",cedula,"",null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],cedula,"",null));
                                                                
                                                            } else {
                                                                if (!numeroCel.isEmpty()) {
                                                                     listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "","",numeroCel,null);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "","",numeroCel,null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "","",numeroCel,null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],"",numeroCel,null));
                                                                   
                                                                } else {
                                                                    if (fechaNac != null) {
                                                                         listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "","","",fechaNac);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "","","",fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "","","",fechaNac));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],"","",fechaNac));
                                                                       

                                                                    } else {
                                                                        listaPersonas = PersonaEJB.buscarSisPersonasPorDosNombreDosApellido(a[0], "", "", "","","",null);
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", a[0], "", "","","",null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", a[0], "","","",null));
                                                                        listaPersonas.addAll(PersonaEJB.buscarSisPersonasPorDosNombreDosApellido("", "", "", a[0],"","",null));
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
    }

    public void pasarNombre(String nombre) {
        nombreCompleto = nombre;
    }
    
    public SisPersonas ParaExpediente(Long cod){
    SisPersonas sis= PersonaEJB.porCodigo(cod).get(0);
    
    return sis;
    
    }

}
