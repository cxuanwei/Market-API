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

import co.realvantage.market.api.entities.ResidentialMR;
import co.realvantage.market.api.respositories.ResidentialMRRepository;

@RestController
public class ResidentialMRController {
	
	@Autowired
	public ResidentialMRRepository _RMRRespository;
	
	@GetMapping("/RetailMR")
	@CrossOrigin(origins="*")
	public Page<ResidentialMR> getAll(Pageable pageable)	{
		return _RMRRespository.findAll(pageable);
	}
	
	@PostMapping("/RetailMR")
	@CrossOrigin(origins="*")
	public ResponseEntity<ResidentialMR> create(@Validated @RequestBody ResidentialMR ki)	{
		 try {
			 ResidentialMR _officeKeyIndicators = _RMRRespository.save(ki);
		      return new ResponseEntity<>(_officeKeyIndicators, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
