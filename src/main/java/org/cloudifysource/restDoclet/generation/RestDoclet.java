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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.cloudifysource.restDoclet.constants.RestDocConstants;

import com.sun.javadoc.Doclet;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.RootDoc;

/**
 * 
 * @author yael
 *
 */
public class RestDoclet extends Doclet {
	private static final Logger logger = Logger.getLogger(RestDoclet.class
			.getName());

	/**
	 * 
	 * @param root .
	 * @return true on success. 
	 */
	public static boolean start(final RootDoc root) {
		try {
			new Generator(root).run();
			logger.info(
					"REST API documentation was successfully generated");
			return true;
		} catch (Exception e) {
			logger.log(
					Level.SEVERE,
					"Failed to generate REST API documentation.");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param option .
	 * @return The number of separate pieces or tokens in the option.
	 */
	public static int optionLength(final String option) {
		if (RestDocConstants.VELOCITY_TEMPLATE_PATH_FLAG.equals(option)
				|| RestDocConstants.DOC_DEST_PATH_FLAG.equals(option)
				|| RestDocConstants.VERSION_FLAG.equals(option)
				|| RestDocConstants.DOC_CSS_PATH_FLAG.equals(option)
				|| RestDocConstants.REQUEST_EXAMPLE_GENERATOR_CLASS_FLAG.equals(option)
				|| RestDocConstants.RESPONSE_EXAMPLE_GENERATOR_CLASS_FLAG.equals(option)
				|| RestDocConstants.REQUEST_BODY_PARAM_FILTER_CLASS_FLAG.equals(option)) {
			return 2;
		}
		return 0;
	}
	
	/**
	    * NOTE: Without this method present and returning LanguageVersion.JAVA_1_5,
	    *       Javadoc will not process generics because it assumes LanguageVersion.JAVA_1_1.
	    * @return language version (hard coded to LanguageVersion.JAVA_1_5)
	    */
	   public static LanguageVersion languageVersion() {
	      return LanguageVersion.JAVA_1_5;
	   }

}
