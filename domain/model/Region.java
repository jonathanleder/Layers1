package model;

import java.util.Objects;
import java.util.Set;

import portsin.DomainException;

class Region {
	private String region;
	private static Set<String> regionesConocidas = Set.of("China", "Us", "Europa");

	public Region(String region) throws DomainException {
		Objects.requireNonNull(region);

		if (region.isEmpty() || region.isBlank()) {
			throw new DomainException("El campo de region esta vacio");
		}

		if (!regionesConocidas.contains(region)) {
			throw new DomainException("Region desconocida");
		}

		this.region = region;
	}

	public String getRegion() {
		return this.region;
	}

}