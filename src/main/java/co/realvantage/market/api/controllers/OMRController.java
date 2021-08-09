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

import co.realvantage.market.api.entities.OfficeMR;
import co.realvantage.market.api.respositories.OfficeMRRepository;

@RestController
public class OMRController {
	
	@Autowired
	public OfficeMRRepository _OMRRespository;
	
	@GetMapping("/OMR")
	@CrossOrigin(origins="*")
	public Page<OfficeMR> getAll(Pageable pageable)	{
		return _OMRRespository.findAll(pageable);
	}
	
	@PostMapping("/OMR")
	@CrossOrigin(origins="*")
	public ResponseEntity<OfficeMR> create(@Validated @RequestBody OfficeMR ki)	{
		 try {
			 System.out.println("ki.getSuburb():"+ki.getSuburb());
			 OfficeMR _officeKeyIndicators = _OMRRespository.save(ki);
		      return new ResponseEntity<>(_officeKeyIndicators, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
