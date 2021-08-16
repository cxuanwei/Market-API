package co.realvantage.market.api.respositories;

import java.time.Year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.ResidentialKI;

@Repository
public interface ResidentialKIRepository extends JpaRepository<ResidentialKI, Long> {
	
	@Query(value="SELECT * FROM residentialki WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 AND suburb like ?5 AND indicator like ?6 AND grade like ?7",nativeQuery=true)
	public ResidentialKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
}
