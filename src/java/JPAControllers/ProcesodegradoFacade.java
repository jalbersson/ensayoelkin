/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import EntityClassesDB.Procesodegrado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jalber
 */
@Stateless
public class ProcesodegradoFacade extends AbstractFacade<Procesodegrado> {
    @PersistenceContext(unitName = "Siprogra_prueba2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesodegradoFacade() {
        super(Procesodegrado.class);
    }
    
}
