/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.spi.service;

/**
 * Contract for a {@link org.ehcache.CacheManager} managed service.
 * <P>
 *   Implementation of this interface have be thread-safe.
 * </P>
 * <P>
 *   Since {@code CacheManager}s can be closed and initialized again, {@code Service} implementations should support
 *   multiple start/stop cycles. Failure to do so will limit the init/close cycles at the {@code CacheManager} level.
 * </P>
 */
public interface Service {

  /**
   * Start this service using the provided configuration and {@link ServiceProvider}.
   * <P>
   * The goal of the service provider is to allow a service to use other services.
   * </P>
   * <P>
   *   A {@code Service} retrieved at this stage may not yet be started. So the recommended usage pattern is to keep a
   *   reference to the dependent {@code Service} but use it only when specific methods are invoked on subtypes.
   * </P>
   *
   * @param serviceProvider the service provider
   */
  void start(ServiceProvider<Service> serviceProvider);

  /**
   * Stops this service.
   */
  void stop();
}
