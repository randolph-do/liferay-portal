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

package com.liferay.osb.koroneiki.trunk.service.http;

import com.liferay.osb.koroneiki.trunk.service.ProductConsumptionServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>ProductConsumptionServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductConsumptionServiceSoap
 * @generated
 */
@ProviderType
public class ProductConsumptionServiceHttp {

	public static com.liferay.osb.koroneiki.trunk.model.ProductConsumption
			addProductConsumption(
				HttpPrincipal httpPrincipal, long accountId, long projectId,
				long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class, "addProductConsumption",
				_addProductConsumptionParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId, projectId, productEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.osb.koroneiki.trunk.model.ProductConsumption)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.osb.koroneiki.trunk.model.ProductConsumption
			deleteProductConsumption(
				HttpPrincipal httpPrincipal, long productConsumptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class, "deleteProductConsumption",
				_deleteProductConsumptionParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productConsumptionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.osb.koroneiki.trunk.model.ProductConsumption)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.osb.koroneiki.trunk.model.ProductConsumption
			deleteProductConsumption(
				HttpPrincipal httpPrincipal, long accountId, long projectId,
				long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class, "deleteProductConsumption",
				_deleteProductConsumptionParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId, projectId, productEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.osb.koroneiki.trunk.model.ProductConsumption)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List
		<com.liferay.osb.koroneiki.trunk.model.ProductConsumption>
				getAccountProductConsumptions(
					HttpPrincipal httpPrincipal, long accountId, int start,
					int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class,
				"getAccountProductConsumptions",
				_getAccountProductConsumptionsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.osb.koroneiki.trunk.model.ProductConsumption>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAccountProductConsumptionsCount(
			HttpPrincipal httpPrincipal, long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class,
				"getAccountProductConsumptionsCount",
				_getAccountProductConsumptionsCountParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.osb.koroneiki.trunk.model.ProductConsumption
			getProductConsumption(
				HttpPrincipal httpPrincipal, long productConsumptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class, "getProductConsumption",
				_getProductConsumptionParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productConsumptionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.osb.koroneiki.trunk.model.ProductConsumption)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List
		<com.liferay.osb.koroneiki.trunk.model.ProductConsumption>
				getProjectProductConsumptions(
					HttpPrincipal httpPrincipal, long projectId, int start,
					int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class,
				"getProjectProductConsumptions",
				_getProjectProductConsumptionsParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, projectId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.osb.koroneiki.trunk.model.ProductConsumption>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getProjectProductConsumptionsCount(
			HttpPrincipal httpPrincipal, long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProductConsumptionServiceUtil.class,
				"getProjectProductConsumptionsCount",
				_getProjectProductConsumptionsCountParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, projectId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ProductConsumptionServiceHttp.class);

	private static final Class<?>[] _addProductConsumptionParameterTypes0 =
		new Class[] {long.class, long.class, long.class};
	private static final Class<?>[] _deleteProductConsumptionParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _deleteProductConsumptionParameterTypes2 =
		new Class[] {long.class, long.class, long.class};
	private static final Class<?>[]
		_getAccountProductConsumptionsParameterTypes3 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[]
		_getAccountProductConsumptionsCountParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getProductConsumptionParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getProjectProductConsumptionsParameterTypes6 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[]
		_getProjectProductConsumptionsCountParameterTypes7 = new Class[] {
			long.class
		};

}