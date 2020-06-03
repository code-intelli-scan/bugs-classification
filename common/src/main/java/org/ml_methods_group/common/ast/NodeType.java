package org.ml_methods_group.common.ast;


import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public enum NodeType {
    NONE(0),
    ANONYMOUS_CLASS_DECLARATION(1),
    ARRAY_ACCESS(2),
    ARRAY_CREATION(3),
    ARRAY_INITIALIZER(4),
    ARRAY_TYPE(5),
    ASSERT_STATEMENT(6),
    ASSIGNMENT(7),
    BLOCK(8),
    BOOLEAN_LITERAL(9),
    BREAK_STATEMENT(10),
    CAST_EXPRESSION(11),
    CATCH_CLAUSE(12),
    CHARACTER_LITERAL(13),
    CLASS_INSTANCE_CREATION(14),
    COMPILATION_UNIT(15),
    CONDITIONAL_EXPRESSION(16),
    CONSTRUCTOR_INVOCATION(17),
    CONTINUE_STATEMENT(18),
    DO_STATEMENT(19),
    EMPTY_STATEMENT(20),
    EXPRESSION_STATEMENT(21),
    FIELD_ACCESS(22),
    FIELD_DECLARATION(23),
    FOR_STATEMENT(24),
    IF_STATEMENT(25),
    IMPORT_DECLARATION(26),
    INFIX_EXPRESSION(27),
    INITIALIZER(28),
    JAVADOC(29),
    LABELED_STATEMENT(30),
    METHOD_DECLARATION(31),
    METHOD_INVOCATION(32),
    NULL_LITERAL(33),
    NUMBER_LITERAL(34),
    PACKAGE_DECLARATION(35),
    PARENTHESIZED_EXPRESSION(36),
    POSTFIX_EXPRESSION(37),
    PREFIX_EXPRESSION(38),
    PRIMITIVE_TYPE(39),
    QUALIFIED_NAME(40),
    RETURN_STATEMENT(41),
    SIMPLE_NAME(42),
    SIMPLE_TYPE(43),
    SINGLE_VARIABLE_DECLARATION(44),
    STRING_LITERAL(45),
    SUPER_CONSTRUCTOR_INVOCATION(46),
    SUPER_FIELD_ACCESS(47),
    SUPER_METHOD_INVOCATION(48),
    SWITCH_CASE(49),
    SWITCH_STATEMENT(50),
    SYNCHRONIZED_STATEMENT(51),
    THIS_EXPRESSION(52),
    THROW_STATEMENT(53),
    TRY_STATEMENT(54),
    TYPE_DECLARATION(55),
    TYPE_DECLARATION_STATEMENT(56),
    TYPE_LITERAL(57),
    VARIABLE_DECLARATION_EXPRESSION(58),
    VARIABLE_DECLARATION_FRAGMENT(59),
    VARIABLE_DECLARATION_STATEMENT(60),
    WHILE_STATEMENT(61),
    INSTANCEOF_EXPRESSION(62),
    LINE_COMMENT(63),
    BLOCK_COMMENT(64),
    TAG_ELEMENT(65),
    TEXT_ELEMENT(66),
    MEMBER_REF(67),
    METHOD_REF(68),
    METHOD_REF_PARAMETER(69),
    ENHANCED_FOR_STATEMENT(70),
    ENUM_DECLARATION(71),
    ENUM_CONSTANT_DECLARATION(72),
    TYPE_PARAMETER(73),
    PARAMETERIZED_TYPE(74),
    QUALIFIED_TYPE(75),
    WILDCARD_TYPE(76),
    NORMAL_ANNOTATION(77),
    MARKER_ANNOTATION(78),
    SINGLE_MEMBER_ANNOTATION(79),
    MEMBER_VALUE_PAIR(80),
    ANNOTATION_TYPE_DECLARATION(81),
    ANNOTATION_TYPE_MEMBER_DECLARATION(82),
    MODIFIER(83),
    UNION_TYPE(84),
    DIMENSION(85),
    LAMBDA_EXPRESSION(86),
    INTERSECTION_TYPE(87),
    NAME_QUALIFIED_TYPE(88),
    CREATION_REFERENCE(89),
    EXPRESSION_METHOD_REFERENCE(90),
    SUPER_METHOD_REFERENCE(91),
    TYPE_METHOD_REFERENCE(92),
    // My own nodes
    MY_MEMBER_NAME(93),
    MY_VARIABLE_NAME(94),
    MY_PATH_NAME(95),
    MY_ALL_CLASSES(96),
    MY_METHOD_INVOCATION_ARGUMENTS(97),

    // srcML
    C_UNIT(3594628),
    C_FUNCTION(1380938712),
    C_NAME(3373707),
    C_BLOCK(93832333),
    C_EXPR(3127797),
    C_TYPE(3575610),
    C_BLOCK_CONTENT(1384891079),
    C_PARAMETER_LIST(1133090676),
    C_RETURN(-934396624),
    C_LITERAL(182460591),
    C_CALL(3045982),
    C_ARGUMENT_LIST(-40060704),
    C_INIT(3237136),
    C_DECL(3079338),
    C_INCR(3236948),
    C_FOR(101577),
    C_DECL_STMT(425139773),
    C_CONTROL(951543133),
    C_EXPR_STMT(490731474),
    C_OPERATOR(-500553564),
    C_CONDITION(-861311717);

    private int id = 0;

    public final String humanReadableName;

    private static Map<Integer, NodeType> buffer = null;

    private NodeType(int id) {
        this();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    NodeType() {
        final StringBuilder builder = new StringBuilder();
        boolean wordStart = true;
        for (char c : name().toCharArray()) {
            if (c == '_') {
                wordStart = true;
            } else {
                builder.append(wordStart ? Character.toUpperCase(c) : Character.toLowerCase(c));
                wordStart = false;
            }
        }
        humanReadableName = builder.toString();
    }

    public static NodeType valueOf(int id) {
        // not thread-safe
        if (buffer == null) {
            buffer = Arrays.stream(values()).collect(Collectors.toMap(NodeType::getId, x -> x));

        }

        if (id == -1) return null;

        if (buffer.containsKey(id)) return buffer.get(id);

        throw new InvalidParameterException("Found a NodeType id=" + id + " which is not added to a map");
    }
}
