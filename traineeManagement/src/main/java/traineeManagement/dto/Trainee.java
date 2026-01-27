package traineeManagement.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainee")
public class Trainee {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int trainee_id;
    String trainee_name;
    String branch;
    double percentage;
    
    public Trainee() {
    }

	public Trainee(String trainee_name, String branch, double percentage) {
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}
	public int getTrainee_id() {
		return trainee_id;
	}

	public String getTrainee_name() {
		return trainee_name;
	}

	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Trainee [trainee_id=" + trainee_id + ", trainee_name=" + trainee_name + ", branch=" + branch
				+ ", percentage=" + percentage + "]";
	}
    
    
}
