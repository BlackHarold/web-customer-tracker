package home.blackharold.dao;

import home.blackharold.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerImpl implements CustomerDAO {

    Session session;

    //    need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        session = sessionFactory
                //get the current hibernate session
                .getCurrentSession();
        Query query = session
                //create and execute query
//                .createQuery("from Customer", Customer.class);
                .createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query
                //get result list
                .getResultList();
//        return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
//        get current hibernate session
        session = sessionFactory.getCurrentSession();
//        save/update the customer
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {

//        get current hibernate session
        session = sessionFactory.getCurrentSession();

//        retrieve/read from database using the primary key
        Customer customer = session.get(Customer.class, id);
        saveCustomer(customer);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }
}
