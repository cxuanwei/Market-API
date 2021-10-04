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

import co.realvantage.market.api.entities.Retail;
import co.realvantage.market.api.entities.RetailKD;
import co.realvantage.market.api.entities.RetailKI;
import co.realvantage.market.api.services.RetailService;

@RestController
public class RetailController {
	@Autowired	
	RetailService _service;
	
	@GetMapping("/RetailKI")
	@CrossOrigin(origins="*")
	public Page<RetailKI> getAllKeyIndicators(Pageable pageable)	{
		return _service.findAllKeyIndicators(pageable);
	}
	
	@GetMapping("/RetailKI/query")
	@CrossOrigin(origins="*")
	public Page<RetailKI> getKeyIndicatorsBySuburdQuarterYear(
			@RequestParam(name="state",required=false) String _state,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyIndicatorsByStateQuarterYear(_state, _quarter, _year, pageable);
	}
	
	@PostMapping("/RetailKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<RetailKI> create(@Validated @RequestBody RetailKI ki)	{
		 try {
			 RetailKI _KeyIndicator = _service.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/RetailKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<RetailKI>> createKIs(@RequestBody List<RetailKI> kis)	{
		 try {
			 kis.stream().forEach(c->_service.createKeyIndicator(c));
		      return new ResponseEntity<List<RetailKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/RetailKD")
	@CrossOrigin(origins="*")
	public Page<RetailKD> getAll(Pageable pageable)	{
		return _service.findAllKeyDrivers(pageable);
	}
	
	@GetMapping("/RetailKD/query")
	@CrossOrigin(origins="*")
	public Page<RetailKD> getKeyDriversBySuburdQuarterYear(
			@RequestParam(name="state",required=false) String _suburb,
			@RequestParam(name="quarter",required=false) Integer _quarter,
			@RequestParam(name="year",required=false) Year _year,
			Pageable pageable
			)	{
		return _service.findKeyDriversByStateQuarterYear(_suburb, _quarter, _year, pageable);
	}
	
	@PostMapping("/RetailKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<RetailKD> create(@Validated @RequestBody RetailKD ki)	{
		 try {
			 RetailKD _KeyDriver = _service.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/RetailKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<RetailKD>> createKDs(@RequestBody List<RetailKD> kds)	{
		 try {
			 kds.stream().forEach(c->_service.createKeyDriver(c));
		      return new ResponseEntity<List<RetailKD>>(kds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/Retails")
	@CrossOrigin(origins="*")
	public ResponseEntity<Retail> createIndustrials(@RequestBody Retail _obj)	{
		 try {
			 List<RetailKI> kiList = _obj.getKiList();
			 if(kiList!=null)
				 kiList.stream().forEach(c->_service.createKeyIndicator(c));
			 
			 List <RetailKD> kdList = _obj.getKdList();
			 if(kdList!=null)
				 kdList.stream().forEach(c->_service.createKeyDriver(c));
			 
		      return new ResponseEntity<Retail>(_obj, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/Retail")
	@CrossOrigin(origins="*")
	public ResponseEntity<Retail> getIndustrials()	{
		//return new ResponseEntity<Industrial>(new Industrial(),HttpStatus.ACCEPTED);
		return new ResponseEntity<Retail>(_service.findAllDriversAndIndicators(),HttpStatus.ACCEPTED);
	}
}