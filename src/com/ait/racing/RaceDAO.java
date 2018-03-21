package com.ait.racing;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class RaceDAO {

    @PersistenceContext
    private EntityManager em;
    
    public RaceHorse getHorse(int id) {
        return em.find(RaceHorse.class, id);
    }
    
    public List<RaceHorse> getAllHorses(){
    	Query query=em.createQuery("SELECT w FROM RaceHorse w");
        return query.getResultList();
    }
    
    //---------------------------------------------------------------------------------------
    /*
    WHERE CustomerName LIKE 'a%'	Finds any values that starts with "a"
    WHERE CustomerName LIKE '%a'	Finds any values that ends with "a"
    WHERE CustomerName LIKE '%or%'	Finds any values that have "or" in any position
    WHERE CustomerName LIKE '_r%'	Finds any values that have "r" in the second position
    WHERE CustomerName LIKE 'a_%_%'	Finds any values that starts with "a" and are at least 3 characters in length
    WHERE ContactName LIKE 'a%o'	Finds any values that starts with "a" and ends with "o"
    */

    
    public List<RaceHorse> getHorseByName(String name) {
    	Query query=em.createQuery("SELECT w FROM RaceHorse w where w.name like '%" +name+ "%'");
        return query.getResultList();
    }
    
    public List<RaceHorse> getHorseByOwner(String owner) {
    	Query query=em.createQuery("SELECT w FROM Mission w where w.owner like '" +owner+ "%'");
        return query.getResultList();
    }
 
    
    
    
}
