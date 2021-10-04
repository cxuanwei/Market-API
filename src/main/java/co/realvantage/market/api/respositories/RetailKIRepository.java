package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.RetailKI;

@Repository
public interface RetailKIRepository extends JpaRepository<RetailKI, Long> {
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5 and indicator like ?6 and grade like ?7",nativeQuery=true)
	public RetailKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND state like ?3",nativeQuery=true)
	public Page<RetailKI> findKeyIndicatorsByStateQuarterYear(long _quarter, Year _year, String _state, Pageable page); 
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 and year=?2 and state like ?3",nativeQuery=true)
	public List<RetailKI> findKeyIndicatorsByStateQuarterYear(long _quarter, Year _year, String _state);
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND state like %?3% AND country like %?4%",nativeQuery=true)
	public Page<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country, Pageable page); 
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 and year=?2 and state like %?3% AND country like %?4%",nativeQuery=true)
	public List<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country);
}
