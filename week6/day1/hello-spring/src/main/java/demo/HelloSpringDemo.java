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

package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.HelloSpringConfig;
import service.HelloSpringService;

/**
 * @author Sam Brannen
 */
public class HelloSpringDemo {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = //
			new AnnotationConfigApplicationContext(HelloSpringConfig.class);

		System.out.println("\n-----------------------------------------------------\n");

		// this will fail:
		// context.getBean(Number.class);

		HelloSpringService helloSpringService1 = context.getBean(HelloSpringService.class);
		System.out.println("Message 1: " + helloSpringService1.generateMessage());
		System.out.println("\n-----------------------------------------------------\n");

		HelloSpringService helloSpringService2 = context.getBean(HelloSpringService.class);
		System.out.println("Message 2: " + helloSpringService2.generateMessage());
		System.out.println("\n-----------------------------------------------------\n");

		System.out.println("service 1 == service 2: "//
				+ (helloSpringService1 == helloSpringService2));
		System.out.println("\n-----------------------------------------------------\n");

		// Old school "by name" -- not recommended.
		//		HelloSpringService helloSpringServiceByName = //
		//			(HelloSpringService) context.getBean("helloSpringService");

		HelloSpringService helloSpringServiceByName = //
			context.getBean("helloSpringService", HelloSpringService.class);
		System.out.println("Message by name: " + helloSpringServiceByName.generateMessage());
		System.out.println("\n-----------------------------------------------------\n");

		System.out.println("service 1 == service by name: "//
				+ (helloSpringService1 == helloSpringServiceByName));
		System.out.println("\n-----------------------------------------------------\n");

		System.out.println("Beans of type...");
		context.getBeansOfType(HelloSpringService.class)//
				.forEach((id, service) -> System.out.println(id + " says: " + service.generateMessage()));
	}

}
