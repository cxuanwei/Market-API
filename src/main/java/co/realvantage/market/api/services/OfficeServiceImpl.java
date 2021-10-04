package co.realvantage.market.api.services;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.realvantage.market.api.respositories.OfficeKIRepository;
import co.realvantage.market.api.entities.Office;
import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;
import co.realvantage.market.api.respositories.OfficeKDRepository;

@Service
public class OfficeServiceImpl implements OfficeService{
	@Autowired
	OfficeKIRepository _kiRepository;
	
	@Autowired
	OfficeKDRepository _kdRepository;

	@Override
	public OfficeKI createKeyIndicator(OfficeKI _ki) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		OfficeKI ki=_kiRepository.findByTimePeriodAndLocationAndIndicatorAndGrade(_ki.getQuarter(),_ki.getYear(),
				_ki.getCountry(),_ki.getState(),_ki.getSuburb(),_ki.getIndicator(),_ki.getGrade());
		if(ki!=null)	{
			_ki.setId(ki.getId());
		}
		else
			_ki.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kiRepository.save(_ki);
	}

	@Override
	public void updateKeyIndicator(OfficeKI _ki) throws Exception {
		// TODO Auto-generated method stub
		if(_ki.getId()<=0)
			throw new Exception("Invalid ID!");
		_kiRepository.save(_ki);
	}

	@Override
	public void deleteKeyIndicator(long id) {
		// TODO Auto-generated method stub
		_kiRepository.deleteById(id);
		
	}

	@Override
	public Collection<OfficeKI> findAllKeyIndicators() {
		// TODO Auto-generated method stub
		return _kiRepository.findAll();
	}
	
	@Override
	public Page<OfficeKI> findAllKeyIndicators(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _kiRepository.findAll(_pageable);
	}


	@Override
	public OfficeKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade) {
		// TODO Auto-generated method stub
		return _kiRepository.findByTimePeriodAndLocationAndIndicatorAndGrade(_quarter, _year, _country, _state, _suburb, _indicator, _grade);
	}

	@Override
	public OfficeKD createKeyDriver(OfficeKD _kd) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		OfficeKD kd=_kdRepository.findByTimePeriodAndLocationAndDriver(_kd.getQuarter(),_kd.getYear(),
				_kd.getCountry(),_kd.getState(),_kd.getSuburb(),_kd.getDriver());
		if(kd!=null)	{
			_kd.setId(kd.getId());
		}
		else
			_kd.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kdRepository.save(_kd);
	}

	@Override
	public void updateKeyDriver(OfficeKD _kd) throws Exception {
		// TODO Auto-generated method stub
		if(_kd.getId()==0)
			throw new Exception("Invalid ID!");
		_kdRepository.save(_kd);
	}

	@Override
	public void deleteKeyDriver(long id) {
		// TODO Auto-generated method stub
		_kdRepository.deleteById(id);
	}	

	@Override
	public Collection<OfficeKD> findAllKeyDrivers() {
		// TODO Auto-generated method stub
		return _kdRepository.findAll();
	}

	@Override
	public Page<OfficeKD> findAllKeyDrivers(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _kdRepository.findAll(_pageable);
	}

	@Override
	public OfficeKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _driver) {
		// TODO Auto-generated method stub
		return _kdRepository.findByTimePeriodAndLocationAndDriver(_quarter, _year, _country, _state, _suburb, _driver);
	}
	
	@Override
	public Office findAllDriversAndIndicators()	{
		Office _office = new Office();
		_office.setKdList(_kdRepository.findAll());
		_office.setKiList(_kiRepository.findAll());
		return _office;
	}
	
	@Override
	public List<OfficeKI> findKeyIndicatorsBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)	
			return _kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb);
		return new ArrayList<OfficeKI>();	//return any empty list
		
	}
	
	@Override
	public Page<OfficeKI> findKeyIndicatorsBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year, Pageable _page)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
		return new PageImpl<OfficeKI>(Collections.emptyList());
		
	}
	
	@Override
	public List<OfficeKD> findKeyDriversBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversBySuburbQuarterYear(_quarter.longValue(), _year, _suburb);

		return new ArrayList<OfficeKD>();	//return any empty list
		
	}
	
	@Override
	public Page<OfficeKD> findKeyDriversBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year, Pageable _page)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
		 
		return new PageImpl<OfficeKD>(Collections.emptyList());
		
	}

	@Override
	public List<OfficeKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state,
			String _suburb, Integer _quarter, Year _year) {
		if(_country!=null&&_state!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByCountryStateSuburbQuarterYear(_country, _state, _quarter.longValue(), _year, _suburb);

		return new ArrayList<OfficeKI>();	//return any empty list
	}

	@Override
	public Page<OfficeKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state,
			String _suburb, Integer _quarter, Year _year, Pageable pageable) {
		if(_country!=null&&_state!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByCountryStateSuburbQuarterYear(_country, _state, _quarter.longValue(), _year, _suburb, pageable);
		
		return new PageImpl<OfficeKI>(Collections.emptyList());
	}

	@Override
	public List<OfficeKD> findKeyDriversByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,
			Integer _quarter, Year _year) {
		if(_country!=null&&_state!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountryStateSuburbQuarterYear(_country,_state,_quarter.longValue(), _year, _suburb);

		return new ArrayList<OfficeKD>();	//return any empty list
	}

	@Override
	public Page<OfficeKD> findKeyDriversByCountryStateSuburbQuarterYear(String _country, String _state, String _suburb,
			Integer _quarter, Year _year, Pageable pageable) {
		if(_country!=null&&_state!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountryStateSuburbQuarterYear(_country, _state, _quarter.longValue(), _year, _suburb, pageable);
		
		return new PageImpl<OfficeKD>(Collections.emptyList());
	}

}
