package com.github.marcelothebuilder.builderpattern.model.builder.restrictions;

public interface ClientOrderBuilder {
	FullOrderBuilder withClient(String name, boolean vip);
}
