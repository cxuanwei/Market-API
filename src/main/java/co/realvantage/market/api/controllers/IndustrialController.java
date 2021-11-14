package co.realvantage.market.api.controllers;

import static org.junit.Assert.assertTrue;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
	
	@Test
	public void testGetAllKeyIndicators()	{
		Page<IndustrialKI> test=this.getAllKeyIndicators(new PageImpl<IndustrialKI>(Collections.emptyList()).getPageable());
		assertTrue(!test.equals(null));
	}
	
	@GetMapping("/IndustrialKI/query")
	@CrossOrigin(origins="*")
	public Page<IndustrialKI> getKeyIndicatorsBySuburbAndQuarter(
			@RequestParam(name="country",required=false) String _country,
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="suburb",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyIndicatorsByCountryStateSuburbQuarterYear(_country, _state, _suburb, _quarter, _year, pageable);
	}
	
	@Test
	public void testGetKeyIndicatorsBySuburdAndQuarter()	{
		String _country = "australia";
		String _state = "New South Wales";
		String _suburb = "South Sydney";
		Integer _quarter = (Integer)1;
		Year _year=Year.of(2021);
		Pageable pageable = new PageImpl<IndustrialKI>(Collections.emptyList()).getPageable();
		
		//Page<IndustrialKI> allKeyIndicators=_service.findKeyIndicatorsByCountryStateSuburbQuarterYear(_country, _state, _suburb, _quarter, _year, pageable);
		Page<IndustrialKI> test=this.getKeyIndicatorsBySuburbAndQuarter(_country, _state, _suburb, _quarter, _year, pageable);
		assertTrue(!test.hasContent());
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
	
	@Test
	public void testCreateIndustrialKI()	{
		IndustrialKI ki = new IndustrialKI();
		ki.setCountry("australia");
		ki.setState("New South Wales");
		ki.setSuburb("South Sydney");
		ki.setQuarter(2021);
		ki.setYear(Year.of(2021));
		ki.setGrade("Prime");
		ki.setIndicator("Rental Net Face ($/sq m)");
		ki.setLow(170);
		ki.setHigh(235);
		ResponseEntity<IndustrialKI> test = this.create(ki);
		assertTrue(test.getStatusCode()==HttpStatus.CREATED);
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
	
	@Test
	public void testCreateOfficeKIs()	{
		List<IndustrialKI> kis = new ArrayList<IndustrialKI>();
		IndustrialKI ki = new IndustrialKI();
		ki.setCountry("australia");
		ki.setState("New South Wales");
		ki.setSuburb("South Sydney");
		ki.setQuarter(2021);
		ki.setYear(Year.of(2021));
		ki.setGrade("Prime");
		ki.setIndicator("Rental Net Face ($/sq m)");
		ki.setLow(170);
		ki.setHigh(235);
		kis.add(ki);
		IndustrialKI ki2 = new IndustrialKI();
		ki2.setCountry("australia");
		ki2.setState("New South Wales");
		ki2.setSuburb("South Sydney");
		ki2.setQuarter(2021);
		ki2.setYear(Year.of(2021));
		ki2.setGrade("Prime");
		ki2.setIndicator("Rental Net Face ($/sq m)");
		ki2.setLow(170);
		ki2.setHigh(235);
		kis.add(ki2);
		ResponseEntity<List<IndustrialKI>> test=this.createOfficeKIs(kis);
		assertTrue(test.getStatusCode()==HttpStatus.CREATED);
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