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
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND country ILIKE ?3 AND state ILIKE ?4 and suburb ILIKE ?5 and indicator ILIKE ?6 and grade ILIKE ?7",nativeQuery=true)
	public RetailKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND state ILIKE ?3",nativeQuery=true)
	public Page<RetailKI> findKeyIndicatorsByStateQuarterYear(long _quarter, Year _year, String _state, Pageable page); 
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 and year=?2 and state ILIKE ?3",nativeQuery=true)
	public List<RetailKI> findKeyIndicatorsByStateQuarterYear(long _quarter, Year _year, String _state);
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 AND year=?2 AND state ILIKE %?3% AND country ILIKE %?4%",nativeQuery=true)
	public Page<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country, Pageable page); 
	
	@Query(value="SELECT * FROM retailki WHERE quarter=?1 and year=?2 and state ILIKE %?3% AND country ILIKE %?4%",nativeQuery=true)
	public List<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country);
}
