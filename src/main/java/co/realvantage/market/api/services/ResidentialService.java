package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.realvantage.market.api.entities.Residential;
import co.realvantage.market.api.entities.ResidentialKD;
import co.realvantage.market.api.entities.RetailKD;

public interface ResidentialService {
	
	/*
	 * public abstract ResidentialKI createKeyIndicator(ResidentialKI _ki); public
	 * abstract void updateKeyIndicator(ResidentialKI _ki) throws Exception; public
	 * abstract void deleteKeyIndicator(long id); public abstract
	 * Collection<ResidentialKI> findAllKeyIndicators(); public abstract
	 * Page<ResidentialKI> findAllKeyIndicators(Pageable pageable); public abstract
	 * ResidentialKI
	 * findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter,
	 * Year _year, String _country, String _state, String _suburb, String
	 * _indicator, String _grade);
	 */
	
	public abstract ResidentialKD createKeyDriver(ResidentialKD _kd);
	public abstract void updateKeyDriver(ResidentialKD _kd) throws Exception;
	public abstract void deleteKeyDriver(long id);
	public abstract Collection<ResidentialKD> findAllKeyDrivers();
	public abstract Page<ResidentialKD> findAllKeyDrivers(Pageable pageable);
	public abstract ResidentialKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country, String _state, String _suburb, String _driver);
	
	public abstract Residential findAllDriversAndIndicators();
	public abstract List<ResidentialKD> findKeyDriversBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year);
	public abstract Page<ResidentialKD> findKeyDriversBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year, Pageable pageable);
	
}
