/**
 * Copyright (c) 2014,2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.core.items;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.core.common.registry.Identifiable;

/**
 * This is a data class for storing meta-data for a given item and namespace.
 * It is the entity used for within the {@link MetadataRegistry}.
 *
 * @author Kai Kreuzer - Initial contribution and API
 *
 */
@NonNullByDefault
public final class Metadata implements Identifiable<MetadataKey> {

    private final MetadataKey key;
    private final String value;
    private final Map<String, Object> configuration;

    public Metadata(MetadataKey key, String value, @Nullable Map<String, Object> configuration) {
        this.key = key;
        this.value = value;
        this.configuration = configuration != null ? Collections.unmodifiableMap(new HashMap<>(configuration))
                : Collections.emptyMap();
    }

    @Override
    public MetadataKey getUID() {
        return key;
    }

    /**
     * Provides the configuration meta-data.
     *
     * @return configuration as a map of key-value pairs
     */
    public Map<String, Object> getConfiguration() {
        return configuration;
    }

    /**
     * Provides the main value of the meta-data.
     *
     * @return the main meta-data as a string
     */
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + key.hashCode();
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Metadata other = (Metadata) obj;
        if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

}
