package com.cenfotec.exam.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.exam.domain.Patent;
import com.cenfotec.exam.exceptions.ServerNotRunningException;
import com.cenfotec.exam.service.IPatentService;

@RestController
@RequestMapping({ "/patents" })
public class PatentController {

	@Autowired
	IPatentService service;

	@PostMapping
	public ResponseEntity<Patent> savePatent(@RequestBody Patent patent) throws Throwable {
	
		
		try {
			Patent p =  service.set(patent);	
			return ResponseEntity.ok().body(p);
		}
		catch(Exception e) {
			if(e.getMessage().equals("SERVER NOT RUNNING")) {
				throw new ServerNotRunningException("SERVER NOT RUNNING");
			}
			else {
				return ResponseEntity.status(500).build();
			}
		}
		
		
		
		
		
	}

	@GetMapping
	public ResponseEntity<List<Patent>> getAllPatents() {

		if (service.getAll().size() == 0) {
			return new ResponseEntity<List<Patent>>(service.getAll(), HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Patent>>(service.getAll(), HttpStatus.OK);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getPatentById(@PathVariable String id) throws Exception {
		if (service.getById(id) == null) {
			return new ResponseEntity<String>("SPICE DOESN'T EXISTS IN THE DATABASE", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>(service.getById(id).toString(), HttpStatus.OK);
		}

	}

	@GetMapping("/guid/{guid}")
	public ResponseEntity<String> getPatentByGuid(@PathVariable String guid) throws Exception {

		if (service.getByGUID(guid) == null) {
			return new ResponseEntity<String>("SPICE DOESN'T EXISTS IN THE DATABASE", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>(service.getByGUID(guid).toString(), HttpStatus.OK);
		}

	}

	@PostMapping("/update")
	public ResponseEntity<String> updatePatent(@RequestBody Patent p) throws Exception {

		Patent updated = service.update(p);
		return new ResponseEntity<String>("UPDATED: " + updated.toString(), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) throws Exception {
		if (service.getById(id) == null) {
			return new ResponseEntity<String>("SPICE DOESN'T EXISTS IN THE DATABASE", HttpStatus.NOT_FOUND);
		} else {
			if (service.delete(id)) {
				return new ResponseEntity<String>("PATENT WITH ID: " + id + " DELETED FROM DATABASE", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("PATENT WASN'T DELETED FROM DATABASE", HttpStatus.CONFLICT);
			}
		}

	}

}
