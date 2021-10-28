package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.IndustrialKI;

@Repository
public interface IndustrialKIRepository extends JpaRepository<IndustrialKI, Long> {
	
	@Query(value="SELECT * FROM industrialki WHERE quarter=?1 AND year=?2 AND country ILIKE ?3 AND state ILIKE ?4 AND suburb ILIKE ?5 AND indicator ILIKE ?6 AND grade ILIKE ?7",nativeQuery=true)
	public IndustrialKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	@Query(value="SELECT * FROM industrialki WHERE quarter=?1 AND year=?2 AND suburb ILIKE %?3%",nativeQuery=true)
	public Page<IndustrialKI> findKeyIndicatorsBySuburbQuarterYear(long _quarter, Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM industrialki WHERE quarter=?1 and year=?2 AND suburb ILIKE %?3%",nativeQuery=true)
	public List<IndustrialKI> findKeyIndicatorsBySuburbQuarterYear(long _quarter, Year _year, String _suburb);
	
	@Query(value="SELECT * FROM industrialki WHERE quarter=?1 AND year=?2 AND suburb ILIKE %?3% and state ILIKE %?4% and country ILIKE %?5%",nativeQuery=true)
	public Page<IndustrialKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(long _quarter, Year _year, String _suburb, String _state, String _country, Pageable page); 
	
	@Query(value="SELECT * FROM industrialki WHERE quarter=?1 and year=?2 and suburb ILIKE %?3% and state ILIKE %?4% and country ILIKE %?5%",nativeQuery=true)
	public List<IndustrialKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(long _quarter, Year _year, String _suburb, String _state, String _country);
	
	@Query(value="SELECT * FROM industrialki WHERE quarter=?1 and year=?2 and suburb = ?3 and state = ?4 and country = ?5 and indicator=?6 and grade=?7",nativeQuery=true)
	public IndustrialKI findKeyIndicatorByKICountryStateQuarterYear(long _quarter, Year _year, String _suburb, String _state, String _country, String _ki, String _grade);
}
 