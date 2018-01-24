/**************************************************
 * Copyright (c) pure-systems GmbH 
 * All rights reserved. 
 **************************************************/
package lyoIssue526717.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.lyo.oslc4j.core.model.Publisher;

public interface ServiceAPI {

  
  @GET
  @Produces("application/rdf+xml")
  public Publisher getPublisher();
}
