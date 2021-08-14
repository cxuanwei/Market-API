package co.realvantage.market.api.respositories;

import java.time.Year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.OfficeKD;

@Repository
public interface OfficeKDRepository extends JpaRepository<OfficeKD, Long> {
	
	@Query(value="SELECT * FROM officekd WHERE quarter=?1 AND year=?2 AND country like ?3 AND state like ?4 and suburb like ?5",nativeQuery=true)
	public OfficeKD findByTimePeriodAndLocation(long _quarter, Year _year, String _country, String _state, String _suburb);

}
