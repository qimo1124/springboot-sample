package top.dingyy.springbootweek04.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public MappingJackson2HttpMessageConverter customJacksonConverter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().modules(
                new JavaTimeModule().addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter)),
                new SimpleModule().addSerializer(Long.class,ToStringSerializer.instance)).build();
        return new MappingJackson2HttpMessageConverter(objectMapper);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取项目根目录下的 uploads 文件夹
        String projectDir = System.getProperty("user.dir");
        String uploadPath = "file:" + projectDir + File.separator + "uploads" + File.separator;

        // 映射 /upload/** 到实际的上传目录
        registry.addResourceHandler("/upload/**")
                .addResourceLocations(uploadPath);

        // 可选：也映射 /files/** 路径
        registry.addResourceHandler("/files/**")
                .addResourceLocations(uploadPath);

        // 打印配置信息，方便调试
        System.out.println("========================================");
        System.out.println("静态资源映射配置:");
        System.out.println("/upload/** -> " + uploadPath);
        System.out.println("/files/**  -> " + uploadPath);
        System.out.println("========================================");
    }
}

