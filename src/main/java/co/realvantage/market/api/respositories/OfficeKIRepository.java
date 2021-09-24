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
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5 and indicator like ?6 and grade like ?7",nativeQuery=true)
	public OfficeKI findByTimePeriodAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 AND year=?2 AND suburb like ?3",nativeQuery=true)
	public Page<OfficeKI> findKeyIndicatorsBySuburbQuarterYear(long _quarter, Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM officeki WHERE quarter=?1 and year=?2 and suburb like ?3",nativeQuery=true)
	public List<OfficeKI> findKeyIndicatorsBySuburbQuarterYear(long _quarter, Year _year, String _suburb);
	
	@Query(value="SELECT * FROM officeki WHERE year=?1 AND suburb like ?2",nativeQuery=true)
	public Page<OfficeKI> findKeyIndicatorsByYear(Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM officeki WHERE year=?1 and suburb like ?2",nativeQuery=true)
	public List<OfficeKI> findKeyIndicatorsByYear(Year _year, String _suburb); 
}
