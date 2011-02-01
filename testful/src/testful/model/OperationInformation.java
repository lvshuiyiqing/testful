/*
 * TestFul - http://code.google.com/p/testful/
 * Copyright (C) 2010  Matteo Miraz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package testful.model;

import java.io.Serializable;

import testful.utils.ElementWithKey;

/**
 * Attach some information to operations.
 * These information are only available at design-time,
 * unless the {@link ExecutorSerializer} explicitly serializes them.
 * @author matteo
 */
public abstract class OperationInformation implements ElementWithKey<String>, Serializable {

	private static final long serialVersionUID = -62965317854987267L;

	private final String key;

	public OperationInformation(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public abstract OperationInformation clone();
}
