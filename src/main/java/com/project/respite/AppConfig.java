package com.project.respite;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest/*")
public class AppConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(com.project.respite.ColorService.class);
    //classes.add(com.project.respite.PrometheusService.class);
    return classes;
  }
}
