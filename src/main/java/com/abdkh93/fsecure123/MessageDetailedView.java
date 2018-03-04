package com.abdkh93.fsecure123;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.glassfish.jersey.internal.inject.AnnotationLiteral;
import org.glassfish.jersey.message.filtering.EntityFiltering;

// Factory decides how to construct view for messages based on annotations on the data members
// If version 1 of REST API for listing message service then no Url provided in messages
// otherwise all data members provided from the Message object

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EntityFiltering
public @interface MessageDetailedView {

    public static class Factory extends AnnotationLiteral<MessageDetailedView> implements MessageDetailedView {

        private Factory() {
        }

        public static MessageDetailedView get() {
            return new Factory();
        }
    }
}
