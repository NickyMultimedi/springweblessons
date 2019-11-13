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

    requires org.mariadb.jdbc;
    requires spring.boot.starter.jdbc;
    requires spring.jdbc;
    requires java.persistence;
    requires spring.boot.starter.data.jpa;
    requires spring.data.jpa;
    requires spring.data.commons;

    requires java.xml.bind;
    requires jackson.annotations;
    requires net.bytebuddy;
}
