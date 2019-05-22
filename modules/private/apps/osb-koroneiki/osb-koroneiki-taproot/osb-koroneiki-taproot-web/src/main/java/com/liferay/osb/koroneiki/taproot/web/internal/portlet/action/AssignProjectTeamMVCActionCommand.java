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
import com.liferay.osb.koroneiki.taproot.exception.NoSuchTeamException;
import com.liferay.osb.koroneiki.taproot.model.Team;
import com.liferay.osb.koroneiki.taproot.model.TeamRole;
import com.liferay.osb.koroneiki.taproot.service.TeamLocalService;
import com.liferay.osb.koroneiki.taproot.service.TeamProjectRoleService;
import com.liferay.osb.koroneiki.taproot.service.TeamRoleLocalService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	property = {
		"javax.portlet.name=" + TaprootPortletKeys.PROJECTS_ADMIN,
		"mvc.command.name=/projects_admin/assign_project_team"
	},
	service = MVCActionCommand.class
)
public class AssignProjectTeamMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			long projectId = ParamUtil.getLong(actionRequest, "projectId");

			String teamName = ParamUtil.getString(actionRequest, "teamName");
			String teamRoleName = ParamUtil.getString(
				actionRequest, "teamRoleName");

			List<Team> teams = _teamLocalService.getTeams(teamName);
			List<TeamRole> teamRoles = _teamRoleLocalService.getTeamRoles(
				teamRoleName);

			Team team = teams.get(0);
			TeamRole teamRole = teamRoles.get(0);

			_teamProjectRoleService.addTeamProjectRole(
				team.getTeamId(), projectId, teamRole.getTeamRoleId());

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			JSONObject jsonObject = JSONUtil.put("redirectURL", redirect);

			JSONPortletResponseUtil.writeJSON(
				actionRequest, actionResponse, jsonObject);
		}
		catch (Exception e) {
			if (e instanceof NoSuchTeamException) {
				ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
					themeDisplay.getLocale(),
					AssignProjectTeamMVCActionCommand.class);

				JSONObject jsonObject = JSONUtil.put(
					"error",
					LanguageUtil.get(
						resourceBundle, "the-team-could-not-be-found"));

				JSONPortletResponseUtil.writeJSON(
					actionRequest, actionResponse, jsonObject);
			}
			else {
				_log.error(e, e);

				throw e;
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AssignProjectTeamMVCActionCommand.class);

	@Reference
	private TeamLocalService _teamLocalService;

	@Reference
	private TeamProjectRoleService _teamProjectRoleService;

	@Reference
	private TeamRoleLocalService _teamRoleLocalService;

}