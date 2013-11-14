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

import org.apache.commons.lang.ClassUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.web.multipart.MultipartFile;

import com.sun.javadoc.Type;

/**
 * Creates a default example -
 * 		creates a JSON format of an instantiated object of the given clazz.
 * @author yael
 * @since 0.5.0
 */
public class DocDefaultExampleGenerator implements
		IDocExampleGenerator {

  private ObjectCreator objectCreator_ = new ObjectCreator();

	private String generateJSON(final Type type) throws Exception {
		Class<?> clazz = ClassUtils.getClass(type.qualifiedTypeName());
		if (MultipartFile.class.getName().equals(clazz.getName())) {
			return "\"file content\"";
		}

    Object newInstance = objectCreator_.createObject(clazz);
		return new ObjectMapper()
            .configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
            .writeValueAsString(newInstance);
	}

  @Override
	public String generateExample(final Type type) throws Exception {
		return generateJSON(type);
	}
}
