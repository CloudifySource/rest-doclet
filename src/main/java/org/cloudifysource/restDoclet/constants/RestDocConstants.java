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

import java.io.File;

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
public final class RestDocConstants {
	/**
	 * 
	 */
	public static final String DOCLET_FLAG = "-doclet";
	/**
	 * 
	 */
	public static final String CLOUDIFY_PATH = ".." + File.separator + ".." + File.separator 
			+ "workspaceCloudify" + File.separator + "cloudify";
	/**
	 * 
	 */
	public static final String SOURCE_PATH_FLAG = "-sourcepath";
	/**
	 * 
	 */
	public static final String SOURCES_PATH = CLOUDIFY_PATH + File.separator + "restful" + File.separator + "src" 
			+ File.separator + "main" + File.separator + "java";
	/**
	 * 
	 */
	public static final String CONTROLLERS_PACKAGE = "org.cloudifysource.rest.controllers";
	/**
	 * 
	 */
	public static final String DSL_RESPONSE_SOURCES_PATH = CLOUDIFY_PATH + File.separator + "dsl" 
			+ File.separator + "src" + File.separator + "main" + File.separator + "java"
			+ File.separator + "org" + File.separator + "cloudifysource" + File.separator 
			+ "dsl" + File.separator + "rest" + File.separator + "response";
	/**
	 * 
	 */
	public static final String DSL_RESPONSE_PACKAGE = "org.cloudifysource.dsl.rest.response";
	/**
	 * 
	 */
	public static final String SERVICE_CONTROLLER_CLASS_NAME = "org.cloudifysource.rest.controllers.ServiceController";
	/**
	 * 
	 */
	public static final String ADMIN_API_CONTROLLER_CLASS_NAME = 
			"org.cloudifysource.rest.controllers.AdminAPIController";
	/**
	 * 
	 */
	public static final String VELOCITY_TEMPLATE_PATH_FLAG = "-velocityTemplateFilePath";
	/**
	 * 
	 */
	public static final String VELOCITY_TEMPLATE_FILE_NAME = "restDocletVelocityTemplate.vm";
	/**
	 * 
	 */
	public static final String VELOCITY_TEMPLATE_PATH = "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator
			+ VELOCITY_TEMPLATE_FILE_NAME;
	/**
	 * 
	 */
	public static final String DOC_DEST_PATH_FLAG = "-docletDestdir";
	/**
	 * 
	 */
	public static final String DOC_DEST_PATH = "restdoclet.html";
	/**
	 * 
	 */
	public static final String DOC_CSS_PATH_FLAG = "-docletCss";
	/**
	 * 
	 */
	public static final String DOC_CSS_PATH = "restdoclet.css";

	/**
	 * 
	 */
	public static final String VERSION_FLAG = "-restVersion";
	/**
	 * 
	 */
	public static final String VERSION = "";
	/**
	 * 
	 */
	public static final String REQUEST_EXAMPLE_GENERATOR_CLASS_FLAG = "-requestExample";
	/**
	 * 
	 */
	public static final String RESPONSE_EXAMPLE_GENERATOR_CLASS_FLAG = "-responseExample";
	/**
	 * 
	 */
	public static final String REQUEST_BODY_PARAM_FILTER_CLASS_FLAG = "-requestBodyParamFilter";
	/**
	 * 
	 */
	public static final String CONTROLLER_ANNOTATION = "Controller";

	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_ANNOTATION = "RequestMapping";
	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_VALUE = "value";
	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_METHOD = "method";
	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_HEADERS = "headers";
	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_PARAMS = "params";
	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_PRODUCES = "produces";
	/**
	 * 
	 */
	public static final String REQUEST_MAPPING_CONSUMED = "consumes";

	/**
	 * 
	 */
	public static final String REQUEST_PARAMS_ANNOTATION = "RequestParam";
	/**
	 * 
	 */
	public static final String REQUEST_PARAMS_REQUIRED = "required";
	/**
	 * 
	 */
	public static final String REQUEST_PARAMS_VALUE = "value";
	/**
	 * 
	 */
	public static final String REQUEST_PARAMS_DEFAULT_VALUE = "defaultValue";

	/**
	 * 
	 */
	public static final String REQUEST_BODY_ANNOTATION = "RequestBody";

	/**
	 * 
	 */
	public static final String RESPONSE_BODY_ANNOTATION = "ResponseBody";

	/**
	 * 
	 */
	public static final String PATH_VARIABLE_ANNOTATION = "PathVariable";

	/**
	 * 
	 */
	public static final String JSON_RESPONSE_EXAMPLE_ANNOTATION = "JsonResponseExample";
	/**
	 * 
	 */
	public static final String JSON_RESPONSE_EXAMPLE_STATUS = "status";
	/**
	 * 
	 */
	public static final String JSON_RESPONSE_EXAMPLE_RESPONSE = "responseBody";
	/**
	 * 
	 */
	public static final String JSON_RESPONSE_EXAMPLE_COMMENTS = "comments";

