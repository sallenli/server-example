package com.netease.server.example.web.controller.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionBindingEvent;
import org.apache.log4j.Logger;

public class TestListener implements ServletContextListener,
		ServletContextAttributeListener, HttpSessionListener,
		HttpSessionAttributeListener {

	/**
	 * Logger for this class.
	 */
	private static Logger logger = Logger.getLogger(TestListener.class);

	public void contextInitialized(ServletContextEvent event) {
		logger.info("contextInitialized");
	}

	public void contextDestroyed(ServletContextEvent event) {
		logger.info("contextDestroyed");
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		logger.info("context attributeAdded");
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		logger.info("context attributeRemoved");
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		logger.info("context attributeReplaced");
	}

	public void sessionCreated(HttpSessionEvent event) {
		logger.info("sessionCreated");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("sessionDestroyed");
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		logger.info("session attributeAdded");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.info("session attributeRemoved");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.info("session attributeReplaced");
	}
}
