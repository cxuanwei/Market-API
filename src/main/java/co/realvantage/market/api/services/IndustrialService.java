package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.realvantage.market.api.entities.Industrial;
import co.realvantage.market.api.entities.IndustrialKD;
import co.realvantage.market.api.entities.IndustrialKI;

public interface IndustrialService {
	
	public abstract IndustrialKI createKeyIndicator(IndustrialKI _ki);
	public abstract void updateKeyIndicator(IndustrialKI _ki) throws Exception;
	public abstract void deleteKeyIndicator(long id);
	public abstract Collection<IndustrialKI> findAllKeyIndicators();
	public abstract Page<IndustrialKI> findAllKeyIndicators(Pageable pageable);
	public abstract IndustrialKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	public abstract IndustrialKD createKeyDriver(IndustrialKD _kd);
	public abstract void updateKeyDriver(IndustrialKD _kd) throws Exception;
	public abstract void deleteKeyDriver(long id);
	public abstract Collection<IndustrialKD> findAllKeyDrivers();
	public abstract Page<IndustrialKD> findAllKeyDrivers(Pageable pageable);
	public abstract IndustrialKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	public abstract Industrial findAllDriversAndIndicators();
	public abstract List<IndustrialKI> findKeyIndicatorsBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year);
	public abstract Page<IndustrialKI> findKeyIndicatorsBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year, Pageable pageable);
	public abstract List<IndustrialKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year);
	public abstract Page<IndustrialKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year, Pageable pageable);
	
	public abstract List<IndustrialKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,Integer _quarter,Year _year);
	public abstract Page<IndustrialKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,Integer _quarter,Year _year, Pageable pageable);
	public abstract List<IndustrialKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state,Integer _quarter,Year _year);
	public abstract Page<IndustrialKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state,Integer _quarter,Year _year, Pageable pageable);
	
	public abstract IndustrialKI findKeyIndicatorByKICountryStateQuarterYear(String _ki, String _grade, String _country, String _state, String _suburb, Integer _quarter,Year _year);
	public abstract IndustrialKD findKeyDriverByKDCountryStateQuarterYear(String _country, String _state,Integer _quarter,Year _year, String _kd);
}
