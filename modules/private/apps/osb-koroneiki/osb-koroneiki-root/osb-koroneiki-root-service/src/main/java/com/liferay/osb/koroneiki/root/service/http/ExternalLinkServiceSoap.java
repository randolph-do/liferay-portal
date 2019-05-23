/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.osb.koroneiki.root.service.http;

import com.liferay.osb.koroneiki.root.service.ExternalLinkServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>ExternalLinkServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.osb.koroneiki.root.model.ExternalLinkSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.osb.koroneiki.root.model.ExternalLink</code>, that is translated to a
 * <code>com.liferay.osb.koroneiki.root.model.ExternalLinkSoap</code>. Methods that SOAP
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
 * @author Brian Wing Shun Chan
 * @see ExternalLinkServiceHttp
 * @generated
 */
@ProviderType
public class ExternalLinkServiceSoap {

	public static com.liferay.osb.koroneiki.root.model.ExternalLinkSoap
			addExternalLink(
				long classNameId, long classPK, String domain,
				String entityName, String entityId)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.root.model.ExternalLink returnValue =
				ExternalLinkServiceUtil.addExternalLink(
					classNameId, classPK, domain, entityName, entityId);

			return com.liferay.osb.koroneiki.root.model.ExternalLinkSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.koroneiki.root.model.ExternalLinkSoap
			deleteExternalLink(long externalLinkId)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.root.model.ExternalLink returnValue =
				ExternalLinkServiceUtil.deleteExternalLink(externalLinkId);

			return com.liferay.osb.koroneiki.root.model.ExternalLinkSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.koroneiki.root.model.ExternalLinkSoap
			updateExternalLink(long externalLinkId, String entityId)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.root.model.ExternalLink returnValue =
				ExternalLinkServiceUtil.updateExternalLink(
					externalLinkId, entityId);

			return com.liferay.osb.koroneiki.root.model.ExternalLinkSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ExternalLinkServiceSoap.class);

}