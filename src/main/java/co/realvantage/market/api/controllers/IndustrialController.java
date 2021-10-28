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

import co.realvantage.market.api.entities.IndustrialKD;
import co.realvantage.market.api.entities.IndustrialKI;
import co.realvantage.market.api.entities.Industrial;
import co.realvantage.market.api.services.IndustrialService;

@RestController
public class IndustrialController {
	@Autowired	
	IndustrialService _service;
	
	@GetMapping("/IndustrialKI")
	@CrossOrigin(origins="*")
	public Page<IndustrialKI> getAllKeyIndicators(Pageable pageable)	{
		return _service.findAllKeyIndicators(pageable);
	}
	
	@GetMapping("/IndustrialKI/query")
	@CrossOrigin(origins="*")
	public Page<IndustrialKI> getKeyIndicatorsBySuburdAndQuarter(
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyIndicatorsByCountryStateSuburbQuarterYear(_country, _state, _suburb, _quarter, _year, pageable);
	}
	
	@PostMapping("/IndustrialKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKI> create(@Validated @RequestBody IndustrialKI ki)	{
		 try {
			 IndustrialKI _KeyIndicator = _service.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/IndustrialKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<IndustrialKI>> createOfficeKIs(@RequestBody List<IndustrialKI> kis)	{
		 try {
			 kis.stream().forEach(c->_service.createKeyIndicator(c));
		      return new ResponseEntity<List<IndustrialKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/IndustrialKD")
	@CrossOrigin(origins="*")
	public Page<IndustrialKD> getAll(Pageable pageable)	{
		return _service.findAllKeyDrivers(pageable);
	}
	
	@GetMapping("/IndustrialKD/query")
	@CrossOrigin(origins="*")
	public Page<IndustrialKD> getKeyDriversBySuburdQuarterYear(
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyDriversByCountryStateQuarterYear(_country, _state, _quarter, _year, pageable);
	}
	
	@PostMapping("/IndustrialKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKD> create(@Validated @RequestBody IndustrialKD ki)	{
		 try {
			 IndustrialKD _KeyDriver = _service.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/IndustrialKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<IndustrialKD>> createOfficeKDs(@RequestBody List<IndustrialKD> officekds)	{
		 try {
			 officekds.stream().forEach(c->_service.createKeyDriver(c));
		      return new ResponseEntity<List<IndustrialKD>>(officekds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/Industrials")
	@CrossOrigin(origins="*")
	public ResponseEntity<Industrial> createIndustrials(@RequestBody Industrial _obj)	{
		 try {
			 List<IndustrialKI> kiList = _obj.getKiList();
			 if(kiList!=null)
				 kiList.stream().forEach(c->_service.createKeyIndicator(c));
			 
			 List <IndustrialKD> kdList = _obj.getKdList();
			 if(kdList!=null)
				 kdList.stream().forEach(c->_service.createKeyDriver(c));
			 
		      return new ResponseEntity<Industrial>(_obj, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/Industrial")
	@CrossOrigin(origins="*")
	public ResponseEntity<Industrial> getIndustrials()	{
		//return new ResponseEntity<Industrial>(new Industrial(),HttpStatus.ACCEPTED);
		return new ResponseEntity<Industrial>(_service.findAllDriversAndIndicators(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/IndustrialKI/singlequery")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKI> getKeyIndicatorByKICountryStateQuarterYear(
			@RequestParam(name="ki",required=false) String _ki,
			@RequestParam(name="grade",required=false) String _grade,
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year
			)	{
		IndustrialKI industrialKI =  _service.findKeyIndicatorByKICountryStateQuarterYear(_ki, _grade, _country, _state, _suburb, _quarter, _year);
		if(industrialKI!=null)
			return new ResponseEntity<>(industrialKI, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/IndustrialKD/singlequery")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKD> getKeyDriverByKDQuarterYear(
			@RequestParam(name="kd",required=false) String _kd,
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year
			)	{
		
		IndustrialKD industrialKD =  _service.findKeyDriverByKDCountryStateQuarterYear(_country, _state, _quarter, _year, _kd);
		if(industrialKD!=null)
			return new ResponseEntity<>(industrialKD, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
}