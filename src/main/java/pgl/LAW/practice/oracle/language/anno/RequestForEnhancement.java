package pgl.LAW.practice.oracle.language.anno;

/**
 * Describes the Request-for-Enhancement (RFE) annotation type.
 */
public @interface RequestForEnhancement {
    int id();
    String synopsis();
    String engineer() default "[unassigned]";
    String date() default "[unknown]";
}
