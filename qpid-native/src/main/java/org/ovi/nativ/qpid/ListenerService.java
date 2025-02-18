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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@SuppressWarnings("static-method")
@Service
public class ListenerService {

	private static final Logger LOG = LoggerFactory.getLogger(ListenerService.class);

	@JmsListener(destination = "test")
	public void listen() {
		LOG.info("Receive.");
	}
}
