package com.makhir.springboot.katharsis.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.katharsis.resource.registry.RegistryEntry;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;

@RestController
@Import({ KatharsisConfigV3.class })
public class KatharsisRestService {
	private static final Logger log = LoggerFactory.getLogger(KatharsisRestService.class);

	@Autowired
	private ResourceRegistry resourceRegistry;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public Map<String, String> getCustomers() {
		log.debug("Enter: getCustomers() ---------- ");
		Map<String, String> result = new HashMap<>();

		for (RegistryEntry entry : resourceRegistry.getResources()) {
			log.debug("## ResourceType : " + entry.getResourceInformation().getResourceType());
			log.debug("## SuperResourceType : " + entry.getResourceInformation().getSuperResourceType());
			result.put(entry.getResourceInformation().getResourceType(),
					resourceRegistry.getResourceUrl(entry.getResourceInformation()));
		}
		
		log.debug("Exit: getCustomers() ---------- ");
		return result;
	}
}
