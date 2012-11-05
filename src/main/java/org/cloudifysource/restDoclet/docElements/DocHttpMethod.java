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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author yael
 *
 */
public class DocHttpMethod {
	private String methodSignatureName;
	private String httpMethodName;
	private String description;

	private List<DocParameter> params;
	private List<DocParameter> annotatedParams;
	private Map<String, String> requestParamAnnotationParamValues;

	private DocReturnDetails returnDetails;

	private DocJsonRequestExample jsonRequestExample;
	private DocJsonResponseExample jsonResponseExample;
	private List<DocPossibleResponseStatusAnnotation> possibleResponseStatuses;

	public DocHttpMethod(final String methodSignatureName, final String requestMethod) {
		this.methodSignatureName = methodSignatureName;
		this.httpMethodName = requestMethod;
	}

	public String getMethodSignatureName() {
		return methodSignatureName;
	}

	public String getHttpMethodName() {
		return httpMethodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String commentText) {
		description = commentText;

	}

	public List<DocParameter> getParams() {
		return params;
	}

	/**
	 * 
	 * @param params .
	 */
	public void setParams(final List<DocParameter> params) {
		this.params = params;
		setAnnotatedParams();
	}

	public List<DocParameter> getAnnotatedParams() {
		return annotatedParams;
	}

	/**
	 * 
	 */
	public void setAnnotatedParams() {
		if (params == null) {
			return;
		}
		for (DocParameter docParameter : params) {
			DocRequestParamAnnotation requestParamAnnotation = docParameter
					.getRequestParamAnnotation();
			if (requestParamAnnotation != null) {
				if (requestParamAnnotationParamValues == null) {
					requestParamAnnotationParamValues = new HashMap<String, String>();
				}
				requestParamAnnotationParamValues.put(docParameter.getName(),
						("<" + docParameter.getType() + ">"));
			}
			List<DocAnnotation> annotations = docParameter.getAnnotations();
			if (annotations != null && !annotations.isEmpty()) {
				if (annotatedParams == null) {
					annotatedParams = new LinkedList<DocParameter>();
				}
				annotatedParams.add(docParameter);
			}
		}
	}

	public DocReturnDetails getReturnDetails() {
		return returnDetails;
	}

	public void setReturnDetails(final DocReturnDetails returnDetails) {
		this.returnDetails = returnDetails;
	}

	public DocJsonResponseExample getJsonResponseExample() {
		return jsonResponseExample;
	}

	public void setJsonResponseExample(
			final DocJsonResponseExample jsonResponseExample) {
		this.jsonResponseExample = jsonResponseExample;
	}

	public DocJsonRequestExample getJsonRequestExample() {
		return jsonRequestExample;
	}

	public void setJsonRequesteExample(final DocJsonRequestExample request) {
		this.jsonRequestExample = request;
	}

	public List<DocPossibleResponseStatusAnnotation> getPossibleResponseStatuses() {
		return possibleResponseStatuses;
	}

	/**
	 * 
	 * @param possibleResponseStatusesAnnotation .
	 */
	public void setPossibleResponseStatuses(
			final DocPossibleResponseStatusesAnnotation possibleResponseStatusesAnnotation) {
		if (possibleResponseStatusesAnnotation != null) {
			this.possibleResponseStatuses = possibleResponseStatusesAnnotation
					.getResponseStatuses();
		}
	}

	@Override
	public String toString() {
		String httpMethodShort = httpMethodName.substring(httpMethodName
				.lastIndexOf('.') + 1);
		String str = "http method: " + httpMethodShort + "\n";
		if (StringUtils.isBlank(description)) {
			str += "description: " + description + "\n";
		}
		if (params != null && !params.isEmpty()) {
			StringBuilder paramsStr = new StringBuilder();
			for (DocParameter param : params) {
				paramsStr.append("   ").append(param).append("\n");
			}
			str += "parameters: \n" + paramsStr;
		}
		str += "returns " + returnDetails;
		if (jsonResponseExample != null) {
			str += "Response example: " + jsonResponseExample + "\n";
		}
		if (jsonRequestExample != null) {
			str += "Request example: " + jsonRequestExample + "\n";
		}

		if (possibleResponseStatuses != null) {
			StringBuilder responseStatusStr = new StringBuilder();
			for (DocPossibleResponseStatusAnnotation responseStatus : possibleResponseStatuses) {
				responseStatusStr.append("* ").append(responseStatus)
						.append("\n");
			}
			str += "Returns: " + responseStatusStr;
		}
		return str;
	}

}
