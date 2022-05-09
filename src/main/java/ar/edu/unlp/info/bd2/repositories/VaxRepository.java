package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.SupportStaff;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import ar.edu.unlp.info.bd2.model.*;

public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    
    public void save(Object o) {
    	try {
    		this.sessionFactory.getCurrentSession().saveOrUpdate(o);
    	}
    	catch (Exception e) {
    		this.sessionFactory.getCurrentSession().clear();
    		throw e;
    	}



    /*
    public Object save(Object object) {
        getSession().save(object);
        return object;
    }
	*/

}

    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        return getSession().createQuery
                        ("from SupportStaff sup where sup.dni = dni").setParameter("dni", dni).getResultList()
                .stream().findFirst();

    }
    public Optional<Centre> getCentreByName(String name) {
        //Fran
        return this.getSession().createQuery("from Centre c where c.name = name")
                .setParameter("name",name).stream().findFirst();
    }

}
