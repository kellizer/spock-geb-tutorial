package com.spockgeb.tutorial

import spock.lang.Specification

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class IncludeExcludeExtensionSpec extends Specification {
    static {
//        System.setProperty "spock.configuration", "IncludeFastConfig.groovy"

        // Alternatively, try this:
        System.setProperty "spock.configuration", "ExcludeSlowConfig.groovy"
    }

    @Fast
    def "a fast method"() {
        expect: true
    }

    @Slow
    def "a slow method"() {
        expect: true
    }

    def "a neither fast nor slow method"() {
        expect: true
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Fast {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Slow {}
