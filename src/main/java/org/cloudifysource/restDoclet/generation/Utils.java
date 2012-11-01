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
package org.cloudifysource.restDoclet.generation;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.cloudifysource.restDoclet.constants.RestDocConstants;
import org.cloudifysource.restDoclet.docElements.DocAnnotation;
import org.cloudifysource.restDoclet.docElements.DocController;
import org.cloudifysource.restDoclet.docElements.DocHttpMethod;
import org.cloudifysource.restDoclet.docElements.DocJsonRequestExample;
import org.cloudifysource.restDoclet.docElements.DocJsonResponseExample;
import org.cloudifysource.restDoclet.docElements.DocMethod;
import org.cloudifysource.restDoclet.docElements.DocPossibleResponseStatusAnnotation;
import org.cloudifysource.restDoclet.docElements.DocPossibleResponseStatusesAnnotation;
import org.cloudifysource.restDoclet.docElements.DocRequestMappingAnnotation;
import org.cloudifysource.restDoclet.docElements.DocRequestParamAnnotation;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.AnnotationDesc.ElementValuePair;

public class Utils {

	public static DocAnnotation createNewAnnotation(AnnotationDesc annotationDesc) {
		DocAnnotation docAnnotation = null;
		String name = annotationDesc.annotationType().typeName();
		switch (RestDocConstants.DocAnnotationTypes.fromName(name)) {
		case REQUEST_MAPPING: 
			docAnnotation = new DocRequestMappingAnnotation(name);
			break;
		case REQUEST_PARAM: 
			docAnnotation = new DocRequestParamAnnotation(name);
			break;
		case JSON_RESPONSE_EXAMPLE: 
			docAnnotation = new DocJsonResponseExample(name);
			break;
		case JSON_REQUEST_EXAMPLE: 
			docAnnotation = new DocJsonRequestExample(name);
			break;
		case POSSIBLE_RESPONSE_STATUS: 
			docAnnotation = new DocPossibleResponseStatusAnnotation(name);
			break;
		case POSSIBLE_RESPONSE_STATUSES:
			docAnnotation = new DocPossibleResponseStatusesAnnotation(name);
			break;
		case CONTROLLER: 
		default: docAnnotation = new DocAnnotation(name);
		}
		
		// add annotation's attributes
		for (ElementValuePair elementValuePair : annotationDesc.elementValues()) {
			String element = elementValuePair.element().toString();
			Object constractAttrValue = DocAnnotation.constractAttrValue(elementValuePair.value().value());
			docAnnotation.addAttribute(element, constractAttrValue);
		}
		return docAnnotation;
	}

	protected static DocAnnotation getAnnotation(List<DocAnnotation> annotations, String annotationName) {
		DocAnnotation requestedAnnotation = null;
		if(annotations != null) {
			for (DocAnnotation annotation : annotations) {
				if(annotation.getName().equals(annotationName)) {
					requestedAnnotation = annotation;
					break;
				}
			}
		}
		return requestedAnnotation;
	}

	protected static DocRequestParamAnnotation getRequestParamAnnotation(List<DocAnnotation> annotations) {
		return  (DocRequestParamAnnotation) 
				getAnnotation(annotations, RestDocConstants.REQUEST_PARAMS_ANNOTATION);
	}

	protected static DocRequestMappingAnnotation getRequestMappingAnnotation(List<DocAnnotation> annotations) {
		return (DocRequestMappingAnnotation) 
				getAnnotation(annotations, RestDocConstants.REQUEST_MAPPING_ANNOTATION);
	}

	protected static DocJsonResponseExample getJsonResponseExampleAnnotation(List<DocAnnotation> annotations) {
		return (DocJsonResponseExample) 
				getAnnotation(annotations, RestDocConstants.JSON_RESPONSE_EXAMPLE_ANNOTATION);
	}

	protected static DocJsonRequestExample getJsonRequestExampleAnnotation(List<DocAnnotation> annotations) {
		return (DocJsonRequestExample) 
				getAnnotation(annotations, RestDocConstants.JSON_REQUEST_EXAMPLE_ANNOTATION);
	}

	protected static DocPossibleResponseStatusAnnotation getPossibleResponseStatusAnnotation(List<DocAnnotation> annotations) {
		return (DocPossibleResponseStatusAnnotation) 
				getAnnotation(annotations, RestDocConstants.POSSIBLE_RESPONSE_STATUS_ANNOTATION);
	}
	
	protected static DocPossibleResponseStatusesAnnotation getPossibleResponseStatusesAnnotation(List<DocAnnotation> annotations) {
		return (DocPossibleResponseStatusesAnnotation) 
				getAnnotation(annotations, RestDocConstants.POSSIBLE_RESPONSE_STATUSES_ANNOTATION);
	}

	protected static Map<String, String> getParamTagsComments(MethodDoc methodDoc) {
		Map<String, String> paramComments = new HashMap<String, String>();
		for (ParamTag paramTag : methodDoc.paramTags()) {
			paramComments.put(paramTag.parameterName(), paramTag.parameterComment());
		}
		return paramComments;
	}

	protected static boolean filterOutControllerClass(ClassDoc classDoc, 
			List<DocAnnotation> annotations) {
		return 
				(Utils.getAnnotation(annotations, RestDocConstants.CONTROLLER_ANNOTATION) == null ||
						RestDocConstants.ADMIN_API_CONTROLLER_CLASS_NAME.equals(classDoc.qualifiedTypeName()));
		//return !(classDoc.qualifiedTypeName().equals(RestDocConstants.SERVICE_CONTROLLER_CLASS_NAME));
	}


	protected static void printMethodsToFile(List<DocController> controllers, String fileName) throws IOException {
		PrintStream print = null;
		try {
			print = new PrintStream(new File(fileName));
			for (DocController docController : controllers) {
				Collection<DocMethod> methods = docController.getMethods().values();
				print.println("*****************************************");
				print.println("Controller " + docController.getName());
				print.println("*****************************************");
				for (DocMethod docMethod : methods) {
					List<DocHttpMethod> httpMethods = docMethod.getHttpMethods();
					for (DocHttpMethod docHttpMethod : httpMethods) {
						print.println("method " + docHttpMethod.getMethodSignatureName());
						//print.println("				uri " + docMethod.getUri());
						//print.println("				request method " + docHttpMethod.getHttpMethodName());
					}				
				}
			}
		} finally {
			if(print != null) {
				print.flush();
				print.close();
			}
		}
	}

	public static String getIndentJson(String body) throws JsonParseException, IOException {
		if(StringUtils.isBlank(body))
			return null;

		StringWriter out = new StringWriter();
		JsonParser parser = null;
		JsonGenerator gen = null;
		try {
			JsonFactory fac = new JsonFactory();

			parser = fac.createJsonParser(new StringReader(body));
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(parser);
			// Create pretty printer:
			gen = fac.createJsonGenerator(out);
			gen.useDefaultPrettyPrinter();
			// Write:
			mapper.writeTree(gen, node);

			gen.close();
			parser.close();

			return out.toString();

		} finally {
			out.close();
			if(gen != null) {
				gen.close();
			}
			if(parser != null) {
				parser.close();
			}
		}

	}

}
