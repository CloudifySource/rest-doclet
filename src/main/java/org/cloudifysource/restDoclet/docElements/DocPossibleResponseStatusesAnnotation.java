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

import java.util.LinkedList;
import java.util.List;

import org.cloudifysource.restDoclet.constants.RestDocConstants;

/**
 * 
 * @author yael
 *
 */
public class DocPossibleResponseStatusesAnnotation extends DocAnnotation {

	private List<DocPossibleResponseStatusAnnotation> responseStatuses;

	public DocPossibleResponseStatusesAnnotation(final String name) {
		super(name);
		responseStatuses = new LinkedList<DocPossibleResponseStatusAnnotation>();
	}

	public List<DocPossibleResponseStatusAnnotation> getResponseStatuses() {
		return responseStatuses;
	}


	@Override
	public void addAttribute(final String attrName, final Object attrValue) {
		String shortAttrName = getShortName(attrName);
		if (RestDocConstants.POSSIBLE_RESPONSE_STATUSES_RESPONSE_STATUSES.equals(shortAttrName)) {
			DocPossibleResponseStatusAnnotation[] docPossibleResponseStatusAnnotations = 
					(DocPossibleResponseStatusAnnotation[]) attrValue;
			for (DocPossibleResponseStatusAnnotation annotation : docPossibleResponseStatusAnnotations) {
				this.responseStatuses.add(annotation);
			}
		}
		super.addAttribute(attrName, attrValue);
	}

}
