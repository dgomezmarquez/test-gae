package com.test.dao;

import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.SearchServiceFactory;
import com.googlecode.objectify.ObjectifyService;
import com.test.data.TestBean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Alejandro Aranda
 */
public class TestBeanDAO {

	private static final Logger LOGGER = Logger.getLogger(TestBeanDAO.class.getName());

	/**
	 * @return list of test beans
	 */
	public List<TestBean> list() {
		LOGGER.info("Retrieving list of beans");
		List<TestBean> retval = ObjectifyService.ofy().load().type(TestBean.class).list();
		for (int i = 0; i < retval.size(); i++) {
			LOGGER.info(retval.get(0).toString());
		}
		return retval;
	}

	/**
	 * @param id
	 * @return test bean with given id
	 */
	public TestBean get(Long id) {
		LOGGER.info("Retrieving bean " + id);
		TestBean retval = ObjectifyService.ofy().load().type(TestBean.class).id(id).now();
		LOGGER.info(retval.toString());
		return retval;
	}

	/**
	 * Saves given bean
	 * 
	 * @param bean
	 */
	public void save(TestBean bean) {
		if (bean == null) {
			throw new IllegalArgumentException("null test object");
		}
		LOGGER.info("Saving bean " + bean.toString());
		ObjectifyService.ofy().save().entity(bean).now();
	}

	/**
	 * Deletes given bean
	 * 
	 * @param bean
	 */
	public void delete(TestBean bean) {
		if (bean == null) {
			throw new IllegalArgumentException("null test object");
		}
		LOGGER.info("Deleting bean " + bean.getId());
		ObjectifyService.ofy().delete().entity(bean);
	}

	public List<TestBean> sarchByName(String nombre) {
		List<TestBean> retval = new ArrayList<TestBean>();

		if (nombre == null) {
			throw new IllegalArgumentException("null nombre");
		}
		LOGGER.info("Searching by name: " + nombre);

		List<TestBean> auxList = list();
		String nombreAndAutor;
		for (TestBean temp : auxList) {
			nombreAndAutor = temp.getNombre() + " " + temp.getAutor();
			if (nombreAndAutor.contains(nombre)) {
				LOGGER.info("Search add: " + temp.toString());
				retval.add(temp);
			}
		}

		return retval;
	}

}
