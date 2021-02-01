package com.bms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bms.model.AdminModel;
import com.bms.model.BloodGroupModel;
import com.bms.model.DonorModel;
import com.bms.model.OrderModel;




@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory session;

	@Transactional
	public AdminModel loginAdmin(AdminModel model) {
        AdminModel result = null;
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(AdminModel.class);
			criteria.add(Restrictions.eq("userName", model.getUserName()));
			criteria.add(Restrictions.eq("password", model.getPassword()));

			System.out.println((AdminModel) criteria.uniqueResult());
			 result = (AdminModel) criteria.uniqueResult();
			return result;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}

	}

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
	public void save(BloodGroupModel model) {
    	try {
			Criteria criteria = session.getCurrentSession().createCriteria(BloodGroupModel.class);
			criteria.add(Restrictions.eq("id", model.getId()));
			session.getCurrentSession().update(model);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
			criteria.add(Restrictions.like("username", searchParam, MatchMode.ANYWHERE));
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

	@Transactional
	public void verify(String str) {
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);
			criteria.add(Restrictions.eq("username", str));
			DonorModel obj = (DonorModel) criteria.uniqueResult();
			obj.setVerified(1);
			

			session.getCurrentSession().update(obj);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
    
	@Transactional
	public void delete(List<String> tab) {
		try {
			for (String obj : tab) {
				System.out.println(obj);
				Criteria criteria = session.getCurrentSession().createCriteria(DonorModel.class);

				criteria.add(Restrictions.eq("username", obj));
				DonorModel reslt = (DonorModel) criteria.uniqueResult();
				session.getCurrentSession().delete(reslt);

			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	 @Transactional
		public List<OrderModel> searchOrderDetails(String searchParam, String sSearch, int displaystart,
				int idisplaylength) {
			List<OrderModel> result = null;
			try {
				Criteria criteria = session.getCurrentSession().createCriteria(OrderModel.class);
				criteria.setMaxResults(idisplaylength);
				criteria.setFirstResult(displaystart);
				int sp=0;
				if(!searchParam.equals("")) {
					sp = Integer.parseInt(searchParam);
					 criteria.add(Restrictions.eq("order_id", sp));
					 
				}
				
				 
				 
				criteria.addOrder(Order.desc("time"));
				result = criteria.list();
				System.out.println(result);
				if (StringUtils.isEmpty(result)) {
					result = new ArrayList<OrderModel>();
				}
			}

			catch (Exception e) {
				System.out.println(e);

			}
			return result;
		}

		@Transactional
		public long getRecordCountForOrder(String searchParam, String sSearch) throws DataAccessException {
			Long count = (long) 0;
			try {
				Criteria criteria = session.getCurrentSession().createCriteria(OrderModel.class);
				count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			} catch (Exception e) {
				System.out.println(e);
			}
			return count;
		}

        @Transactional
		@Override
		public OrderModel getOrder(int order) {
        	OrderModel reslt = null;
			try {
				Criteria criteria = session.getCurrentSession().createCriteria(OrderModel.class);

				criteria.add(Restrictions.eq("order_id", order));
				 reslt = (OrderModel) criteria.uniqueResult();
				return reslt;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return reslt;
			}
		}
		
		@Transactional
		@Override
		public void deleteorder(int o) {
			try {
				OrderModel order = getOrder(o);
				session.getCurrentSession().delete(order);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

}
