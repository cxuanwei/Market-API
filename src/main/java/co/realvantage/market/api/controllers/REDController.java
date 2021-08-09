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

import co.realvantage.market.api.entities.RetailED;
import co.realvantage.market.api.respositories.RetailEDRepository;

@RestController
public class REDController {
	
	@Autowired
	public RetailEDRepository _REDRespository;
	
	@GetMapping("/RED")
	@CrossOrigin(origins="*")
	public Page<RetailED> getAll(Pageable pageable)	{
		return _REDRespository.findAll(pageable);
	}
	
	@PostMapping("/RED")
	@CrossOrigin(origins="*")
	public ResponseEntity<RetailED> create(@Validated @RequestBody RetailED red)	{
		 try {
			 RetailED _red = _REDRespository.save(red);
		      return new ResponseEntity<>(_red, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
