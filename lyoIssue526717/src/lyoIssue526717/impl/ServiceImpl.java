/**************************************************
 * Copyright (c) pure-systems GmbH 
 * All rights reserved. 
 **************************************************/
package lyoIssue526717.impl;

import org.eclipse.lyo.oslc4j.core.model.Publisher;

import lyoIssue526717.api.ServiceAPI;

public class ServiceImpl implements ServiceAPI {

  @Override
  public Publisher getPublisher() {
    return new Publisher();
  }

}
