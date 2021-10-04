package co.realvantage.market.api.respositories;

import java.time.Year;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.RetailKD;

@Repository
public interface RetailKDRepository extends JpaRepository<RetailKD, Long> {
	
	@Query(value="SELECT * FROM retailkd WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5 and driver like ?6",nativeQuery=true)
	public RetailKD findByTimePeriodAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);

	
	@Query(value="SELECT * FROM retailkd WHERE quarter=?1 AND year=?2 AND state like ?3",nativeQuery=true)
	public Page<RetailKD> findKeyDriversByStateQuarterYear(long _quarter, Year _year, String _state, Pageable page); 
	
	@Query(value="SELECT * FROM retailkd WHERE quarter=?1 and year=?2 and state like ?3",nativeQuery=true)
	public List<RetailKD> findKeyDriversByStateQuarterYear(long _quarter, Year _year, String _state);
	
	@Query(value="SELECT * FROM retailkd WHERE quarter=?1 AND year=?2 AND state like %?3% AND country like %?4%",nativeQuery=true)
	public Page<RetailKD> findKeyDriversByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country, Pageable page); 
	
	@Query(value="SELECT * FROM retailkd WHERE quarter=?1 and year=?2 and state like %?3% AND country like %?4%",nativeQuery=true)
	public List<RetailKD> findKeyDriversByCountryStateQuarterYear(long _quarter, Year _year, String _state, String _country);
}
