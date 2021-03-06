package org.ml_methods_group.marking.markers;


import org.ml_methods_group.common.Cluster;
import org.ml_methods_group.common.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

public class ManualClusterMarker extends AbstractManualMarker<Cluster<Solution>, String> {

    private final int elementsBound;

    public ManualClusterMarker(InputStream input, OutputStream output, int elementsBound) {
        super(input, output);
        this.elementsBound = elementsBound;
    }

    public ManualClusterMarker(int elementsBound) {
        super(System.in, System.out);
        this.elementsBound = elementsBound;
    }

    @Override
    protected String valueToString(Cluster<Solution> value) {
        final List<Solution> buffer = value.elementsCopy();
        Collections.shuffle(buffer);
        final StringBuilder builder = new StringBuilder();
        builder.append("Cluster: (Size: ").append(buffer.size()).append(")").append(System.lineSeparator());
        buffer.stream()
                .limit(elementsBound)
                .forEach(solution -> {
                    builder.append("Id: ").append(solution.getId()).append(System.lineSeparator());
                    builder.append(solution.getCode()).append(System.lineSeparator()).append(System.lineSeparator());
                });
        return builder.toString();
    }

    @Override
    protected String stringToMark(String token) {
        token = token.toLowerCase().trim();
        return "trash".equals(token) ? null : token;
    }
}
