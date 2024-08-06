package com.spearhead.nova.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }

    @Bean
    public ClassLoaderTemplateResolver yourTemplateResolver() {
        ClassLoaderTemplateResolver configurer = new ClassLoaderTemplateResolver();
        configurer.setPrefix("templates/");
        configurer.setSuffix(".rad");
        configurer.setTemplateMode(TemplateMode.HTML);
        configurer.setCharacterEncoding("UTF-8");
        configurer.setOrder(0);  // this is important. This way spring //boot will listen to both places 0 and 1
        configurer.setCacheable(false);
        configurer.setCheckExistence(true);
        return configurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //TODO Auto-generated method stub

        exposeDirectory("kyc-doc", registry);
        // registry.addResourceHandler("/resources/**")
        // .addResourceLocations("/resources/","classpath:/other-resources/");
    //    Path kycDoc = Paths.get("./kyc-doc/");
    //     String kycUploadPath = kycDoc.toFile().getAbsolutePath();
    //     registry.addResourceHandler("/kyc-doc/**").addResourceLocations("classpath:/kyc-doc/") ;
        
    }

       private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        //Path kycDoc = Paths.get("./kyc-doc/");
        Path uploadDir = Paths.get(dirName);
        //String kycUploadPath = kycDoc.toFile().getAbsolutePath();
         String uploadPath = uploadDir.toFile().getAbsolutePath();
         
         
        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
         
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    }

    
}