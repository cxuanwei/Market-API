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

import co.realvantage.market.api.entities.IndustrialKD;
import co.realvantage.market.api.entities.IndustrialKI;
import co.realvantage.market.api.services.IndustrialService;

@RestController
public class IndustrialController {
	@Autowired	
	IndustrialService _Service;
	
	@GetMapping("/IndustrialKI")
	@CrossOrigin(origins="*")
	public Page<IndustrialKI> getAllKeyIndicators(Pageable pageable)	{
		return _Service.findAllKeyIndicators(pageable);
	}
	
	@PostMapping("/IndustrialKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKI> create(@Validated @RequestBody IndustrialKI ki)	{
		 try {
			 IndustrialKI _KeyIndicator = _Service.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/IndustrialKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<IndustrialKI>> createOfficeKIs(@RequestBody List<IndustrialKI> kis)	{
		 try {
			 kis.stream().forEach(c->_Service.createKeyIndicator(c));
		      return new ResponseEntity<List<IndustrialKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/IndustrialKD")
	@CrossOrigin(origins="*")
	public Page<IndustrialKD> getAll(Pageable pageable)	{
		return _Service.findAllKeyDrivers(pageable);
	}
	
	@PostMapping("/IndustrialKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKD> create(@Validated @RequestBody IndustrialKD ki)	{
		 try {
			 IndustrialKD _KeyDriver = _Service.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/IndustrialKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<IndustrialKD>> createOfficeKDs(@RequestBody List<IndustrialKD> officekds)	{
		 try {
			 officekds.stream().forEach(c->_Service.createKeyDriver(c));
		      return new ResponseEntity<List<IndustrialKD>>(officekds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}