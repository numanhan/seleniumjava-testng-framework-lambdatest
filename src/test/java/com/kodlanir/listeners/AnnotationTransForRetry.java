package com.kodlanir.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// TODO Annotation Transformer in Retry icin Onemine bak
// bu olmadan da calisiyordu. Bunu a listener gibi kabul edip xml e ekledik. : https://www.swtestacademy.com/extent-reports-in-selenium-with-testng/
public class AnnotationTransForRetry implements IAnnotationTransformer { // niye kullaniyoruz

        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            annotation.setRetryAnalyzer(Retry.class);
        }

}
