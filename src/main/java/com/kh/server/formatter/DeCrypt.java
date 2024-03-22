package com.kh.server.formatter;

//import jakarta.validation.Payload;
//import javax.validation.Payload;

//import jakarta.validation.Payload;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(DeCrypt.List.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface DeCrypt {

    String message() default "Crypto error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public static @interface List {
        DeCrypt[] value();
    }
}
