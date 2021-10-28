package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.realvantage.market.api.entities.Retail;
import co.realvantage.market.api.entities.RetailKD;
import co.realvantage.market.api.entities.RetailKI;

public interface RetailService {
	
	public abstract RetailKI createKeyIndicator(RetailKI _retailKI);
	public abstract void updateKeyIndicator(RetailKI _retailKI) throws Exception;
	public abstract void deleteKeyIndicator(long id);
	public abstract Collection<RetailKI> findAllKeyIndicators();
	public abstract Page<RetailKI> findAllKeyIndicators(Pageable pageable);
	public abstract RetailKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade);
	
	public abstract RetailKD createKeyDriver(RetailKD _retailKD);
	public abstract void updateKeyDriver(RetailKD _retailD) throws Exception;
	public abstract void deleteKeyDriver(long id);
	public abstract Collection<RetailKD> findAllKeyDrivers();
	public abstract Page<RetailKD> findAllKeyDrivers(Pageable pageable);
	public abstract RetailKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	public abstract Retail findAllDriversAndIndicators();
	public abstract List<RetailKI> findKeyIndicatorsByStateQuarterYear(String _state,Integer _quarter,Year _year);
	public abstract Page<RetailKI> findKeyIndicatorsByStateQuarterYear(String _state,Integer _quarter,Year _year, Pageable pageable);
	public abstract List<RetailKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year);
	public abstract Page<RetailKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year, Pageable pageable);
	
	public abstract List<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(String _state,Integer _quarter,Year _year, String _country);
	public abstract Page<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(String _state,Integer _quarter,Year _year, String _country, Pageable pageable);
	public abstract List<RetailKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state,Integer _quarter,Year _year);
	public abstract Page<RetailKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state,Integer _quarter,Year _year,Pageable pageable);
	
	public abstract RetailKD findKeyDriverByKDStateCountryQuarterYear(String _kd, String _state, String _country, Integer _quarter,Year _year);
	public abstract RetailKI findKeyIndicatorByKIGradeStateQuarterYear(String _ki, String _grade, String _state,String _country, Integer _quarter,Year _year);
	
}
