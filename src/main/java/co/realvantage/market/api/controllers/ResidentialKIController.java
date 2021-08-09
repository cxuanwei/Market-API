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

import co.realvantage.market.api.entities.ResidentialKI;
import co.realvantage.market.api.respositories.ResidentialKIRepository;

@RestController
public class ResidentialKIController {
	
	@Autowired
	public ResidentialKIRepository _ResidentialKIRespository;
	
	@GetMapping("/ResidentialKI")
	@CrossOrigin(origins="*")
	public Page<ResidentialKI> getAll(Pageable pageable)	{
		return _ResidentialKIRespository.findAll(pageable);
	}
	
	@PostMapping("/ResidentialKI")
	@CrossOrigin(origins="*")
	public ResponseEntity<ResidentialKI> create(@Validated @RequestBody ResidentialKI rkd)	{
		 try {
			 ResidentialKI _rkd = _ResidentialKIRespository.save(rkd);
		      return new ResponseEntity<>(_rkd, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
