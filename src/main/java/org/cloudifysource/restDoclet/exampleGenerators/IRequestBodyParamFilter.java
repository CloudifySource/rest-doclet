package org.cloudifysource.restDoclet.exampleGenerators;

import org.cloudifysource.restDoclet.docElements.DocHttpMethod;
import org.cloudifysource.restDoclet.docElements.DocParameter;

/**
 */
public interface IRequestBodyParamFilter {

	/**
	 * 
	 * @param httpMethod The HTTP method.
	 * @param param The parameter.
	 * @return true iff the parameter transforms in request body of the given httpMethod.
	 */
	boolean filter(DocHttpMethod httpMethod, DocParameter param);
}
