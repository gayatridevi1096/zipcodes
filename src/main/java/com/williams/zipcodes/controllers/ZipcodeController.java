package com.williams.zipcodes.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.williams.zipcodes.exceptions.ZipcodeException;
import com.williams.zipcodes.services.ZipcodeService;

@RestController
public class ZipcodeController {

	private static final Logger LOG = LogManager.getLogger(ZipcodeController.class.getName());

	@Autowired
	ZipcodeService zipcodeService;

	@RequestMapping(value = "/zipcodesMinimumRange", method = RequestMethod.POST)
	public ResponseEntity<List<Integer[]>> zipcodesMinRange(@RequestBody List<Integer[]> allPossibleRanges) {
		try {
			LOG.info("ZipcodesMinRange method of ZipcodeController Class Calling - > " + allPossibleRanges.toString());
			return new ResponseEntity<List<Integer[]>>(zipcodeService.zipcodesMinimumRange(allPossibleRanges),
					HttpStatus.OK);
		} catch (ZipcodeException e) {
			LOG.debug("Exception in zipcodesMinRange method of ZipcodeController Class" + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
