package co.realvantage.market.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.realvantage.market.api.entities.OfficeKD;
import co.realvantage.market.api.entities.OfficeKI;
import co.realvantage.market.api.respositories.OfficeKIRepository;
import co.realvantage.market.api.services.OfficeService;

@RestController
public class OfficeController {
	@Autowired	
	OfficeService _OfficeService;
	
	@GetMapping("/OfficeKi")
	@CrossOrigin(origins="*")
	public Page<OfficeKI> getAllOfficeKeyIndicators(Pageable pageable)	{
		return _OfficeService.findAllOfficeKeyIndicators(pageable);
	}
	
	@PostMapping("/OfficeKi")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKI> create(@Validated @RequestBody OfficeKI ki)	{
		 try {
			 OfficeKI _officeKeyIndicator = _OfficeService.createOfficeKeyIndicator(ki);
		      return new ResponseEntity<>(_officeKeyIndicator, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@PostMapping("/OfficeKIs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<OfficeKI>> createOfficeKIs(@RequestBody List<OfficeKI> officekis)	{
		 try {
			 officekis.stream().forEach(c->_OfficeService.createOfficeKeyIndicator(c));
		      return new ResponseEntity<List<OfficeKI>>(officekis, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}	
	
	@GetMapping("/OfficeKD")
	@CrossOrigin(origins="*")
	public Page<OfficeKD> getAll(Pageable pageable)	{
		return _OfficeService.findAllOfficeKeyDrivers(pageable);
	}
	
	@PostMapping("/OfficeKD")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKD> create(@Validated @RequestBody OfficeKD ki)	{
		 try {
			 OfficeKD _officeKeyDriver = _OfficeService.createOfficeKeyDriver(ki);
		      return new ResponseEntity<>(_officeKeyDriver, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@PostMapping("/OfficeKDs")
	@CrossOrigin(origins="*")
	public ResponseEntity<List<OfficeKD>> createOfficeKDs(@RequestBody List<OfficeKD> officekds)	{
		 try {
			 officekds.stream().forEach(c->_OfficeService.createOfficeKeyDriver(c));
		      return new ResponseEntity<List<OfficeKD>>(officekds, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}