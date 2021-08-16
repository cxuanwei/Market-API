package co.realvantage.market.api.respositories;

import java.time.Year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import co.realvantage.market.api.entities.OfficeKI;

@Repository
public interface OfficeKIRepository extends JpaRepository<OfficeKI, Long> {
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5 and indicator like ?6 and grade like ?7",nativeQuery=true)
	public OfficeKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
}
