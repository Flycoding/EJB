package com.flyingh.client.demo;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

public class Demo2 {

	@Test
	public void test3() {
		System.out.println(String[].class.getName());
		System.out.println(String[].class.getSimpleName());
		System.out.println(String[].class.getCanonicalName());
		System.out.println("********************");
		System.out.println(int[].class.getName());
		System.out.println(int[].class.getSimpleName());
		System.out.println(int[].class.getCanonicalName());
	}

	@Test
	public void test2() throws NamingException, JMSException {
		final InitialContext context = new InitialContext();
		final TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) context.lookup("TopicConnectionFactory");
		final TopicSession topicSession = topicConnectionFactory.createTopicConnection().createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		final TopicPublisher topicPublisher = (TopicPublisher) topicSession.createProducer((Destination) context.lookup("topic/flyinghTopic"));
		topicPublisher.publish(topicSession.createTextMessage("Hello,I'm a topic message"));
		topicPublisher.close();
		topicSession.close();
		context.close();
	}

	@Test
	public void test() throws NamingException, JMSException {
		final InitialContext context = new InitialContext();
		final QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) context.lookup("QueueConnectionFactory");
		final QueueSession queueSession = queueConnectionFactory.createQueueConnection().createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		final MessageProducer producer = queueSession.createProducer((Destination) context.lookup("queue/flyinghQueue"));
		producer.send(queueSession.createTextMessage("Hello,I'm a message."));
		producer.close();
		queueSession.close();
		context.close();
	}
}
