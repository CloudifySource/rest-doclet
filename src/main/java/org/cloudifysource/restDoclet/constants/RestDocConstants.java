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
package org.cloudifysource.restDoclet.constants;

import org.cloudifysource.restDoclet.docElements.DocAnnotation;
import org.cloudifysource.restDoclet.docElements.DocJsonRequestExample;
import org.cloudifysource.restDoclet.docElements.DocJsonResponseExample;
import org.cloudifysource.restDoclet.docElements.DocPossibleResponseStatusAnnotation;
import org.cloudifysource.restDoclet.docElements.DocPossibleResponseStatusesAnnotation;
import org.cloudifysource.restDoclet.docElements.DocRequestMappingAnnotation;
import org.cloudifysource.restDoclet.docElements.DocRequestParamAnnotation;


/**
 * 
 * @author yael
 *
 */
public class RestDocConstants {
	public static final String DOCLET_FLAG = "-doclet";
	
	public static final String SOURCE_PATH_FLAG = "-sourcepath";
	public static final String SOURCES_PATH = "../../workspaceCloudify/cloudify/restful/src/main/java";
	public static final String CONTROLLERS_PACKAGE = "org.cloudifysource.rest.controllers";
	
	public static final String SERVICE_CONTROLLER_CLASS_NAME = "org.cloudifysource.rest.controllers.ServiceController";
	public static final String ADMIN_API_CONTROLLER_CLASS_NAME = "org.cloudifysource.rest.controllers.AdminAPIController";

	public static final String VELOCITY_TEMPLATE_PATH_FLAG = "-velocityTemplateFilePath";
	public static final String DOC_DEST_PATH_FLAG = "-docletDestdir";
	
	public static final String VERSION_FLAG = "-version";
	public static final String VERSION = "";

	public static final String VELOCITY_TEMPLATE_FILE_NAME = "restDocletVelocityTemplate.vm";
	public static final String VELOCITY_TEMPLATE_PATH = "src/main/resources/" + VELOCITY_TEMPLATE_FILE_NAME;
	public static final String DOC_DEST_PATH = "restdoclet.html";
	
	public static final String CONTROLLER_ANNOTATION = "Controller";
	
	public static final String REQUEST_MAPPING_ANNOTATION = "RequestMapping";
	public static final String REQUEST_MAPPING_VALUE = "value";
	public static final String REQUEST_MAPPING_METHOD = "method";
	public static final String REQUEST_MAPPING_HEADERS = "headers";
	public static final String REQUEST_MAPPING_PARAMS = "params";
	public static final String REQUEST_MAPPING_PRODUCES = "produces";
	public static final String REQUEST_MAPPING_CONSUMED = "consumes";
	
	public static final String REQUEST_PARAMS_ANNOTATION = "RequestParam";
	public static final String REQUEST_PARAMS_REQUIRED = "required";
	public static final String REQUEST_PARAMS_VALUE = "value";
	public static final String REQUEST_PARAMS_DEFAULT_VALUE = "defaultValue";
	
	public static final String REQUEST_BODY_ANNOTATION = "RequestBody";
	
	public static final String RESPONSE_BODY_ANNOTATION = "ResponseBody";
	
	public static final String PATH_VARIABLE_ANNOTATION = "PathVariable";
	
	public static final String JSON_RESPONSE_EXAMPLE_ANNOTATION = "JsonResponseExample";
	public static final String JSON_RESPONSE_EXAMPLE_STATUS = "status";
	public static final String JSON_RESPONSE_EXAMPLE_RESPONSE = "responseBody";
	public static final String JSON_RESPONSE_EXAMPLE_COMMENTS = "comments";

	public static final String JSON_REQUEST_EXAMPLE_ANNOTATION = "JsonRequestExample";
	public static final String JSON_REQUEST_EXAMPLE_REQUEST_PARAMS = "requestBody";
	public static final String JSON_REQUEST_EXAMPLE_COMMENTS = "comments";
	
	public static final String POSSIBLE_RESPONSE_STATUSES_ANNOTATION = "PossibleResponseStatuses";
	public static final String POSSIBLE_RESPONSE_STATUSES_RESPONSE_STATUSES = "responseStatuses";
	
