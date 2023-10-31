package com.vds.chung.ws.soap;

import com.vds.chung.ws.soap.dto.PaymentProcessorRequest;
import com.vds.chung.ws.soap.dto.PaymentProcessorResponse;



public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
