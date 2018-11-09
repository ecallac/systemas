/**
 * 
 */
package com.internal.web.config;

import javax.servlet.Filter;

import org.directwebremoting.servlet.DwrServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * @author EFRAIN
 * @dateCreated 5 mar. 2017 14:38:53
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{WebConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		//return new Class[]{DwrServlet.class};
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/dwr/**/*","/"};
	}
	
//	@Override
//    protected Filter[] getServletFilters() {
//        Filter [] singleton = { new CORSFilter()};
//        return singleton;
//    }

}
