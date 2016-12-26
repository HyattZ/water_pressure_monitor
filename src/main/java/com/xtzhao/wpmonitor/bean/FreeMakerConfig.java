package com.xtzhao.wpmonitor.bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@org.springframework.context.annotation.Configuration
public class FreeMakerConfig {
	@Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Bean
    public Configuration getFreeMarkerConfiguration(){
        return freeMarkerConfigurer.getConfiguration();
    }

    public String resolveMap(Map<String,String> model, String templateName){
    	String result = new String();
        try {
            Template template = this.getFreeMarkerConfiguration().getTemplate(templateName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            template.process(model, new OutputStreamWriter(baos));
            result = baos.toString();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
