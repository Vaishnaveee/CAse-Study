package com.cart.api.controller;

import org.springframework.stereotype.Component;



import com.cart.api.model.SmsModel;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {
	
	private final String ACCOUNT_SID ="AC2319c56e6f68874cce7bcfd2471c4b3e";

    private final String AUTH_TOKEN = "c60149ef08d88285600badf1724ef92a";

    private final String FROM_NUMBER = "+12535232576";

    public void send(SmsModel sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }


}
