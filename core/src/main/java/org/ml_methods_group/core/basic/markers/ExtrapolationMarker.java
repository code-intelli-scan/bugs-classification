package org.ml_methods_group.core.basic.markers;

import org.ml_methods_group.core.Marker;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExtrapolationMarker<V, M> implements Marker<List<V>, M> {

    private final Marker<V, M> marker;
    private final int bound;

    public ExtrapolationMarker(Marker<V, M> marker, int bound) {
        this.marker = marker;
        this.bound = bound;
    }

    @Override
    public M mark(List<V> cluster) {
        final List<M> tips = cluster.stream()
                .map(marker::mark)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= bound)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return tips.size() == 1 ? tips.get(0) : null;
    }
}