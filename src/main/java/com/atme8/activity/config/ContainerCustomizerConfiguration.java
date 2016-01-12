package com.atme8.activity.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by Administrator on 2015/12/29.
 */
@Configuration
public class ContainerCustomizerConfiguration {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
//                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/404"));
            }
        };
    }
}
