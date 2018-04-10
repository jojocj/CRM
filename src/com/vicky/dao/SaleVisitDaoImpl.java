package com.vicky.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.vicky.bean.SaleVisit;
import com.vicky.util.PageBean;
import com.vicky.util.UtilDaoImpl;

public class SaleVisitDaoImpl extends UtilDaoImpl<SaleVisit> implements SaleVisitDao {

//	@Override
//	public void save(SaleVisit saleVisit) {
//		
//		this.getHibernateTemplate().save(saleVisit);
//	}
//
//	@Override
//	public PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
//		
//		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
//		//设置每页显示数
//		pageBean.setPageSize(pageSize);
//		//获取总记录数
//		List<Number> number = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
//		if(number != null && number.size() > 0){
//			pageBean.setTotalCount(number.get(0).intValue());
//		}
//		//设置当前页
//		if(pageCode > pageBean.getTotalPage()){
//			pageCode = pageBean.getTotalPage();
//		}
//		pageBean.setPageCode(pageCode);
//		
//		//继续使用criteria需将projection置空
//		criteria.setProjection(null);
//		
//		//获取当前页记录
//		List<SaleVisit> list = (List<SaleVisit>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1)*pageSize,pageSize);
//		if(list != null && list.size() > 0){
//			pageBean.setBeanList(list);
//		}
//		
//		return pageBean;
//	}

}
