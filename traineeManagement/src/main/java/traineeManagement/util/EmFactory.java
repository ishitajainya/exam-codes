package traineeManagement.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ymali_pu");
		return entityManagerFactory;
	}
}