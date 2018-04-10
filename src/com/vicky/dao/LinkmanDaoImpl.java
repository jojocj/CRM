package com.vicky.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.vicky.bean.Linkman;
import com.vicky.util.PageBean;
import com.vicky.util.UtilDaoImpl;

public class LinkmanDaoImpl extends UtilDaoImpl<Linkman> implements LinkmanDao {

//	@Override
//	public void save(Linkman linkman) {
//		
//		this.getHibernateTemplate().save(linkman);
//	}
//
//	@Override
//	public PageBean findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
//		PageBean<Linkman> pageBean = new PageBean<Linkman>();
//		//设置页面显示记录数
//		pageBean.setPageSize(pageSize);
//		//得到总记录数
//		List<Number> number = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
//		if(number != null && number.size() > 0){
//			//设置总记录数
//			pageBean.setTotalCount(number.get(0).intValue());
//		}
//		//设置当前页,判断当前页是否超过总页数
//		int totalPage = pageBean.getTotalPage();
//		if(pageCode > totalPage){
//			pageCode = totalPage;
//		}
//		pageBean.setPageCode(pageCode);
//		//继续使用criteria需将Projection置空
//		criteria.setProjection(null);
//		//获取当前页记录
//		List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().findByCriteria(criteria,(pageCode - 1) * pageSize, pageSize);
//		if(list != null && list.size() > 0){
//			pageBean.setBeanList(list);
//		}
//		return pageBean;
//	}
//
//	@Override
//	public Linkman findById(Long lkm_id) {
//		
//		List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().find("from Linkman where lkm_id = ?", lkm_id);
//		if(list != null && list.size() > 0){
//			return list.get(0);
//		}
//		return null;
//	}
//
//	@Override
//	public void delete(Linkman linkman) {
//		
//		this.getHibernateTemplate().delete(linkman);
//	}
//
//	@Override
//	public void update(Linkman linkman) {
//		
//		this.getHibernateTemplate().update(linkman);
//	}

}
