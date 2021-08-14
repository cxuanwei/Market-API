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

import co.realvantage.market.api.entities.IndustrialKD;
import co.realvantage.market.api.respositories.IndustrialEDRepository;

@RestController
public class IndustrialEDController {
	
	@Autowired
	public IndustrialEDRepository _industrialEDRepository;
	
	@GetMapping("/IndustrialED")
	@CrossOrigin(origins="*")
	public Page<IndustrialKD> getAll(Pageable pageable)	{
		return _industrialEDRepository.findAll(pageable);
	}
	
	@PostMapping("/IndustrialED")
	@CrossOrigin(origins="*")
	public ResponseEntity<IndustrialKD> create(@Validated @RequestBody IndustrialKD ed)	{
		 try {
			 IndustrialKD _ed = _industrialEDRepository.save(ed);
		      return new ResponseEntity<>(_ed, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
