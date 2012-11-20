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

/**
 * 
 * @author yael
 *
 */
public class DocMethod {
	private String uri;
	private String description;
	private final List<DocHttpMethod> httpMethods;
	
	
	public DocMethod(final DocHttpMethod httpMethod) {
		httpMethods = new LinkedList<DocHttpMethod>();
		httpMethods.add(httpMethod);
	}
	public DocMethod(final DocHttpMethod[] httpMethodArray) {
		httpMethods = new LinkedList<DocHttpMethod>();
		for (DocHttpMethod docHttpMethod : httpMethodArray) {			
			httpMethods.add(docHttpMethod);
		}
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(final String uri) {
		this.uri = uri;
	}
	public List<DocHttpMethod> getHttpMethods() {
		return httpMethods;
	}
	/** 
	 * 
	 * @param httpMethod .
	 */
	public void addHttpMethod(final DocHttpMethod httpMethod) {
		this.httpMethods.add(httpMethod);
	}
	/**
	 * 
	 * @param httpMethodArray An array of HTTP methods.
	 */
	public void addHttpMethods(final DocHttpMethod[] httpMethodArray) {
		for (DocHttpMethod docHttpMethod : httpMethodArray) {			
			this.httpMethods.add(docHttpMethod);
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("\nmapping: ").append(uri).append('\n');
		if (description != null && !description.isEmpty()) {
			str.append("description: \n").append(description).append('\n');
		}
		if (httpMethods != null) {
			str.append("httpMethods:\n");
			for (DocHttpMethod httpMethod : httpMethods) {
				str.append(httpMethod).append('\n');
			}
		}
		return str.toString();
	}
}
