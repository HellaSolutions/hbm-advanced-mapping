package it.hella.hibernate.utils;

import org.hibernate.SessionFactory;

/**
 * The Class HibernateUtil.
 * 
 * Singleton factory pattern for the Hibernate Session Factory
 */
public class HibernateUtil {

	/** The session factory. */
	private static SessionFactory sessionFactory;

	/**
	 * Only static methods
	 */
	private HibernateUtil() {
	}

	@SuppressWarnings("unused")
	private static class SessionFactoryHolder {
		private static SessionFactory sessionFactory = new SessionFactoryBuilder().getSessionFactory();

		private SessionFactoryHolder() {
		}
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Releases the Session Factory
	 */
	public static void shutdown() {

		if (sessionFactory != null) {
			synchronized (HibernateUtil.class) {
				if (sessionFactory != null) {
					sessionFactory.close();
					sessionFactory = null;
				}
			}
		}

	}

}