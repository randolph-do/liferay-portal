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

import com.liferay.osb.koroneiki.phloem.rest.dto.v1_0.ExternalLink;
import com.liferay.osb.koroneiki.phloem.rest.internal.dto.v1_0.util.ExternalLinkUtil;
import com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ExternalLinkResource;
import com.liferay.osb.koroneiki.root.service.ExternalLinkService;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Contact;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.model.Team;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Amos Fong
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/external-link.properties",
	scope = ServiceScope.PROTOTYPE, service = ExternalLinkResource.class
)
public class ExternalLinkResourceImpl extends BaseExternalLinkResourceImpl {

	@Override
	public void deleteExternalLink(Long externalLinkId) throws Exception {
		_externalLinkService.deleteExternalLink(externalLinkId);
	}

	@Override
	public Page<ExternalLink> getAccountExternalLinksPage(
			Long accountId, Pagination pagination)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Account.class);

		return Page.of(
			transform(
				_externalLinkService.getExternalLinks(
					classNameId, accountId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ExternalLinkUtil::toExternalLink),
			pagination,
			_externalLinkService.getExternalLinksCount(classNameId, accountId));
	}

	@Override
	public Page<ExternalLink> getContactExternalLinksPage(
			Long contactId, Pagination pagination)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Contact.class);

		return Page.of(
			transform(
				_externalLinkService.getExternalLinks(
					classNameId, contactId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ExternalLinkUtil::toExternalLink),
			pagination,
			_externalLinkService.getExternalLinksCount(classNameId, contactId));
	}

	@Override
	public ExternalLink getExternalLink(Long externalLinkId) throws Exception {
		return ExternalLinkUtil.toExternalLink(
			_externalLinkService.getExternalLink(externalLinkId));
	}

	@Override
	public Page<ExternalLink> getProjectExternalLinksPage(
			Long projectId, Pagination pagination)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Project.class);

		return Page.of(
			transform(
				_externalLinkService.getExternalLinks(
					classNameId, projectId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ExternalLinkUtil::toExternalLink),
			pagination,
			_externalLinkService.getExternalLinksCount(classNameId, projectId));
	}

	@Override
	public Page<ExternalLink> getTeamExternalLinksPage(
			Long teamId, Pagination pagination)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Team.class);

		return Page.of(
			transform(
				_externalLinkService.getExternalLinks(
					classNameId, teamId, pagination.getStartPosition(),
					pagination.getEndPosition()),
				ExternalLinkUtil::toExternalLink),
			pagination,
			_externalLinkService.getExternalLinksCount(classNameId, teamId));
	}

	@Override
	public ExternalLink postAccountExternalLink(
			Long accountId, ExternalLink externalLink)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Account.class);

		return ExternalLinkUtil.toExternalLink(
			_externalLinkService.addExternalLink(
				classNameId, accountId, externalLink.getDomain(),
				externalLink.getEntityName(), externalLink.getEntityId()));
	}

	@Override
	public ExternalLink postContactExternalLink(
			Long contactId, ExternalLink externalLink)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Contact.class);

		return ExternalLinkUtil.toExternalLink(
			_externalLinkService.addExternalLink(
				classNameId, contactId, externalLink.getDomain(),
				externalLink.getEntityName(), externalLink.getEntityId()));
	}

	@Override
	public ExternalLink postProjectExternalLink(
			Long projectId, ExternalLink externalLink)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Project.class);

		return ExternalLinkUtil.toExternalLink(
			_externalLinkService.addExternalLink(
				classNameId, projectId, externalLink.getDomain(),
				externalLink.getEntityName(), externalLink.getEntityId()));
	}

	@Override
	public ExternalLink postTeamExternalLink(
			Long teamId, ExternalLink externalLink)
		throws Exception {

		long classNameId = _classNameLocalService.getClassNameId(Team.class);

		return ExternalLinkUtil.toExternalLink(
			_externalLinkService.addExternalLink(
				classNameId, teamId, externalLink.getDomain(),
				externalLink.getEntityName(), externalLink.getEntityId()));
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private ExternalLinkService _externalLinkService;

}