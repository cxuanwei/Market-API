package co.realvantage.market.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;
import co.realvantage.market.api.services.OfficeService;

@RestController
public class OfficeController {
	@Autowired	
	OfficeService _Service;
	
	@GetMapping("/OfficeKI")
	@CrossOrigin(origins="*")
	public Page<OfficeKI> getAllKeyIndicators(Pageable pageable)	{
		return _Service.findAllKeyIndicators(pageable);
	}
	
	@PostMapping("/OfficeKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKI> create(@Validated @RequestBody OfficeKI ki)	{
		 try {
			 OfficeKI _KeyIndicator = _Service.createKeyIndicator(ki);
		      return new ResponseEntity<>(_KeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/OfficeKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<OfficeKI>> createKIs(@RequestBody List<OfficeKI> kis)	{
		 try {
			 kis.stream().forEach(c->_Service.createKeyIndicator(c));
		      return new ResponseEntity<List<OfficeKI>>(kis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/OfficeKD")
	@CrossOrigin(origins="*")
	public Page<OfficeKD> getAll(Pageable pageable)	{
		return _Service.findAllKeyDrivers(pageable);
	}
	
	@PostMapping("/OfficeKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKD> create(@Validated @RequestBody OfficeKD ki)	{
		 try {
			 OfficeKD _KeyDriver = _Service.createKeyDriver(ki);
		      return new ResponseEntity<>(_KeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/OfficeKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<OfficeKD>> createKDs(@RequestBody List<OfficeKD> kds)	{
		 try {
			 kds.stream().forEach(c->_Service.createKeyDriver(c));
		      return new ResponseEntity<List<OfficeKD>>(kds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}