package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.OfficeKD;

@Repository
public interface OfficeKDRepository extends JpaRepository<OfficeKD, Long> {
	
	@Query(value="SELECT * FROM officekd WHERE quarter=?1 AND year=?2 AND country ILIKE ?3 AND state ILIKE ?4 and suburb ILIKE ?5 and driver ILIKE ?6",nativeQuery=true)
	public OfficeKD findByTimePeriodAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	@Query(value="SELECT * FROM officekd WHERE quarter=?1 AND year=?2 AND suburb ILIKE ?3",nativeQuery=true)
	public Page<OfficeKD> findKeyDriversBySuburbQuarterYear(long _quarter, Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM officekd WHERE quarter=?1 and year=?2 and suburb ILIKE ?3",nativeQuery=true)
	public List<OfficeKD> findKeyDriversBySuburbQuarterYear(long _quarter, Year _year, String _suburb);
	
	@Query(value="SELECT * FROM officekd WHERE country  ILIKE  %?1% AND state  ILIKE %?2% AND quarter=?3 and year=?4 and suburb  ILIKE %?5%",nativeQuery=true)
	public Page<OfficeKD> findKeyDriversByCountryStateSuburbQuarterYear(String _country, String _state, long _quarter, Year _year, String _suburb, Pageable page);
	
	@Query(value="SELECT * FROM officekd WHERE country  ILIKE  %?1% AND state  ILIKE %?2% AND quarter=?3 and year=?4 and suburb  ILIKE %?5%",nativeQuery=true)
	public List<OfficeKD> findKeyDriversByCountryStateSuburbQuarterYear(String _country, String _state, long _quarter, Year _year, String _suburb);

	@Query(value="SELECT * FROM officekd WHERE driver = ?1 AND country = ?2 AND state = ?3 AND quarter=?4 and year=?5 and suburb = ?6",nativeQuery=true)
	public OfficeKD findKeyDriverByKDCountryStateSuburbQuarterYear(String _kd, String _country, String _state, long _quarter, Year _year, String _suburb);
}
