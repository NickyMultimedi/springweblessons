open module be.multimedi.weblessons {
    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires java.sql;

    requires spring.web;
    requires spring.boot.starter.web;
    requires spring.webmvc;
    requires java.annotation;
    requires java.validation;
    requires tomcat.embed.core;

    requires spring.boot.starter.security;
    requires spring.security.core;
    requires spring.security.config;
}
