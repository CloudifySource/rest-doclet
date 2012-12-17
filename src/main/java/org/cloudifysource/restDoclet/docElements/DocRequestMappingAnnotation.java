/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
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
package org.cloudifysource.restDoclet.docElements;

import org.cloudifysource.restDoclet.constants.RestDocConstants;

import com.sun.tools.javadoc.FieldDocImpl;

/**
 * 
 * @author yael
 *
 */
public class DocRequestMappingAnnotation extends DocAnnotation {
	private String[] value;
	private String[] method;
	private String[] headers;
	private String[] params;
	private String[] produces;
	private String[] consumes;

	public DocRequestMappingAnnotation(final String name) {
		super(name);
	}

	public String[] getValue() {
		return value;
	}

	public String[] getMethod() {
		return method;
	}

	public String[] getHeaders() {
		return headers;
	}

	public String[] getParams() {
		return params;
	}

	public String[] getProduces() {
		return produces;
	}

	public String[] getConsumes() {
		return consumes;
	}

	@Override
	public void addAttribute(final String attrName, final Object attrValue) {
		String shortAttrName = getShortName(attrName);

		if (RestDocConstants.REQUEST_MAPPING_VALUE.equals(shortAttrName)) {
			String[] valueArray = (String[]) attrValue;
			value = new String[valueArray.length];
			for (int i = 0; i < valueArray.length; i++) {
				String valueStr = valueArray[i];
				if (valueStr.endsWith("/")) {
					valueStr = valueStr.substring(0, valueStr.length() - 1);
				}
				value[i] = valueStr.startsWith("/") ? valueStr
						: ("/" + valueStr);
			}
		}
		if (RestDocConstants.REQUEST_MAPPING_METHOD.equals(shortAttrName)) {
			FieldDocImpl[] methodArray = (FieldDocImpl[]) attrValue;
			method = new String[methodArray.length];
			for (int i = 0; i < methodArray.length; i++) {
				method[i] = methodArray[i].name();
			}
		}
		if (RestDocConstants.REQUEST_MAPPING_HEADERS.equals(shortAttrName)) {
			headers = ((String[]) attrValue);
		}
		if (RestDocConstants.REQUEST_MAPPING_PARAMS.equals(shortAttrName)) {
			params = ((String[]) attrValue);
		}
		if (RestDocConstants.REQUEST_MAPPING_PRODUCES.equals(shortAttrName)) {
			produces = ((String[]) attrValue);
		}
		if (RestDocConstants.REQUEST_MAPPING_CONSUMED.equals(shortAttrName)) {
			consumes = ((String[]) attrValue);
		}

		super.addAttribute(shortAttrName, attrValue);
	}
}
