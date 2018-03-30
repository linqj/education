package com.chinayouthedu.zqzc.config.conf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpEncodingProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 消息转换器
 * @author 张超群
 * @time   2018年3月13日下午5:20:14
 */
@Configuration
public class CustomConfiguration extends WebMvcConfigurerAdapter{
	
	/**
	 * 消息转换器JSON,完成请求和注解POJO的映射形成自动转换
	 */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		//1
        ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        converters.add(byteArrayHttpMessageConverter);
        //2
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(HttpEncodingProperties.DEFAULT_CHARSET);
        converters.add(stringHttpMessageConverter);
        //3
//        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
//        converters.add(formHttpMessageConverter);
        //4
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> SupportedMediaTypes = new ArrayList<>();
//        SupportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        SupportedMediaTypes.add(MediaType.TEXT_HTML);	
        SupportedMediaTypes.add(MediaType.APPLICATION_JSON);
        SupportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(SupportedMediaTypes);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        converters.add(mappingJackson2HttpMessageConverter);

//        //REST中根据URL后缀自动判定Content-Type
//        ContentNegotiationManagerFactoryBean negotiationManagerFactoryBean = new ContentNegotiationManagerFactoryBean();
//        Map<String,MediaType> mediaTypes = new HashMap<String, MediaType>();
//        mediaTypes.put("json",MediaType.APPLICATION_JSON);
//        mediaTypes.put("xml",MediaType.APPLICATION_XML);
//        negotiationManagerFactoryBean.addMediaTypes(mediaTypes);
        
    }
}
