/**************************************************
 * Copyright (c) pure-systems GmbH 
 * All rights reserved. 
 **************************************************/
package lyoIssue526717.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.lyo.oslc4j.core.model.Publisher;

import lyoIssue526717.api.ServiceAPI;

@Path("publisher")
public class ServiceImpl implements ServiceAPI {
//public class ServiceImpl {

  @Override
//  @GET
//  @Produces("application/rdf+xml")
  public Publisher getPublisher() {
    return new Publisher();
  }

}
