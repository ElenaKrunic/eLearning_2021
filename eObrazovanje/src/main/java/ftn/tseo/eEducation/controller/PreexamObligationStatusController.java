package ftn.tseo.eEducation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.tseo.eEducation.DTO.PreexamObligationDTO;
import ftn.tseo.eEducation.DTO.PreexamObligationStatusDTO;
import ftn.tseo.eEducation.model.PreexamObligationStatus;
import ftn.tseo.eEducation.service.PreexamObligationStatusService;

@RestController
@RequestMapping(value="/api")
public class PreexamObligationStatusController {

	@Autowired 
	private PreexamObligationStatusService preexamObligationStatusService; 
	
	@RequestMapping(value="/preexamObligationStatus", method = RequestMethod.GET)
	public ResponseEntity<List<PreexamObligationStatusDTO>> getAllPreexamObligationStatus(){
		
		List<PreexamObligationStatus> listOfPreexamObligationStatus = preexamObligationStatusService.findAll();
		List<PreexamObligationStatusDTO> preexamObligationStatusDTO = new ArrayList<>();
		for(PreexamObligationStatus preexamObligationStatus : listOfPreexamObligationStatus) {
			preexamObligationStatusDTO.add(new PreexamObligationStatusDTO(preexamObligationStatus));
		}
		return new ResponseEntity<>(preexamObligationStatusDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="preexamObligationStatus/{id}", method=RequestMethod.GET)
	public ResponseEntity<PreexamObligationStatusDTO> getPreexamObligationStatus(@PathVariable Long id){
		PreexamObligationStatus preexamObligationStatus = preexamObligationStatusService.findOne(id);
		
		if(preexamObligationStatus == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PreexamObligationStatusDTO(preexamObligationStatus), HttpStatus.OK);
	}
	
	@PostMapping(value="/preexamObligationStatus", consumes="application/json")
	public ResponseEntity<PreexamObligationStatusDTO> savePreexamObligationStatus(@RequestBody PreexamObligationDTO preexamObligationDTO){		
		
		PreexamObligationStatus preexamObligationStatus = new PreexamObligationStatus();
		preexamObligationStatus.setName(preexamObligationStatus.getName());
		preexamObligationStatus.setCode(preexamObligationStatus.getCode());
		
		preexamObligationStatus = preexamObligationStatusService.save(preexamObligationStatus);
		return new ResponseEntity<>(new PreexamObligationStatusDTO(preexamObligationStatus), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/preexamObligationStatus/{id}", consumes="application/json")
	public ResponseEntity<PreexamObligationStatusDTO> updatePreexamObligationStatus(@RequestBody PreexamObligationStatusDTO preexamObligationStatusDto, @PathVariable("id") Long id){
		
		PreexamObligationStatus preexamObligationStatus = preexamObligationStatusService.findOne(preexamObligationStatusDto.getId()); 
		
		if (preexamObligationStatus == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		preexamObligationStatus.setName(preexamObligationStatusDto.getName());
		preexamObligationStatus.setCode(preexamObligationStatusDto.getCode());

		preexamObligationStatus = preexamObligationStatusService.save(preexamObligationStatus);
		return new ResponseEntity<>(new PreexamObligationStatusDTO(preexamObligationStatus), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/preexamObligationStatus/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePreexamObligationStatus(@PathVariable Long id){
		PreexamObligationStatus preexamObligationStatus = preexamObligationStatusService.findOne(id);
		if (preexamObligationStatus != null){
			preexamObligationStatusService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
