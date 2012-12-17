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

/**
 * 
 * @author yael
 *
 */
public class DocRequestParamAnnotation extends DocAnnotation {

	public DocRequestParamAnnotation(final String name) {
		super(name);
	}

	private String value;
	private String defaultValue;
	private Boolean requierd;

	public String getValue() {
		return value;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public Boolean isRequierd() {
		return requierd;
	}

	@Override
	public void addAttribute(final String attrName, final Object attrValue) {
		String shortAttrName = getShortName(attrName);

		if (RestDocConstants.REQUEST_PARAMS_VALUE.equals(shortAttrName)) {
			value = (String) attrValue;
		}
		if (RestDocConstants.REQUEST_PARAMS_DEFAULT_VALUE.equals(shortAttrName)) {
			defaultValue = (String) attrValue;
		}
		if (RestDocConstants.REQUEST_PARAMS_REQUIRED.equals(shortAttrName)) {
			requierd = (Boolean) attrValue;
		}

		super.addAttribute(shortAttrName, attrValue);
	}

}
