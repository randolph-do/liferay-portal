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

package com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util;

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.Project;
import com.liferay.portal.vulcan.util.TransformUtil;

/**
 * @author Amos Fong
 */
public class ProjectUtil {

	public static Project toProject(
			com.liferay.osb.koroneiki.taproot.model.Project project)
		throws Exception {

		return new Project() {
			{
				accountId = project.getAccountId();
				code = project.getCode();
				dateCreated = project.getCreateDate();
				dateModified = project.getModifiedDate();
				externalLinks = TransformUtil.transformToArray(
					project.getExternalLinks(),
					ExternalLinkUtil::toExternalLink, ExternalLink.class);
				id = project.getProjectId();
				name = project.getName();
				notes = project.getNotes();
				status = project.getStatusLabel();
			}
		};
	}

}