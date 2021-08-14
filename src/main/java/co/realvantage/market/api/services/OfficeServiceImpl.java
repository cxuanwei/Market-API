package co.realvantage.market.api.services;

import java.time.Year;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.realvantage.market.api.respositories.OfficeKIRepository;
import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;
import co.realvantage.market.api.respositories.OfficeKDRepository;

@Service
public class OfficeServiceImpl implements OfficeService{
	@Autowired
	OfficeKIRepository _officeKIRepository;
	
	@Autowired
	OfficeKDRepository _officeKDRepository;

	@Override
	public OfficeKI createOfficeKeyIndicator(OfficeKI _officeKI) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		OfficeKI ki=findAllOfficeKeyIndicatorsByQuarterAndLocation(_officeKI.getQuarter(),_officeKI.getYear(),
				_officeKI.getCountry(),_officeKI.getState(),_officeKI.getState());
		if(ki!=null)	{
			_officeKI.setId(ki.getId());
		}
		else
			_officeKI.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _officeKIRepository.save(_officeKI);
	}

	@Override
	public void updateOfficeKeyIndicator(OfficeKI _officeKI) throws Exception {
		// TODO Auto-generated method stub
		if(_officeKI.getId()==0)
			throw new Exception("Invalid ID!");
		_officeKIRepository.save(_officeKI);
	}

	@Override
	public void deleteOfficeKeyIndicator(long id) {
		// TODO Auto-generated method stub
		_officeKIRepository.deleteById(id);
		
	}

	@Override
	public Collection<OfficeKI> findAllOfficeKeyIndicators() {
		// TODO Auto-generated method stub
		return _officeKIRepository.findAll();
	}
	
	@Override
	public Page<OfficeKI> findAllOfficeKeyIndicators(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _officeKIRepository.findAll(_pageable);
	}


	@Override
	public OfficeKI findAllOfficeKeyIndicatorsByQuarterAndLocation(long _quarter, Year _year, String _country, String _state, String _suburb) {
		// TODO Auto-generated method stub
		return _officeKIRepository.findByTimePeriodAndLocation(_quarter, _year, _country, _state, _suburb);
	}

	@Override
	public OfficeKD createOfficeKeyDriver(OfficeKD _officeKD) {
		// TODO Auto-generated method stub
		
		//Check whether record exist
		OfficeKD kd=_officeKDRepository.findByTimePeriodAndLocation(_officeKD.getQuarter(),_officeKD.getYear(),
				_officeKD.getCountry(),_officeKD.getState(),_officeKD.getState());
		if(kd!=null)	{
			_officeKD.setId(kd.getId());
		}
		else
			_officeKD.setId(0);	//ensure id is 0 so that repository will create a new record instead of update
		return _officeKDRepository.save(_officeKD);
	}

	@Override
	public void updateOfficeKeyDriver(OfficeKD _officeKD) throws Exception {
		// TODO Auto-generated method stub
		if(_officeKD.getId()==0)
			throw new Exception("Invalid ID!");
		_officeKDRepository.save(_officeKD);
	}

	@Override
	public void deleteOfficeKeyDriver(long id) {
		// TODO Auto-generated method stub
		_officeKDRepository.deleteById(id);
	}	

	@Override
	public Collection<OfficeKD> findAllOfficeKeyDrivers() {
		// TODO Auto-generated method stub
		return _officeKDRepository.findAll();
	}

	@Override
	public Page<OfficeKD> findAllOfficeKeyDrivers(Pageable _pageable) {
		// TODO Auto-generated method stub
		return _officeKDRepository.findAll(_pageable);
	}

	@Override
	public OfficeKD findAllOfficeKeyDriversByQuarterAndLocation(long _quarter, Year _year, String _country,
			String _state, String _suburb) {
		// TODO Auto-generated method stub
		return _officeKDRepository.findByTimePeriodAndLocation(_quarter, _year, _country, _state, _suburb);
	}

}
