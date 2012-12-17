package org.cloudifysource.restDoclet.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 
 * <P>Annotation to specify that a method is internal method.
 * 
 * @author yael
 *
 */
@Target({ElementType.METHOD })
@Documented
public @interface InternalMethod {

}
