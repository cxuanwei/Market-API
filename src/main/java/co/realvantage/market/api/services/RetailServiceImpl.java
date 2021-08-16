package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.realvantage.market.api.respositories.RetailKDRepository;
import co.realvantage.market.api.respositories.RetailKIRepository;
import co.realvantage.market.api.entities.RetailKD;
import co.realvantage.market.api.entities.RetailKI;

@Service
public class RetailServiceImpl implements RetailService{
	@Autowired
	RetailKIRepository _retailKIRepository;
	
	@Autowired
	RetailKDRepository _retailKDRepository;

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
		return _retailKIRepository.save(_retailKI);
	}

	@Override
	public void updateKeyIndicator(RetailKI _retailKI) throws Exception {
		// TODO Auto-generated method stub
		if(_retailKI.getId()<=0)
			throw new Exception("Invalid ID!");
		_retailKIRepository.save(_retailKI);
	}

	@Override
	public void deleteKeyIndicator(long id) {
		// TODO Auto-generated method stub
		_retailKIRepository.deleteById(id);
	}

	@Override
	public Collection<RetailKI> findAllKeyIndicators() {
		// TODO Auto-generated method stub
		return _retailKIRepository.findAll();
	}

	@Override
	public Page<RetailKI> findAllKeyIndicators(Pageable pageable) {
		// TODO Auto-generated method stub
		return _retailKIRepository.findAll(pageable);
	}

	@Override
	public RetailKI findAllKeyIndicatorsByQuarterAndLocationAndIndicatorAndGrade(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _indicator, String _grade) {
		// TODO Auto-generated method stub
		return _retailKIRepository.findByTimePeriodAndLocationAndIndicatorAndGrade(_quarter, _year, _country, _state, _suburb, _indicator, _grade);
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
		return _retailKDRepository.save(_retailKD);
	}

	@Override
	public void updateKeyDriver(RetailKD _retailD) throws Exception {
		// TODO Auto-generated method stub
		
		if(_retailD.getId()<=0)
			throw new Exception("Invalid ID!");
		_retailKDRepository.save(_retailD);
	}

	@Override
	public void deleteKeyDriver(long id) {
		// TODO Auto-generated method stub
		_retailKDRepository.deleteById(id);
	}

	@Override
	public Collection<RetailKD> findAllKeyDrivers() {
		// TODO Auto-generated method stub
		return _retailKDRepository.findAll();
	}

	@Override
	public Page<RetailKD> findAllKeyDrivers(Pageable pageable) {
		// TODO Auto-generated method stub
		return _retailKDRepository.findAll(pageable);
	}

	@Override
	public RetailKD findAllKeyDriversByQuarterAndLocationAndDriver(long _quarter, Year _year, String _country,
			String _state, String _suburb, String _driver) {
		// TODO Auto-generated method stub
		return _retailKDRepository.findByTimePeriodAndLocationAndDriver(_quarter, _year, _country, _state, _suburb, _driver);
	}

}
