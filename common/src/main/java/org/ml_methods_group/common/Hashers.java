package org.ml_methods_group.common;

import org.ml_methods_group.common.ast.NodeType;
import org.ml_methods_group.common.ast.changes.ChangeType;
import org.ml_methods_group.common.ast.changes.CodeChange;
import org.ml_methods_group.common.ast.changes.CodeChange.NodeContext;
import org.ml_methods_group.common.ast.changes.CodeChange.NodeState;
import org.ml_methods_group.common.extractors.HashExtractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hashers {

    public static final HashExtractor<ChangeType> CHANGE_TYPE_HASH = HashExtractor.<ChangeType>builder()
            .append("CT")
            .hashComponent(ChangeType::ordinal)
            .build();
    public static final HashExtractor<NodeType> NODE_TYPE_HASH = HashExtractor.<NodeType>builder()
            .append("NT")
            .hashComponent(NodeType::ordinal)
            .build();
    public static final HashExtractor<NodeState> TYPE_ONLY_NODE_STATE_HASH = HashExtractor.<NodeState>builder()
            .append("TOS")
            .hashComponent(NodeState::getType, NODE_TYPE_HASH)
            .build();
    public static final HashExtractor<NodeState> LABEL_NODE_STATE_HASH = HashExtractor.<NodeState>builder()
            .append("LNS")
            .hashComponent(NodeState::getType, NODE_TYPE_HASH)
            .hashComponent(NodeState::getLabel)
            .build();
    public static final HashExtractor<NodeState> JAVA_TYPE_NODE_STATE_HASH = HashExtractor.<NodeState>builder()
            .append("JNS")
            .hashComponent(NodeState::getType, NODE_TYPE_HASH)
            .hashComponent(NodeState::getJavaType)
            .build();
    public static final HashExtractor<NodeState> FULL_NODE_STATE_HASH = HashExtractor.<NodeState>builder()
            .append("FNS")
            .hashComponent(NodeState::getType, NODE_TYPE_HASH)
            .append(Character.toString(31))
            .hashComponent(NodeState::getLabel)
            .append(Character.toString(31))
            .hashComponent(NodeState::getJavaType)
            .build();
    public static final HashExtractor<NodeContext> weak = HashExtractor.<NodeContext>builder()
            .append("TOC")
            .hashComponent(NodeContext::getNode, TYPE_ONLY_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParent, TYPE_ONLY_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParentOfParent, TYPE_ONLY_NODE_STATE_HASH)
            .build();
    public static final HashExtractor<NodeContext> javaTypes = HashExtractor.<NodeContext>builder()
            .append("JTC")
            .hashComponent(NodeContext::getNode, JAVA_TYPE_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParent, TYPE_ONLY_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParentOfParent, TYPE_ONLY_NODE_STATE_HASH)
            .build();
    public static final HashExtractor<NodeContext> full = HashExtractor.<NodeContext>builder()
            .append("FCC")
            .hashComponent(NodeContext::getNode, FULL_NODE_STATE_HASH)
            .append(Character.toString(31))
            .hashComponent(NodeContext::getParent, TYPE_ONLY_NODE_STATE_HASH)
            .append(Character.toString(31))
            .hashComponent(NodeContext::getParentOfParent, TYPE_ONLY_NODE_STATE_HASH)
            .build();
    public static final HashExtractor<NodeContext> extended = HashExtractor.<NodeContext>builder()
            .append("ECC")
            .hashComponent(NodeContext::getNode, JAVA_TYPE_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParent, LABEL_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParentOfParent, TYPE_ONLY_NODE_STATE_HASH)
            .build();
    public static final HashExtractor<NodeContext> fullExtended = HashExtractor.<NodeContext>builder()
            .append("FEC")
            .hashComponent(NodeContext::getNode, FULL_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParent, LABEL_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParentOfParent, TYPE_ONLY_NODE_STATE_HASH)
            .build();
    public static final HashExtractor<NodeContext> deepExtended = HashExtractor.<NodeContext>builder()
            .append("DEC")
            .hashComponent(NodeContext::getNode, JAVA_TYPE_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParent, LABEL_NODE_STATE_HASH)
            .hashComponent(NodeContext::getParentOfParent, LABEL_NODE_STATE_HASH)
            .build();

    public static HashExtractor<CodeChange> getCodeChangeHasher(HashExtractor<NodeContext> hasher) {
        return HashExtractor.<CodeChange>builder()
                .append("CCE")
                .hashComponent(CodeChange::getChangeType, CHANGE_TYPE_HASH)
                .append(Character.toString(31))
                .hashComponent(CodeChange::getOriginalContext, hasher)
                .append(Character.toString(31))
                .hashComponent(CodeChange::getDestinationContext, hasher)
                .build();
    }

    public static final List<HashExtractor<CodeChange>> hashers = Arrays.asList(getCodeChangeHasher(weak),
            getCodeChangeHasher(javaTypes), getCodeChangeHasher(full), getCodeChangeHasher(extended),
            getCodeChangeHasher(fullExtended), getCodeChangeHasher(deepExtended));
}
