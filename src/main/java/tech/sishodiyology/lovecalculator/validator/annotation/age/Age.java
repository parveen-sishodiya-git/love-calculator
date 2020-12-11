/**
 * 
 */
package tech.sishodiyology.lovecalculator.validator.annotation.age;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Parveen Sishodiya
 *
 */

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeImpl.class)
public @interface Age {

	int min() default 18;

	int max() default 60;

	String message() default "{com.sishodiyology.validation.Age}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
