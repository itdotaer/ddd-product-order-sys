package com.itdotaer.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegionValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Region {
    String[] value() default "tw";
    String message() default "Not supported region";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
