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
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util.ProductConsumptionUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProductConsumptionResource;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.service.ProductConsumptionService;
import com.liferay.osb.koroneiki.trunk.service.ProductFieldLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public void deleteProductConsumption(String productConsumptionKey)
		throws Exception {

		_productConsumptionService.deleteProductConsumption(
			productConsumptionKey);
	}

	@Override
	public Page<ProductConsumption> getAccountAccountKeyProductConsumptionsPage(
			String accountKey, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_productConsumptionService.getAccountProductConsumptions(
					accountKey, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProductConsumptionUtil::toProductConsumption),
			pagination,
			_productConsumptionService.getAccountProductConsumptionsCount(
				accountKey));
	}

	@Override
	public ProductConsumption getProductConsumption(
			String productConsumptionKey)
		throws Exception {

		return ProductConsumptionUtil.toProductConsumption(
			_productConsumptionService.getProductConsumption(
				productConsumptionKey));
	}

	@Override
	public Page<ProductConsumption> getProjectProjectKeyProductConsumptionsPage(
			String projectKey, Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_productConsumptionService.getAccountProductConsumptions(
					projectKey, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ProductConsumptionUtil::toProductConsumption),
			pagination,
			_productConsumptionService.getAccountProductConsumptionsCount(
				projectKey));
	}

	@Override
	public ProductConsumption postAccountAccountKeyProductConsumption(
			String accountKey, ProductConsumption productConsumption)
		throws Exception {

		List<ProductField> productFields = getProductFields(
			productConsumption.getProperties());

		return ProductConsumptionUtil.toProductConsumption(
			_productConsumptionService.addProductConsumption(
				accountKey, null, productConsumption.getProductKey(),
				productFields));
	}

	@Override
	public ProductConsumption postProjectProjectKeyProductConsumption(
			String projectKey, ProductConsumption productConsumption)
		throws Exception {

		Project project = _projectLocalService.getProject(projectKey);

		List<ProductField> productFields = getProductFields(
			productConsumption.getProperties());

		return ProductConsumptionUtil.toProductConsumption(
			_productConsumptionService.addProductConsumption(
				project.getAccountKey(), projectKey,
				productConsumption.getProductKey(), productFields));
	}

	protected List<ProductField> getProductFields(
		Map<String, String> properties) {

		List<ProductField> productFields = new ArrayList<>();

		if (properties == null) {
			return productFields;
		}

		for (Map.Entry<String, String> entry : properties.entrySet()) {
			ProductField productField =
				_productFieldLocalService.createProductField(0);

			productField.setName(entry.getKey());
			productField.setValue(entry.getValue());

			productFields.add(productField);
		}

		return productFields;
	}

	@Reference
	private ProductConsumptionService _productConsumptionService;

	@Reference
	private ProductFieldLocalService _productFieldLocalService;

	@Reference
	private ProjectLocalService _projectLocalService;

}