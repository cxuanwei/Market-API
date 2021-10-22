package co.realvantage.market.api.controllers;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.realvantage.market.api.entities.Office;
import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;
import co.realvantage.market.api.services.OfficeService;

@RestController
public class OfficeController {
	@Autowired	
	OfficeService _service;
	
	@GetMapping("/OfficeKI")
	@CrossOrigin(origins="*")
	public Page<OfficeKI> getAllKeyIndicators(Pageable pageable)	{
		return _service.findAllKeyIndicators(pageable);
	}
	/*
	 * @GetMapping("/OfficeKI/query")
	 * 
	 * @CrossOrigin(origins="*") public Page<OfficeKI> getKeyIndicatorsBySuburb(
	 * 
	 * @RequestParam(name="suburb") String _suburb, Pageable pageable ) { return
	 * _service.findAllKeyIndicators(pageable); }
	 */
	
	@GetMapping("/OfficeKI/query")
	@CrossOrigin(origins="*")
	public Page<OfficeKI> getKeyIndicatorsByCountryStateSuburbQuarterYear(
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyIndicatorsByCountryStateSuburbQuarterYear(_country, _state, _suburb, _quarter, _year, pageable);

	}
	
	@GetMapping("/OfficeKI/singlequery")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKI> getKeyIndicatorByKIGradeCountryStateSuburbQuarterYear(
			@RequestParam(name="ki",required=false) String _ki,
			@RequestParam(name="grade",required=false) String _grade,
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year
			)	{
		OfficeKI officeKi=_service.findKeyIndicatorByKIGradeCountryStateSuburbQuarterYear(_ki, _grade, _country, _state, _suburb, _quarter, _year);
		if(officeKi!=null)	
			return new ResponseEntity<>(officeKi, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/OfficeKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKI> create(@Validated @RequestBody OfficeKI ki)	{
		 try {
			 OfficeKI _KeyIndicator = _service.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/OfficeKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<OfficeKI>> createKIs(@RequestBody List<OfficeKI> kis)	{
		 try {
			 kis.stream().forEach(c->_service.createKeyIndicator(c));
		      return new ResponseEntity<List<OfficeKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/OfficeKD")
	@CrossOrigin(origins="*")
	public Page<OfficeKD> getAll(Pageable pageable)	{
		return _service.findAllKeyDrivers(pageable);
	}
	
	@GetMapping("/OfficeKD/query")
	@CrossOrigin(origins="*")
	public Page<OfficeKD> getKeyDriversByCountryStateSuburbQuarterYear(
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyDriversByCountryStateSuburbQuarterYear(_country, _state, _suburb, _quarter, _year, pageable);
	}
	
	@PostMapping("/OfficeKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKD> create(@Validated @RequestBody OfficeKD ki)	{
		 try {
			 OfficeKD _KeyDriver = _service.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/OfficeKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<OfficeKD>> createKDs(@RequestBody List<OfficeKD> kds)	{
		 try {
			 kds.stream().forEach(c->_service.createKeyDriver(c));
		      return new ResponseEntity<List<OfficeKD>>(kds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/Offices")
	@CrossOrigin(origins="*")
	public ResponseEntity<Office> createOffices(@RequestBody Office ofc)	{
		 try {
			 List<OfficeKI> kiList = ofc.getKiList();
			 if(kiList!=null)
				 kiList.stream().forEach(c->_service.createKeyIndicator(c));
			 
			 List <OfficeKD> kdList = ofc.getKdList();
			 if(kdList!=null)
				 kdList.stream().forEach(c->_service.createKeyDriver(c));
			 
		      return new ResponseEntity<Office>(ofc, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/Office")
	@CrossOrigin(origins="*")
	public ResponseEntity<Office> getOffices()	{
		//return new ResponseEntity<Office>(new Office(),HttpStatus.ACCEPTED);
		return new ResponseEntity<Office>(_service.findAllDriversAndIndicators(), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/OfficeKD/singlequery")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKD> getKeyDriverByKDGradeCountryStateSuburbQuarterYear(
			@RequestParam(name="kd",required=false) String _kd,
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year
			)	{
		OfficeKD officeKd=_service.findKeyDriverByKDCountryStateSuburbQuarterYear(_kd, _country, _state, _suburb, _quarter, _year);
		if(officeKd!=null)	
			return new ResponseEntity<>(officeKd, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}