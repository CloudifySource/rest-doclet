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
 * Defines multiple {@link PossibleResponseStatus} annotations for a single object property.<br />
 * Should be use within the REST's controllers above requestMapping methods 
 * to specify the possible status responses that will be shown in the REST API documentation. 
 *  
 * <p>For example:
 * <dd><code>PossibleResponseStatuses{PossibleResponseStatus(code = 200, description = "success")
 * , PossibleResponseStatus(code = 500, description = "error")}</code></p>
 * 
 * @author yael
 *
 */
@Target({ElementType.METHOD })
@Documented
public @interface PossibleResponseStatuses {
	PossibleResponseStatus[] responseStatuses();
	
}
