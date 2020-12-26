package com.doctorquantum.frostbite.common.util;

import com.doctorquantum.frostbite.Frostbite;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModRegistry<T extends IForgeRegistryEntry<T>> {
	
	private final DeferredRegister<T> registry;
	
	public ModRegistry(final IForgeRegistry<T> registry) {
		this.registry = DeferredRegister.create(registry, Frostbite.MODID);
	}
	
	public <I extends T> RegistryObject<I> register(final String name, final Supplier<? extends I> supplier) {
		return registry.register(name, supplier);
	}
	
	public void register(final IEventBus bus) {
		registry.register(bus);
	}
	
	public Stream<T> getEntries() {
		return registry.getEntries().stream().map(RegistryObject::get);
	}

	@SafeVarargs
	public final Stream<T> getWhitelistFilteredByType(@Nullable final Class<? extends T>... filter) {
		final Stream<T> stream = this.getEntries();
		if(filter.length == 0 || filter == null) {
			return stream;
		}
		Stream<T> mutableStream = stream.distinct();
		for(int i = 0; i < filter.length; i++) {
			final Class<?> filterClass = filter[i];
			mutableStream = mutableStream.filter((object) -> filterClass.isInstance(object));
		}
		return mutableStream;
	}
	
	@SafeVarargs
	public final Stream<T> getBlacklistFilteredByType(@Nullable final Class<? extends T>... filter) {
		final Stream<T> stream = this.getEntries();
		if(filter.length == 0 || filter == null) {
			return stream;
		}
		Stream<T> mutableStream = stream.distinct();
		for(int i = 0; i < filter.length; i++) {
			final Class<?> filterClass = filter[i];
			mutableStream = mutableStream.filter((object) -> !filterClass.isInstance(object));
		}
		return mutableStream;
	}
	
	@SafeVarargs
	public final Stream<T> getWhitelistedStream(@Nullable final RegistryObject<T>... whiteList) {
		final Stream<T> stream = this.getEntries();
		if(whiteList.length == 0 || whiteList == null) {
			return stream;
		}
		Stream<T> mutableStream = stream.distinct();
		for(int i = 0; i < whiteList.length; i++) {
			final T whitelistObject = whiteList[i].get();
			mutableStream = mutableStream.filter((object) -> object == whitelistObject);
		}
		return mutableStream;
	}
	
	@SafeVarargs
	public final Stream<T> getBlacklistedStream(@Nullable final RegistryObject<T>... blackList) {
		final Stream<T> stream = this.getEntries();
		if(blackList.length == 0 || blackList == null) {
			return stream;
		}
		Stream<T> mutableStream = stream.distinct();
		for(int i = 0; i < blackList.length; i++) {
			final T blacklistObject = blackList[i].get();
			mutableStream = mutableStream.filter((object) -> object != blacklistObject);
		}
		return mutableStream;
	}
	
	public DeferredRegister<T> getRegistry() {
		return registry;
	}
	
}
