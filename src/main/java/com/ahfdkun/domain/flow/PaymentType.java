package com.ahfdkun.domain.flow;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;

public enum PaymentType {
	
	CASH, CHECK, CREDIT_CARD;

	public static List<PaymentType> asList() {
		PaymentType[] paymentTypes = values();
		return Arrays.asList(paymentTypes);
	}

	@Override
	public String toString() {
		return WordUtils.capitalizeFully(name().replace('_', ' '));
	}
	
}
