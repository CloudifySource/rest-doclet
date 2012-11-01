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
package org.cloudifysource.restDoclet.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * <p> Annotation to specify an example of a JSON response.<br />
 * Should be use within the REST's controllers above requestMapping methods 
 * to specify an example that will be shown in the REST API documentation.</p>
 * 
 * <p>For example:
 * <dd><code>JsonResponseExample(status = "success",
 *  responseBody = "{Json map content}", comments = "some comments")</code></p>
 * 
 * 
 * @author yael
 *
 */
@Target({ElementType.METHOD })
@Documented
public @interface JsonResponseExample {
	
	/**
	 * 
	 * The status.
	 * 
	 */
	String status();
	
	/**
	 * 
	 * The response.
	 */
	String responseBody() default "{}";
	
	/**
	 * 
	 * Comments to describe the response's body.
	 * 
	 */
	String comments() default "";
}
