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

package com.liferay.osb.koroneiki.taproot.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Project service. Represents a row in the &quot;Koroneiki_Project&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.osb.koroneiki.taproot.model.impl.ProjectImpl"
)
@ProviderType
public interface Project extends PersistedModel, ProjectModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.osb.koroneiki.taproot.model.impl.ProjectImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Project, Long> PROJECT_ID_ACCESSOR =
		new Accessor<Project, Long>() {

			@Override
			public Long get(Project project) {
				return project.getProjectId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Project> getTypeClass() {
				return Project.class;
			}

		};

	public Account getAccount()
		throws com.liferay.portal.kernel.exception.PortalException;

	public String getStatusLabel();

}