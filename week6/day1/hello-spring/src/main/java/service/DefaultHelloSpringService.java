/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Sam Brannen
 */
// @Component
@Service("helloSpringService")
public class DefaultHelloSpringService implements HelloSpringService {

	private final String message;

	//	public DefaultHelloSpringService() {
	//		this.message = "Nix";
	//	}

	// Unnecessary since there is only one constructor.
	// @Autowired
	public DefaultHelloSpringService(@Qualifier("message2") String message) {
		this.message = message;
	}

	@Override
	public String generateMessage() {
		return this.message;
	}

}
