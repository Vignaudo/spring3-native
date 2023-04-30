/**
 *     Copyright (C) 2023-2024 Olivier Vignaud.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.ovi.nativ.qpid;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;

@SuppressWarnings("static-method")
@ImportRuntimeHints(CustomHint.class)
@SpringBootApplication
public class QpidNativeApplication {

	public static void main(final String[] args) {
		SpringApplication.run(QpidNativeApplication.class, args);
	}

	@Bean
	JmsTemplate jmsTopicTemplate(final ConnectionFactory connectionFactory) {
		final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setPubSubDomain(true);
		return jmsTemplate;
	}

	@Bean
	JmsConnectionFactory createConnectionFactory() {
		final JmsConnectionFactory conn = new JmsConnectionFactory();
		conn.setRemoteURI("amqp://10.255.3.55:61616?amqp.saslLayer=false");
		conn.setRemoteURI("amqp://10.255.3.55:61616?amqp.vhost=");
		conn.setUsername("artemis");
		conn.setPassword("simetraehcapa");
		return conn;
	}

}
