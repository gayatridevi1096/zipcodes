package com.williams.zipcodes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.williams.zipcodes.exceptions.ZipcodeException;

@Service
public interface ZipcodeService {


	List<Integer[]> zipcodesMinimumRange(List<Integer[]> allPossibleRanges) throws ZipcodeException;

}