	/**
	 * 
	 */
	public static final String JSON_REQUEST_EXAMPLE_ANNOTATION = "JsonRequestExample";
	/**
	 * 
	 */
	public static final String JSON_REQUEST_EXAMPLE_REQUEST_PARAMS = "requestBody";
	/**
	 * 
	 */
	public static final String JSON_REQUEST_EXAMPLE_COMMENTS = "comments";

	/**
	 * 
	 */
	public static final String POSSIBLE_RESPONSE_STATUSES_ANNOTATION = "PossibleResponseStatuses";
	/**
	 * 
	 */
	public static final String POSSIBLE_RESPONSE_STATUSES_RESPONSE_STATUSES = "responseStatuses";

	/**
	 * 
	 */
	public static final String POSSIBLE_RESPONSE_STATUS_ANNOTATION = "PossibleResponseStatus";
	/**
	 * 
	 */
	public static final String POSSIBLE_RESPONSE_STATUS_CODE = "code";
	/**
	 * 
	 */
	public static final String POSSIBLE_RESPONSE_STATUS_DESCRIPTION = "description";

	/**
	 * 
	 */
	public static final String INTERNAL_METHOD_ANNOTATION = "InternalMethod";
	
	/**
	 * 
	 */
	public static final String HTTP_MATHOD_GET = "GET";
	/**
	 * 
	 */
	public static final String HTTP_MATHOD_POST = "POST";
	/**
	 * 
	 */
	public static final String HTTP_MATHOD_DELETE = "DELETE";
	/**
	 * 
	 */
	public enum DocAnnotationTypes {
		/**
		 * 
		 */
		INTERNAL_METHOD_ANNOTATION, 
		/**
		 * 
		 */
		CONTROLLER, 
		/**
		 * 
		 */
		REQUEST_MAPPING, 
		/**
		 * 
		 */
		REQUEST_PARAM, 
		/**
		 * 
		 */
		REQUEST_BODY, 
		/**
		 * 
		 */
		RESPONSE_BODY, 
		/**
		 * 
		 */
		PATH_VARIABLE, 
		/**
		 * 
		 */
		JSON_RESPONSE_EXAMPLE, 
		/**
		 * 
		 */
		JSON_REQUEST_EXAMPLE, 
		/**
		 * 
		 */
		POSSIBLE_RESPONSE_STATUS, 
		/**
		 * 
		 */
		POSSIBLE_RESPONSE_STATUSES, 
		/**
		 * 
		 */
		DEFAULT;

		/**
		 * 
		 * @param annotationName .
		 * @return The annotation type.
		 */
		public static DocAnnotationTypes fromName(final String annotationName) {
			if (INTERNAL_METHOD_ANNOTATION.equals(annotationName)) {
				return INTERNAL_METHOD_ANNOTATION;
			} else if (CONTROLLER_ANNOTATION.equals(annotationName)) {
				return CONTROLLER;
			} else if (REQUEST_MAPPING_ANNOTATION.equals(annotationName)) {
				return REQUEST_MAPPING;
			} else if (REQUEST_PARAMS_ANNOTATION.equals(annotationName)) {
				return REQUEST_PARAM;
			} else if (REQUEST_BODY_ANNOTATION.equals(annotationName)) {
				return REQUEST_BODY;
			} else if (RESPONSE_BODY_ANNOTATION.equals(annotationName)) {
				return RESPONSE_BODY;
			} else if (PATH_VARIABLE_ANNOTATION.equals(annotationName)) {
				return PATH_VARIABLE;
			} else if (JSON_RESPONSE_EXAMPLE_ANNOTATION.equals(annotationName)) {
				return JSON_RESPONSE_EXAMPLE;
			} else if (JSON_REQUEST_EXAMPLE_ANNOTATION.equals(annotationName)) {
				return JSON_REQUEST_EXAMPLE;
			} else if (POSSIBLE_RESPONSE_STATUS_ANNOTATION.equals(annotationName)) {
				return POSSIBLE_RESPONSE_STATUS;
			} else if (POSSIBLE_RESPONSE_STATUSES_ANNOTATION
					.endsWith(annotationName)) {
				return POSSIBLE_RESPONSE_STATUSES;
			} else {
				return DEFAULT;
			}
		}

