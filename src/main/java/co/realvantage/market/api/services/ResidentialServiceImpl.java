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

//import co.realvantage.market.api.respositories.ResidentialKIRepository;
import co.realvantage.market.api.entities.Residential;
import co.realvantage.market.api.entities.ResidentialKD;
import co.realvantage.market.api.respositories.ResidentialKDRepository;

@Service
public class ResidentialServiceImpl implements ResidentialService{
	//@Autowired
	//ResidentialKIRepository _kiRepository;
	
	@Autowired
	ResidentialKDRepository _kdRepository;

	/*
	@Override
	public ResidentialKI createKeyIndicator(ResidentialKI _ki) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		ResidentialKI ki=findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(_ki.getQuarter(),_ki.getYear(),
				_ki.getCountry(),_ki.getState(),_ki.getState(), _ki.getIndicator(), _ki.getGrade());
		if(ki!=null)	{
			_ki.setId(ki.getId());
		}
		else
			_ki.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kiRepository.save(_ki);
	}

	@Override
	public void updateKeyIndicator(ResidentialKI _ki) throws Exception {
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
	public Collection<ResidentialKI> findAllKeyIndicators() {
		// TODO Auto-generated method stub
		return _kiRepository.findAll();
	}
	
	@Override
	public Page<ResidentialKI> findAllKeyIndicators(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _kiRepository.findAll(_pageable);
	}


	@Override
	public ResidentialKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country, String _state, String _suburb, String _indicator, String _grade) {
		// TODO Auto-generated method stub
		return _kiRepository.findByTimePeriodAndLocationAndIndicatorAndGrade(_quarter, _year, _country, _state, _suburb, _indicator, _grade);
	}
	*/

	@Override
	public ResidentialKD createKeyDriver(ResidentialKD _kd) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		ResidentialKD kd=_kdRepository.findByTimePeriodAndLocationAndDriver(_kd.getQuarter(),_kd.getYear(),
				_kd.getCountry(),_kd.getState(),_kd.getSuburb(),_kd.getDriver());
		if(kd!=null)	{
			_kd.setId(kd.getId());
		}
		else
			_kd.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _kdRepository.save(_kd);
	}

	@Override
	public void updateKeyDriver(ResidentialKD _kd) throws Exception {
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
	public Collection<ResidentialKD> findAllKeyDrivers() {
		// TODO Auto-generated method stub
		return _kdRepository.findAll();
	}

	@Override
	public Page<ResidentialKD> findAllKeyDrivers(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _kdRepository.findAll(_pageable);
	}

	@Override
	public ResidentialKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _driver) {
		// TODO Auto-generated method stub
		return _kdRepository.findByTimePeriodAndLocationAndDriver(_quarter, _year, _country, _state, _suburb, _driver);
	}
	
	@Override
	public Residential findAllDriversAndIndicators()	{
		Residential _residential = new Residential();
		_residential.setKdList(_kdRepository.findAll());
		//_retail.setKiList(_kiRepository.findAll());
		return _residential;
	}
	
	@Override
	public List<ResidentialKD> findKeyDriversBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			//_kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
			return _kdRepository.findKeyDriversBySuburbQuarterYear(_quarter.longValue(), _year, _suburb);

		return new ArrayList<ResidentialKD>();	//return any empty list
		
	}
	
	@Override
	public Page<ResidentialKD> findKeyDriversBySuburbQuarterYear(String _suburb,Integer _quarter,Year _year, Pageable _page)	{
		if(_suburb!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
		return new PageImpl<ResidentialKD>(Collections.emptyList());
		
	}

	@Override
	public List<ResidentialKD> findKeyDriversByCountrySuburbQuarterYear(String _suburb, Integer _quarter, Year _year,
			String _country) {
		if(_country!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			//_kiRepository.findKeyIndicatorsBySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _page);
			return _kdRepository.findKeyDriversByCountrySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _country);

		return new ArrayList<ResidentialKD>();	//return any empty list
	}

	@Override
	public Page<ResidentialKD> findKeyDriversByCountrySuburbQuarterYear(String _suburb, Integer _quarter, Year _year,
			String _country, Pageable pageable) {
		if(_country!=null&&_suburb!=null&&_quarter!=null&&_year!=null)
			return _kdRepository.findKeyDriversByCountrySuburbQuarterYear(_quarter.longValue(), _year, _suburb, _country, pageable);
		return new PageImpl<ResidentialKD>(Collections.emptyList());
	}

}
