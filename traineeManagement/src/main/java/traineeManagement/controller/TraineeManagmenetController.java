package traineeManagement.controller;

import traineeManagement.dao.TraineeDaoHibImpl;
import traineeManagement.dao.TraineeDaoJdbcImpl;
import traineeManagement.dto.Trainee;
import traineeManagement.service.TraineeService;

public class TraineeManagmenetController {
	public static void main(String[] args) {
		
			//jpa testing
			TraineeDaoHibImpl traineeDaoHibImpl = new TraineeDaoHibImpl();
			TraineeService traineeServiceUsingHib = new TraineeService(traineeDaoHibImpl); 
			
			Trainee foundTrainee = traineeServiceUsingHib.findTraineeById(1);
			System.out.println(foundTrainee);
			//traineeServiceUsingHib.findTraineeById(-1);
			
			
			 Trainee trainee1 = new Trainee("Ishita", "java", 90);
			 traineeServiceUsingHib.addTrainee(trainee1);
			
			 
			 //jdbc tetsing
			 TraineeDaoJdbcImpl traineeDaoJdbcImpl = new TraineeDaoJdbcImpl();
			 TraineeService traineeServiceUsingJdbc = new TraineeService(traineeDaoJdbcImpl); 
			 
			 traineeServiceUsingJdbc.findTraineeById(1);
			 

	}	
}
