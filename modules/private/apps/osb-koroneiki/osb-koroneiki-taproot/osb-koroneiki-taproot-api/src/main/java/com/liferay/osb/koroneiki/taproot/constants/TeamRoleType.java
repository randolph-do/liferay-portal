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

import java.util.Objects;

/**
 * @author Kyle Bischof
 */
public class TeamRoleType {

	public static final int PROJECT = 2;

	public static final String PROJECT_LABEL = "project";

	public static final int REGULAR = 1;

	public static final String REGULAR_LABEL = "regular";

	public static final int[] VALUES = {REGULAR, PROJECT};

	public static int fromLabel(String label) {
		if (Objects.equals(PROJECT_LABEL, label)) {
			return PROJECT;
		}
		else if (Objects.equals(REGULAR_LABEL, label)) {
			return REGULAR;
		}

		throw new IllegalArgumentException("Invalid label " + label);
	}

	public static String getLabel(int value) {
		if (value == REGULAR) {
			return REGULAR_LABEL;
		}
		else if (value == PROJECT) {
			return PROJECT_LABEL;
		}
		else {
			return null;
		}
	}

}