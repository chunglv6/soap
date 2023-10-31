package com.vds.chung.ws.soap;

import com.vds.chung.ws.soap.dto.PaymentProcessorRequest;
import com.vds.chung.ws.soap.dto.PaymentProcessorResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name = "response") PaymentProcessorResponse processPayment(@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
