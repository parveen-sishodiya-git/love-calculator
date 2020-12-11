package tech.sishodiyology.lovecalculator.validator.annotation.username;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.GroupSequence;
import javax.validation.Payload;

import com.sun.mail.handlers.message_rfc822;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = UsernameImpl.class)
public @interface Username {

	String message() default "Username Invalid | Default Message";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
