package com.flyingh.ejb.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/flyinghQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "queue/flyinghQueue")
public class QueueMessageDriven implements MessageListener {
	@Override
	public void onMessage(Message message) {
		if (TextMessage.class.isInstance(message)) {
			try {
				System.out.println(((TextMessage) message).getText());
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
