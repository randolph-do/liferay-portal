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

package com.liferay.osb.koroneiki.phloem.rest.internal.resource.v1_0;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ProductConsumption;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ProductConsumptionUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProductConsumptionResource;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
import com.liferay.osb.koroneiki.trunk.service.ProductConsumptionService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/product-consumption.properties",
	scope = ServiceScope.PROTOTYPE, service = ProductConsumptionResource.class
)
public class ProductConsumptionResourceImpl
	extends BaseProductConsumptionResourceImpl {

	@Override
	public void deleteAccountProductConsumption(Long accountId, Long productId)
		throws Exception {

		_productConsumptionService.deleteProductConsumption(
			accountId, 0, productId);
	}

	@Override
	public void deleteProductConsumption(Long productConsumptionId)
		throws Exception {

		_productConsumptionService.deleteProductConsumption(
			productConsumptionId);
	}

	@Override
	public void deleteProjectProductConsumption(Long projectId, Long productId)
		throws Exception {

		Project project = _projectLocalService.getProject(projectId);

		_productConsumptionService.deleteProductConsumption(
			project.getAccountId(), projectId, productId);
	}

	@Override
	public Page<ProductConsumption> getAccountProductConsumptionsPage(
			Long accountId, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_productConsumptionService.getAccountProductConsumptions(
					accountId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProductConsumptionUtil::toProductConsumption),
			pagination,
			_productConsumptionService.getAccountProductConsumptionsCount(
				accountId));
	}

	@Override
	public ProductConsumption getProductConsumption(Long productConsumptionId)
		throws Exception {

		return ProductConsumptionUtil.toProductConsumption(
			_productConsumptionService.getProductConsumption(
				productConsumptionId));
	}

	@Override
	public Page<ProductConsumption> getProjectProductConsumptionsPage(
			Long projectId, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_productConsumptionService.getAccountProductConsumptions(
					projectId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProductConsumptionUtil::toProductConsumption),
			pagination,
			_productConsumptionService.getAccountProductConsumptionsCount(
				projectId));
	}

	@Override
	public ProductConsumption postAccountProductConsumption(
			Long accountId, Long productId)
		throws Exception {

		return ProductConsumptionUtil.toProductConsumption(
			_productConsumptionService.addProductConsumption(
				accountId, 0, productId));
	}

	@Override
	public ProductConsumption postProjectProductConsumption(
			Long projectId, Long productId)
		throws Exception {

		Project project = _projectLocalService.getProject(projectId);

		return ProductConsumptionUtil.toProductConsumption(
			_productConsumptionService.addProductConsumption(
				project.getAccountId(), projectId, productId));
	}

	@Reference
	private ProductConsumptionService _productConsumptionService;

	@Reference
	private ProjectLocalService _projectLocalService;

}