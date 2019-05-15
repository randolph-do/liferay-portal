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

package com.liferay.osb.koroneiki.taproot.constants;

/**
 * @author Amos Fong
 */
public class ContactRoleType {

	public static final int ACCOUNT = 1;

	public static final int PROJECT = 2;

	public static final int TEAM = 3;

	public static final int[] VALUES = {ACCOUNT, PROJECT, TEAM};

	public static String getLabel(int value) {
		if (value == ACCOUNT) {
			return "account";
		}
		else if (value == PROJECT) {
			return "project";
		}
		else if (value == TEAM) {
			return "team";
		}
		else {
			return null;
		}
	}

}