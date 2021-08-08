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

import co.realvantage.market.api.entities.OfficeKeyIndicators;
import co.realvantage.market.api.respositories.OfficeKeyIndicatorsRespository;

@RestController
public class OfficekeyIndicatorsController {
	
	@Autowired
	public OfficeKeyIndicatorsRespository _officeKeyIndicatorsRespository;
	
	@GetMapping("/OfficeKi")
	@CrossOrigin(origins="*")
	public Page<OfficeKeyIndicators> getAllOfficeKeyIndicators(Pageable pageable)	{
		return _officeKeyIndicatorsRespository.findAll(pageable);
	}
	
	@PostMapping("/OfficeKi")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeKeyIndicators> createOfficeKeyIndicators(@Validated @RequestBody OfficeKeyIndicators ki)	{
		 try {
			 System.out.println("ki.getSuburb():"+ki.getSuburb());
			 OfficeKeyIndicators _officeKeyIndicators = _officeKeyIndicatorsRespository.save(ki);
		      return new ResponseEntity<>(_officeKeyIndicators, HttpStatus.CREATED);
		    } catch (Exception e) {
		    	System.out.println("Exception Message is "+e.getMessage());
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
