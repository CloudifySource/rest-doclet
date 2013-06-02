/*******************************************************************************
 * Copyright (c) 2013 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.cloudifysource.restDoclet.exampleGenerators;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Creates a default example - 
 * 		creates a JSON format of an instantiated random valued object of the given clazz. 
 * @author yael
 *
 */
public class DocDefaultExampleGenerator implements
		IDocExampleGenerator {

	@Override
	public String generateExample(final Class<?> clazz) throws Exception {
		if (clazz.isInterface()) {
			return "Could not generate the example, the given class is an interface [" + clazz.getName() + "].";
		}
		Object newInstance = null;
		if (clazz.isPrimitive()) {
			newInstance = PrimitiveExampleValues.getValue(clazz);
		}
		Class<?> classToInstantiate = clazz;
		if (newInstance == null) {
			newInstance = classToInstantiate.newInstance();
		}
		return new ObjectMapper().writeValueAsString(newInstance);
	}
}
