package com.williams.zipcodes.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.williams.zipcodes.exceptions.ZipcodeException;
import com.williams.zipcodes.services.ZipcodeService;

@Service
public class ZipcodeServiceImpl implements ZipcodeService {

	private static final Logger LOG = LogManager.getLogger(ZipcodeServiceImpl.class.getName());

	static List<Integer> minimumRanges;
	static List<Integer> maximumRanges;

	private static void sortRanges() {
		int temp;
		for (int i = 0; i < minimumRanges.size(); i++) {
			for (int j = i + 1; j < minimumRanges.size(); j++) {
				if (minimumRanges.get(i) > minimumRanges.get(j)) {
					temp = minimumRanges.get(i);
					minimumRanges.set(i, minimumRanges.get(j));
					minimumRanges.set(j, temp);
					temp = maximumRanges.get(i);
					maximumRanges.set(i, maximumRanges.get(j));
					maximumRanges.set(j, temp);
				}
			}
		}

	}

	@Override
	public List<Integer[]> zipcodesMinimumRange(List<Integer[]> allPossibleRanges) throws ZipcodeException {
		LOG.info("ZipcodesMinRange method of ZipcodeServiceImpl Class Calling - > ");
		minimumRanges = new ArrayList<>();
		maximumRanges = new ArrayList<>();
		List<Integer[]> zipcodeRanges = new ArrayList<>();
		for (Integer[] zipcodeRange : allPossibleRanges) {
			minimumRanges.add(zipcodeRange[0]);
			maximumRanges.add(zipcodeRange[1]);
		}

		for (int i = 0; i < minimumRanges.size(); i++) {
			for (int j = 0; j < maximumRanges.size(); j++) {
				if ((minimumRanges.get(j) >= minimumRanges.get(i) && maximumRanges.get(j) < maximumRanges.get(i))) {
					minimumRanges.remove(j);
					maximumRanges.remove(j);
					sortRanges();
					i = 0;
					j = 0;
				}
				if ((minimumRanges.get(j) >= minimumRanges.get(i)
						&& (minimumRanges.get(j) <= maximumRanges.get(i)
								|| minimumRanges.get(j) == maximumRanges.get(i) + 1)
						&& maximumRanges.get(j) > maximumRanges.get(i))) {
					maximumRanges.set(i, maximumRanges.get(j));
					minimumRanges.remove(j);
					maximumRanges.remove(j);
					sortRanges();
					i = 0;
					j = 0;
				}

			}
		}

		for (Integer min : minimumRanges) {
			Integer[] lst = new Integer[2];
			lst[0] = min;
			lst[1] = maximumRanges.get(minimumRanges.indexOf(min));
			zipcodeRanges.add(lst);
		}

		return zipcodeRanges;
	}
}
