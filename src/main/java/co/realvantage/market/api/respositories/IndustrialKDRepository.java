package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.IndustrialKD;

@Repository
public interface IndustrialKDRepository extends JpaRepository<IndustrialKD, Long> {
	
	@Query(value="SELECT * FROM industrialkd WHERE quarter=?1 AND year=?2 AND country ILIKE ?3 AND state ILIKE ?4 and suburb ILIKE ?5 and driver ILIKE ?6",nativeQuery=true)
	public IndustrialKD findByTimePeriodAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	@Query(value="SELECT * FROM industrialkd WHERE quarter=?1 AND year=?2 AND state ILIKE %?3%",nativeQuery=true)
	public Page<IndustrialKD> findKeyDriversByStateQuarterYear(long _quarter, Year _year, String _state, Pageable page); 
	
	@Query(value="SELECT * FROM industrialkd WHERE quarter=?1 and year=?2 and state ILIKE %?3%",nativeQuery=true)
	public List<IndustrialKD> findKeyDriversByStateQuarterYear(long _quarter, Year _year, String _state);
	
	@Query(value="SELECT * FROM industrialkd WHERE quarter=?1 AND year=?2 AND state ILIKE %?3% and country ILIKE %?4%",nativeQuery=true)
	public Page<IndustrialKD> findKeyDriversByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country, Pageable page); 
	
	@Query(value="SELECT * FROM industrialkd WHERE quarter=?1 and year=?2 and state ILIKE %?3% and country ILIKE %?4%",nativeQuery=true)
	public List<IndustrialKD> findKeyDriversByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country);
	
	@Query(value="SELECT * FROM industrialkd WHERE quarter=?1 and year=?2 and state = ?3 and country = ?4 and driver = ?5",nativeQuery=true)
	public IndustrialKD findKeyDriverByKDCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country, String _kd);
}
