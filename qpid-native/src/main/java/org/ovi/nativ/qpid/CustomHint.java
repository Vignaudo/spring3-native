/**
 *     Copyright (C) 2023-2025 Olivier Vignaud.
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
import org.apache.qpid.jms.provider.amqp.AmqpProvider;
import org.apache.qpid.jms.provider.amqp.AmqpProviderFactory;
import org.apache.qpid.jms.sasl.AnonymousMechanismFactory;
import org.apache.qpid.jms.sasl.PlainMechanismFactory;
import org.apache.qpid.jms.tracing.opentracing.OpenTracingTracerFactory;
import org.apache.qpid.jms.transports.netty.NettySslTransportFactory;
import org.apache.qpid.jms.transports.netty.NettyTcpTransportFactory;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class CustomHint implements RuntimeHintsRegistrar {

	@Override
	public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
		hints.reflection().registerType(JmsConnectionFactory.class, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.reflection().registerType(AmqpProviderFactory.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.reflection().registerType(NettyTcpTransportFactory.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.reflection().registerType(OpenTracingTracerFactory.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.reflection().registerType(NettySslTransportFactory.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.reflection().registerType(AmqpProvider.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		//
		hints.reflection().registerType(PlainMechanismFactory.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.reflection().registerType(AnonymousMechanismFactory.class, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INVOKE_DECLARED_METHODS);
		hints.resources().registerPattern("META-INF/services/org/apache/qpid/jms/*");
	}

}
