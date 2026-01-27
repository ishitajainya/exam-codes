package traineeManagement.dao;
import traineeManagement.Exceptions.DaoException;
import traineeManagement.dto.Trainee;
import traineeManagement.util.EmFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;


public class TraineeDaoHibImpl implements TraineeDao {

	private EntityManagerFactory entityManagerFactory;
	public TraineeDaoHibImpl() {
		entityManagerFactory=EmFactory.getEntityManagerFactory();
	}

	@Override
	public Trainee findTraineeById(int traineeId){
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
            return em.find(Trainee.class, traineeId);
        } catch (PersistenceException e) {
            throw new DaoException("Failed to find trainee with id " + traineeId, e);
        }
	}

	@Override
	public void addTrainee(Trainee trainee){
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(trainee);
			tx.commit();
		}catch(PersistenceException e) {
			throw new DaoException("Failed to add trainee", e);
		}
		em.close();
	}

}