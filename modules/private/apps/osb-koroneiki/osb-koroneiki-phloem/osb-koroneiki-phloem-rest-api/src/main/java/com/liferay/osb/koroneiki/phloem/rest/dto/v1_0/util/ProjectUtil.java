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

package com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.util;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ProductPurchase;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.osb.koroneiki.trunk.service.ProductPurchaseLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.vulcan.util.TransformUtil;

/**
 * @author Amos Fong
 */
public class ProjectUtil {

	public static Project toProject(
			com.liferay.osb.koroneiki.taproot.model.Project project,
			String[] includes)
		throws Exception {

		return new Project() {
			{
				accountKey = project.getAccountKey();
				code = project.getCode();
				dateCreated = project.getCreateDate();
				dateModified = project.getModifiedDate();
				externalLinks = TransformUtil.transformToArray(
					project.getExternalLinks(),
					ExternalLinkUtil::toExternalLink, ExternalLink.class);
				key = project.getProjectKey();
				industry = Industry.create(project.getIndustry());
				name = project.getName();
				notes = project.getNotes();
				soldBy = project.getSoldBy();
				status = Status.create(project.getStatusLabel());
				tier = Tier.create(project.getTier());

				setProductPurchases(
					() -> {
						if (!ArrayUtil.contains(includes, "products")) {
							return null;
						}

						return productPurchases =
							TransformUtil.transformToArray(
								ProductPurchaseLocalServiceUtil.
									getProjectProductPurchases(
										project.getProjectId(),
										QueryUtil.ALL_POS, QueryUtil.ALL_POS),
								ProductPurchaseUtil::toProductPurchase,
								ProductPurchase.class);
					});
			}
		};
	}

}