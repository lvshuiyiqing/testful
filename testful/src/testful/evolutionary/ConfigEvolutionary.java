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

package testful.evolutionary;

import java.io.File;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;

import testful.ConfigGeneration;
import testful.IConfigCut;
import testful.IConfigGeneration;
import testful.IConfigProject;
import testful.TestfulException;

/**
 * Contains the information required to run Testful.
 * @author matteo
 */
public class ConfigEvolutionary implements IConfigEvolutionary, IConfigFitness.Args4j, IConfigGeneration.Args4j, IConfigCut.Args4j, IConfigProject.Args4j {

	private final IConfigGeneration.Args4j configGenerator = new ConfigGeneration();
	private final IConfigFitness.Args4j configFitness = new ConfigFitness();

	@Option(required = false, name = "-localSearchPeriod", usage = "Period of the local search (default: every 20 generations; <= 0 to disable local search)")
	private int localSearchPeriod = 5;

	@Option(required = false, name = "-localSearchElements", usage = "% of elements on which the local search is applied (0 to consider the whole fronteer, 100 to enhance all the elements in the population)")
	private int localSearchElements = 0;

	@Option(required = false, name = "-popSize", usage = "The size of the population (# of individuals)")
	private int popSize = 128;

	@Option(required = false, name = "-fitnessInheritance", usage = "Select the type of fitness inheritance")
	private FitnessInheritance fitnessInheritance = FitnessInheritance.UNIFORM;

	@Option(required = false, name = "-randomSeeding", usage = "Use Random Search to seed the initial population")
	private int randomSeeding = 60;

	@Option(required = false, name ="-seed", usage = "Set the seed of the random number generator")
	private long seed = System.currentTimeMillis();

	@Override
	public int getLocalSearchPeriod() {
		return localSearchPeriod;
	}

	public void setLocalSearchPeriod(int localSearchPeriod) {
		this.localSearchPeriod = localSearchPeriod;
	}

	@Override
	public int getLocalSearchElements() {
		return localSearchElements;
	}

	@Override
	public int getPopSize() {
		return popSize;
	}

	public void setPopSize(int popSize) {
		this.popSize = popSize;
	}

	@Override
	public FitnessInheritance getFitnessInheritance() {
		return fitnessInheritance;
	}

	public void setFitnessInheritance(FitnessInheritance fitnessInheritance) {
		this.fitnessInheritance = fitnessInheritance;
	}

	@Override
	public int getRandomSeeding() {
		return randomSeeding;
	}

	@Override
	public File getDirBase() {
		return configGenerator.getDirBase();
	}

	@Override
	public String getCut() {
		return configGenerator.getCut();
	}

	@Override
	public boolean isReloadClasses() {
		return configGenerator.isReloadClasses();
	}

	@Override
	public File getDirSource() {
		return configGenerator.getDirSource();
	}

	@Override
	public File getDirCompiled() {
		return configGenerator.getDirCompiled();
	}

	@Override
	public List<File> getLibraries() {
		return configGenerator.getLibraries();
	}

	@Override
	public File getDirGeneratedTests() {
		return configGenerator.getDirGeneratedTests();
	}

	@Override
	public int getTime() {
		return configGenerator.getTime();
	}

	/**
	 * Returns the seed to use in the random number generator
	 * @return the seed to use in the random number generator
	 */
	@Override
	public long getSeed() {
		return seed;
	}

	@Override
	public File getDirInstrumented() {
		return configGenerator.getDirInstrumented();
	}

	@Override
	public int getNumVar() {
		return configGenerator.getNumVar();
	}

	@Override
	public int getNumVarCut() {
		return configGenerator.getNumVarCut();
	}

	@Override
	public void setDirBase(File dirBase) {
		configGenerator.setDirBase(dirBase);
	}

	@Override
	public int getMaxTestLen() {
		return configGenerator.getMaxTestLen();
	}

	@Override
	public void setDirSource(File dirSource) {
		configGenerator.setDirSource(dirSource);
	}

	@Override
	public void setCut(String cut) throws TestfulException {
		configGenerator.setCut(cut);
	}

	@Override
	public void setReloadClasses(boolean reloadClasses) {
		configGenerator.setReloadClasses(reloadClasses);
	}

	@Override
	public void setDirCompiled(File dirCompiled) {
		configGenerator.setDirCompiled(dirCompiled);
	}

	@Override
	public void addLibrary(File library) {
		configGenerator.addLibrary(library);
	}

	@Override
	public void setDirGeneratedTests(File dirGeneratedTests) {
		configGenerator.setDirGeneratedTests(dirGeneratedTests);
	}

	@Override
	public void setTime(int time) {
		configGenerator.setTime(time);
	}

	/**
	 * Set the seed to use in the random number generator
	 * @param seed the seed to use in the random number generator
	 */
	public void setSeed(long seed) {
		this.seed = seed;
	}

	@Override
	public void setDirInstrumented(File dirInstrumented) {
		configGenerator.setDirInstrumented(dirInstrumented);
	}

	@Override
	public void setNumVar(int numVar) {
		configGenerator.setNumVar(numVar);
	}

	@Override
	public void setNumVarCut(int numVarCut) {
		configGenerator.setNumVarCut(numVarCut);
	}

	@Override
	public void setMaxTestLen(int maxTestLen) {
		configGenerator.setMaxTestLen(maxTestLen);
	}

	public void setRandomSeeding(int seedingRandom) {
		randomSeeding = seedingRandom;
	}

	// --------------- fitness -----------------------

	@Override
	public boolean isBasicBlock() {
		return configFitness.isBasicBlock();
	}

	@Override
	public void setDisableBasicBlock(boolean disable) {
		configFitness.setDisableBasicBlock(disable);
	}

	@Override
	public boolean isBranch() {
		return configFitness.isBranch();
	}

	@Override
	public void setDisableBranch(boolean disable) {
		configFitness.setDisableBranch(disable);
	}

	@Override
	public boolean isDefUse() {
		return configFitness.isDefUse();
	}

	@Override
	public void setDisableDefUse(boolean disable) {
		configFitness.setDisableDefUse(disable);
	}

	@Override
	public boolean isBehavioral() {
		return configFitness.isBehavioral();
	}

	@Override
	public void setBehavioral(boolean disable) {
		configFitness.setBehavioral(disable);
	}

	// --------------- validate -----------------------

	/* (non-Javadoc)
	 * @see testful.IConfig#validate()
	 */
	@Override
	public void validate() throws CmdLineException {
		// everything is ok!
	}
}
