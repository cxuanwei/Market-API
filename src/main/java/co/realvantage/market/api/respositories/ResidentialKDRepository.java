package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.ResidentialKD;

@Repository
public interface ResidentialKDRepository extends JpaRepository<ResidentialKD, Long> {

	@Query(value="SELECT * FROM residentialkd WHERE quarter=?1 AND year=?2 AND country ILIKE ?3 AND state ILIKE ?4 AND suburb ILIKE ?5 AND driver ILIKE ?6",nativeQuery=true)
	public ResidentialKD findByTimePeriodAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	@Query(value="SELECT * FROM residentialkd WHERE quarter=?1 AND year=?2 AND suburb ILIKE ?3",nativeQuery=true)
	public Page<ResidentialKD> findKeyDriversBySuburbQuarterYear(long _quarter, Year _year, String _suburb, Pageable page); 
	
	@Query(value="SELECT * FROM residentialkd WHERE quarter=?1 and year=?2 and suburb ILIKE ?3",nativeQuery=true)
	public List<ResidentialKD> findKeyDriversBySuburbQuarterYear(long _quarter, Year _year, String _suburb);
	
	@Query(value="SELECT * FROM residentialkd WHERE quarter=?1 AND year=?2 AND suburb ILIKE %?3% AND country ILIKE %?4%",nativeQuery=true)
	public Page<ResidentialKD> findKeyDriversByCountrySuburbQuarterYear(long _quarter, Year _year, String _suburb, String _country, Pageable page); 
	
	@Query(value="SELECT * FROM residentialkd WHERE quarter=?1 and year=?2 and suburb ILIKE %?3% AND country ILIKE %?4%",nativeQuery=true)
	public List<ResidentialKD> findKeyDriversByCountrySuburbQuarterYear(long _quarter, Year _year, String _suburb, String _country);
}
