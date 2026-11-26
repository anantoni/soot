package soot.util;

/*-
 * #%L
 * Soot - a J*va Optimization Framework
 * %%
 * Copyright (C) 1997 - 2026 Raja Vallee-Rai and others
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * A {@link HashMultiMap} that iterates keys, the values of a key, and {@link #values()} in insertion order, so that
 * iterating it does not depend on the hash codes of its elements (identity hash codes differ from run to run).
 */
public class LinkedHashMultiMap<K, V> extends HashMultiMap<K, V> {

  private static final long serialVersionUID = 4920154163476130475L;

  public LinkedHashMultiMap() {
    super();
  }

  @Override
  protected Map<K, Set<V>> createMap(int initialSize) {
    return new LinkedHashMap<K, Set<V>>(initialSize, loadFactor);
  }

  @Override
  protected Set<V> newSet() {
    return new LinkedHashSet<V>(4);
  }

  @Override
  public Set<V> values() {
    Set<V> ret = new LinkedHashSet<V>(m.size());
    for (Set<V> s : m.values()) {
      ret.addAll(s);
    }
    return ret;
  }
}
