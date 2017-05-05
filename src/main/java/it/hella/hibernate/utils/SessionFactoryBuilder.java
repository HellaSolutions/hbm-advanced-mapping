package it.hella.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryBuilder {

	private SessionFactory sessionFactory;

	public SessionFactoryBuilder() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
		MetadataSources meta = new MetadataSources(registry);
		sessionFactory = meta.buildMetadata().buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
