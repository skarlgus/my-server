package com.kh.server.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collections;
import java.util.*;

@Slf4j
//@Component
public class DecryptFormatter implements AnnotationFormatterFactory<DeCrypt> {
    final String message;

    public DecryptFormatter (String message){
        this.message = message;
    }

    public static final Set<Class<?>> STANDARD_CRYPTO_TYPE;

    static {
        Set<Class<?>> cryptoTypes = new HashSet<>(3);
        cryptoTypes.add(String.class);
        cryptoTypes.add(Object.class);
        STANDARD_CRYPTO_TYPE = Collections.unmodifiableSet(cryptoTypes);
    }

    @Override
    public Set<Class<?>> getFieldTypes () {
        return STANDARD_CRYPTO_TYPE;
        //return Collections.singleton(String.class);
    }

    @Override
    public Printer<?> getPrinter (DeCrypt annotation, Class<?> fieldType) {
        return configureFormatterFrom(annotation,fieldType);
    }

    @Override
    public Parser<?> getParser (DeCrypt annotation, Class<?> fieldType) {
        return configureFormatterFrom(annotation,fieldType);
    }

    private Formatter<String> configureFormatterFrom(DeCrypt annotation, Class<?> fieldType) {
        return 	new cryptoFormatter(annotation,fieldType);
    }

    class cryptoFormatter implements Formatter<String> {

        DeCrypt annotation;
        Class<?> fieldType;

        cryptoFormatter(DeCrypt annotation, Class<?> fieldType){
            this.annotation = annotation;
            this.fieldType = fieldType;
        }
        @Override
        public String parse (String text, Locale locale) throws ParseException {
            String decryptStr = null;

            //복호화 로직 진행
            decryptStr = "decryptStr";

            return decryptStr;
        }

        @Override
        public String print (String object, Locale locale) {
            String decryptStr = null;

            //복호화 로직 진행
            decryptStr = "decryptStr";

            return decryptStr;
        }

    }
}
