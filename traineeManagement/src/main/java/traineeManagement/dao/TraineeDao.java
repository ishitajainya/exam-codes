package traineeManagement.dao;
import traineeManagement.dto.Trainee;

public interface TraineeDao {
	Trainee findTraineeById(int traineeId);
    public void addTrainee(Trainee trainee);
}

