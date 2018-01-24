package lyoIssue526717;

import java.util.Hashtable;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.lyo.oslc4j.provider.jena.OslcRdfXmlArrayProvider;
import org.eclipse.lyo.oslc4j.provider.jena.OslcRdfXmlCollectionProvider;
import org.eclipse.lyo.oslc4j.provider.jena.OslcRdfXmlProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import lyoIssue526717.api.ServiceAPI;
import lyoIssue526717.impl.ServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		Server server = new Server();
		// do any setup on Server in here
		// String serverName = "lyo";
		// Dictionary<String, String> serverProps = new Hashtable<String,
		// String>();
		// //define the unique name of the server instance
		// serverProps.put("managedServerName", serverName);
		// serverProps.put("jetty.http.port", "8080");
		// serverProps.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN,
		// "/*");
		//
		// //let Jetty apply some configuration files to the Server instance
		// serverProps.put("jetty.etc.config.urls",
		// "file:/opt/jetty/etc/jetty.xml,file:/opt/jetty/etc/jetty-selector.xml,file:/opt/jetty/etc/jetty-deployer.xml");
		//
		//// server.
		//
		// //register as an OSGi Service for Jetty to find
		// context.registerService(Server.class.getName(), server, serverProps);
		//

		//
		Hashtable<String, Object> props = new Hashtable<>();
		props.put(HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN, "/*");
		context.registerService(
				Servlet.class, new ServletContainer(new ResourceConfig(ServiceAPI.class, ServiceImpl.class,
						OslcRdfXmlProvider.class, OslcRdfXmlCollectionProvider.class, OslcRdfXmlArrayProvider.class)),
				props);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
