package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import co.realvantage.market.api.entities.OfficeKI;

@Repository
public interface OfficeKIRepository extends JpaRepository<OfficeKI, Long> {
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 AND year=?2 AND country ILIKE ?3 AND state ILIKE ?4 and suburb ILIKE ?5 and indicator ILIKE ?6 and grade ILIKE ?7",nativeQuery=true)
	public OfficeKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 AND year=?2 AND suburb ILIKE ?3",nativeQuery=true)
	public Page<OfficeKI> findKeyIndicatorsBySuburbQuarterYear(long _quarter, Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 AND year=?2 AND suburb %?1%",nativeQuery=true)
	public List<OfficeKI> findKeyIndicatorsBySuburbQuarterYear(long _quarter, Year _year, String _suburb);
	
	@Query(value="SELECT * FROM officeki WHERE country ILIKE %?1% AND state ILIKE %?2% AND quarter=?3 AND year=?4 AND suburb ILIKE %?5%",nativeQuery=true)
	public Page<OfficeKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state, long _quarter, Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM officeki WHERE country ILIKE %?1% AND state ILIKE %?2% AND quarter=?3 and year=?4 and suburb ILIKE %?5%",nativeQuery=true)
	public List<OfficeKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state, long _quarter, Year _year, String _suburb);
	
	@Query(value="SELECT * FROM officeki WHERE indicator = ?1 AND grade = ?2 AND country = ?3 AND state = ?4 AND quarter=?5 and year=?6 and suburb = ?7",nativeQuery=true)
	public OfficeKI findKeyIndicatorByKIGradeCountryStateSuburbQuarterYear(String _ki, String _grade, String _country, String _state, long _quarter, Year _year, String _suburb);
	
}
