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

package com.liferay.segments.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.segments.service.SegmentsExperimentRelServiceUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>SegmentsExperimentRelServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.segments.model.SegmentsExperimentRelSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.segments.model.SegmentsExperimentRel</code>, that is translated to a
 * <code>com.liferay.segments.model.SegmentsExperimentRelSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Eduardo Garcia
 * @see SegmentsExperimentRelServiceHttp
 * @generated
 */
@ProviderType
public class SegmentsExperimentRelServiceSoap {

	public static com.liferay.segments.model.SegmentsExperimentRelSoap
			addSegmentsExperimentRel(
				long segmentsExperimentId, long segmentsExperienceId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.segments.model.SegmentsExperimentRel returnValue =
				SegmentsExperimentRelServiceUtil.addSegmentsExperimentRel(
					segmentsExperimentId, segmentsExperienceId, serviceContext);

			return com.liferay.segments.model.SegmentsExperimentRelSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.segments.model.SegmentsExperimentRelSoap
			deleteSegmentsExperimentRel(long segmentsExperimentRelId)
		throws RemoteException {

		try {
			com.liferay.segments.model.SegmentsExperimentRel returnValue =
				SegmentsExperimentRelServiceUtil.deleteSegmentsExperimentRel(
					segmentsExperimentRelId);

			return com.liferay.segments.model.SegmentsExperimentRelSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.segments.model.SegmentsExperimentRelSoap
			getSegmentsExperimentRel(
				long segmentsExperimentId, long segmentsExperienceId)
		throws RemoteException {

		try {
			com.liferay.segments.model.SegmentsExperimentRel returnValue =
				SegmentsExperimentRelServiceUtil.getSegmentsExperimentRel(
					segmentsExperimentId, segmentsExperienceId);

			return com.liferay.segments.model.SegmentsExperimentRelSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.segments.model.SegmentsExperimentRelSoap[]
			getSegmentsExperimentRels(long segmentsExperimentId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.segments.model.SegmentsExperimentRel>
				returnValue =
					SegmentsExperimentRelServiceUtil.getSegmentsExperimentRels(
						segmentsExperimentId);

			return com.liferay.segments.model.SegmentsExperimentRelSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.segments.model.SegmentsExperimentRelSoap
			updateSegmentsExperimentRel(
				long segmentsExperimentRelId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.segments.model.SegmentsExperimentRel returnValue =
				SegmentsExperimentRelServiceUtil.updateSegmentsExperimentRel(
					segmentsExperimentRelId, name, serviceContext);

			return com.liferay.segments.model.SegmentsExperimentRelSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SegmentsExperimentRelServiceSoap.class);

}