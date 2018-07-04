package org.ml_methods_group.core.changes;


public enum NodeType {
    NONE,
    ANONYMOUS_CLASS_DECLARATION,
    ARRAY_ACCESS,
    ARRAY_CREATION,
    ARRAY_INITIALIZER,
    ARRAY_TYPE,
    ASSERT_STATEMENT,
    ASSIGNMENT,
    BLOCK,
    BOOLEAN_LITERAL,
    BREAK_STATEMENT,
    CAST_EXPRESSION,
    CATCH_CLAUSE,
    CHARACTER_LITERAL,
    CLASS_INSTANCE_CREATION,
    COMPILATION_UNIT,
    CONDITIONAL_EXPRESSION,
    CONSTRUCTOR_INVOCATION,
    CONTINUE_STATEMENT,
    DO_STATEMENT,
    EMPTY_STATEMENT,
    EXPRESSION_STATEMENT,
    FIELD_ACCESS,
    FIELD_DECLARATION,
    FOR_STATEMENT,
    IF_STATEMENT,
    IMPORT_DECLARATION,
    INFIX_EXPRESSION,
    INITIALIZER,
    JAVADOC,
    LABELED_STATEMENT,
    METHOD_DECLARATION,
    METHOD_INVOCATION,
    NULL_LITERAL,
    NUMBER_LITERAL,
    PACKAGE_DECLARATION,
    PARENTHESIZED_EXPRESSION,
    POSTFIX_EXPRESSION,
    PREFIX_EXPRESSION,
    PRIMITIVE_TYPE,
    QUALIFIED_NAME,
    RETURN_STATEMENT,
    SIMPLE_NAME,
    SIMPLE_TYPE,
    SINGLE_VARIABLE_DECLARATION,
    STRING_LITERAL,
    SUPER_CONSTRUCTOR_INVOCATION,
    SUPER_FIELD_ACCESS,
    SUPER_METHOD_INVOCATION,
    SWITCH_CASE,
    SWITCH_STATEMENT,
    SYNCHRONIZED_STATEMENT,
    THIS_EXPRESSION,
    THROW_STATEMENT,
    TRY_STATEMENT,
    TYPE_DECLARATION,
    TYPE_DECLARATION_STATEMENT,
    TYPE_LITERAL,
    VARIABLE_DECLARATION_EXPRESSION,
    VARIABLE_DECLARATION_FRAGMENT,
    VARIABLE_DECLARATION_STATEMENT,
    WHILE_STATEMENT,
    INSTANCEOF_EXPRESSION,
    LINE_COMMENT,
    BLOCK_COMMENT,
    TAG_ELEMENT,
    TEXT_ELEMENT,
    MEMBER_REF,
    METHOD_REF,
    METHOD_REF_PARAMETER,
    ENHANCED_FOR_STATEMENT,
    ENUM_DECLARATION,
    ENUM_CONSTANT_DECLARATION,
    TYPE_PARAMETER,
    PARAMETERIZED_TYPE,
    QUALIFIED_TYPE,
    WILDCARD_TYPE,
    NORMAL_ANNOTATION,
    MARKER_ANNOTATION,
    SINGLE_MEMBER_ANNOTATION,
    MEMBER_VALUE_PAIR,
    ANNOTATION_TYPE_DECLARATION,
    ANNOTATION_TYPE_MEMBER_DECLARATION,
    MODIFIER,
    UNION_TYPE,
    DIMENSION,
    LAMBDA_EXPRESSION,
    INTERSECTION_TYPE,
    NAME_QUALIFIED_TYPE,
    CREATION_REFERENCE,
    EXPRESSION_METHOD_REFERENCE,
    SUPER_METHOD_REFERENCE,
    TYPE_METHOD_REFERENCE;

    private static final NodeType[] buffer = values();

    public static NodeType valueOf(int value) {
        return buffer[value];
    }
}