	public static final String POSSIBLE_RESPONSE_STATUS_ANNOTATION = "PossibleResponseStatus";
	public static final String POSSIBLE_RESPONSE_STATUS_CODE = "code";
	public static final String POSSIBLE_RESPONSE_STATUS_DESCRIPTION = "description";

	public static final String HTTP_MATHOD_GET = "GET";
	public static final String HTTP_MATHOD_POST = "POST";
	public static final String HTTP_MATHOD_DELETE = "DELETE";
	
	public enum DocAnnotationTypes {
		CONTROLLER,
		REQUEST_MAPPING,
		REQUEST_PARAM,
		REQUEST_BODY,
		RESPONSE_BODY,
		PATH_VARIABLE,
		JSON_RESPONSE_EXAMPLE,
		JSON_REQUEST_EXAMPLE,
		POSSIBLE_RESPONSE_STATUS,
		POSSIBLE_RESPONSE_STATUSES,
		DEFAULT;

		public static DocAnnotationTypes fromName(String annotationName) {
			if(CONTROLLER_ANNOTATION.equals(annotationName))
				return CONTROLLER;
			else if(REQUEST_MAPPING_ANNOTATION.equals(annotationName))
				return REQUEST_MAPPING;
			else if(REQUEST_PARAMS_ANNOTATION.equals(annotationName))
				return REQUEST_PARAM;
			else if(REQUEST_BODY_ANNOTATION.equals(annotationName))
				return REQUEST_BODY;
			else if(RESPONSE_BODY_ANNOTATION.equals(annotationName))
				return RESPONSE_BODY;
			else if(PATH_VARIABLE_ANNOTATION.equals(annotationName))
				return PATH_VARIABLE;
			else if(JSON_RESPONSE_EXAMPLE_ANNOTATION.equals(annotationName))
				return JSON_RESPONSE_EXAMPLE;
			else if(JSON_REQUEST_EXAMPLE_ANNOTATION.equals(annotationName))
				return JSON_REQUEST_EXAMPLE;
			else if(POSSIBLE_RESPONSE_STATUS_ANNOTATION.equals(annotationName))
				return POSSIBLE_RESPONSE_STATUS;
			else if(POSSIBLE_RESPONSE_STATUSES_ANNOTATION.endsWith(annotationName))
				return POSSIBLE_RESPONSE_STATUSES;
			else 
				return DEFAULT;
		}
		public static Class<?> getAnnotationClass(String name)
		{
			switch (fromName(name))
			{
				case REQUEST_MAPPING: return DocRequestMappingAnnotation.class;
				case REQUEST_PARAM: return DocRequestParamAnnotation.class;
				case JSON_REQUEST_EXAMPLE: return DocJsonRequestExample.class;
				case JSON_RESPONSE_EXAMPLE: return DocJsonResponseExample.class;
				case POSSIBLE_RESPONSE_STATUS: return DocPossibleResponseStatusAnnotation.class;
				case POSSIBLE_RESPONSE_STATUSES: return DocPossibleResponseStatusesAnnotation.class;
				case REQUEST_BODY:
				case RESPONSE_BODY: 
				case PATH_VARIABLE: 
				case CONTROLLER: return DocAnnotation.class;
				default: throw new IllegalArgumentException("Unsupported DocAnnotations: " + name);
			}
		}

	}
	
	public enum ResponseCodes {
		OK(200, "OK"),
		INTERNAL_SERVER_ERROR(500, "Internal Server Error");
		
		private final int value;
		private final String reasonPhrase;
		
		private ResponseCodes(int value, String reasonPhrase) {
			this.value = value;
			this.reasonPhrase = reasonPhrase;
		}
		
		public static ResponseCodes fromCode(int code) {
			switch (code) {
			case 200:
				return OK;
			case 500:
				return INTERNAL_SERVER_ERROR;
			default:
				throw new IllegalArgumentException("Unsupported ResponseCodes code: " + code);
			}
		}
		
		public int getValue() {
			return this.value;
		}
		
		public String getReasonPhrase() {
			return this.reasonPhrase;
		}
	}
}
