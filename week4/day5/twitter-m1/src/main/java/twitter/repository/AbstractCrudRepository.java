/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sam Brannen
 */
public abstract class AbstractCrudRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {

	private final Map<ID, T> database = new HashMap<>();

	@Override
	public void save(T entity, ID id) {
		this.database.put(id, entity);
	}

	@Override
	public T findById(ID id) {
		return this.database.get(id);
	}

	@Override
	public List<T> findAll() {
		return new ArrayList<>(this.database.values());
	}

	@Override
	public void deleteById(ID id) {
		this.database.remove(id);
	}

	@Override
	public void deleteAll() {
		this.database.clear();
	}

}
