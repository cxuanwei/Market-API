package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.realvantage.market.api.entities.Office;
import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;

public interface OfficeService {
	
	public abstract OfficeKI createKeyIndicator(OfficeKI _ki);
	public abstract void updateKeyIndicator(OfficeKI _ki) throws Exception;
	public abstract void deleteKeyIndicator(long id);
	public abstract Collection<OfficeKI> findAllKeyIndicators();
	public abstract Page<OfficeKI> findAllKeyIndicators(Pageable pageable);
	public abstract OfficeKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	public abstract OfficeKD createKeyDriver(OfficeKD _kd);
	public abstract void updateKeyDriver(OfficeKD _kd) throws Exception;
	public abstract void deleteKeyDriver(long id);
	public abstract Collection<OfficeKD> findAllKeyDrivers();
	public abstract Page<OfficeKD> findAllKeyDrivers(Pageable pageable);
	public abstract OfficeKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	public abstract Office findAllDriversAndIndicators();
	//public abstract Page<Office> findAllOfficeDriversAndIndicators(Pageable pageable);
	
}
