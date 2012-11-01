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
/**
 * 
 * This package contains all the extra annotations needed for creating the REST API documentation:
 * <ol>
 * <li> {@link org.cloudifysource.restDoclet.annotations.JsonRequestExample} - an example for Json request,
 * the request that is sent to the annotated HTTP method.</li>
 * <li> {@link org.cloudifysource.restDoclet.annotations.JsonResponseExample} - an example for Json response, 
 * the response of the annotated HTTP method.</li>
 * <li> {@link org.cloudifysource.restDoclet.annotations.PossibleResponseStatuses} - a list of
 * {@link org.cloudifysource.restDoclet.annotations.PossibleResponseStatus} annotations.<br />
 * Each PossibleResponseStatus annotation in the list describes a response status (code and description) 
 * that might be returned as the response status of the annotated HTTP method.</li>
 * </ol>
 * 
 * @author yael
 *
 */
package org.cloudifysource.restDoclet.annotations;