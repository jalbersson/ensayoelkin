/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import EntityClassesDB.Fase;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jalber
 */
@Stateless
public class FaseFacade extends AbstractFacade<Fase> {
    @PersistenceContext(unitName = "Siprogra_prueba2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FaseFacade() {
        super(Fase.class);
    }
    public BigDecimal maximaFase() 
    {
        Query query = getEntityManager().createNamedQuery("Fase.maximaId");
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result;
    }
    public String nombreFaseID(int id)
    {
        String n=id+"";
        BigInteger idCasteado=new BigInteger(n);
        Query query = getEntityManager().createNamedQuery("Fase.sacarFasnombre"); query.setParameter("fasid", idCasteado);
        String result= (String)query.getSingleResult();
        return result;
    }
}
