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
import org.cloudifysource.restDoclet.constants.RestDocConstants.ResponseCodes;

/**
 * 
 * @author yael
 *
 */
public class DocPossibleResponseStatusAnnotation extends DocAnnotation {

	private Integer code;
	private String codeName;
	private String description;

	public DocPossibleResponseStatusAnnotation(final String name) {
		super(name);
	}

	public int getCode() {
		return this.code;
	}

	public String getCodeName() {
		return codeName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public void addAttribute(final String attrName, final Object attrValue) {
		String shortAttrName = getShortName(attrName);
		if (RestDocConstants.POSSIBLE_RESPONSE_STATUS_CODE
				.equals(shortAttrName)) {
			code = (Integer) attrValue;
			codeName = ResponseCodes.fromCode(code).getReasonPhrase();
		} else if (RestDocConstants.POSSIBLE_RESPONSE_STATUS_DESCRIPTION
				.equals(shortAttrName)) {
			description = (String) attrValue;
		}
		super.addAttribute(attrName, attrValue);
	}

	@Override
	public String toString() {
		String str = "@" + RestDocConstants.POSSIBLE_RESPONSE_STATUS_ANNOTATION + "{";
		if (code != null) {			
			str += "code : \"" + code + " " + codeName + "\"";
		}
		if (code != null && description != null) {	
			str += ", ";
		}
		if (description != null) {
			str += "description: " + description;
		}
		return str + "}";
	}
}
