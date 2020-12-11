package product.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import product.dao.ProductDao;
import product.model.ProductBean;
import tool.HibernateUtils;



public class ProductDaoImpl implements ProductDao {
	
	
	SessionFactory factory = HibernateUtils.getSessionFactory();

	@Override
	public int saveProduct(ProductBean pb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(pb);
		count++;
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getAllProducts() {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getProduct(int no) {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean WHERE productno = :productno";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.setParameter("productno", no).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getBrandProduct(String brandname) {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean WHERE brandname = :brandname";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.setParameter("brandname", brandname).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getSeriesProduct(String series) {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean WHERE productseries = :productseries";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.setParameter("productseries", series).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getCateProduct(String cate) {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean WHERE productcategory = :productcategory";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.setParameter("productcategory", cate).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getKeyword(String keyword) {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean WHERE productname like :keyword";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.setParameter("keyword", "%" + keyword + "%").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getBrand() {
		List<ProductBean> list = new ArrayList<>();
		String hql = "SELECT DISTINCT brandname FROM ProductBean ";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getSeries() {
		List<ProductBean> list = new ArrayList<>();
		String hql = "SELECT DISTINCT productseries FROM ProductBean ";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getCate() {
		List<ProductBean> list = new ArrayList<>();
		String hql = "SELECT DISTINCT productcategory FROM ProductBean ";
		Session session = factory.getCurrentSession();
		Query<ProductBean> query = session.createQuery(hql);
		list = query.getResultList();
		return list;
	}

	@Override
	public int deleteProduct(int no) {
		int count = 0;
		Session session = factory.getCurrentSession();
		ProductBean pb = new ProductBean();
		pb.setProductno(no);
		session.delete(pb);
		count++;
		return count;
	}

	@Override
	public int updateProduct(ProductBean pb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(pb);
		count++;
		return count;
	}
}
