package it.echi.stores.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.echi.beans.Country;
import it.echi.stores.CountryDAO;
import it.echi.stores.DAOException;

@Repository
public class CountryDAOImpl implements CountryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public CountryDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Country> getCountries() throws DAOException {
		Session session=null;
		List<Country> countries=null;
		try {
			session = this.sessionFactory.openSession();
			Criteria q = session.createCriteria(Country.class);
			
			countries =q.addOrder(Order.asc("country")).list();
			session.close();
		} catch (HibernateException e) {
			throw new DAOException("Error in  getCountries:"+e.getMessage(), e);
		}
		return countries;
	}

	public Country findCountryById(String code) throws DAOException {
		Session session=null;
		Country country=null;
		try {
			session = this.sessionFactory.openSession();
			Criteria q = session.createCriteria(Country.class).add(Restrictions.eq("country", code));
			country=(Country) q.uniqueResult();
			session.close(); 
		} catch (HibernateException e) {
			throw new DAOException("Error in  findCountryById:"+e.getMessage(), e);
		}
		
		
		return country;
	}

}
