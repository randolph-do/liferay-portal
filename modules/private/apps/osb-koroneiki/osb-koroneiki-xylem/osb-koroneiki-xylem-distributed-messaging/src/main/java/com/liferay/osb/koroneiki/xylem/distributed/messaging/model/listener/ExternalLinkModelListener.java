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

package com.liferay.osb.koroneiki.xylem.distributed.messaging.model.listener;

import com.liferay.osb.distributed.messaging.Message;
import com.liferay.osb.koroneiki.root.model.ExternalLink;
import com.liferay.osb.koroneiki.taproot.model.Account;
import com.liferay.osb.koroneiki.taproot.model.Project;
import com.liferay.osb.koroneiki.taproot.service.AccountLocalService;
import com.liferay.osb.koroneiki.taproot.service.ProjectLocalService;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ClassNameLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = ModelListener.class)
public class ExternalLinkModelListener
	extends BaseXylemModelListener<ExternalLink> {

	@Override
	public Message createMessage(ExternalLink externalLink) throws Exception {
		if (externalLink.getClassNameId() ==
				_classNameLocalService.getClassNameId(Account.class)) {

			Account account = _accountLocalService.getAccount(
				externalLink.getClassPK());

			return messageFactory.create(account);
		}
		else if (externalLink.getClassNameId() ==
					_classNameLocalService.getClassNameId(Project.class)) {

			Project project = _projectLocalService.getProject(
				externalLink.getClassPK());

			return messageFactory.create(project);
		}

		return null;
	}

	@Override
	protected String getCreateTopic(ExternalLink externalLink) {
		return _getTopic(externalLink);
	}

	@Override
	protected String getRemoveTopic(ExternalLink externalLink) {
		return _getTopic(externalLink);
	}

	@Override
	protected String getUpdateTopic(ExternalLink externalLink) {
		return _getTopic(externalLink);
	}

	private String _getTopic(ExternalLink externalLink) {
		if (externalLink.getClassNameId() ==
				_classNameLocalService.getClassNameId(Account.class)) {

			return "koroneiki.account.update";
		}
		else if (externalLink.getClassNameId() ==
					_classNameLocalService.getClassNameId(Project.class)) {

			return "koroneiki.project.update";
		}

		return null;
	}

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private ProjectLocalService _projectLocalService;

}