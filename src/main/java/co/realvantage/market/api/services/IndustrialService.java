package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;

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
}