		/**
		 * 
		 * @param name
		 *            .
		 * @return The class of the annotation.
		 */
		public static Class<?> getAnnotationClass(final String name) {
			switch (fromName(name)) {
			case REQUEST_MAPPING:
				return DocRequestMappingAnnotation.class;
			case REQUEST_PARAM:
				return DocRequestParamAnnotation.class;
			case JSON_REQUEST_EXAMPLE:
				return DocJsonRequestExample.class;
			case JSON_RESPONSE_EXAMPLE:
				return DocJsonResponseExample.class;
			case POSSIBLE_RESPONSE_STATUS:
				return DocPossibleResponseStatusAnnotation.class;
			case POSSIBLE_RESPONSE_STATUSES:
				return DocPossibleResponseStatusesAnnotation.class;
			case REQUEST_BODY:
			case RESPONSE_BODY:
			case PATH_VARIABLE:
			case CONTROLLER:
			case INTERNAL_METHOD_ANNOTATION:
				return DocAnnotation.class;
			default:
				throw new IllegalArgumentException(
						"Unsupported DocAnnotations: " + name);
			}
		}

	}

	/**
	 * 
	 * @author yael
	 * 
	 */
	public enum ResponseCodes {
		/**
		 * 
		 */
		CONTINUE(100, "Continue"),
		/**
		 * 
		 */
		SWITCHING_PROTOCOLS(101, "Switching Protocols"),
		
		/**
		 * 
		 */
		OK(200, "OK"),
		/**
		 * 
		 */
		CREATED(201, "Created"),
		/**
		 * 
		 */
		ACCEPTED(202, "Accepted"),
		/**
		 * 
		 */
		NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
		/**
		 * 
		 */
		NO_CONTENT(204, "No Content"),
		/**
		 * 
		 */
		RESET_CONTENT(205, "Reset Content"),
		/**
		 * 
		 */
		PARTIAL_CONTENT(206, "Partial Content"),
		
		/**
		 * 
		 */
		MULTIPLE_CHOICES(300, "Multiple Choices"),
		/**
		 * 
		 */
		MOVED_PERMANENTLY(301, "Moved Permanently"),
		/**
		 * 
		 */
		FOUND(302, "Found"),
		/**
		 * 
		 */
		SEE_OTHER(303, "See Other"),
		/**
		 * 
		 */
		NOT_MODIFIED(304, "Not Modified"),
		/**
		 * 
		 */
		USE_PROXY(305, "Use Proxy"),
		/**
		 * 
		 */
		UNUSED(306, "(Unused)"),
		/**
		 * 
		 */
		TEMPORARY_REDIRECT(307, "Temporary Redirect"),
		
		/**
		 * 
		 */
		BAD_REQUEST(400, "Bad Request"),
		/**
		 * 
		 */
		UNAUTHORIZED(401, "Unauthorized"),
		/**
		 * 
		 */
		PAYMENT_REQUIRED(402, "Payment Required"),
		/**
		 * 
		 */
		FORBIDDEN(403, "Forbidden"),
		/**
		 * 
		 */
		NOT_FOUND(404, "Not Found"),
		/**
		 * 
		 */
		METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
		/**
		 * 
		 */
		NOT_ACCEPTABLE(406, "Not Acceptable"),
		/**
		 * 
		 */
		PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
		/**
		 * 
		 */
		REQUEST_TIMEOUT(408, "Request Timeout"),
		/**
		 * 
		 */
		CONFLICT(409, "Conflict"),
		/**
		 * 
		 */
		GONE(410, "Gone"),
		/**
		 * 
		 */
		LENGTH_REQUIRED(411, "Length Required"),
		/**
		 * 
		 */
		PRECONDITION_FAILED(412, "Precondition Failed"),
		/**
		 * 
		 */
		REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
		/**
		 * 
		 */
		REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
		/**
		 * 
		 */
		UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
		/**
		 * 
		 */
		REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
		/**
		 * 
		 */
		EXPECTATION_FAILED(417, "Expectation Failed"),
		
		/**
		 * 
		 */
		INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
		/**
		 * 
		 */
		NOT_IMPLEMENTED(501, "Not Implemented"),
		/**
		 * 
		 */
		BAD_GATEWAY(502, "Bad Gateway"),
		/**
		 * 
		 */
		SERVICE_UNAVAILABALE(503, "Service Unavailable"),
		/**
		 * 
		 */
		GATEWAY_TIMEOUT(504, "Gateway Timeout"),
		/**
		 * 
		 */
		HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported");

		private final int value;
		private final String reasonPhrase;

		private ResponseCodes(final int value, final String reasonPhrase) {
			this.value = value;
			this.reasonPhrase = reasonPhrase;
		}

