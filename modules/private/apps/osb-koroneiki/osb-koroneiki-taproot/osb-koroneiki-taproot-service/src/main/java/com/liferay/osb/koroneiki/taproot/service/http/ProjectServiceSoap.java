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

package com.liferay.osb.koroneiki.taproot.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.taproot.service.ProjectServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ProjectServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.osb.koroneiki.taproot.model.ProjectSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.osb.koroneiki.taproot.model.Project</code>, that is translated to a
 * <code>com.liferay.osb.koroneiki.taproot.model.ProjectSoap</code>. Methods that SOAP
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
 * @see ProjectServiceHttp
 * @generated
 */
@ProviderType
public class ProjectServiceSoap {

	public static com.liferay.osb.koroneiki.taproot.model.ProjectSoap
			addProject(
				long accountId, long supportRegionId, String name, String code,
				int industry, int tier, String notes, int status)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.taproot.model.Project returnValue =
				ProjectServiceUtil.addProject(
					accountId, supportRegionId, name, code, industry, tier,
					notes, status);

			return com.liferay.osb.koroneiki.taproot.model.ProjectSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.koroneiki.taproot.model.ProjectSoap
			deleteProject(long projectId)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.taproot.model.Project returnValue =
				ProjectServiceUtil.deleteProject(projectId);

			return com.liferay.osb.koroneiki.taproot.model.ProjectSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.koroneiki.taproot.model.ProjectSoap
			getProject(long projectId)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.taproot.model.Project returnValue =
				ProjectServiceUtil.getProject(projectId);

			return com.liferay.osb.koroneiki.taproot.model.ProjectSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.koroneiki.taproot.model.ProjectSoap[]
			getProjects(long accountId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.osb.koroneiki.taproot.model.Project>
				returnValue = ProjectServiceUtil.getProjects(
					accountId, start, end);

			return com.liferay.osb.koroneiki.taproot.model.ProjectSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getProjectsCount(long accountId) throws RemoteException {
		try {
			int returnValue = ProjectServiceUtil.getProjectsCount(accountId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.koroneiki.taproot.model.ProjectSoap
			updateProject(
				long projectId, long supportRegionId, String name, String code,
				int industry, int tier, String notes, int status)
		throws RemoteException {

		try {
			com.liferay.osb.koroneiki.taproot.model.Project returnValue =
				ProjectServiceUtil.updateProject(
					projectId, supportRegionId, name, code, industry, tier,
					notes, status);

			return com.liferay.osb.koroneiki.taproot.model.ProjectSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProjectServiceSoap.class);

}