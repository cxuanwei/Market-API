package co.realvantage.market.api.respositories;

import java.time.Year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.RetailKD;

@Repository
public interface RetailKDRepository extends JpaRepository<RetailKD, Long> {
	
	@Query(value="SELECT * FROM retailkd WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5 and driver like ?6",nativeQuery=true)
	public RetailKD findByTimePeriodAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
}
