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

import co.realvantage.market.api.entities.OfficeKI;
import co.realvantage.market.api.respositories.OfficeKIRepository;

@RestController
public class OfficeKIController {
	
	@Autowired
	public OfficeKIRepository _officeKIRespository;
	
	@GetMapping("/OfficeKi")
	@CrossOrigin(origins="*")
	public Page<OfficeKI> getAll(Pageable pageable)	{
		return _officeKIRespository.findAll(pageable);
	}
	
	@PostMapping("/OfficeKi")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKI> create(@Validated @RequestBody OfficeKI ki)	{
		 try {
			 System.out.println("ki.getSuburb():"+ki.getSuburb());
			 OfficeKI _officeKeyIndicators = _officeKIRespository.save(ki);
		      return new ResponseEntity<>(_officeKeyIndicators, HttpStatus.CREATED);
		    } catch (Exception e) {
		    	System.out.println("Exception Message is "+e.getMessage());
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
