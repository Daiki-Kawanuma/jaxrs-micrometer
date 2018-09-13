package com.project.respite;

import static javax.ejb.LockType.*;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.logging.LogbackMetrics;
import io.micrometer.core.instrument.binder.system.FileDescriptorMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@Lock(READ)
@Singleton
@Path("/prometheus")
public class PrometheusService {

	PrometheusMeterRegistry registry;

	public PrometheusService(){

		registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

		new JvmGcMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new ClassLoaderMetrics().bindTo(registry);
		
		new LogbackMetrics().bindTo(registry);
		
		new UptimeMetrics().bindTo(registry);
		new FileDescriptorMetrics().bindTo(registry);
		new ProcessorMetrics().bindTo(registry);
	}

	@GET
    public String getPrometheus() {
        return registry.scrape();
    }
}
