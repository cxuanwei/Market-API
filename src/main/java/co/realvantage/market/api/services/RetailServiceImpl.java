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

import co.realvantage.market.api.respositories.RetailKDRepository;
import co.realvantage.market.api.respositories.RetailKIRepository;
import co.realvantage.market.api.entities.Retail;
import co.realvantage.market.api.entities.RetailKD;
import co.realvantage.market.api.entities.RetailKI;

@Service
public class RetailServiceImpl implements RetailService{
	@Autowired
	RetailKIRepository _kiRepository;
	
	@Autowired
	RetailKDRepository _kdRepository;

	@Override
	public RetailKI createKeyIndicator(RetailKI _retailKI) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		RetailKI ki=findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(_retailKI.getQuarter(),_retailKI.getYear(),
				_retailKI.getCountry(),_retailKI.getState(),_retailKI.getSuburb(),_retailKI.getIndicator(),_retailKI.getGrade());
		if(ki!=null)	{
			_retailKI.setId(ki.getId());
		}
		else
			_retailKI.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kiRepository.save(_retailKI);
	}

	@Override
	public void updateKeyIndicator(RetailKI _retailKI) throws Exception {
		// TODO Auto-generated method stub
		if(_retailKI.getId()<=0)
			throw new Exception("Invalid ID!");
		_kiRepository.save(_retailKI);
	}

	@Override
	public void deleteKeyIndicator(long id) {
		// TODO Auto-generated method stub
		_kiRepository.deleteById(id);
	}

	@Override
	public Collection<RetailKI> findAllKeyIndicators() {
		// TODO Auto-generated method stub
		return _kiRepository.findAll();
	}

	@Override
	public Page<RetailKI> findAllKeyIndicators(Pageable pageable) {
		// TODO Auto-generated method stub
		return _kiRepository.findAll(pageable);
	}

	@Override
	public RetailKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _indicator, String _grade) {
		// TODO Auto-generated method stub
		return _kiRepository.findByTimePeriodAndLocationAndIndicatorAndGrade(_quarter, _year, _country, _state, _suburb, _indicator, _grade);
	}

	@Override
	public RetailKD createKeyDriver(RetailKD _retailKD) {
		// TODO Auto-generated method stub
		//Check whether record exist
		RetailKD kd=findAllKeyDriversByQuarterAndLocationAndDriver(_retailKD.getQuarter(),_retailKD.getYear(),
				_retailKD.getCountry(),_retailKD.getState(),_retailKD.getSuburb(),_retailKD.getDriver());
		if(kd!=null)	{
			_retailKD.setId(kd.getId());
		}
		else
			_retailKD.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kdRepository.save(_retailKD);
	}

	@Override
	public void updateKeyDriver(RetailKD _retailD) throws Exception {
		// TODO Auto-generated method stub
		
		if(_retailD.getId()<=0)
			throw new Exception("Invalid ID!");
		_kdRepository.save(_retailD);
	}

	@Override
	public void deleteKeyDriver(long id) {
		// TODO Auto-generated method stub
		_kdRepository.deleteById(id);
	}

	@Override
	public Collection<RetailKD> findAllKeyDrivers() {
		// TODO Auto-generated method stub
		return _kdRepository.findAll();
	}

	@Override
	public Page<RetailKD> findAllKeyDrivers(Pageable pageable) {
		// TODO Auto-generated method stub
		return _kdRepository.findAll(pageable);
	}

	@Override
	public RetailKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _driver) {
		// TODO Auto-generated method stub
		return _kdRepository.findByTimePeriodAndLocationAndDriver(_quarter, _year, _country, _state, _suburb, _driver);
	}
	
	@Override
	public Retail findAllDriversAndIndicators()	{
		Retail _retail = new Retail();
		_retail.setKdList(_kdRepository.findAll());
		_retail.setKiList(_kiRepository.findAll());
		return _retail;
	}
	
	@Override
	public List<RetailKI> findKeyIndicatorsByStateQuarterYear(String _state,Integer _quarter,Year _year)	{
		if(_state!=null&&_quarter!=null&&_year!=null)
			//_kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
			return _kiRepository.findKeyIndicatorsByStateQuarterYear(_quarter.longValue(), _year, _state);

		return new ArrayList<RetailKI>();	//return any empty list
		
	}
	
	@Override
	public Page<RetailKI> findKeyIndicatorsByStateQuarterYear(String _state,Integer _quarter,Year _year, Pageable _page)	{
		if(_state!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByStateQuarterYear(_quarter.longValue(), _year, _state, _page);
		return new PageImpl<RetailKI>(Collections.emptyList());
		
	}
	
	@Override
	public List<RetailKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year)	{
		if(_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state);

		return new ArrayList<RetailKD>();	//return any empty list
		
	}
	
	@Override
	public Page<RetailKD> findKeyDriversByStateQuarterYear(String _state,Integer _quarter,Year _year, Pageable _page)	{
		if(_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state, _page);
		 
		return new PageImpl<RetailKD>(Collections.emptyList());
		
	}

	@Override
	public List<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(String _state, Integer _quarter, Year _year,
			String _country) {
		if(_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			//_kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
			return _kiRepository.findKeyIndicatorsByCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country);
		else if(_state!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByStateQuarterYear(_quarter.longValue(), _year, _state);
		return new ArrayList<RetailKI>();	//return any empty list
	}

	@Override
	public Page<RetailKI> findKeyIndicatorsByCountryStateQuarterYear(String _state, Integer _quarter, Year _year,
			String _country, Pageable pageable) {
		if(_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country, pageable);
		else if(_state!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorsByStateQuarterYear(_quarter.longValue(), _year, _state, pageable);
		return new PageImpl<RetailKI>(Collections.emptyList());
	}

	@Override
	public List<RetailKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state, Integer _quarter, Year _year) {
		if(_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country);
		else if(_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state);
		else
			return new ArrayList<RetailKD>();	//return any empty list
	}

	@Override
	public Page<RetailKD> findKeyDriversByCountryStateQuarterYear(String _country, String _state, Integer _quarter, Year _year,
		 Pageable pageable) {
		if(_country!=null&&_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountryStateQuarterYear(_quarter.longValue(), _year, _state, _country, pageable);
		else if(_state!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByStateQuarterYear(_quarter.longValue(), _year, _state, pageable);
		else 
			return new PageImpl<RetailKD>(Collections.emptyList());
	}

	@Override
	public RetailKD findKeyDriverByKDStateCountryQuarterYear(String _kd, String _state, String _country, Integer _quarter, Year _year) {
		if(_kd!=null&&_state!=null&&_country!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriverByKDStateCountryQuarterYear(_quarter.longValue(), _year, _state, _country, _kd);
		return null;
	}

	@Override
	public RetailKI findKeyIndicatorByKIGradeStateQuarterYear(String _ki, String _grade, String _state, String _country, Integer _quarter, Year _year) {
		if(_ki!=null&&_grade!=null&&_state!=null&&_country!=null&&_quarter!=null&&_year!=null)
			return _kiRepository.findKeyIndicatorByKIGradeCountryStateQuarterYear(_quarter.longValue(), _year, _country, _state, _ki, _grade);
		return null;
	}
}
