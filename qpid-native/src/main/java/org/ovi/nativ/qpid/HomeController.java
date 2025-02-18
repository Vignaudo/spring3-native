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

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("static-method")
@RestController
public class HomeController {
	private final JmsTemplate jmsTemplate;

	public HomeController(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@GetMapping("/")
	public String home() {
		return "Hello  !!!";
	}

	@GetMapping("/send")
	public String home(final @RequestParam("msg") String msg) {
		jmsTemplate.convertAndSend("test", msg);
		return "Hello  !!!";
	}
}
