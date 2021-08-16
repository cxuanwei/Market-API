package co.realvantage.market.api.respositories;

import java.time.Year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.RetailKI;

@Repository
public interface RetailKIRepository extends JpaRepository<RetailKI, Long> {
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5 and indicator like ?6 and grade like ?7",nativeQuery=true)
	public RetailKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
}
