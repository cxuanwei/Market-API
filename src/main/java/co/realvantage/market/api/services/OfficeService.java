package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;
import java.util.List;

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
	
	public abstract Office findAllDriversAndIndicators();
	public abstract List<OfficeKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,Integer _quarter,Year _year);
	public abstract Page<OfficeKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,Integer _quarter,Year _year, Pageable pageable);
	public abstract List<OfficeKD> findKeyDriversByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,Integer _quarter,Year _year);
	public abstract Page<OfficeKD> findKeyDriversByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,Integer _quarter,Year _year, Pageable pageable);
	
	public abstract OfficeKI findKeyIndicatorByKIGradeCountryStateSuburbQuarterYear(String _ki, String _grade, String _country, String _state, String _suburb,Integer _quarter,Year _year);
	public abstract OfficeKD findKeyDriverByKDCountryStateSuburbQuarterYear(String _kd, String _country, String _state, String _suburb,Integer _quarter,Year _year);
	
}
