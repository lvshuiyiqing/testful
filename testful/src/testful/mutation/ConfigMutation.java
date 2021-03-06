package testful.mutation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import testful.ConfigProject;
import testful.IConfigProject;

public class ConfigMutation extends ConfigProject implements IConfigProject.Args4j {

	public ConfigMutation() {
		setDirInstrumented(new File("mutants"));
	}

	@Option(required = false, name = "-generateMutant", usage = "Generate mutants for this class", multiValued = true, metaVar = "full.qualified.ClassName")
	private List<String> genMutant = new ArrayList<String>();

	public List<String> getGenMutant() {
		return genMutant;
	}

	@Option(required = false, name = "-disableTrack", usage = "When generating mutants, disable the track of excuted mutants")
	private boolean disableTrack;

	@Option(required = false, name = "-reload", usage = "Reload classes before each run (reinitialize static fields)")
	private boolean reloadClasses;

	/**
	 * Returns whether or not I have to reload classes before each run (reinitialize static fields)
	 */
	public boolean isReloadClasses() {
		return reloadClasses;
	}

	public boolean isTrack() {
		return !disableTrack;
	}

	@Option(required = false, name = "-disableAbs", usage = "When generating mutants, disable ABS")
	private boolean disableAbs;

	public boolean isAbs() {
		return !disableAbs;
	}

	@Option(required = false, name = "-disableAor", usage = "When generating mutants, disable AOR")
	private boolean disableAor;

	public boolean isAor() {
		return !disableAor;
	}

	@Option(required = false, name = "-disableLcr", usage = "When generating mutants, disable LCR")
	private boolean disableLcr;

	public boolean isLcr() {
		return !disableLcr;
	}

	@Option(required = false, name = "-disableRor", usage = "When generating mutants, disable ROR")
	private boolean disableRor;

	public boolean isRor() {
		return !disableRor;
	}

	@Option(required = false, name = "-disableUoi", usage = "When generating mutants, disable UOI")
	private boolean disableUoi;

	public boolean isUoi() {
		return !disableUoi;
	}

	@Argument(usage="Tests to run")
	private List<String> arguments = new ArrayList<String>();
	public List<String> getArguments() {
		return arguments;
	}
}

