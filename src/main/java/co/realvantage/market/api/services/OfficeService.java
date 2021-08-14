package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;

public interface OfficeService {
	
	public abstract OfficeKI createOfficeKeyIndicator(OfficeKI _officeKI);
	public abstract void updateOfficeKeyIndicator(OfficeKI _officeKI) throws Exception;
	public abstract void deleteOfficeKeyIndicator(long id);
	public abstract Collection<OfficeKI> findAllOfficeKeyIndicators();
	public abstract Page<OfficeKI> findAllOfficeKeyIndicators(Pageable pageable);
	public abstract OfficeKI findAllOfficeKeyIndicatorsByQuarterAndLocation(long _quarter, Year _year, String _country, String _state, String _suburb);
	
	public abstract OfficeKD createOfficeKeyDriver(OfficeKD _officeKD);
	public abstract void updateOfficeKeyDriver(OfficeKD _officeKD) throws Exception;
	public abstract void deleteOfficeKeyDriver(long id);
	public abstract Collection<OfficeKD> findAllOfficeKeyDrivers();
	public abstract Page<OfficeKD> findAllOfficeKeyDrivers(Pageable pageable);
	public abstract OfficeKD findAllOfficeKeyDriversByQuarterAndLocation(long _quarter, Year _year, String _country, String _state, String _suburb);
	
}
