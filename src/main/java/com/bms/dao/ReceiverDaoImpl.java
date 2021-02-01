package com.bms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bms.model.BloodGroupModel;
import com.bms.model.DonorModel;
import com.bms.model.OrderModel;

@Repository
public class ReceiverDaoImpl implements ReceiverDao {
	@Autowired
	private SessionFactory session;

	@Transactional
	public BloodGroupModel getStatus() {
		BloodGroupModel result=null;
		
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(BloodGroupModel.class);

			 result = (BloodGroupModel) criteria.uniqueResult();
			return result;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}

	@Transactional
	public void book(OrderModel model) {
		
		try {
			session.getCurrentSession().save(model);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	@Transactional
	public void updateStatus(BloodGroupModel bgmodel) {
		try {
			session.getCurrentSession().update(bgmodel);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

	@Override
	@Transactional
	public OrderModel getorder(int order) {
		OrderModel result=null;
		
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(OrderModel.class);
			criteria.add(Restrictions.eq("order_id",order));
			 result = (OrderModel) criteria.uniqueResult();
			return result;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
		
	}
	
	
	 @Transactional
		public List<DonorModel> searchUserDetails(String searchParam, String sSearch, int displaystart,
				int idisplaylength) {
			List<DonorModel> result = null;
			try {
				Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);
				criteria.setMaxResults(idisplaylength);
				criteria.setFirstResult(displaystart);
				
				criteria.add(Restrictions.ilike("bg", searchParam, MatchMode.ANYWHERE));
				criteria.add(Restrictions.eq("status", 1 ));
				criteria.add(Restrictions.eq("verified", 1));
				result = criteria.list();
				System.out.println(result);
				if (StringUtils.isEmpty(result)) {
					result = new ArrayList<DonorModel>();
				}
			}

			catch (Exception e) {
				System.out.println(e);

			}
			return result;
		}

		@Transactional
		public long getRecordCountForUser(String searchParam, String sSearch) throws DataAccessException {
			Long count = (long) 0;
			try {
				Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);
				count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			} catch (Exception e) {
				System.out.println(e);
			}
			return count;
		}

}
