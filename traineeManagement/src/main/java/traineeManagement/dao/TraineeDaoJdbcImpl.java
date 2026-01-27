package traineeManagement.dao;

import java.sql.*;

import traineeManagement.Exceptions.DaoException;
import traineeManagement.dto.Trainee;
import traineeManagement.util.ConnectionFactory;

public class TraineeDaoJdbcImpl implements TraineeDao{
	private Connection connection;

	public TraineeDaoJdbcImpl() {
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public Trainee findTraineeById(int traineeId){
        String sql = "SELECT * FROM trainee WHERE trainee_id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, traineeId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Trainee(
                    		rs.getString("trainee_name"),
        	                rs.getString("branch"),
        	                rs.getDouble("percentage")
        	         );
                } else {
                    throw new DaoException("trainee not found with traineeId: " + traineeId, null);
                }
            }

        } catch (SQLException e) {
            throw new DaoException("Failed to find book", e);
        }
    }

	
	@Override
	public void addTrainee(Trainee trainee) {
		try {
			PreparedStatement psmt=connection
					.prepareStatement("insert into trainee(trainee_name, branch, percentage) values(?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, trainee.getTrainee_name());
			psmt.setString(2, trainee.getBranch());
			psmt.setDouble(3, trainee.getPercentage());
			
			psmt.executeUpdate();
			
			ResultSet rs=psmt.getGeneratedKeys();
			
			if(rs.next()) {
				trainee.setTrainee_id(rs.getInt(1));
			}
		}catch(SQLException e) {
			throw new DaoException("Failed to add trainee", e);
		}
	}
}
