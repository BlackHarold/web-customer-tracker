package home.blackharold.impl;

import home.blackharold.dao.CustomerDAO;
import home.blackharold.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerImpl implements CustomerDAO {

    //    need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory
                //get the current hibernate session
                .getCurrentSession();
        Query query = session
                //create and execute query
                .createQuery("from Customer", Customer.class);
        List<Customer> customers = query
                //get result list
                .getResultList();
//        return the results
        return customers;
    }
}
