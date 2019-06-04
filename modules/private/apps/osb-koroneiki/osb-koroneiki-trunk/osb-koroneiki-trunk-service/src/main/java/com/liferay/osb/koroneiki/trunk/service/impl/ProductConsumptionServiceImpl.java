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

package com.liferay.osb.koroneiki.trunk.service.impl;

import com.liferay.osb.koroneiki.taproot.permission.AccountPermission;
import com.liferay.osb.koroneiki.taproot.permission.ProjectPermission;
import com.liferay.osb.koroneiki.trunk.constants.TrunkActionKeys;
import com.liferay.osb.koroneiki.trunk.exception.NoSuchProductConsumptionException;
import com.liferay.osb.koroneiki.trunk.model.ProductConsumption;
import com.liferay.osb.koroneiki.trunk.permission.ProductConsumptionPermission;
import com.liferay.osb.koroneiki.trunk.permission.ProductEntryPermission;
import com.liferay.osb.koroneiki.trunk.service.base.ProductConsumptionServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"json.web.service.context.name=koroneiki",
		"json.web.service.context.path=ProductConsumption"
	},
	service = AopService.class
)
public class ProductConsumptionServiceImpl
	extends ProductConsumptionServiceBaseImpl {

	public ProductConsumption addProductConsumption(
			long accountId, long projectId, long productEntryId)
		throws PortalException {

		_productEntryPermission.check(
			getPermissionChecker(), productEntryId, TrunkActionKeys.CONSUME);

		return productConsumptionLocalService.addProductConsumption(
			getUserId(), accountId, projectId, productEntryId);
	}

	public ProductConsumption deleteProductConsumption(
			long productConsumptionId)
		throws PortalException {

		_productConsumptionPermission.check(
			getPermissionChecker(), productConsumptionId, ActionKeys.DELETE);

		return productConsumptionLocalService.deleteProductConsumption(
			productConsumptionId);
	}

	public ProductConsumption deleteProductConsumption(
			long accountId, long projectId, long productEntryId)
		throws PortalException {

		List<ProductConsumption> productConsumptions =
			productConsumptionLocalService.getProductConsumptions(
				getUserId(), accountId, projectId, productEntryId);

		if (productConsumptions.isEmpty()) {
			throw new NoSuchProductConsumptionException();
		}

		ProductConsumption productConsumption = productConsumptions.get(0);

		_productConsumptionPermission.check(
			getPermissionChecker(), productConsumption, ActionKeys.DELETE);

		return productConsumptionLocalService.deleteProductConsumption(
			productConsumption.getProductConsumptionId());
	}

	public List<ProductConsumption> getAccountProductConsumptions(
			long accountId, int start, int end)
		throws PortalException {

		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return productConsumptionLocalService.getAccountProductConsumptions(
			accountId, start, end);
	}

	public int getAccountProductConsumptionsCount(long accountId)
		throws PortalException {

		_accountPermission.check(
			getPermissionChecker(), accountId, ActionKeys.VIEW);

		return productConsumptionLocalService.
			getAccountProductConsumptionsCount(accountId);
	}

	public ProductConsumption getProductConsumption(long productConsumptionId)
		throws PortalException {

		_productConsumptionPermission.check(
			getPermissionChecker(), productConsumptionId, ActionKeys.VIEW);

		return productConsumptionLocalService.getProductConsumption(
			productConsumptionId);
	}

	public List<ProductConsumption> getProjectProductConsumptions(
			long projectId, int start, int end)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), projectId, ActionKeys.VIEW);

		return productConsumptionLocalService.getProjectProductConsumptions(
			projectId, start, end);
	}

	public int getProjectProductConsumptionsCount(long projectId)
		throws PortalException {

		_projectPermission.check(
			getPermissionChecker(), projectId, ActionKeys.VIEW);

		return productConsumptionLocalService.
			getProjectProductConsumptionsCount(projectId);
	}

	@Reference
	private AccountPermission _accountPermission;

	@Reference
	private ProductConsumptionPermission _productConsumptionPermission;

	@Reference
	private ProductEntryPermission _productEntryPermission;

	@Reference
	private ProjectPermission _projectPermission;

}