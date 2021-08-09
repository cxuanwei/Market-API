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

import co.realvantage.market.api.entities.IndustrialKI;
import co.realvantage.market.api.respositories.IndustrialKIRepository;;

@RestController
public class IndustrialKIController {
	
	@Autowired
	public IndustrialKIRepository _industrialKIRepository;
	
	@GetMapping("/IndustrialKi")
	@CrossOrigin(origins="*")
	public Page<IndustrialKI> getAll(Pageable pageable)	{
		return _industrialKIRepository.findAll(pageable);
	}
	
	@PostMapping("/IndustrialKi")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKI> create(@Validated @RequestBody IndustrialKI ki)	{
		 try {
			 System.out.println("ki.getSuburb():"+ki.getSuburb());
			 IndustrialKI _industrialKeyIndicators = _industrialKIRepository.save(ki);
		      return new ResponseEntity<>(_industrialKeyIndicators, HttpStatus.CREATED);
		    } catch (Exception e) {
		    	System.out.println("Exception Message is "+e.getMessage());
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
