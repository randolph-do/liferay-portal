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
import com.liferay.osb.koroneiki.taproot.model.TeamProjectRole;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = {
		"create.topic=koroneiki.project.assigned.teamrole",
		"remove.topic=koroneiki.project.unassigned.teamrole"
	},
	service = ModelListener.class
)
public class TeamProjectRoleModelListener
	extends BaseXylemModelListener<TeamProjectRole> {

	@Override
	public Message createMessage(TeamProjectRole teamProjectRole)
		throws Exception {

		return messageFactory.create(teamProjectRole);
	}

}