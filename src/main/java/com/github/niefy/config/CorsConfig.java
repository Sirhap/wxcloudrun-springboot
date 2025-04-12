package com.github.niefy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 允许跨域的域名，设置为 * 时不能同时设置 allowCredentials 为 true
        // 如果需要允许携带认证信息，这里必须指定具体的域名
        config.setAllowedOriginPatterns(Arrays.asList("*"));

        // 允许跨域的请求头
        config.addAllowedHeader("*");

        // 允许跨域的请求方法
        config.addAllowedMethod("*");

        // 允许携带认证信息（cookie等）
        config.setAllowCredentials(true);

        // 预检请求的有效期，单位为秒
        config.setMaxAge(3600L);

        // 允许返回的响应头
        config.addExposedHeader("Authorization");
        config.addExposedHeader("Content-Type");
        config.addExposedHeader("X-Requested-With");
        config.addExposedHeader("Access-Control-Allow-Origin");
        config.addExposedHeader("Access-Control-Allow-Credentials");
        config.addExposedHeader("Access-Control-Allow-Headers");
        config.addExposedHeader("Access-Control-Allow-Methods");
        config.addExposedHeader("Access-Control-Max-Age");
        config.addExposedHeader("Access-Control-Expose-Headers");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
