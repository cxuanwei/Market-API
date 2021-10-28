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

import co.realvantage.market.api.respositories.IndustrialKIRepository;
import co.realvantage.market.api.entities.Industrial;
import co.realvantage.market.api.entities.IndustrialKD;
import co.realvantage.market.api.entities.IndustrialKI;
import co.realvantage.market.api.respositories.IndustrialKDRepository;

@Service
public class IndustrialServiceImpl implements IndustrialService{
	@Autowired
	IndustrialKIRepository _kiRepository;
	
	@Autowired
	IndustrialKDRepository _kdRepository;

	@Override
	public IndustrialKI createKeyIndicator(IndustrialKI _ki) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		IndustrialKI ki=findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(_ki.getQuarter(),_ki.getYear(),
				_ki.getCountry(),_ki.getState(),_ki.getSuburb(),_ki.getIndicator(),_ki.getGrade());
		if(ki!=null)	{
			_ki.setId(ki.getId());
		}
		else
			_ki.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kiRepository.save(_ki);
	}

	@Override
	public void updateKeyIndicator(IndustrialKI _ki) throws Exception {
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
	public Collection<IndustrialKI> findAllKeyIndicators() {
		// TODO Auto-generated method stub
		return _kiRepository.findAll();
	}
	
	@Override
	public Page<IndustrialKI> findAllKeyIndicators(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _kiRepository.findAll(_pageable);
	}


	@Override
	public IndustrialKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade) {
		// TODO Auto-generated method stub
		return _kiRepository.findByTimePeriodAndLocationAndIndicatorAndGrade(_quarter, _year, _country, _state, _suburb, _indicator, _grade);
	}

	@Override
	public IndustrialKD createKeyDriver(IndustrialKD _kd) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		IndustrialKD kd=_kdRepository.findByTimePeriodAndLocationAndDriver(_kd.getQuarter(),_kd.getYear(),
				_kd.getCountry(),_kd.getState(),_kd.getSuburb(), _kd.getDriver());
		if(kd!=null)	{
			_kd.setId(kd.getId());
		}
		else
			_kd.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kdRepository.save(_kd);
	}

	@Override
	public void updateKeyDriver(IndustrialKD _kd) throws Exception {
		// TODO Auto-generated method stub
		if(_kd.getId()<=0)
			throw new Exception("Invalid ID!");
		_kdRepository.save(_kd);
	}

	@Override
	public void deleteKeyDriver(long id) {
		// TODO Auto-generated method stub
		_kdRepository.deleteById(id);
	}	

	@Override
	public Collection<IndustrialKD> findAllKeyDrivers() {
		// TODO Auto-generated method stub
		return _kdRepository.findAll();
	}

	@Override
	public Page<IndustrialKD> findAllKeyDrivers(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _kdRepository.findAll(_pageable);
	}

	@Override
	public IndustrialKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _driver) {
		// TODO Auto-generated method stub
		return _kdRepository.findByTimePeriodAndLocationAndDriver(_quarter, _year, _country, _state, _suburb, _driver);
	}
	
	@Override
	public Industrial findAllDriversAndIndicators()	{
		Industrial _industrial = new Industrial();
		_industrial.setKdList(_kdRepository.findAll());
		_industrial.setKiList(_kiRepository.findAll());
		return _industrial;
	}
	
	@Override
	public List<IndustrialKI> findKeyIndicatorsBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			//_kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
			return _kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb);

		return new ArrayList<IndustrialKI>();	//return any empty list
		
	}
	
	@Override
	public Page<IndustrialKI> findKeyIndicatorsBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year, Pageable _page)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
		return new PageImpl<IndustrialKI>(Collections.emptyList());
		
	}
	
	@Override
	public List<IndustrialKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year)	{
		if(_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state);

		return new ArrayList<IndustrialKD>();	//return any empty list
		
	}
	
	@Override
	public Page<IndustrialKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year, Pageable _page)	{
		if(_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state, _page);
		 
		return new PageImpl<IndustrialKD>(Collections.emptyList());
		
	}

	@Override
	public List<IndustrialKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state,
			String _suburb, Integer _quarter, Year _year) {
		if(_country!=null&&_state!=null&_suburb!=null&&_quarter!=null&&_year!=null)
			//_kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
			return _kiRepository.findKeyIndicatorsByCountryStateSuburbQuarterYear(_quarter.longValue(), _year, _suburb, _state, _country);
		else if (_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb);
		return new ArrayList<IndustrialKI>();	//return any empty list
	}

	@Override
	public Page<IndustrialKI> findKeyIndicatorsByCountryStateSuburbQuarterYear(String _country, String _state,
			String _suburb, Integer _quarter, Year _year, Pageable pageable) {
		if(_country!=null&&_state!=null&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByCountryStateSuburbQuarterYear(_quarter.longValue(), _year, _suburb, _state, _country, pageable);
		else if (_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, pageable);
		else
		return new PageImpl<IndustrialKI>(Collections.emptyList());
	}

	@Override
	public List<IndustrialKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state, Integer _quarter,
			Year _year) {
		if(_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country);
		else if (_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state);
		else
			return new ArrayList<IndustrialKD>();	//return any empty list
	}

	@Override
	public Page<IndustrialKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state, Integer _quarter,
			Year _year, Pageable pageable) {
		if(_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country, pageable);
		else if (_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state, pageable);
		else 
			return new PageImpl<IndustrialKD>(Collections.emptyList());
	}

	@Override
	public IndustrialKI findKeyIndicatorByKICountryStateQuarterYear(String _ki, String _grade, String _country, String _state,
			String _suburb, Integer _quarter, Year _year) {
		if(_ki!=null&&_grade!=null&&_country!=null&&_state!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorByKICountryStateQuarterYear(_quarter.longValue(), _year, _suburb, _state, _country, _ki, _grade);
		else
			return null;
	}

	@Override
	public IndustrialKD findKeyDriverByKDCountryStateQuarterYear(String _country, String _state, Integer _quarter,
			Year _year, String _kd) {
		if(_kd!=null&&_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriverByKDCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country, _kd);
		else
			return null;
	}
}
