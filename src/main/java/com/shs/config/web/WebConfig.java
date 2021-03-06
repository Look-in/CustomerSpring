package com.shs.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Web configuration without web.xml.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.shs.config.authorization", "com.shs.controllers", "com.shs.service", "com.shs.dao"})
@ImportResource({"classpath:spring/dao.xml", "classpath:spring/exception.xml"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}