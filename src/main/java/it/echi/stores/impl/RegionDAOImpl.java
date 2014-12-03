package it.echi.stores.impl;

import it.echi.beans.Region;
import it.echi.stores.DAOException;
import it.echi.stores.RegionDAO;

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
 
@Repository
public class RegionDAOImpl implements RegionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public RegionDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Region> getAllRegions() throws DAOException {
		Session session =null;
		List<Region> regions=null;
		try {
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Region.class).addOrder(Order.asc("description"));
			regions = cr.list();
		} catch (HibernateException e) {
			throw new DAOException("Error in  getAllRegions():"+e.getMessage(), e);
		}
		return regions;
	}
	

	@SuppressWarnings("unchecked")
	public List<Region> getRegionsByCountryCode(String code)
			throws DAOException {
		Session session =null;
		List<Region> regions=null;

		try {
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Region.class, "re").addOrder(Order.asc("re.description"));
			 
						/*
					.setFetchMode("countryBean", FetchMode.JOIN)
					.add(Restrictions.eq("country", code));*/
			regions = cr/*
					.setFetchMode("re.countryBean", FetchMode.JOIN)
					.setFetchMode("re.towns", FetchMode.JOIN)
					*/.add(Restrictions.eq("re.countryBean.country", code)).add(Restrictions.and(Restrictions.isNotNull("re.towns"), Restrictions.isNotEmpty("re.towns"))).list();
		} catch (HibernateException e) {
			throw new DAOException("Error in  getRegionsByCountryCode:"+e.getMessage(), e);
		}
		return regions;
	}

	public Region findRegionById(long id) throws DAOException {
		Session session =null;
		Region region=null;
		try {
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Region.class, "re").add(
					Restrictions.eq("re.idRegion",(int)id)).addOrder(Order.asc("re.description"));
			
		
			region = (Region) cr.setFetchMode("re.countryBean", FetchMode.JOIN).uniqueResult();
		} catch (HibernateException e) {
			throw new DAOException("Error in  findRegionById:"+e.getMessage(), e);
		}
		return region; 
	}

}
