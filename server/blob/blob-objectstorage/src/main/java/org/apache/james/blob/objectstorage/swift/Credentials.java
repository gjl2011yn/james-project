/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.blob.objectstorage.swift;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public final class Credentials {
    public static Credentials of(String value) {
        return new Credentials(value);
    }

    private final String credentials;

    private Credentials(String value) {
        Preconditions.checkArgument(
            !Strings.isNullOrEmpty(value),
            this.getClass().getSimpleName() + " cannot be null or empty");
        this.credentials = value;
    }

    public String value() {
        return credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Credentials) {
            Credentials that = (Credentials) o;
            return Objects.equal(credentials, that.credentials);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(credentials);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("credentials", credentials)
            .toString();
    }
}
