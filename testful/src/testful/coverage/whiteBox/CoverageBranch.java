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

package testful.coverage.whiteBox;

import java.util.BitSet;

import testful.coverage.BitSetCoverage;
import testful.coverage.CoverageInformation;

public class CoverageBranch extends BitSetCoverage {
	private static final long serialVersionUID = 1841450132658247037L;

	public static String KEY = "br";
	public static String NAME = "Branch Coverage";

	private final String key;
	private final String name;

	private CoverageBranch(String key, String name) {
		super();
		this.key = key;
		this.name = name;
	}

	CoverageBranch(String key, String name, BitSet coverage) {
		super(coverage);
		this.key = key;
		this.name = name;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CoverageInformation createEmpty() {
		return new CoverageBranch(key, name);
	}

	@Override
	public CoverageBranch clone() throws CloneNotSupportedException {
		return new CoverageBranch(key, name, (BitSet) coverage.clone());
	}
}
