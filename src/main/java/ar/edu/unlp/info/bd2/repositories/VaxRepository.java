package ar.edu.unlp.info.bd2.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;
    
    public void save(Object o) {
    	try {
    		this.sessionFactory.getCurrentSession().saveOrUpdate(o);
    	}
    	catch (Exception e) {
    		this.sessionFactory.getCurrentSession().clear();
    		throw e;
    	}
    }
}
