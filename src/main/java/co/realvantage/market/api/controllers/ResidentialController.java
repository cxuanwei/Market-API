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

import co.realvantage.market.api.entities.ResidentialKD;
import co.realvantage.market.api.services.ResidentialService;

@RestController
public class ResidentialController {
	@Autowired	
	ResidentialService _Service;
	
	/*
	@GetMapping("/ResidentialKI")
	@CrossOrigin(origins="*")
	public Page<ResidentialKI> getAllKeyIndicators(Pageable pageable)	{
		return _Service.findAllKeyIndicators(pageable);
	}
	
	@PostMapping("/ResidentialKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<ResidentialKI> create(@Validated @RequestBody ResidentialKI ki)	{
		 try {
			 ResidentialKI _KeyIndicator = _Service.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/ResidentialKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<ResidentialKI>> createOfficeKIs(@RequestBody List<ResidentialKI> kis)	{
		 try {
			 kis.stream().forEach(c->_Service.createKeyIndicator(c));
		      return new ResponseEntity<List<ResidentialKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	*/
	
	@GetMapping("/ResidentialKD")
	@CrossOrigin(origins="*")
	public Page<ResidentialKD> getAll(Pageable pageable)	{
		return _Service.findAllKeyDrivers(pageable);
	}
	
	@PostMapping("/ResidentialKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<ResidentialKD> create(@Validated @RequestBody ResidentialKD ki)	{
		 try {
			 ResidentialKD _KeyDriver = _Service.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/ResidentialKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<ResidentialKD>> createOfficeKDs(@RequestBody List<ResidentialKD> officekds)	{
		 try {
			 officekds.stream().forEach(c->_Service.createKeyDriver(c));
		      return new ResponseEntity<List<ResidentialKD>>(officekds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}