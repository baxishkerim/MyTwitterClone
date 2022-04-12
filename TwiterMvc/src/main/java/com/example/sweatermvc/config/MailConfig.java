package com.example.sweatermvc.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private  String host;

    @Value("${spring.mail.port}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${mail.debug}")
    private String debug;


    @Bean
    public JavaMailSender getMyEmailSender(){
        JavaMailSenderImpl mysender  = new JavaMailSenderImpl();

        mysender.setHost(host);
        mysender.setUsername(username);
        mysender.setPassword(password);
        mysender.setPort(port);
        mysender.setProtocol(protocol);

        Properties properties = mysender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug",debug);


        return mysender;



    }
}