/*
 * Copyright (c) pakoito 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxsealedunions.generic;

import com.pacoworks.rxsealedunions.Union3;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

final class Union3Third<T, U, V> implements Union3<T, U, V> {
    private final V value;

    public Union3Third(V value) {
        this.value = value;
    }

    @Override
    public void continued(Consumer<T> continuationFirst, Consumer<U> continuationSecond,
            Consumer<V> continuationThird) {
        try {
            continuationThird.accept(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <R> R join(Function<T, R> mapFirst, Function<U, R> mapSecond, Function<V, R> mapThird) {
        try {
            return mapThird.apply(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Union3Third))
            return false;
        final Union3Third other = (Union3Third)o;
        final Object this$value = this.value;
        final Object other$value = other.value;
        return this$value == null ? other$value == null : this$value.equals(other$value);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $value = this.value;
        result = result * PRIME + ($value == null ? 0 : $value.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}