		/**
		 * 
		 * @param code
		 *            .
		 * @return The response code.
		 */
		public static ResponseCodes fromCode(final int code) {
			if (CONTINUE.getValue() == code) {
				return CONTINUE;
			}
			if (SWITCHING_PROTOCOLS.getValue() == code) {
				return SWITCHING_PROTOCOLS;
			}
			if (OK.getValue() == code) {
				return OK;
			}
			if (CREATED.getValue() == code) {
				return CREATED;
			}
			if (ACCEPTED.getValue() == code) {
				return ACCEPTED;
			}
			if (NON_AUTHORITATIVE_INFORMATION.getValue() == code) {
				return NON_AUTHORITATIVE_INFORMATION;
			}
			if (NO_CONTENT.getValue() == code) {
				return NO_CONTENT;
			}
			if (RESET_CONTENT.getValue() == code) {
				return RESET_CONTENT;
			}
			if (PARTIAL_CONTENT.getValue() == code) {
				return PARTIAL_CONTENT;
			}
			if (MULTIPLE_CHOICES.getValue() == code) {
				return MULTIPLE_CHOICES;
			}
			if (MOVED_PERMANENTLY.getValue() == code) {
				return MOVED_PERMANENTLY;
			}
			if (FOUND.getValue() == code) {
				return FOUND;
			}
			if (SEE_OTHER.getValue() == code) {
				return SEE_OTHER;
			}
			if (NOT_MODIFIED.getValue() == code) {
				return NOT_MODIFIED;
			}
			if (USE_PROXY.getValue() == code) {
				return USE_PROXY;
			}
			if (UNUSED.getValue() == code) {
				return UNUSED;
			}
			if (TEMPORARY_REDIRECT.getValue() == code) {
				return TEMPORARY_REDIRECT;
			}
			if (BAD_REQUEST.getValue() == code) {
				return BAD_REQUEST;
			}
			if (UNAUTHORIZED.getValue() == code) {
				return UNAUTHORIZED;
			}
			if (PAYMENT_REQUIRED.getValue() == code) {
				return PAYMENT_REQUIRED;
			}
			if (FORBIDDEN.getValue() == code) {
				return FORBIDDEN;
			}
			if (NOT_FOUND.getValue() == code) {
				return NOT_FOUND;
			}
			if (METHOD_NOT_ALLOWED.getValue() == code) {
				return METHOD_NOT_ALLOWED;
			}
			if (NOT_ACCEPTABLE.getValue() == code) {
				return NOT_ACCEPTABLE;
			}
			if (PROXY_AUTHENTICATION_REQUIRED.getValue() == code) {
				return PROXY_AUTHENTICATION_REQUIRED;
			}
			if (REQUEST_TIMEOUT.getValue() == code) {
				return REQUEST_TIMEOUT;
			}
			if (CONFLICT.getValue() == code) {
				return CONFLICT;
			}
			if (GONE.getValue() == code) {
				return GONE;
			}
			if (LENGTH_REQUIRED.getValue() == code) {
				return LENGTH_REQUIRED;
			}
			if (PRECONDITION_FAILED.getValue() == code) {
				return PRECONDITION_FAILED;
			}
			if (REQUEST_ENTITY_TOO_LARGE.getValue() == code) {
				return REQUEST_ENTITY_TOO_LARGE;
			}
			if (REQUEST_URI_TOO_LONG.getValue() == code) {
				return REQUEST_URI_TOO_LONG;
			}
			if (UNSUPPORTED_MEDIA_TYPE.getValue() == code) {
				return UNSUPPORTED_MEDIA_TYPE;
			}
			if (REQUESTED_RANGE_NOT_SATISFIABLE.getValue() == code) {
				return REQUESTED_RANGE_NOT_SATISFIABLE;
			}
			if (EXPECTATION_FAILED.getValue() == code) {
				return EXPECTATION_FAILED;
			}
			if (INTERNAL_SERVER_ERROR.getValue() == code) {
				return INTERNAL_SERVER_ERROR;
			}
			if (NOT_IMPLEMENTED.getValue() == code) {
				return NOT_IMPLEMENTED;
			}
			if (BAD_GATEWAY.getValue() == code) {
				return BAD_GATEWAY;
			}
			if (SERVICE_UNAVAILABALE.getValue() == code) {
				return SERVICE_UNAVAILABALE;
			}
			if (GATEWAY_TIMEOUT.getValue() == code) {
				return GATEWAY_TIMEOUT;
			}
			if (HTTP_VERSION_NOT_SUPPORTED.getValue() == code) {
				return HTTP_VERSION_NOT_SUPPORTED;
			}
			throw new IllegalArgumentException(
					"Unsupported ResponseCodes code: " + code);
		}

		public int getValue() {
			return this.value;
		}

		public String getReasonPhrase() {
			return this.reasonPhrase;
		}
	}

	public static final String FAILED_TO_CREATE_REQUEST_EXAMPLE = 
	"Failed to generate the request body example out of the request parameter type.";
	public static final String FAILED_TO_CREATE_RESPONSE_EXAMPLE = 
	"Failed to generate the response body example out of the return value type.";
	
	private RestDocConstants() {
		
	}
}
