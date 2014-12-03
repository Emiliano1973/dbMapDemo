package it.echi.stores.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.echi.beans.Town;
import it.echi.stores.DAOException;
import it.echi.stores.TownDAO;

@Repository
public class TownDAOImpl implements TownDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public TownDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Town> getAllTowns() throws DAOException {
		List<Town> towns=null;
		Session session=null;
		try {
			session=this.sessionFactory.openSession();
			towns = (session.createCriteria(Town.class)).addOrder(Order.asc("town"))
					.list();
		} catch (HibernateException e) {
			throw new DAOException("Error in  getAllTowns:"+e.getMessage(), e);
		}
		return towns;
	}

	public List<Town> getTownsByRegionId(long regionId)
			throws DAOException {
		List<Town> towns=null;
		Session session=null;

		try {
			session=this.sessionFactory.openSession();
			Criteria cr=session.createCriteria(Town.class,"tow").addOrder(Order.asc("town"));
			  
			towns =cr/*.setFetchMode("tow.region",  FetchMode.JOIN)*/.add(Restrictions.eq("tow.region.idRegion", (int)regionId)).list();
		} catch (HibernateException e) {
			throw new DAOException("Error in  getTownsByRegionId:"+e.getMessage(), e);
		}
		return towns;
	}

	public Town findTownByPostCode(String postCode) throws DAOException {
		Town town=null;
		Session session=null;
		try {
			session=this.sessionFactory.openSession();
			Criteria cr=session.createCriteria(Town.class,"tow").addOrder(Order.asc("town"));
			town= (Town) cr.add(Restrictions.eq("postcode", postCode)).setFetchMode("tow.region", FetchMode.JOIN).uniqueResult();
			
			
		}catch (HibernateException e) {
			throw new DAOException("Error in  findTownByPostCode:"+e.getMessage(), e);
		}

		return town;
	}


}
