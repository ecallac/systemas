/**
 * 
 */
package com.ecallac.rentcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * @author EFRAIN
 * @dateCreated 5 mar. 2017 14:19:08
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.ecallac.rentcar"})
@Import({SpringSecurityConfig.class})
//@ImportResource("classpath:/com/internal/web/config/application-context-web.xml")
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webapp/**").addResourceLocations("/webapp/");
	}
	
//	@Bean
//	public JasperReportsViewResolver getJasperReportsViewResolver() {
//	  JasperReportsViewResolver resolver = new JasperReportsViewResolver();
//	  resolver.setPrefix("/report/");
//	  resolver.setSuffix(".jasper");
//	  resolver.setReportDataKey("datasource");
//	  resolver.setViewNames("rpt_*");
//	  resolver.setViewClass(JasperReportsMultiFormatView.class);
//	  resolver.setOrder(0);
//	  return resolver;
//	} 
	
//	@Bean
//	public InternalResourceViewResolver viewResolver(){
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/jsp/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
	
	/**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/jsp/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
 
    @Bean
    public ViewResolver getViewResolver(){
    	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
    	viewResolver.setViewClass(TilesView.class);
    	return viewResolver;
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
//    /**
//     * Configure ViewResolvers to deliver preferred views.
//     */
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        TilesViewResolver viewResolver = new TilesViewResolver();
//        registry.viewResolver(viewResolver);
//    }
}
