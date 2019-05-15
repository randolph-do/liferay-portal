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

package com.liferay.osb.koroneiki.taproot.web.internal.portlet.action;

import com.liferay.osb.koroneiki.taproot.constants.TaprootPortletKeys;
import com.liferay.osb.koroneiki.taproot.exception.NoSuchAccountException;
import com.liferay.osb.koroneiki.taproot.exception.ProjectNameException;
import com.liferay.osb.koroneiki.taproot.service.ProjectService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"javax.portlet.name=" + TaprootPortletKeys.PROJECTS_ADMIN,
		"mvc.command.name=/projects_admin/edit_project"
	},
	service = MVCActionCommand.class
)
public class EditProjectMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteProject(ActionRequest actionRequest)
		throws PortalException {

		long projectId = ParamUtil.getLong(actionRequest, "projectId");

		_projectService.deleteProject(projectId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteProject(actionRequest);
			}
			else {
				updateProject(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchAccountException ||
				e instanceof ProjectNameException) {

				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName", "/projects_admin/edit_project");
			}
			else {
				throw e;
			}
		}
	}

	protected void updateProject(ActionRequest actionRequest)
		throws PortalException {

		long projectId = ParamUtil.getLong(actionRequest, "projectId");

		long accountId = ParamUtil.getLong(actionRequest, "accountId");
		String name = ParamUtil.getString(actionRequest, "name");
		String code = ParamUtil.getString(actionRequest, "code");
		String notes = ParamUtil.getString(actionRequest, "notes");

		if (projectId <= 0) {
			_projectService.addProject(
				accountId, 0, name, code, 0, 0, notes,
				WorkflowConstants.STATUS_APPROVED);
		}
		else {
			_projectService.updateProject(
				projectId, 0, name, code, 0, 0, notes,
				WorkflowConstants.STATUS_APPROVED);
		}
	}

	@Reference
	private ProjectService _projectService;

}