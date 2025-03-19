
package acme.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.Length;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRegistrationNumberValidator.class)
@Length(min = 1, max = 255)
public @interface ValidRegistrationNumber {

	String message() default "Registration number must be unique";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
