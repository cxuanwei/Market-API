package co.realvantage.market.api.controllers;

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

import co.realvantage.market.api.entities.RetailKI;
import co.realvantage.market.api.respositories.RetailKIRepository;

@RestController
public class RetailKIController {
	
	@Autowired
	public RetailKIRepository _retailKIRepository;
	
	@GetMapping("/RetailKI")
	@CrossOrigin(origins="*")
	public Page<RetailKI> getAll(Pageable pageable)	{
		return _retailKIRepository.findAll(pageable);
	}
	
	@PostMapping("/RetailKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<RetailKI> create(@Validated @RequestBody RetailKI ki)	{
		 try {
			 RetailKI _RetailKeyIndicators = _retailKIRepository.save(ki);
		      return new ResponseEntity<>(_RetailKeyIndicators, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
