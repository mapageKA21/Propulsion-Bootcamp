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

package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sam Brannen
 */
@Configuration
@ComponentScan("service")
// @ComponentScan(basePackageClasses = DefaultHelloSpringService.class)
public class HelloSpringConfig {

	@Bean
	public String message() {
		return "Hello, Spring!";
	}

	@Bean
	public String message2() {
		return "Message #2";
	}

	/*
	@Bean // @Scope("prototype")
	@Primary
	public HelloSpringService helloSpringService() {
		return new DefaultHelloSpringService();
	}

	@Bean
	public HelloSpringService helloSpringService2() {
		return new DefaultHelloSpringService();
	}
	*/

}
