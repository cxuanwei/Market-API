package co.realvantage.market.api.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import co.realvantage.market.api.entities.RetailKD;
import co.realvantage.market.api.entities.RetailKI;
import co.realvantage.market.api.services.RetailService;

@RestController
public class RetailController {
	@Autowired	
	RetailService _retailService;
	
	@GetMapping("/RetailKI")
	@CrossOrigin(origins="*")
	public Page<RetailKI> getAllKeyIndicators(Pageable pageable)	{
		return _retailService.findAllKeyIndicators(pageable);
	}
	
	@PostMapping("/RetailKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<RetailKI> create(@Validated @RequestBody RetailKI ki)	{
		 try {
			 RetailKI _KeyIndicator = _retailService.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/RetailKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<RetailKI>> createKIs(@RequestBody List<RetailKI> kis)	{
		 try {
			 kis.stream().forEach(c->_retailService.createKeyIndicator(c));
		      return new ResponseEntity<List<RetailKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/RetailKD")
	@CrossOrigin(origins="*")
	public Page<RetailKD> getAll(Pageable pageable)	{
		return _retailService.findAllKeyDrivers(pageable);
	}
	
	@PostMapping("/RetailKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<RetailKD> create(@Validated @RequestBody RetailKD ki)	{
		 try {
			 RetailKD _KeyDriver = _retailService.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/RetailKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<RetailKD>> createKDs(@RequestBody List<RetailKD> kds)	{
		 try {
			 kds.stream().forEach(c->_retailService.createKeyDriver(c));
		      return new ResponseEntity<List<RetailKD>>(kds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}