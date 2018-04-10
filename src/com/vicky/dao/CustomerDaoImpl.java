package com.vicky.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.vicky.bean.Customer;
import com.vicky.util.PageBean;
import com.vicky.util.UtilDaoImpl;

public class CustomerDaoImpl extends UtilDaoImpl<Customer> implements CustomerDao {

//	@Override
//	public void save(Customer customer) {
//		
//		this.getHibernateTemplate().save(customer);
//		
//	}
//
//	@Override
//	public PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
//		//新建分页工具类对象
//		PageBean<Customer> pageBean = new PageBean<Customer>();
//		
//		//设置每页记录数
//		pageBean.setPageSize(pageSize);
//		//获取总记录数
//		List<Number> number = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
//		if(number != null && number.size() > 0){
//			pageBean.setTotalCount(number.get(0).intValue());
//		}
//		if(pageCode > pageBean.getTotalPage()){
//			pageCode = pageBean.getTotalPage();
//		}
//		if(pageCode < 1){
//			pageCode = 1;
//		}
//		//设置当前页
//		pageBean.setPageCode(pageCode);
//		//查询置空
//		criteria.setProjection(null);
//		//获取当前页显示记录
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1) * pageSize, pageSize);
//		if(list != null && list.size() > 0){
//			pageBean.setBeanList(list);
//		}
//		return pageBean;
//	}
//
//	@Override
//	public Customer findById(Long cust_id) {
//		
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id = ?", cust_id);
//		if(list != null && list.size() > 0){
//			return list.get(0);
//		}
//		
//		return null;
//	}
//
//	@Override
//	public void update(Customer customer) {
//		
//		this.getHibernateTemplate().update(customer);
//	}
//
//	@Override
//	public void delete(Customer customer) {
//		
//		this.getHibernateTemplate().delete(customer);
//		
//	}
//
//	@Override
//	public List<Customer> findAll() {
//		
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
//		if(list != null && list.size() > 0){
//			return list;
//		}
//		return null;
//	}


	@Override
	public List<Object[]> findByLevel(DetachedCriteria criteria) {
		//分组统计结合使用，结果列顺序跟添加顺序一致
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("level")).add(Projections.rowCount()));
		
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().findByCriteria(criteria);
		//List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find("select count(cust_id),c.level from Customer c group by c.level");
		if(list != null && list.size() > 0){
			/*for (Object[] objects : list) {
				
				System.out.println(Arrays.toString(objects));
			}*/
			return list;
			
		}
		return null;
	}

	@Override
	public List<Object[]> findBySource(DetachedCriteria criteria) {
		//分组统计结合使用，结果列顺序跟添加顺序一致
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("source")).add(Projections.rowCount()));
		
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().findByCriteria(criteria);
		//List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find("select count(cust_id),c.level from Customer c group by c.level");
		if(list != null && list.size() > 0){

			return list;
			
		}				
		return null;
	}



}
