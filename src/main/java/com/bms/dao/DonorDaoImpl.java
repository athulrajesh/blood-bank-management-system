package com.bms.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.bms.model.DonorModel;


@Repository
public class DonorDaoImpl implements DonorDao {
	@Autowired
	private SessionFactory session;

	@Override
	@Transactional
	public DonorModel loginDonor(DonorModel model) {
		DonorModel result= null;
		
			try {
				Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);
				criteria.add(Restrictions.eq("username", model.getUsername()));
				criteria.add(Restrictions.eq("password", model.getPassword()));

				
				 result = (DonorModel) criteria.uniqueResult();
				return result;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return result;
			}

		}

	@Override
	@Transactional
	public DonorModel getDonor(String username) {
		DonorModel result= null;
		
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);
			criteria.add(Restrictions.eq("username", username));
			

			
			 result = (DonorModel) criteria.uniqueResult();
			return result;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
		
	}

	@Override
	@Transactional
	public void update(DonorModel model) {
		try {
			session.getCurrentSession().update(model);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public void save(DonorModel model) {
		try {
			session.getCurrentSession().save(model);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	@Transactional
	public DonorModel check(String user) {
		DonorModel result = null;
		
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);
			criteria.add(Restrictions.eq("username", user));
			 result = (DonorModel) criteria.uniqueResult();
			return result;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}
		
	}


