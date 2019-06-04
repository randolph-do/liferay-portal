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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Product;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ProductUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProductResource;
import com.liferay.osb.koroneiki.trunk.service.ProductEntryService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/product.properties",
	scope = ServiceScope.PROTOTYPE, service = ProductResource.class
)
public class ProductResourceImpl extends BaseProductResourceImpl {

	@Override
	public void deleteProduct(Long productId) throws Exception {
		_productEntryService.deleteProductEntry(productId);
	}

	@Override
	public Product getProduct(Long productId) throws Exception {
		return ProductUtil.toProduct(
			_productEntryService.getProductEntry(productId));
	}

	@Override
	public Page<Product> getProductsPage(Pagination pagination)
		throws Exception {

		return Page.of(
			transform(
				_productEntryService.getProductEntries(
					pagination.getStartPosition(), pagination.getEndPosition()),
				ProductUtil::toProduct),
			pagination, _productEntryService.getProductEntriesCount());
	}

	@Override
	public Product postProduct(Product product) throws Exception {
		return ProductUtil.toProduct(
			_productEntryService.addProductEntry(product.getName()));
	}

	@Override
	public Product putProduct(Long productId, Product product)
		throws Exception {

		return ProductUtil.toProduct(
			_productEntryService.updateProductEntry(
				productId, product.getName()));
	}

	@Reference
	private ProductEntryService _productEntryService;

}