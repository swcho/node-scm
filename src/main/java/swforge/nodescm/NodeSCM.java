package swforge.nodescm;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.Util;
import hudson.model.BuildListener;
import hudson.model.TaskListener;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Descriptor.FormException;
import hudson.scm.ChangeLogParser;
import hudson.scm.PollingResult;
import hudson.scm.SCMDescriptor;
import hudson.scm.SCMRevisionState;
import hudson.scm.SCM;

public class NodeSCM extends SCM {

	private static Logger log = Logger.getLogger(NodeSCM.class.getName());
	private final String nodeLabel;
	private final String command;
	
	@DataBoundConstructor
	public NodeSCM(String nodeLabel, String command) {
		this.nodeLabel = nodeLabel;
		this.command = command;
		log.fine("nodeLabel = " + nodeLabel);
		log.fine("command = " + command);
	}
	
	public String getNodeLabel() {
		return nodeLabel;
	}
	
	public String getCommand() {
		return command;
	}
	
	@Override
	public SCMRevisionState calcRevisionsFromBuild(AbstractBuild<?, ?> build,
			Launcher launcher, TaskListener listener) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PollingResult compareRemoteRevisionWith(
			AbstractProject<?, ?> project, Launcher launcher,
			FilePath workspace, TaskListener listener, SCMRevisionState baseline)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkout(AbstractBuild<?, ?> build, Launcher launcher,
			FilePath workspace, BuildListener listener, File changelogFile)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChangeLogParser createChangeLogParser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Extension
	public static final class DescriptorImpl extends SCMDescriptor<NodeSCM> {

		private String tfExecutable;
		
		public DescriptorImpl() {
			super(NodeSCM.class, null);
			load();
		}

		@Override
		public String getDisplayName() {
			return "Node SCM";
		}

		@Override
		public boolean configure(StaplerRequest req, JSONObject json)
				throws FormException {
			tfExecutable = Util.fixEmpty(req.getParameter("tfs.tfExecutable").trim());
			return super.configure(req, json);
		}
		
	}

}
