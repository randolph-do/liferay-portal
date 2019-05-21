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

package com.liferay.osb.koroneiki.trunk.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.AccountLocalServiceUtil;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalServiceUtil;
import com.liferay.osb.koroneiki.trunk.model.ProductEntry;
import com.liferay.osb.koroneiki.trunk.model.ProductField;
import com.liferay.osb.koroneiki.trunk.service.ProductEntryLocalServiceUtil;
import com.liferay.osb.koroneiki.trunk.service.ProductFieldLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Kyle Bischof
 */
@ProviderType
public class ProductPurchaseImpl extends ProductPurchaseBaseImpl {

	public ProductPurchaseImpl() {
	}

	public Account getAccount() throws PortalException {
		return AccountLocalServiceUtil.getAccount(getAccountId());
	}

	public ProductEntry getProductEntry() throws PortalException {
		return ProductEntryLocalServiceUtil.getProductEntry(
			getProductEntryId());
	}

	public List<ProductField> getProductFields() {
		return ProductFieldLocalServiceUtil.getProductFields(
			getProductPurchaseId());
	}

	public Project getProject() {
		if (getProjectId() > 0) {
			return ProjectLocalServiceUtil.fetchProject(getProjectId());
		}

		return null;
	}

}