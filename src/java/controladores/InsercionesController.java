package controladores;

import EntityClassesDB.Fase;
import EntityClassesDB.Restriccion;
import EntityClassesDB.Rol;
import JPAControllers.FaseFacade;
import JPAControllers.RestriccionFacade;
import JPAControllers.RolFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jalber
 */
@ManagedBean
@Named(value = "insercionesController")
@ViewScoped
public class InsercionesController implements Serializable
{
    @EJB
    private RolFacade rolFI;
    @EJB
    private FaseFacade faseFI;
    @EJB
    private RestriccionFacade restriccionFI;
    
    private Rol rol;
    private Fase fase;
    private Restriccion restriccion;
    
    public InsercionesController() 
    {
        rol=new Rol();
        rol.setRolestado("activo");
        fase=new Fase();
        fase.setFasestado("activa");
    }
    public Rol getRol() 
    {
        return rol;
    }
    public void setRol(Rol rol) 
    {
        this.rol = rol;
    }
    public void insertarRol()
    {
        BigDecimal bg=rolFI.maximoRol();
        bg=bg.add(BigDecimal.ONE);
        rol.setRolid(bg);
        rolFI.create(rol);
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('dialogoAñadir').hide()");
    }
    public Fase getFase() 
    {
        return fase;
    }
    public void setFase(Fase fase) 
    {
        this.fase = fase;
    }
    public void insertarFase()
    {
        BigDecimal bg=faseFI.maximaFase();
        bg=bg.add(BigDecimal.ONE);
        //fase.setFasid(bg);
        faseFI.create(fase);
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('dialogoAñadir2').hide()");
    }
    public Restriccion getRestriccion() 
    {
        return restriccion;
    }
    public void setRestriccion(Restriccion restriccion) 
    {
        this.restriccion = restriccion;
    }
    public void insertarRestriccion()
    {
        System.out.println("entro a insercion restriccion");
        BigDecimal bg=restriccionFI.maximaRestriccion();
        bg=bg.add(BigDecimal.ONE);
        restriccion.setResid(bg);
        restriccionFI.create(restriccion);
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('dialogoAñadir2').hide()");
    }
}
