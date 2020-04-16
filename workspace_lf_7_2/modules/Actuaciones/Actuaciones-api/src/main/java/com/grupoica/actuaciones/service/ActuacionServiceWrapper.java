/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.grupoica.actuaciones.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ActuacionService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActuacionService
 * @generated
 */
@ProviderType
public class ActuacionServiceWrapper
	implements ActuacionService, ServiceWrapper<ActuacionService> {

	public ActuacionServiceWrapper(ActuacionService actuacionService) {
		_actuacionService = actuacionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _actuacionService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean importActuaciones() {
		return _actuacionService.importActuaciones();
	}

	@Override
	public ActuacionService getWrappedService() {
		return _actuacionService;
	}

	@Override
	public void setWrappedService(ActuacionService actuacionService) {
		_actuacionService = actuacionService;
	}

	private ActuacionService _actuacionService;

}